package com.ipze.self_assessment.domains.educationProgramDocument;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.DocumentToDownload;
import com.ipze.self_assessment.domains.educationProgramDocument.dto.GroupedProgramData;
import com.ipze.self_assessment.domains.educationalComponent.EducationalComponentRepository;
import com.ipze.self_assessment.domains.selfAssessment.dto.SelfAssessmentInfoDto;
import com.ipze.self_assessment.exceptions.custom.WrongOperationException;
import com.ipze.self_assessment.model.entity.EducationProgramDocument;
import com.ipze.self_assessment.model.enums.DocumentType;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.springframework.web.client.RestTemplate;

@Service
public class EducationProgramDocumentService {

	@Value("${file.path}")
	private String filePath;

	private final EducationProgramDocumentRepository programDocumentRepository;
	private final EducationalComponentRepository educationalComponentRepository;
	private final RestTemplate restTemplate;

	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	public EducationProgramDocumentService(EducationProgramDocumentRepository programDocumentRepository, EducationalComponentRepository educationalComponentRepository, RestTemplate restTemplate) {
		this.programDocumentRepository = programDocumentRepository;
		this.educationalComponentRepository = educationalComponentRepository;
		this.restTemplate = restTemplate;
	}

	public EducationProgramDocument saveDocument(MultipartFile file, EducationProgramDocument document) throws IOException {

		final String fileName = Optional.ofNullable(file.getOriginalFilename()).orElse("");
		final String saveFilePath = filePath + "_" + System.currentTimeMillis() + "_" + fileName;
		final Path path = Paths.get(saveFilePath);
		try {
			Files.deleteIfExists(path);
			Files.copy(file.getInputStream(), path);

			document.setType(DocumentType.SYLLABUS);
			document.setName(fileName);
			document.setPath(saveFilePath);

			String fileHash = calculateFileHash(path);
			document.setHash(fileHash);

			return programDocumentRepository.save(document);

		} catch (Exception e) {
			Files.deleteIfExists(path);
			e.printStackTrace();
			throw new WrongOperationException("Файл не придатний");
		}
	}

	private String calculateFileHash(Path filePath) throws IOException {
		try (InputStream is = Files.newInputStream(filePath)) {
			// MD5 хеш файлу
			return DigestUtils.md5DigestAsHex(is);
		}
	}

	public DocumentToDownload generateSelfAssessmentDocument(SelfAssessmentInfoDto info) {
		var otherPrograms = fetchProgramsFromNaqa("https://public.naqa.gov.ua/api/Accreditation/Get?$filter=(specialityName eq '122 Комп''ютерні науки') and contains(tolower(universityName), 'національний технічний університет україни «київський політехнічний інститут імені ігоря сікорського»')");
		Context context = new Context();
		// general
		context.setVariable("hei", info.getGeneralInformation().getHigherEducationInstitutionInformation().getHei());
		context.setVariable("programInfo", info.getGeneralInformation().getEducationProgramAccreditationInformation());
		context.setVariable("guarantee", info.getGeneralInformation().getEducationProgramAccreditationInformation().getGuarantee());
		context.setVariable("otherPrograms", otherPrograms);
		context.setVariable("website", info.getGeneralInformation().getWebsite());
		context.setVariable("historyAndDevelopment", info.getGeneralInformation().getHistoryAndDevelopment());
		context.setVariable("educationStatistic", info.getGeneralInformation().getEducationStatistic());
		context.setVariable("area", info.getGeneralInformation().getHigherEducationInstitutionArea());
		context.setVariable("documents", info.getGeneralInformation().getEducationProgramDocuments());

		// criteria
		context.setVariable("programDesign", info.getProgramDesign());
		context.setVariable("structureAndContent", info.getStructureAndContent());
		context.setVariable("programAccess", info.getProgramAccess());
		context.setVariable("learningAndTeaching", info.getLearningAndTeaching());
		context.setVariable("controlMeasuresAndAcademicIntegrity", info.getControlMeasuresAndAcademicIntegrity());
		context.setVariable("humanResource", info.getHumanResource());
		context.setVariable("educationalEnvironmentAndMaterialResource", info.getEducationalEnvironmentAndMaterialResource());
		context.setVariable("qualityAssurance", info.getQualityAssurance());
		context.setVariable("transparencyAndPublicity", info.getTransparencyAndPublicity());
		context.setVariable("educationalProgram", info.getEducationalProgram());
		context.setVariable("developmentPerspective", info.getDevelopmentPerspective());

		//tables
		context.setVariable("educationalComponents", info.getProgramEducationalComponentsInformation().getEducationalComponents());
		context.setVariable("documentTypeValues", DocumentType.values());
		context.setVariable("teachers", info.getTeacherSummaryInformation().getTeachers());
		context.setVariable("studyResults", info.getStudyResultsMatrix().getStudyResults());

		String htmlContentToRender = springTemplateEngine.process("self-assessment-template", context);

		final String saveFilePath = filePath + info.getId() + ".pdf";
		return htmlToPdf(htmlContentToRender, saveFilePath);

	}

