package monitor.cameras.zones;

public class Garden extends Zone{
    public Garden() {
        //Probabilidades de cada tipo de evento
        //{ MOVEMENT_DETECTED, TERMIC_ANOMALY, STRANGE_SHADOW, SOUND_DETECTED}
        super("Garden", new int[]{40, 40, 40, 40});
    }
}
