public class Stats {

    int points = 0;
    int played = 0;
    int won = 0;
    int tied = 0;
    int lost = 0;
    int goalsInFavor = 0;
    int goalsAgainst = 0;
    int goalsDiff = 0;

    public void addVictory(MatchResult result){
        this.played ++;
        this.won++;
        this.points += 3;
        this.goalsInFavor += Math.max(result.getGoalsAway(), result.getGoalsHome());
        this.goalsAgainst += Math.min(result.getGoalsAway(), result.getGoalsHome());
        this.goalsDiff += Math.abs(result.getGoalsAway() - result.getGoalsHome());
    }

    public void addLost(MatchResult result){
        this.played++;
        this.lost++;
        this.goalsInFavor += Math.min(result.getGoalsAway(), result.getGoalsHome());
        this.goalsAgainst += Math.max(result.getGoalsAway(), result.getGoalsHome());
        this.goalsDiff -= Math.abs(result.getGoalsAway() - result.getGoalsHome());
    }

    public void addTie(MatchResult result){
        this.played++;
        this.tied++;
        this.points += 1;
        this.goalsInFavor += result.getGoalsAway();
        this.goalsAgainst += result.getGoalsAway();
    }




}
