package FactoryMethodPatternExample.src.com.example.documents;
public class WordDocument implements Document {
    @Override
    public void printDocument() {
        System.out.println("Printing Word Document");
    }
}