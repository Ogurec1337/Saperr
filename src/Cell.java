public class Cell {
    private enum StateOfCell{EMPTY,HAS_BOMB_NEARBY,HAS_BOMB}
    public int xNumber;
    public int yNumber;
    private StateOfCell stateOfCell;
    private static final int[][] massivOfCells = new int[Game.NUMBER_OF_CELLS-1][Game.NUMBER_OF_CELLS-1];
    Cell() {
        ////вренменное решение - заполнить все ячейки значениями по умолчанию
        for (int i = 0; i < Game.NUMBER_OF_CELLS;i++){
            for (int j = 0; j < Game.NUMBER_OF_CELLS;j++){
                massivOfCells[i][j] = StateOfCell.EMPTY.ordinal();
            }
        }
    }

    public static int[][] getMassivOfCells(){
        return massivOfCells;
    }

}
