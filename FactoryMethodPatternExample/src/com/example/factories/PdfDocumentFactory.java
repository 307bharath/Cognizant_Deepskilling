package FactoryMethodPatternExample.src.com.example.factories;
import FactoryMethodPatternExample.src.com.example.documents.Document;
import FactoryMethodPatternExample.src.com.example.documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}