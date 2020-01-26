package worldSim;

import java.util.Random;

public class Turtle extends Animal{

    public Turtle(Position pos, World world){
        super(pos, world);
        this.setName("Turtle");
        this.setInitiative(1);
        this.setStrength(2);
    }

    @Override
    public void action(){
        Random rnd = new Random();
        if (rnd.nextInt(4) == 0){
            return;
        }
        move(world.randomAround(pos, 1));
    }

    @Override
    public boolean specialCollision(Organism other){
        if (other.getStrength() < 5){
            other.movePermission = false;
            this.movePermission = false;
            return false;
        }
        return true;
    }
}
