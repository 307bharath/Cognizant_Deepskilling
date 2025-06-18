package FactoryMethodPatternExample.src.com.example.factories;

import FactoryMethodPatternExample.src.com.example.documents.Document;
import FactoryMethodPatternExample.src.com.example.documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}