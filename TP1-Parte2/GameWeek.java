import java.util.List;

public class GameWeek {

    String gameWeekNumber;
    List<Match> matches;

    public GameWeek(String gameWeekNumber, List<Match> matches){
        this.gameWeekNumber = gameWeekNumber;
        this.matches = matches;
    }

    @Override
    public String toString() {
        String text = "Fecha "+gameWeekNumber +":\n";
        for (Match match : matches){
            text = text.concat(match.toString()+"\n");
        }
        return text;
    }
}
