package DungeonProject.dungeonFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tile{

    static Tile[][] Tiles = {};

    // Directions
    static final String UP = "up";
    static final String DOWN = "down";
    static final String LEFT = "left";
    static final String RIGHT = "right";

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
    ArrayList<String> inhabitants = new ArrayList<>();

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
        if (y < 0 || y >= Tiles.length || x < 0 || x >= Tiles[y].length){ throw new IllegalArgumentException("Invalid Position!"); }
        this.xPos = x;
        this.yPos = y;
    }

    private boolean isValidType(String type){
        return VALID_TYPES.containsKey(type);
    }

    public void PrintDebug(){
        System.out.println("Cost:" + this.cost + " Type:" + this.type + " X:" + this.xPos + " Y:" + this.yPos);
    }

    public boolean GetWalkable(){
        return this.cost >= 0;
    }


    public static Tile GetTile(int x, int y){
        if (y < 0 || y >= Tiles.length || x < 0 || x >= Tiles[y].length){
            return null;
        }
        return Tiles[y][x];
    }

    public Tile GetTileFromDir(String Dir){
        //Get neighbors, reurn neighbor of dir
        HashMap<String, Tile> neighbors = GetNeighbors(this.xPos, this.yPos);
        Tile target = neighbors.get(Dir);
        if (target == null){
            return null;
        }
        return target;
    }

    public ArrayList<String> GetInhabitants(){
        return this.inhabitants;
    }

    public void AddInhabitant(String target){
        if (!this.inhabitants.contains(target)){
            this.inhabitants.add(target);
        }
    }

    public void RemoveInhabitant(String target){
        if (this.inhabitants.contains(target)){
            this.inhabitants.remove(target);
        }
    }

    public static void GenerateEmptyTiles(int width, int height){
        Tiles = new Tile[height][width];
        for (int i = 0; i < height; i++){
            for (int k = 0; k < width; k++){
                Tile tile = new Tile();
                tile.SetPos(k, i);
                Tiles[i][k] = tile;
            }
        }
    }

    public static String GetRandTileType(){
        String[] types = VALID_TYPES.keySet().toArray(new String[0]);
        int index = (int)(Math.random() * types.length);
        return types[index];
    }

    public static boolean TileMapIncludes(String type){
        for (Tile[] row : Tiles){
            for (Tile x : row){
                if (x.type.equals(type)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void GenerateRandomTiles(int width, int height){
        Tiles = new Tile[height][width];
        boolean exitPlaced = false;


        for (int i = 0; i < height; i++){
            for (int k = 0; k < width; k++){
                String randType = GetRandTileType();

                if (randType.equals("EXIT")){
                    if (exitPlaced){
                        randType = "FLOOR";
                    }
                    exitPlaced = true;
                }

                Tile tile = new Tile(randType);
                tile.SetPos(k, i);
                PutTile(tile);
            }
        }

        if (!exitPlaced){
            Tile exitTile = new Tile("EXIT");
            exitTile.SetPos(width - 1, height - 1); // makes exit tile on the last tile
            PutTile(exitTile);
        }
    }

    public static void GenerateFromArray(String[][] array){
        Tiles = new Tile[array.length][array[0].length];

        for (int y = 0; y < array.length; y++){
            for (int x = 0; x < array[y].length; x++){
                Tile tile = new Tile(array[y][x]);
                tile.SetPos(x, y);
                PutTile(tile);
            }
        }
    }


    public static void PrintTileMap(){
        for (int y = 0; y < Tiles.length; y++){
            for (int x = 0; x < Tiles[y].length; x++){
                Tile target = Tiles[y][x];
                if (!target.GetInhabitants().isEmpty()){
                    System.out.print("# ");
                    continue;
                }
                System.out.print(target.type.charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public static void PutTile(Tile tile){
        Tiles[tile.yPos][tile.xPos] = tile;
    }

    public static void RemoveTile(Tile tile){
        Tile replacment = new Tile();
        replacment.SetPos(tile.xPos, tile.yPos);
        Tiles[tile.yPos][tile.xPos] = replacment;

    }

    public static HashMap<String, Tile> GetNeighbors(int x, int y){
        HashMap<String, Tile> neighbors = new HashMap<>();

        // Neighbors
        Tile upTile = Tile.GetTile(x, y - 1);
        Tile downTile = Tile.GetTile(x, y + 1);
        Tile leftTile = Tile.GetTile(x - 1, y);
        Tile rightTile = Tile.GetTile(x + 1, y);

        if (upTile != null) {
            neighbors.put(Tile.UP, upTile);
        }
        if (downTile != null) {
            neighbors.put(Tile.DOWN, downTile);
        }
        if (leftTile != null) {
            neighbors.put(Tile.LEFT, leftTile);
        }
        if (rightTile != null) {
            neighbors.put(Tile.RIGHT, rightTile);
        }

        return neighbors;
    }
}
