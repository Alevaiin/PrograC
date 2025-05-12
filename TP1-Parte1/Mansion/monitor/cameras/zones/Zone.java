package monitor.cameras.zones;

import monitor.events.Event;

import java.util.Random;

public abstract class Zone {

    private final int[] probabilites;

    private final String name;

    public Zone(String name, int[] probabilites) {
        this.name = name;
        this.probabilites = probabilites;
    }

    public Event generateEvent(){
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int cumulativeProbability = 0;
        for (int i = 0; i < probabilites.length; i++) {
            cumulativeProbability += probabilites[i];
            if (randomNumber < cumulativeProbability) {
                return Event.valueOf(i+1);
            }
        }
        return Event.valueOf(0);
    }

    public String getName() {
        return name;
    }
}
