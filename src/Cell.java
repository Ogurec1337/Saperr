public class Cell {
    public enum StateOfCell{EMPTY,HAS_BOMB_NEARBY,HAS_BOMB}
    public int xNumber;
    public int yNumber;
    final private StateOfCell stateOfCell;
    private static final Cell[][] massivOfCells = new Cell[Game.NUMBER_OF_CELLS ][Game.NUMBER_OF_CELLS ];
    Cell(StateOfCell stateOfCell){
        this.stateOfCell = stateOfCell;
    }
    public static void createCells(){
        ////вренменное решение - заполнить все ячейки значениями по умолчанию
        for (int i = 0; i < Game.NUMBER_OF_CELLS;i++){
            for (int j = 0; j < Game.NUMBER_OF_CELLS;j++){

                if(i==0)
                    massivOfCells[i][j] = new Cell(StateOfCell.HAS_BOMB);
                else if(i==1)
                    massivOfCells[i][j] = new Cell(StateOfCell.HAS_BOMB_NEARBY);
                else
                    massivOfCells[i][j] = new Cell(StateOfCell.EMPTY);

            }
        }
    }

    public static Cell[][] getMassivOfCells(){
        return massivOfCells;
    }

    public StateOfCell getStateOfCell() {
        return stateOfCell;
    }
}
