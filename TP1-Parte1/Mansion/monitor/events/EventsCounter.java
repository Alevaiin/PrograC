package monitor.events;

import java.util.HashMap;
import java.util.Map;

public class EventsCounter {

    private Map<Event,Integer> eventsMap;

    public EventsCounter(){
        this.eventsMap = new HashMap<>() {{
            put(Event.NO_ACTIVITY, 0);
            put(Event.MOVEMENT_DETECTED, 0);
            put(Event.TERMIC_ANOMALY, 0);
            put(Event.SOUND_DETECTED, 0);
            put(Event.STRANGE_SHADOW, 0);
        }};
    }

    public void addEvent(Event event){
        eventsMap.replace(event, eventsMap.get(event)+1);
    }

    public Map<Event,Integer> getEventsMap(){
        return this.eventsMap;
    }

    @Override
    public String toString() {
        String string = "";
        for (Event event : eventsMap.keySet() ){
            string = string.concat(eventsMap.get(event)+" "+event.toString()+"\n");
        }
        return string;
    }
}
