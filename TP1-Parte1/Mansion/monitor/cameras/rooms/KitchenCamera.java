package monitor.cameras.rooms;

import monitor.cameras.Camera;
import monitor.cameras.zones.Kitchen;
import monitor.cameras.zones.Zone;

public class KitchenCamera {
    public static void main(String[] args) {
        Zone kitchen = new Kitchen();
        Camera camera = new Camera(kitchen, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        camera.startMonitoring();
        camera.printEvents();
    }
}
