package DungeonProject.dungeonFiles;

public class Main{
    public static void main(String[] args) {
        Tile.GenerateRandomTiles(3, 5);

        Tile testTile = new Tile("LAVA");
        testTile.SetPos(1, 2);
        Tile.PutTile(testTile);
        testTile.AddInhabitant("Player");

        testTile.PrintDebug();
        Tile.PrintTileMap();
    }
}