	public DocumentToDownload htmlToPdf(String processedHtml, String saveFilePath) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		try {

			PdfWriter pdfwriter = new PdfWriter(byteArrayOutputStream);
			PdfDocument pdfDocument = new PdfDocument(pdfwriter);
			pdfDocument.addEventHandler(PdfDocumentEvent.START_PAGE, new PageNumberEventHandler());

			DefaultFontProvider defaultFont = new DefaultFontProvider(false, true, false);

			ConverterProperties converterProperties = new ConverterProperties();

			converterProperties.setFontProvider(defaultFont);

			HtmlConverter.convertToPdf(processedHtml, pdfDocument, converterProperties);


			FileOutputStream fout = new FileOutputStream(saveFilePath);

			byteArrayOutputStream.writeTo(fout);
			byteArrayOutputStream.close();

			byteArrayOutputStream.flush();
			fout.close();

			return download(saveFilePath);

		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public GroupedProgramData fetchProgramsFromNaqa(String url) {
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String jsonResponse = response.getBody();

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonNode = null;
		try {
			jsonNode = objectMapper.readTree(jsonResponse);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		// Отримайте масив "items" з JSON
		JsonNode itemsNode = jsonNode.get("items");

		GroupedProgramData groupedData = new GroupedProgramData();
		Map<String, List<String>> data = new HashMap<>();

		if (itemsNode != null && itemsNode.isArray()) {
			for (JsonNode itemNode : itemsNode) {
				JsonNode programCycleNameNode = itemNode.get("programCycleName");
				JsonNode programEdboId = itemNode.get("programEdboId");
				JsonNode programName = itemNode.get("programName");

				if (programCycleNameNode != null) {
					String programCycleName = programCycleNameNode.asText();
					String program = programEdboId.asText() + ' ' + programName.asText();

					if (data.containsKey(programCycleName)) {
						data.get(programCycleName).add(program);
					} else {
						List<String> specialities = new ArrayList<>();
						specialities.add(program);
						data.put(programCycleName, specialities);
					}
				}
			}
		}

		groupedData.setPhilosophy(data.get("Доктор філософії"));
		groupedData.setMagistr(data.get("Магістр"));
		groupedData.setBakalavr(data.get("Бакалавр"));
		return groupedData;
	}

	private static class PageNumberEventHandler implements IEventHandler {
		@Override
		public void handleEvent(Event event) {
			PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			PdfDocument pdfDoc = docEvent.getDocument();
			PdfPage page = docEvent.getPage();

			int pageNumber = pdfDoc.getPageNumber(page);

			Rectangle pageSize = page.getPageSize();
			PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);

			PdfFont font = null;
			try {
				font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			pdfCanvas.setFontAndSize(font, 10);

			pdfCanvas.beginText()
				.moveText(pageSize.getWidth() - 50, 30)
				.showText(String.valueOf(pageNumber))
				.endText();

			pdfCanvas.release();
		}
	}

	public DocumentToDownload download(String filePath) {
		try {
			final File file = new File(filePath);
			final InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			return new DocumentToDownload(resource, file.length(), file.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Файл не знайдено в файловій системі");
		}
	}
}
