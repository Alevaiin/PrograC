package monitor.cameras.zones;

public class Attic extends Zone{
    public Attic() {
        //Probabilidades de cada tipo de evento
        //{ MOVEMENT_DETECTED, TERMIC_ANOMALY, STRANGE_SHADOW, SOUND_DETECTED}
        super("Attic",new int[]{15, 0, 40, 50});
    }
}
