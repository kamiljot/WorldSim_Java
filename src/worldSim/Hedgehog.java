package worldSim;

public class Hedgehog extends Animal {
    public Hedgehog(Position pos, World world){
        super(pos, world);
        this.setName("Hedgehog");
        this.setInitiative(3);
        this.setStrength(2);
    }

   /* @Override
    public boolean specialCollision(Organism other){
      if (this.isKilled()){
          other.movePermission = false;
          return false;
      }
      return true;
    }*/
}
