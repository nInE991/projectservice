package com.example.projectservice.service;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfService extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter,
									HttpServletRequest httpServletRequest,
									HttpServletResponse httpServletResponse) throws Exception {
	}
}
