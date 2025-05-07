package monitor.cameras.rooms;

import monitor.cameras.Camera;
import monitor.cameras.zones.Bedroom;
import monitor.cameras.zones.Zone;

public class BedroomCamera {
    public static void main(String[] args) {
        Zone bedroom = new Bedroom();
        Camera camera = new Camera(bedroom, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        camera.startMonitoring();
        camera.printEvents();
    }
}
