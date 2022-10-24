package Task1;

import java.io.*;
import java.util.Random;

import static Task1.Task1.readFromFile;

public abstract class Game {
    public VolleyballTeam team1;
    public VolleyballTeam team2;

    public Game(VolleyballTeam team1, VolleyballTeam team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public static void playMatch(BufferedWriter bw, VolleyballTeam team1, VolleyballTeam team2) throws IOException {
        double team1Score = team1.teamStrength + getRandom(25, 1);
        double team2Score = team2.teamStrength + getRandom(25, 1);
        bw.write(team1.name + " " + "power score: " + team1Score + '\n');
        bw.write(team2.name + " " + "power score: " + team2Score + '\n');

        if (team1Score < team2Score)
            bw.write(team2.name + " is WINNER!!!" + '\n');
        else if (team2Score < team1Score)
            bw.write(team1.name + " is WINNER!!!" + '\n');
        else
            bw.write("DRAW" + '\n');
        bw.close();

    }

    public static int getRandom(int high, int low) {
        Random random = new Random();
        return random.nextInt(low, high) + 1;
    }

    public static void results(File file, VolleyballTeam team1, VolleyballTeam team2) throws IOException {

        FileWriter fwTxt = new FileWriter(file.getAbsolutePath());
        BufferedWriter bwTxt = new BufferedWriter(fwTxt);

        playMatch(bwTxt, team1, team2);

        bwTxt.close();

        readFromFile(String.valueOf(file));
    }

    public static void rewriteFile(String fileName, VolleyballTeam team1, VolleyballTeam team2) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("");
            playMatch(bw, team1, team2);
            readFromFile(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
