package BuilderPatternExample;

public class Computer {
    // Required parameters
    private String cpu;
    private String ram;
    // Optional parameters
    private String storage;
    private String graphicsCard;
    private String os;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.os = builder.os;
    }

    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram +
               ", Storage=" + storage + ", GraphicsCard=" + graphicsCard +
               ", OS=" + os + "]";
    }

    // Static nested Builder class
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private String os;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder os(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
