package worldSim;
import java.io.Serializable;

public class Position implements Serializable{
    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    static Position zero(){
        return new Position(0, 0);
    }

    public boolean isOccupied(Position field){
        return this.x == field.x && this.y == field.y;
    }

}
