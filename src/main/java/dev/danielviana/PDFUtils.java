package dev.danielviana;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dev.danielviana.relatorio.model.City;

public class PDFUtils {

    public static ByteArrayInputStream generatePDf(List<City> list){
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        try {
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1,2});

            PdfPCell header;
            header = new PdfPCell(new Phrase("ID"));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(header);
            
            header = new PdfPCell(new Phrase("NAME"));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(header);
            
            for(City data: list){
                PdfPCell body;
                body = new PdfPCell(new Phrase(data.getId().toString()));
                body.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(body);
                
                body = new PdfPCell(new Phrase(data.getName()));
                body.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(body);
            }

            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            document.add(table);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
    
}
