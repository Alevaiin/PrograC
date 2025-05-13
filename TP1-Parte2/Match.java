import java.util.Random;

public class Match implements Runnable {
    private final Team home;
    private final Team away;
    private MatchResult matchResult;

    private final int MIN_MATCH_DURATION = 100; //Duracion minima de un partido en ms
    private final int MAX_MATCH_DURATION = 500; //Duracion maxima de un partido en ms

    private final int MS_BETWEEN_TICKS = 5;

    private final double PERCENTAGE_DIFFERENCE_TO_GOAL = 0.2;

    public Match(Team home, Team away){
        this.home = home;
        this.away = away;
    }

    @Override
    public String toString() {
        return home.getName() + " vs "+away.getName();
    }

    public MatchResult play() {
        System.out.println("Iniciando "+this.toString());
        Integer powerHome = home.getPower();
        Integer powerAway = away.getPower();
        int pointsHome;
        int pointsAway;

        int goalsHome = 0;
        int goalsAway = 0;

        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        long duration = rand.nextInt(MAX_MATCH_DURATION-MIN_MATCH_DURATION) + MIN_MATCH_DURATION;

        while(System.currentTimeMillis() < (startTime +duration)){ //Tick
            pointsHome = (int) Math.round(rand.nextGaussian() * powerHome);
            pointsAway = (int) Math.round(rand.nextGaussian() * powerAway);

            if(pointsAway * PERCENTAGE_DIFFERENCE_TO_GOAL > Math.abs(pointsHome - pointsAway) )
                if(pointsAway > pointsHome)
                    goalsAway++;
                else
                    goalsHome++;
            try{
                Thread.sleep(MS_BETWEEN_TICKS);
            }catch (InterruptedException e){
                System.out.println("Error en partido");
            }
        }
        this.matchResult = new MatchResult(goalsHome, goalsAway);
        System.out.println("Resultado "+this.toString()+": "+ this.matchResult + " Duracion: "+(System.currentTimeMillis() - startTime ) + "ms");
        return this.matchResult;
    }

    @Override
    public void run() {
        play();
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
