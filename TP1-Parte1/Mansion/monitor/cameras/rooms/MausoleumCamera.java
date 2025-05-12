package monitor.cameras.rooms;

import monitor.cameras.zones.Mausoleum;
import monitor.cameras.zones.Zone;
import monitor.cameras.Camera;

public class MausoleumCamera {

    public static void main(String[] args) {
        Zone mausoleum = new Mausoleum();
        Camera camera = new Camera(mausoleum, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        camera.startMonitoring();
        camera.printEvents();
    }
}
