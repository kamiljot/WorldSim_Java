package worldSim;

public class Sheep extends Animal {
    public Sheep(Position pos, World world) {
        super(pos, world);
        this.setName("Sheep");
        this.setInitiative(4);
        this.setStrength(4);
    }
}
