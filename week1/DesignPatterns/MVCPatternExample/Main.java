package MVCPatternExample;

public class Main {
    public static void main(String[] args) {
        // Create model and view
        Student student = new Student("Bharadwaj", "5586", "A");
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update student details
        controller.setStudentName("Geethu");
        controller.setStudentId("1234");
        controller.setStudentGrade("A+");

        // Display updated details
        controller.updateView();
    }
}