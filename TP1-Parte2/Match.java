import java.util.Random;

public class Match {
    private final Team home;
    private final Team away;
    private MatchResult matchResult;

    private final int MIN_MATCH_DURATION = 100; //Duracion minima de un partido en ms
    private final int MAX_MATCH_DURATION = 500; //Duracion maxima de un partido en ms

    private final int MIN_SLEEP_TIME = 50;
    private final int MAX_SLEEP_TIME = 100;

    public Match(Team home, Team away){
        this.home = home;
        this.away = away;
    }

    @Override
    public String toString() {
        return home.getName() + " vs "+away.getName();
    }

    public MatchResult play(){
        Integer powerHome = home.getPower();
        Integer powerAway = away.getPower();

        Random rand = new Random();
        long maxTime = System.nanoTime() + MAX_MATCH_DURATION;

        int sleepTime = rand.nextInt(MAX_SLEEP_TIME-MIN_SLEEP_TIME) + MIN_SLEEP_TIME;
        int pointsHome = 0;
        int pointsAway = 0;

        while(System.nanoTime() < maxTime){

            pointsHome += (int) Math.round(rand.nextGaussian() * powerHome + (powerHome / 25.0));
            pointsAway += (int) Math.round(rand.nextGaussian() * powerAway + (powerAway / 25.0));

        }

        return new MatchResult();

    }

    private void matchTick(){

    }
}
