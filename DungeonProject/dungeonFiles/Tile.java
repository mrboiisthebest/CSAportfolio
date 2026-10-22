package DungeonProject.dungeonFiles;

import java.util.HashMap;

public class Tile{
    int cost;
    String type;
    HashMap<String, Integer> pos = new HashMap<>();
    //Hashmap<String, T> inhabitats;


    public Tile(){
        this.cost = 1;
        this.type = "FLOOR";
    }

    public void SetPos(int x, int y){
        pos.put("x", x);
        pos.put("y", y);
    }

    public HashMap<String, Integer> GetPos(){
        return this.pos;
    }
}
