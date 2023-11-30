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
    }
}

