import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {
    private Fixture fixture;
    private Map<Team,Stats> teamsStats;
    private int currentWeek;

    public Tournament(String name, Fixture fixture){
        this.fixture = fixture;
        this.teamsStats = new HashMap<>();
        for (Team team : fixture.getTeams()){
            this.teamsStats.put(team, new Stats());
        }
    }

    public void start(){
         List<GameWeek> weeks = this.fixture.getWeeks();
         this.currentWeek = 0;

         for (GameWeek week : weeks){
             List<Match> weekMatches = week.play();
             currentWeek++;
             processWeekResults(weekMatches);
         }
    }

    private void processWeekResults(List<Match> matches){
        for (Match match : matches){
            processSingleResult(match);
        }
    }

    private void processSingleResult(Match match){
        MatchResult matchResult = match.getResult();
        ResultType resultType = matchResult.getResult();

        Stats homeStats = this.teamsStats.get(match.getHome());
        Stats awayStats = this.teamsStats.get(match.getAway());

        if(resultType.equals(ResultType.HOME_WON)){
            homeStats.addVictory(matchResult);
            awayStats.addLost(matchResult);
        }

        if(resultType.equals(ResultType.AWAY_WON)){
            awayStats.addVictory(matchResult);
            homeStats.addLost(matchResult);
        }

        if(resultType.equals(ResultType.TIE)){
            awayStats.addTie(matchResult);
            homeStats.addTie(matchResult);
        }
    }


}
