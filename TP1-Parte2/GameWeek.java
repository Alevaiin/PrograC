import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameWeek {

    private String gameWeekNumber;
    private List<Match> matches;

    public GameWeek(String gameWeekNumber, List<Match> matches){
        this.gameWeekNumber = gameWeekNumber;
        this.matches = matches;
    }

    public List<Match> play(){
        System.out.println("Jugando fecha "+this.gameWeekNumber);
        int poolSize = matches.size();
        CountDownLatch latch = new CountDownLatch(poolSize);
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        for (Match match : matches){
            executor.submit(() -> {
                match.run();
                latch.countDown();
            });
        }

        executor.shutdown();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return matches;
    }

    @Override
    public String toString() {
        String text = "Fecha "+gameWeekNumber +":\n";
        for (Match match : matches){
            text = text.concat(match.toString()+"\n");
        }
        return text;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public String getGameWeekNumber() {
        return gameWeekNumber;
    }

    public boolean isFinished(){
        boolean isFinished = true;
        for ( Match match : this.matches){
            isFinished = isFinished && match.isFinished();
        }
        return isFinished;
    }
}
