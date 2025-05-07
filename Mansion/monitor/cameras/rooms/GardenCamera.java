package monitor.cameras.rooms;

import monitor.cameras.Camera;
import monitor.cameras.zones.Garden;
import monitor.cameras.zones.Zone;

public class GardenCamera {
    public static void main(String[] args) {
        Zone garden = new Garden();
        Camera camera = new Camera(garden, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        camera.startMonitoring();
        camera.printEvents();
    }
}
