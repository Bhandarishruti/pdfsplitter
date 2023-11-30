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

        String inputPdfPath = args[0];
        int numParts = Integer.parseInt(args[1]);

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
        int remainingPages = totalPages % numParts;

        for (int i = 0; i < numParts; i++) {
            PDDocument partDocument = new PDDocument();

            int startPage = i * pagesPerPart;
            int endPage = (i + 1) * pagesPerPart;

            if (i == numParts - 1) {
                // Include remaining pages in the last part
                endPage += remainingPages;
            }

            for (int j = startPage; j < endPage && j < totalPages; j++) {
                partDocument.addPage(document.getPage(j));
            }

            String outputPdfPath = "data\\output_part_" + (i + 1) + ".pdf";
            partDocument.save(outputPdfPath);
            partDocument.close();

            System.out.println("Part " + (i + 1) + " saved to: " + outputPdfPath);
        }

        document.close();
    }

}