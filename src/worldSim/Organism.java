package worldSim;

import java.io.Serializable;
import java.util.Objects;


public class Organism implements Serializable{

    public Organism(Position pos, World world){
        this.setAge(0);
        setPos(pos);
        setWorld(world);
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void setWorld(World world) {
        this.world = world;
    }

    public String getName() {
        return name;
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

    public void action(){

    }

    public void collision(Organism attacker, Organism defender){
        if (Objects.equals(attacker.getName(), defender.getName())){
            this.multiply();
            attacker.movePermission = false;
            return;
        }
        if (!this.specialCollision(defender)){
            return;
        }
        if (!defender.specialCollision(this)){
            return;
        }
        if (attacker.getStrength() >= defender.getStrength()){
            defender.kill();
            return;
        }
        attacker.kill();
    }


    protected void multiply(){

    }

    public boolean specialCollision(Organism other){
        return true;
    }

    public void kill(){
        killed=true;
    }

    public boolean isKilled(){
        return killed;
    }


    boolean killed = false;
    protected boolean movePermission = true;
    protected String name;
    protected int age;
    protected int initiative;
    protected int strength;
    protected Position pos;
    protected World world;


}

