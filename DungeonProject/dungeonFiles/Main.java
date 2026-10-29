package DungeonProject.dungeonFiles;

public class Main{
    public static void main(String[] args) {
       Tile.GenerateTiles(3, 5);
       Tile.PrintTileMap();

       Tile testTile = new Tile("LAVA");
       testTile.SetPos(2, 3);
       Tile.PutTile(testTile);
       testTile.PrintDebug();

       Tile.PrintTileMap();
    }
}