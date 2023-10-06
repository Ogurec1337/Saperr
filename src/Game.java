public class Game {
    final static public int CELL_SIZE = 40;
    final static public int UPPER_BAR_DY = 20;
    final static public int LOWER_BAR_DY = 60;
    final static public int NUMBER_OF_CELLS = 10;
    final static public int THICKNESS_OF_BORDERLINE = 2;
    final static int widthOfField = Game.NUMBER_OF_CELLS*Game.CELL_SIZE + Game.THICKNESS_OF_BORDERLINE*(Game.NUMBER_OF_CELLS-1);
    final static int heightOfField = Game.NUMBER_OF_CELLS*Game.CELL_SIZE+ Game.LOWER_BAR_DY+Game.UPPER_BAR_DY + Game.THICKNESS_OF_BORDERLINE*(Game.NUMBER_OF_CELLS-1);
    private static boolean gameOver = true;

    public static void setGameOver() {
        Game.gameOver = false;
    }
}
