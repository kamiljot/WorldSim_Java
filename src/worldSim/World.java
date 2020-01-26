package worldSim;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import gui.Frame;

public class World /*implements Serializable */{

    protected Position size;
    protected ArrayList<ArrayList<Organism>> organisms;
    protected Frame mainFrame;

    public World(int x, int y){
        size = new Position(x, y);

        organisms = new ArrayList<>();
        for (int i = 0; i < y; i++){
            organisms.add(new ArrayList<>());
        }
    }

    public Organism addOrganism(Position pos, String name){
        if (!isEmpty(pos)){
            return null;
        }
        Organism newOrganism;
        switch (name){
            case "Cheetah":
                newOrganism = new Cheetah(pos, this);
                break;

            case "Hedgehog":
                newOrganism = new Hedgehog(pos, this);
                break;

            case "Sheep":
                newOrganism = new Sheep(pos, this);
                break;

            case "Turtle":
                newOrganism = new Turtle(pos, this);
                break;

            case "Wolf":
                newOrganism = new Wolf(pos, this);
                break;

            case "DeadlyNightshade":
                newOrganism = new DeadlyNightshade(pos, this);
                break;

            case "Grass":
                newOrganism = new Grass(pos, this);
                break;

            case "Guarana":
                newOrganism = new Guarana(pos, this);
                break;

            default:
                return null;
        }
        organisms.get(newOrganism.getInitiative()).add(newOrganism);
        return newOrganism;
    }

    public boolean isEmpty(Position pos){
        for (ArrayList<Organism> organism : organisms){
            for (Organism actual : organism){
                if (actual.getPos().isOccupied(pos)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean inBoundaries(Position pos){
        return pos.x >= 0 && pos.x <= size.x && pos.y >= 0 && pos.y <= size.y;
    }

    public Organism findObject(Position pos){
        for (ArrayList <Organism> organism : organisms){
            for (Organism actual : organism){
                if (actual.getPos().isOccupied(pos)){
                    return actual;
                }
            }
        }
        return null;
    }

    public Position randomAround(Position center, int range){
        Random random = new Random();
        Position newPos = new Position(center.x+(random.nextInt(3)-1)*range,center.y+(random.nextInt(3)-1)*range);
        while (!inBoundaries(newPos) || newPos.equals(center)){
            newPos = new Position(center.x+(random.nextInt(3)-1)*range,center.y+(random.nextInt(3)-1)*range);
        }
        return newPos;
    }

    public Position freeRandomAround(Position center, int range){
        int i = 50;
        Random random = new Random();
        Position newPos = new Position(center.x+(random.nextInt(3)-1)*range,center.y+(random.nextInt(3)-1)*range);
        while (!inBoundaries(newPos) || newPos.equals(center) || !isEmpty(newPos)){
            if (i == 0){
                return center;
            }
            newPos = new Position(center.x+(random.nextInt(3)-1)*range,center.y+(random.nextInt(3)-1)*range);
            i--;
        }
        return newPos;
    }

 /*   public void newTurn(){

    }//TODO

    public void drawMap(){

    }//TODO*/



}
