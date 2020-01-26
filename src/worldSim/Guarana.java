package worldSim;

public class Guarana extends Plant{
    public Guarana(Position pos, World world) {
        super(pos, world);
        this.setName("Guarana");
    }

    @Override
    public boolean specialCollision(Organism other){
        other.setStrength(other.getStrength() + 3);
        return true;
    }
}
