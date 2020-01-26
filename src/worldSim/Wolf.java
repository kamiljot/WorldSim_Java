package worldSim;

public class Wolf extends Animal {
    public Wolf(Position pos, World world){
        super(pos, world);
        this.setName("Wolf");
        this.setInitiative(5);
        this.setStrength(9);
    }
}
