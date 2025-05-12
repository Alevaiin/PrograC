import java.util.List;
import java.util.Map;

public class Tournament {
    private Fixture fixture;
    private Map<Team,Stats> teamsStats;

    public Tournament(String name, List<Team> teams, Fixture fixture){
        this.fixture = fixture;
    }



}
