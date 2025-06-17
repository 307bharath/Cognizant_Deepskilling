package FactoryMethodPatternExample.src.com.example.factories;
import FactoryMethodPatternExample.src.com.example.documents.Document;
import FactoryMethodPatternExample.src.com.example.documents.ExcelDocument;
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}