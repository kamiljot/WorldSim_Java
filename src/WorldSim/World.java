package WorldSim;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import GUI.Frame;

public class World implements Serializable {

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
        //TODO
    }


    public void newTurn(){

    }//TODO

    public void drawMap(){

    }//TODO



}
