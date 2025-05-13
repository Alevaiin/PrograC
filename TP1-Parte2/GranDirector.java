import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GranDirector {
    public static void main(String[] args) {
        List<Team> teams = readTeamsFile("./resources/teamsData.txt");

        Fixture fixture = new Fixture(teams);
        System.out.println(fixture);

        Tournament apertura98 = new Tournament("Apertura 92", fixture);
        apertura98.start();

    }

    private static List<Team> readTeamsFile(String fileName){
        List<Team> teams = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] splittedData = data.split(",");
                teams.add(new Team(splittedData[0], Integer.parseInt(splittedData[1],10)));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el achivo de equipos");
            throw new RuntimeException(e);
        }
        return teams;
    }
}
