package WorldSim;


public class Organism {

    public void setAge(int age) {
        this.age = age;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public int getAge() {
        return age;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getStrength() {
        return strength;
    }

    public Position getPos() {
        return pos;
    }

    protected int age;
    protected int initiative;
    protected int strength;
    protected Position pos;


}

