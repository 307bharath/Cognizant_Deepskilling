# Factory Method Pattern Example

This project demonstrates the Factory Method Pattern through a simple document management system. The system is designed to create different types of documents, including Word, PDF, and Excel documents, using factory classes.

## Purpose

The Factory Method Pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. This pattern promotes loose coupling by eliminating the need for the client code to know the specific classes of objects it needs to create.

## Project Structure

The project is organized as follows:

- `src/com/example/documents/`
  - `Document.java`: Interface that defines the method `printDocument()`.
  - `WordDocument.java`: Implements the `Document` interface for Word documents.
  - `PdfDocument.java`: Implements the `Document` interface for PDF documents.
  - `ExcelDocument.java`: Implements the `Document` interface for Excel documents.

- `src/com/example/factories/`
  - `DocumentFactory.java`: Abstract class that declares the method `createDocument()`.
  - `WordDocumentFactory.java`: Concrete factory that creates Word documents.
  - `PdfDocumentFactory.java`: Concrete factory that creates PDF documents.
  - `ExcelDocumentFactory.java`: Concrete factory that creates Excel documents.

- `src/com/example/Main.java`: Contains the main method to demonstrate the usage of the Factory Method Pattern.

## How to Run

1. Clone the repository or download the project files.
2. Navigate to the project directory.
3. Compile the Java files using a Java compiler.
4. Run the `Main` class to see the Factory Method Pattern in action.

This project serves as a practical example of how to implement the Factory Method Pattern in Java, showcasing its benefits in creating a flexible and maintainable codebase.