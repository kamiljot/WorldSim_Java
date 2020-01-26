package worldSim;

public class Cheetah extends Animal {
    public Cheetah(Position pos, World world) {
        super(pos, world);
        this.setName("Cheetah");
        this.setInitiative(4);
        this.setStrength(4);
    }

    @Override
    public void action(){
        move(world.randomAround(pos, 3));
    }

}
