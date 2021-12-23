package it.unisa.app;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Converter {
    public boolean converter(String path) {
        try {
            FileInputStream docFile = new FileInputStream(new File(path));
            XWPFDocument doc = new XWPFDocument(docFile);
            PdfOptions options = PdfOptions.create();
            String pdf = changeExtensionToPDF(path);
            OutputStream out = new FileOutputStream(pdf);
            PdfConverter.getInstance().convert(doc, out, options);
            doc.close();
            out.close();
            return true;
        } catch (
                Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public static String changeExtensionToPDF(String originalPath) {

//		String separator = System.getProperty("file.separator");
        String filename = originalPath;

//		// Remove the path upto the filename.
//		int lastSeparatorIndex = originalPath.lastIndexOf(separator);
//		if (lastSeparatorIndex == -1) {
//			filename = originalPath;
//		} else {
//			filename = originalPath.substring(lastSeparatorIndex + 1);
//		}

        // Remove the extension.
        int extensionIndex = filename.lastIndexOf(".");

        String removedExtension;
        if (extensionIndex == -1){
            removedExtension =  filename;
        } else {
            removedExtension =  filename.substring(0, extensionIndex);
        }
        String addPDFExtension = removedExtension + ".pdf";
        System.out.println(addPDFExtension);
        return addPDFExtension;
    }
}
