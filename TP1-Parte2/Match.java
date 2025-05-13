import java.util.Random;

public class Match implements Runnable {
    private final Team home;
    private final Team away;
    private MatchResult matchResult;

    private final int MIN_MATCH_DURATION = 100; //Duracion minima de un partido en ms
    private final int MAX_MATCH_DURATION = 500; //Duracion maxima de un partido en ms

    private final int MIN_TICK_WEIGHT = 1;
    private final int MAX_TICK_WEIGHT = 5;

    private final double PERCENTAGE_DIFFERENCE_TO_GOAL = 0.2;

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
        int pointsHome;
        int pointsAway;

        int goalsHome = 0;
        int goalsAway = 0;

        Random rand = new Random();
        long now = System.nanoTime();
        long maxTime = now + MAX_MATCH_DURATION;


        while(now < maxTime){
            pointsHome = (int) Math.round(rand.nextGaussian() * powerHome);
            pointsAway = (int) Math.round(rand.nextGaussian() * powerAway);

            if(pointsAway * PERCENTAGE_DIFFERENCE_TO_GOAL > Math.abs(pointsHome - pointsAway) )
                if(pointsAway > pointsHome)
                    goalsAway++;
                else
                    goalsHome++;

            now = System.nanoTime();
        }
        this.matchResult = new MatchResult(goalsHome, goalsAway);
        return this.matchResult;

    }

    @Override
    public void run() {
        System.out.println("Iniciando "+this.toString());
        play();

        System.out.println("Resultado "+this.toString()+": "+ this.matchResult);
    }

    public boolean isFinished(){
        return matchResult != null;
    }

    public MatchResult getResult() {
        return this.matchResult;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }
}
