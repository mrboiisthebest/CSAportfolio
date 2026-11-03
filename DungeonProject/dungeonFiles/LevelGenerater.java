package DungeonProject.dungeonFiles;

public class LevelGenerater {

    /*
     * ===================== GENERATE PLAN =====================
     *
     * Generate(height, width, difficulty)   difficulty: 0.0 (easy) -> 1.0 (hard)
     *    |
     *    |-- 1. Build weights: type -> chance (skip EXIT)
     *    |-- 2. Fill String[height][width] with weighted random picks
     *    |-- 3. Put "EXIT" in one spot (e.g. bottom-right)
     *    |-- 4. Tile.GenerateFromArray(finalArray)
     *    '-- 5. (later) Check the exit is reachable, otherwise regenerate
     *
     * ---------------------------------------------------------
     * HELPER: private static HashMap<String, Double> getWeights(double difficulty)
     *   - Loop over Tile.GetValidTypes()
     *   - Skip EXIT (it is placed at the end)
     *   - WALL (cost < 0): fixed weight that grows with difficulty,
     *       e.g. 0.1 + 0.3 * difficulty
     *   - Others: blend "easy" and "hard" weights
     *       easy = 1.0 / cost        (cheap tiles favored)
     *       hard = cost / maxCost    (expensive tiles favored)
     *       weight = (1 - difficulty) * easy + difficulty * hard
     *
     *       cost:         FLOOR=1   MUD=2   LAVA=4
     *       easy (1/c):    1.0      0.5     0.25
     *       hard (c/4):    0.25     0.5     1.0
     *
     * ---------------------------------------------------------
     * HELPER: private static String pickType(HashMap<String, Double> weights)
     *   - total = sum of all weights
     *   - roll = Math.random() * total
     *   - Walk through the types, subtracting each weight from roll;
     *     the first one where roll <= 0 is the pick
     *   - Return "FLOOR" as a fallback (rounding errors)
     *
     *       |---FLOOR---|--MUD--|-LAVA-|WALL|
     *       0          0.6     0.85   0.95  1.0
     *                     ^ roll = 0.7 -> MUD
     *
     * ---------------------------------------------------------
     * HELPER (later): private static boolean isReachable(String[][] map,
     *                                                    int startX, int startY,
     *                                                    int endX, int endY)
     *   - BFS from start using a queue + boolean[][] visited
     *   - Only step onto tiles with cost >= 0 (not WALL)
     *   - Return true if the exit is reached
     *   - In Generate: loop "fill -> place exit -> check" until reachable
     *
     * ---------------------------------------------------------
     * METHODS TO ADD TO Tile.java (optional / nice to have):
     *   - static int GetMaxCost()          -> highest cost in VALID_TYPES
     *                                         (instead of hard-coding 4)
     *   - static int GetCost(String type)  -> VALID_TYPES.get(type)
     *
     *
     * IMPORTS NEEDED HERE: java.util.HashMap (+ java.util.LinkedList /
     *   java.util.Queue for the BFS)
     * =========================================================
     */
    public static void Generate(int height, int width, double difficulty){
        String[][] finalArray;
        // Get Chances For Each Tile Based On Cost, Use Difficulty to scale, generate withought adding an end that will be aded ad the end
        
    }
}
