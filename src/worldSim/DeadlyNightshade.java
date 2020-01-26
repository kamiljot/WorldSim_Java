package worldSim;

public class DeadlyNightshade extends Plant{
    public DeadlyNightshade(Position pos, World world){
        super(pos, world);
        this.setName("DeadlyNightshade");
    }

    @Override
    public boolean specialCollision(Organism other){
        other.kill();
        return true;
    }
}
