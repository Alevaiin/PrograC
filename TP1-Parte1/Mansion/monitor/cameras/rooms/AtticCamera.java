package monitor.cameras.rooms;

import monitor.cameras.Camera;
import monitor.cameras.zones.Attic;
import monitor.cameras.zones.Zone;

public class AtticCamera {
    public static void main(String[] args) {
        Zone attic = new Attic();
        Camera camera = new Camera(attic, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        camera.startMonitoring();
        camera.printEvents();
    }
}
