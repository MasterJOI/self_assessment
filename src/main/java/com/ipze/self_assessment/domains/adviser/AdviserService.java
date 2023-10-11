package com.ipze.self_assessment.domains.adviser;

import com.ipze.self_assessment.domains.adviser.dto.AdviseDto;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class AdviserService {

	public AdviseDto getAdvise(String startWith) throws IOException {
		/*кінесь кожного блоку (майже)*/
		var endWIth = "Увага! Для уточнення інформації експерти можуть вимагати або ЗВО може надати необхідні документи!";

		URL pdfUrl = new URL("https://naqa.gov.ua/wp-content/uploads/2019/09/%D0%9F%D0%BE%D1%80%D0%B0%D0%B4%D0%BD%D0%B8%D0%BA-%D0%B4%D0%BB%D1%8F-%D0%97%D0%92%D0%9E-%D0%BE%D1%81%D1%82.pdf");
		PDDocument document = PDDocument.load(pdfUrl.openStream());

		try {
			PDFTextStripper textStripper = new PDFTextStripper();

			String pdfText = textStripper.getText(document);

			// Вилучимо номери сторінок з тексту
			Pattern pagePattern = Pattern.compile("\\b\\d+\\b");
			Matcher pageMatcher = pagePattern.matcher(pdfText);
			while (pageMatcher.find()) {
				String pageMatch = pageMatcher.group();
				pdfText = pdfText.replace(pageMatch, "");
			}

			// Вилучимо символи переносу рядків
			pdfText = pdfText.replace("\r", "").replace("\n", "");

			// Замінюємо декілька пробілів на один пробіл
			pdfText = pdfText.replaceAll("\\s+", " ");

			int startIndex = pdfText.indexOf(startWith);

			if (startIndex != -1) {
				int endIndex = pdfText.indexOf(endWIth, startIndex);
				if (endIndex == -1) {
					endIndex = pdfText.length();
				}

				String blockText = pdfText.substring(startIndex, endIndex).trim();

				String clarifyingQuestions = extractTextBetween(blockText, "Уточнювальні питання", "Рекомендовані показники виконання");
				String recommendedIndicators = extractTextBetween(blockText, "Рекомендовані показники виконання", "Документи та інші матеріали, що ЗВО надає експертам в разі потреби");
				String documents = extractTextAfter(blockText, "Документи та інші матеріали, що ЗВО надає експертам в разі потреби");

				return new AdviseDto(clarifyingQuestions, recommendedIndicators, documents);
			} else {
				return null;
			}
		} finally {
			document.close();
		}
	}

	private String extractTextBetween(String text, String start, String end) {
		int startIndex = text.indexOf(start);
		int endIndex = text.indexOf(end, startIndex);
		if (startIndex != -1 && endIndex != -1) {
			return text.substring(startIndex + start.length(), endIndex).trim();
		}
		return "";
	}

	private String extractTextAfter(String text, String start) {
		int startIndex = text.indexOf(start);
		if (startIndex != -1) {
			return text.substring(startIndex + start.length()).trim();
		}
		return "";
	}

}
