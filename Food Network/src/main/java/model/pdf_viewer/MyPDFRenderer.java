package model.pdf_viewer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;

import java.io.IOException;

public class MyPDFRenderer extends PDFRenderer {
	MyPDFRenderer(PDDocument document) {
		super(document);
	}

	@Override
	protected PageDrawer createPageDrawer(PageDrawerParameters parameters) throws IOException {
		return new MyPageDrawer(parameters);
	}
}