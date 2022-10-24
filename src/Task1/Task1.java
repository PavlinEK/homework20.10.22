package Task1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Task1.Game.rewriteFile;
import static Task1.Squad.*;


public class Task1 {
    static VolleyballTeam team1 = new VolleyballTeam("Perugia", "PalaEvangelisti", "Andrea Anastasi",
            setSquad(team1Players, team1PlayerNames, team1PlayerAge, team1PlayerSkill, playerPosition));
    static VolleyballTeam team2 = new VolleyballTeam("Neftochimic 2010", "Mladost, Sport Hall", "Nikolay Jeliazkov",
            setSquad(team2Players, team2PlayerNames, team2PlayerAge, team2PlayerSkill, playerPosition));


    public static void main(String[] args) throws IOException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);

    }

    public static void menu(Scanner scanner) throws IOException, RuntimeException{

        int num = 0;


        do {
            System.out.println("Please choose an option\n");
            System.out.println("1. Print 'TEAM' info ");
            System.out.println("2. Team practice/ Rest");
            System.out.println("3. GAME ");
            System.out.println("4. Exit");
            try {
                System.out.println("Enter number between 1 and 4: ");
                num = Integer.parseInt(scanner.nextLine());
                switch (num) {
                    case 1 -> {
                        readInfo(scanner, team1, team2, team1Players, team2Players);
                        continue;
                    }
                    case 2 -> {
                        trainingResting(scanner, team1, team2, team1Players, team2Players);
                        continue;
                    }
                    case 3 -> {
                        results(team1, team2);
                        continue;
                    }
                    case 4 -> System.out.println("Exit GAME!");

                }
                if (num < 1 || num >4) {
                    System.out.println("Invalid input! Enter number between 1 and 4!");
                    continue;
                }
                return;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input! Enter number between 1 and 4!");
            }
        } while (4 != num);
    }


    public static void csvFile(String fileName, VolleyballTeam team, VolleyballPlayer[] players) {
        try {
            File teamInfo = new File(fileName);
            if (teamInfo.createNewFile()) {
                FileWriter fwCsv = new FileWriter(teamInfo.getAbsolutePath());
                BufferedWriter bwCsv = new BufferedWriter(fwCsv);
                teamInfo(bwCsv, team);
                playerInfo(bwCsv, players);

                bwCsv.close();
            }
            readFromFile(fileName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void playerInfo(BufferedWriter bw, VolleyballPlayer[] arrays) throws IOException {
        for (VolleyballPlayer array : arrays) {

            bw.write(String.valueOf(array));

        }
    }

    public static void teamInfo(BufferedWriter bw, VolleyballTeam team) throws IOException {
        bw.write(String.valueOf(team));
    }

    public static void readFromFile(String teamName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(teamName));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();
        System.out.println(content);
    }

    public static void readInfo(Scanner scanner, VolleyballTeam team1, VolleyballTeam team2,
                                VolleyballPlayer[] team1Players, VolleyballPlayer[] team2Players) {
        System.out.println("Choose team /1 or2/:");

        int input = scanner.nextInt();
        if (input == 1)
            csvFile(team1.name + "Info.csv", team1, team1Players);
        else if (input == 2)
            csvFile(team2.name + "Info.csv", team2, team2Players);
    }

    public static void results(VolleyballTeam team1, VolleyballTeam team2) {
        try {
            File results = new File("results.txt");
            if (results.createNewFile()) {
                Game.results(results, team1, team2);
            } else {
                rewriteFile(String.valueOf(results), team1, team2);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void trainingResting(Scanner scanner, VolleyballTeam team1, VolleyballTeam
            team2, VolleyballPlayer[] team1Players,
                                       VolleyballPlayer[] team2Players) throws IOException {

        System.out.println("Choose team /1 or2/:");
        int input = scanner.nextInt();
        VolleyballTeam team;
        VolleyballPlayer[] players;
        if (input == 1) {
            team = team1;
            players = team1Players;

        } else if (input == 2) {
            team = team2;
            players = team2Players;
        } else return;
        FileWriter fwCsv;

        fwCsv = new FileWriter(team.name + "Info.csv");

        BufferedWriter bwCsv = new BufferedWriter(fwCsv);
        trainRest(scanner, players);

        teamInfo(bwCsv, team);


        playerInfo(bwCsv, players);
        bwCsv.close();

    }

    public static void trainRest(Scanner scanner, VolleyballPlayer[] players) {
        System.out.println("train / rest");
        String input = scanner.next();
        if (input.equals("train"))
            teamTraining(players);
        else if (input.equals("rest"))
            teamRest(players);

    }
}