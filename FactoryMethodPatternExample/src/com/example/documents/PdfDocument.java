package FactoryMethodPatternExample.src.com.example.documents;
public class PdfDocument implements Document {
    @Override
    public void printDocument() {
        System.out.println("Printing PDF Document");
    }
}