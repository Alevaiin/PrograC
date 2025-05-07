package monitor.cameras;

import monitor.events.Event;
import monitor.events.EventsCounter;
import monitor.cameras.zones.Zone;

public class Camera {

    private long startTime;
    private long lastEvent = 0;
    private final Integer frequency;
    private final Integer duration;
    private EventsCounter eventsCounter;
    private final Zone zone;

    public Camera(Zone zone, Integer duration, Integer frequency){
        this.zone = zone;
        this.frequency = frequency;
        this.duration = duration;
        this.eventsCounter = new EventsCounter();
    }


    private void check(long aliveTime){
        if(( aliveTime - lastEvent) >= frequency){
            this.lastEvent = aliveTime;
            Event event = this.zone.generateEvent();
            System.out.println("Evento "+ event.name()+ " generado en: "+ zone.getName());
            this.eventsCounter.addEvent(event);
        }
    }

    private void resetCounter(){
        this.eventsCounter = new EventsCounter();
    }

    public void startMonitoring() {
        this.startTime = System.currentTimeMillis();
        long aliveTime = System.currentTimeMillis() - startTime;
        while( aliveTime < duration) {
            this.check(aliveTime);
            aliveTime = System.currentTimeMillis() - startTime;
        }
        System.out.println("Camara de " + this.zone.getName() +" finalizo");
    }

    public void printEvents(){
        String result = this.zone.getName()+": \n" + eventsCounter.toString();
        System.out.println(result);
    }
}
