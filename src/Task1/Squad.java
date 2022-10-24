package Task1;


import java.util.Random;


public abstract class Squad extends VolleyballPlayer{

    //    TEAM 1
    static VolleyballPlayer[] team1Players = new VolleyballPlayer[6];
    static String[] team1PlayerNames = {"Matt Anderson", "Fabio Ricci", "Kristers Dardzans", "Dragan Travica", "Thijs ter Horst", "Simone Giannelli"};
    static int[] team1PlayerAge = {35, 28, 21, 36, 31, 26};
    static int[] team1PlayerSkill = {16, 12, 11, 13, 16, 18};
    static String[] playerPosition = {"libero", "outside hitter", "middle blocker", "middle blocker", "setter", "opposite"};
    static int[] agility = {1, 2, 3, 4, 5};




//    TEAM 2
    static VolleyballPlayer[] team2Players = new VolleyballPlayer[6];
    static String[] team2PlayerNames = new String[]{"Teodor Salparov", "Nikolay Uchikov", "Denis Karyagin", "Teodor Todorov", "Georgi Bratoev", "Lubomir Agontsev"};
    static int[] team2PlayerAge = new int[]{40, 36, 20, 33, 33, 35};
    static int[] team2PlayerSkill = new int[]{16, 14, 11, 15, 16, 18};

    public Squad() {
        super();
    }

    public static VolleyballPlayer[] setSquad(VolleyballPlayer[] players, String[] name, int[] age, int[] skill, String[] position) {
        for (int i = 0; i < players.length; i++) {
            players[i] = new VolleyballPlayer(name[i], age[i], skill[i], position[i], getPlayerAgility(agility));

        }return players;
    }

    public static int getPlayerAgility(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

   public static void teamTraining(VolleyballPlayer[] players) {
        for (VolleyballPlayer player : players) player.train();

    }

    public static void teamRest(VolleyballPlayer[] players) {
        for (VolleyballPlayer player : players) player.rest();

    }


}
