package BuilderPatternExample;

public class Main {
    public static void main(String[] args) {

         // Office computer
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .storage("512GB SSD")
                .os("Windows 10")
                .build();

        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
                .storage("256GB SSD")
                .build();

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i5", "32GB")
                .storage("1TB SSD")
                .graphicsCard("NVIDIA RTX 4090")
                .os("Windows 11")
                .build();

        System.out.println(basicComputer+"\n");
        System.out.println(gamingComputer+"\n");
        System.out.println(officeComputer+"\n");
    }
}
