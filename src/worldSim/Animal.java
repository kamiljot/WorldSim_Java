package worldSim;

public class Animal extends Organism {

    public Animal(Position pos, World world) {
        super(pos, world);
    }

    @Override
    protected void multiply(){
        Position newPos = world.freeRandomAround(pos, 1);
        if (newPos.isOccupied(this.pos)){
            return;
        }
        world.addOrganism(newPos, this.getName());
    }

    @Override
    public void action(){
        movePermission = true;
        move(world.randomAround(pos, 1));
    }

    protected void move(Position newPos){
        if (newPos.isOccupied(pos)){
            return;
        }
        if (!world.inBoundaries(newPos)){
            return;
        }
        if (world.isEmpty(newPos)){
            setPos(newPos);
            return;
        }
        Organism enemy = world.findObject(newPos);
        if (!enemy.isKilled()){
            collision(this, enemy);
        }
        if (!this.isKilled() && this.movePermission){
            setPos(newPos);
        }
    }
}
