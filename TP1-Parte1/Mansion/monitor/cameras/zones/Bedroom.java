package monitor.cameras.zones;

public class Bedroom extends Zone{
    public Bedroom() {
        //Probabilidades de cada tipo de evento
        //{ MOVEMENT_DETECTED, TERMIC_ANOMALY, STRANGE_SHADOW, SOUND_DETECTED}
        super("Bedroom",new int[]{20, 20, 20, 20});
    }
}
