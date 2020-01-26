package worldSim;

import gui.Frame;
import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldManager extends World {

    private void generateWorld(){
    }

    public void save() throws FileNotFoundException{
        PrintWriter save = new PrintWriter("save.txt");
        for (ArrayList<Organism> initiative : organisms){
            save.print(initiative.size() + String.format("%n"));
            for (Organism actual : initiative){
                save.print(actual.getName() + " " + actual.getPos().x + " " + actual.getPos().y + " " + actual.getAge() + " " + actual.getStrength() + String.format("%n"));
            }
        }
        save.close();
    }

    public void load() throws DifferentWorldSizeException{
        for (ArrayList list : organisms){
            list.clear();
        }
        File file = new File("save.txt");
        Scanner scanner;

        try{
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException ex){
            return;
        }
        for (int i = 0; i < 10; i++){
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++){
                String name = scanner.next();
                Position pos = new Position(scanner.nextInt(), scanner.nextInt());
                Organism newOrg = this.addOrganism(pos, name);
                newOrg.setAge(scanner.nextInt());
                newOrg.setStrength(scanner.nextInt());
                if (pos.x >= size.x || pos.y >= size.y){
                    throw new DifferentWorldSizeException();
                }
            }
        }
        this.drawWorld();
    }

    public void newTurn(){
        for (int i = organisms.size() - 1; i >= 0; i--){
            for (int j = 0; j < organisms.get(i).size(); j++){
                Organism actual = organisms.get(i).get(j);
                if (actual.isKilled()){
                    continue;
                }
                actual.action();
                actual.setAge(actual.getAge() + 1);
            }
        }
        killOrganisms();
        drawWorld();
    }

    private void killOrganisms(){
        for (int i = 0; i < organisms.size(); i++){
            for (int j = 0; j < organisms.get(i).size(); j++){
                Organism actual = organisms.get(i).get(j);
                if (actual.isKilled()){
                    organisms.get(i).remove(j);
                }
            }
        }
    }

    public void drawWorld(){
        mainFrame.clearSimArea();
        organisms.stream().forEach((organism) -> {
            organism.stream().forEach((actual) -> {
                mainFrame.setFieldText(actual.getName(), actual.getPos().x, actual.getPos().y);
            });
        });
    }

    public WorldManager(int x, int y)
    {
        super(x,y);
        mainFrame = new Frame(x, y, this);
        generateWorld();
    }
}

