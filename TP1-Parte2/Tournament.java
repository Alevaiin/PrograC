import java.util.*;

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

    public void showResults(){
        String leftAlignFormat = "| %-2d | %-16s | %-3d | %-2d | %-2d | %-2d | %-2d | %-2d | %-2d | %-3d |%n";

        System.out.format("+---+-------------------+-----+----+----+----+----+----+----+-----+%n");
        System.out.format("| # | Equipo            | Pts | PJ | PG | PE | PP | GF | GC | DIF |%n");
        System.out.format("+---+-------------------+-----+----+----+----+----+----+----+-----+%n");
        List<Team> teamsInOrder = this.teamsStats.keySet().stream().sorted((o1, o2) -> this.teamsStats.get(o2).compareTo(this.teamsStats.get(o1))).toList();

        for (int i = 0; i < teamsInOrder.size(); i++) {
            Team team = teamsInOrder.get(i);
            Stats stats = this.teamsStats.get(team);
            System.out.format(leftAlignFormat, i+1, team.getName(), stats.getPoints(), stats.getPlayed(), stats.getWon(), stats.getTied(), stats.getLost(), stats.getGoalsInFavor(), stats.getGoalsAgainst(), stats.getGoalsDiff());
        }
        System.out.format("+---+-------------------+-----+----+----+----+----+----+----+-----+%n");
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
