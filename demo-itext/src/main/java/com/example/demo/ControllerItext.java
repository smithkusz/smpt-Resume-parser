package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.Character.UnicodeScript;

import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.parser.Path;

@RestController
public class ControllerItext {

	@GetMapping("/")
	public String itext() {
//		 String html = 
//	       " <title> Test Report</title>"+
//	        "<style type='text/css'>.test-result-table {border: 1px solid black;width: 800px;}.test-result-table-header-cell {border-bottom: 1px solid black;background-color: silver;}.test-result-step-command-cell {border-bottom: 1px solid gray;}.test-result-step-description-cell {border-bottom: 1px solid gray;}.test-result-step-result-cell-ok {border-bottom: 1px solid gray;background-color: green;}.test-result-step-result-cell-failure {border-bottom: 1px solid gray;background-color: red;}.test-result-step-result-cell-notperformed {border-bottom: 1px solid gray;background-color: white;}.test-result-describe-cell {background-color: tan;font-style: italic;}.test-cast-status-box-ok {border: 1px solid black;float: left;margin-right: 10px;width: 45px;height: 25px;background-color: green;}</style>"+
//	    		   
//	    
//	    
//	        "<h1 class='test-results-header'>Test Report</h1>"+
//
//	        "<table class='test-result-table' cellspacing='0'<thead><tr><td class='test-result-table-header-cell'>Test Case</td><td class='test-result-table-header-cell'>Description</td><td class='test-result-table-header-cell'>Result</td></tr></thead><tbody><tr class='test-result-step-row test-result-step-row-altone'><td class='test-result-step-command-cell>open /</td><td class='test-result-step-description-cell'>Open browser to '/'</td><td class='test-result-step-result-cell-ok'>O</td></tr><tr class='test-result-step-row test-result-comment-row'><td class='test-result-describe-cell' colspan='3'>Describe: This is a comment</td></tr><tr class='test-result-step-row test-result-step-row-alttwo'><td class='test-result-step-command-cell'>click btnG</td><td class='test-result-step-description-cell'>Click on page element with identifier of 'btnG'</td><td class='test-result-step-result-cell-failure'>FAILURE - Unable to find element named 'btnG'</td></tr><tr class='test-result-step-row test-result-step-row-altone'><td class='test-result-step-command-cell'>assertTitle something</td><td class='test-result-step-description-cell'>Test that the title of the page is 'something'</td><td class='test-result-step-result-cell-notperformed'>NOT PERFORMED</td></tr></tbody></table>";
//
//		    String dest = "hello.pdf";
//		    try {
//				HtmlConverter.convertToPdf(html, new FileOutputStream(dest));
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

//		Document document = new Document();
//		try {
//
//			PdfWriter.getInstance(document, new FileOutputStream("iText.pdf"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		document.open();
//		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//		Chunk chunk = new Chunk("This the the creation of itext", font);
//
//		try {
//			document.add(chunk);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		document.close();

		return "the pdf is save in E:\\sumit_workspace\\demo-itext";
	}

	@GetMapping("/itextcore")
	public String itextnew() throws FileNotFoundException {
		String path = "E:\\report.pdf";

		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);

		float columnWidth[] = { 280f, 280f };
		Table table = new Table(columnWidth);
		table.setBackgroundColor(Color.LIGHT_GRAY);
		table.addCell(new Cell().add("REPORT").setTextAlignment(TextAlignment.CENTER).setMarginTop(40f)
				.setMarginBottom(30f).setBorder(Border.NO_BORDER).setFontSize(30f));
		table.addCell(new Cell().add("Sumit kushwaha\nkushwaha379@gmail.com\n9140755327")
				.setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setMarginTop(30f)
				.setMarginBottom(30f));
		Table customerInformation = new Table(columnWidth);
		customerInformation
				.addCell(new Cell(0, 4).add("Jobseeker Information").setBold().setTextAlignment(TextAlignment.CENTER));
		customerInformation.addCell(new Cell().add("Name"));
		customerInformation.addCell(new Cell().add("Raju kumar"));
		customerInformation.addCell(new Cell().add("User Id"));
		customerInformation.addCell(new Cell().add("23456"));
		customerInformation.addCell(new Cell().add("Mobile no"));
		customerInformation.addCell(new Cell().add("9140755327"));
		customerInformation.addCell(new Cell().add("Date of Interview"));
		customerInformation.addCell(new Cell().add("18/10/2022"));
		customerInformation.addCell(new Cell().add("Designation"));
		customerInformation.addCell(new Cell().add("Developer"));

		Table tableSignatue = new Table(columnWidth);
		tableSignatue.addCell(new Cell(0, 4).add("Signature").setBold().setTextAlignment(TextAlignment.RIGHT)
				.setMarginTop(60f).setMarginBottom(30f).setMarginRight(30f));

		document.add(table);
		document.add(customerInformation);
		document.add(tableSignatue);
		document.close();
		return "Saved in the location - 'E:\\report.pdf'";

	}

	@GetMapping("/pdf")
	public ResponseEntity<InputStreamResource> getTermsConditions() throws Exception {

		String filePath = "E:\\";
		String fileName = "report.pdf";
		File file = new File(filePath + fileName);
		HttpHeaders headers = new HttpHeaders();
		// headers.add("content-disposition", "inline;filename=" +fileName);
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);
	}


	@GetMapping("/pdfFileName/{fileName}")
	public ResponseEntity<InputStreamResource> getTermsConditionsFileName(@PathVariable String fileName) throws Exception {

		String filePath = "E:\\";
		File file = new File(filePath + fileName);
		HttpHeaders headers = new HttpHeaders();
		// headers.add("content-disposition", "inline;filename=" +fileName);
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);
	}
}
