package monitor.cameras.zones;

public class Basement extends Zone{
    public Basement() {
        //Probabilidades de cada tipo de evento
        //{ MOVEMENT_DETECTED, TERMIC_ANOMALY, STRANGE_SHADOW, SOUND_DETECTED}
        super("Basement",new int[]{0, 10, 35, 25});
    }
}
