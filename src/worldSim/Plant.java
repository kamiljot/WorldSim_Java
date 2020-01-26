package worldSim;

import java.util.Random;

public class Plant extends Organism {
    public Plant(Position pos, World world) {
        super(pos, world);
        this.setInitiative(0);
        this.setStrength(0);
    }

    @Override
    public void multiply()
    {
        Random random = new Random();
        Position newPos = world.freeRandomAround(pos, 1);
        if(newPos.isOccupied(pos))return;
        if(random.nextInt(12)==0)
        {
            world.addOrganism(newPos, name);
        }
    }

    public void action()
    {
        multiply();
    }

}
