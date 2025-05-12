package monitor.events;

import java.util.Arrays;

public enum Event {

    NO_ACTIVITY(0),
    MOVEMENT_DETECTED(1),
    TERMIC_ANOMALY(2),
    STRANGE_SHADOW(3),
    SOUND_DETECTED(4);

    private final int value;

    Event(int value){
        this.value = value;
    }

    public static Event valueOf(int value){
        return Arrays.stream(values())
                .filter(event -> event.value == value)
                .findFirst()
                .orElse(NO_ACTIVITY);
    }

}
