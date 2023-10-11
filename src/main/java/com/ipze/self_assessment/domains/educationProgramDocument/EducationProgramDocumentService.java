package com.ipze.self_assessment.domains.educationProgramDocument;

import com.ipze.self_assessment.exceptions.custom.WrongOperationException;
import com.ipze.self_assessment.model.entity.EducationProgramDocument;
import com.ipze.self_assessment.model.enums.DocumentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class EducationProgramDocumentService {

	@Value("${file.path}")
	private String filePath;

	private final EducationProgramDocumentRepository programDocumentRepository;

	public EducationProgramDocumentService(EducationProgramDocumentRepository programDocumentRepository) {
		this.programDocumentRepository = programDocumentRepository;
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

			return programDocumentRepository.save(document);

		} catch (Exception e) {
			Files.deleteIfExists(path);
			e.printStackTrace();
			throw new WrongOperationException("Файл не придатний");
		}
	}
}
