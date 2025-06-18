package FactoryMethodPatternExample.src.com.example;
// Import necessary packages
import FactoryMethodPatternExample.src.com.example.documents.Document;
import FactoryMethodPatternExample.src.com.example.factories.DocumentFactory;
import FactoryMethodPatternExample.src.com.example.factories.WordDocumentFactory;
import FactoryMethodPatternExample.src.com.example.factories.PdfDocumentFactory;
import FactoryMethodPatternExample.src.com.example.factories.ExcelDocumentFactory;

public class Main {
    public static void main(String[] args) {
        // Create a Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.printDocument();

        // Create a PDF document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.printDocument();

        // Create an Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.printDocument();
    }
}