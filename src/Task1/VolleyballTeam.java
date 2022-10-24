package Task1;

public class VolleyballTeam extends Squad{

    String name;
    String stadium;
    String coach;
    double teamStrength;


    public VolleyballTeam(String name, String stadium, String coach, VolleyballPlayer[] players) {
        super();
        this.name = name;
        this.stadium = stadium;
        this.coach = coach;
        this.teamStrength = calculateStrength(players);
    }

       public double calculateStrength(VolleyballPlayer[]players) {
        double teamStrength;
        teamStrength = 0;
        for (VolleyballPlayer player : players) {
            teamStrength += player.skill;
        }
        return teamStrength;
    }

    @Override
    public String toString() {
        return
                "TEAM: " + name + '\n' +
                "Stadium: " + stadium + '\n' +
                "Coach: " + coach + '\n' +
                "Team Strength: " + teamStrength +
                '\n'+'\n';
    }
}
