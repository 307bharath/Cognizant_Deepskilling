package FactoryMethodPatternExample.src.com.example.factories;
import FactoryMethodPatternExample.src.com.example.documents.Document;
public abstract class DocumentFactory {
    public abstract Document createDocument();
}