package FactoryMethodPatternExample.src.com.example.documents;
public class ExcelDocument implements Document {
    @Override
    public void printDocument() {
        System.out.println("Printing Excel Document");
    }
}
