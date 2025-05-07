package monitor.cameras.zones;

import monitor.events.Event;

public class Mausoleum extends Zone{


    public Mausoleum() {
        //Probabilidades de cada tipo de evento
        //{ MOVEMENT_DETECTED, TERMIC_ANOMALY, STRANGE_SHADOW, SOUND_DETECTED}
        super("Mausoleum", new int[]{15, 20, 15, 35});
    }
}
