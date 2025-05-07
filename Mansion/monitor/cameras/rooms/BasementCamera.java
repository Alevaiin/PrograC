package monitor.cameras.rooms;

import monitor.cameras.Camera;
import monitor.cameras.zones.Basement;
import monitor.cameras.zones.Zone;

public class BasementCamera {
    public static void main(String[] args) {
        Zone basement = new Basement();
        Camera camera = new Camera(basement, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        camera.startMonitoring();
        camera.printEvents();
    }
}
