package monitor.cameras.zones;

public class Kitchen extends Zone{
    public Kitchen() {
        //Probabilidades de cada tipo de evento
        //{ MOVEMENT_DETECTED, TERMIC_ANOMALY, STRANGE_SHADOW, SOUND_DETECTED}
        super("Kitchen",new int[]{50, 30, 0, 20});
    }
}
