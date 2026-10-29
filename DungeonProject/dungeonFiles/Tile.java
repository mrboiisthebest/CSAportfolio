package DungeonProject.dungeonFiles;

import java.util.HashMap;
import java.util.Map;

public class Tile{

    static Tile[][] Tiles = {};

    static final HashMap<String, Integer> VALID_TYPES = new HashMap<>(Map.of(
        "WALL", -1,
        "EXIT", 0,
        "LAVA", 4,
        "MUD", 2,
        "FLOOR", 1
    ));

    public int cost;
    public String type;
    int xPos;
    int yPos;
    //Hashmap<String, T> inhabitats;

    public Tile(){
        this.cost = 1;
        this.type = "FLOOR";
    }

    public Tile(String type){
        if (!isValidType(type)){
            throw new IllegalArgumentException("Invalid Tile Type!");
        }
        this.type = type;
        this.cost = VALID_TYPES.get(this.type);
    }

    public static HashMap<String, Integer> GetValidTypes(){
        return VALID_TYPES;
    }

    public void SetPos(int x, int y){
        if (y < 0 || y >= Tiles.length || x < 0 || x >= Tiles[y].length){ return; }
        this.xPos = x;
        this.yPos = y;
    }

    private boolean isValidType(String type){
        return VALID_TYPES.containsKey(type);
    }

    public void PrintDebug(){
        System.out.println("Cost:" + this.cost + " Type:" + this.type + " X:" + this.xPos + " Y:" + this.yPos);
    }


    public static Tile GetTile(int x, int y){
        if (y < 0 || y >= Tiles.length || x < 0 || x >= Tiles[y].length){
            return null;
        }
        return Tiles[y][x];
    }

    public static void GenerateTiles(int width, int height){
        Tiles = new Tile[height][width];
        for (int i = 0; i < height; i++){
            for (int k = 0; k < width; k++){
                Tile tile = new Tile();
                tile.SetPos(k, i);
                Tiles[i][k] = tile;
            }
        }
    }

    public static void PrintTileMap(){
        for (int y = 0; y < Tiles.length; y++){
            for (int x = 0; x < Tiles[y].length; x++){
                System.out.print(Tiles[y][x].type.charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public static void PutTile(Tile tile){
        Tiles[tile.yPos][tile.xPos] = tile;
    }

    public static void RemoveTile(Tile tile){
        Tiles[tile.yPos][tile.xPos] = new Tile();
    }




}
