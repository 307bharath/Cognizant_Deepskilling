package CommandPatternExample;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is ON

         remote.setCommand(null);
        remote.pressButton(); // Output: No command set.

        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is OFF

       
    }
}
