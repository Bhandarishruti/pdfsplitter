/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.internship.pdfsplitter;

/**
 *
 * @author DELL
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;

public class Pdfsplitter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java PdfSplitter <input_pdf_path> <num_parts>");
            return;
        }
        
        try {
            splitPdf(inputPdfPath, numParts);
            System.out.println("PDF split successfully!");
        } catch (IOException e) {
            System.err.println("Error while splitting PDF: " + e.getMessage());
        }
    }
    private static void splitPdf(String inputPdfPath, int numParts) throws IOException {
       
        PDDocument document = PDDocument.load(new File(inputPdfPath));

        int totalPages = document.getNumberOfPages();
        int pagesPerPart = totalPages / numParts;
        
        for (int i = 0; i < numParts; i++) {
            PDDocument partDocument = new PDDocument();
            
        }

        document.close();


    }
}

