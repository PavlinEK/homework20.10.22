package Task1;

public class VolleyballPlayer {
    String name;
    int age;
    int skill;
    int agility;
    String position;

    public VolleyballPlayer(String name, int age, int skill, String position, int agility) {
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.position = position;
        this.agility = agility;
    }

    public VolleyballPlayer() {

    }

    public  void train() {

        if (agility < 2)
            System.out.println(name + " needs rest!");
        else {
            agility -= 1;
            skill += 1;
            System.out.println(name + "` SKILL: " + skill);
        }
    }

    public void rest() {
        agility += 1;
        System.out.println(name + "` agility restored: +1!");
        System.out.println(name + "` total agility: " + agility);
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Age: " + age + '\n' +
                "Skill: " + skill + '\n' +
                "Agility: " + agility + '\n' +
                "Position: " + position + '\n' +
                '\n';
    }
}
