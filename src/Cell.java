import java.util.ArrayList;

public class Cell {
    public enum StateOfCell{EMPTY,HAS_BOMB_NEARBY,HAS_BOMB}
    public int xNumber;
    public int yNumber;
    final private StateOfCell stateOfCell;
    private int numberOfMinesNearby = 0;
    private static final Cell[][] massivOfCells = new Cell[Game.NUMBER_OF_CELLS ][Game.NUMBER_OF_CELLS ];
    Cell(StateOfCell stateOfCell){
        this.stateOfCell = stateOfCell;
    }
    public void incrementNumberOfMines(){
        this.numberOfMinesNearby++;
    }
    public int getNumberOfMines(){
        return numberOfMinesNearby;
    }

    public ArrayList<Cell> aroundCells(int iCordinate,int jCordinate){
        ArrayList<Cell> list = new ArrayList<>();
        int xCordinateForCycle = jCordinate-1;
        int yCordinateForCycle = iCordinate-1;
        for(int i = 0;i <8;i++){
            if(i==1) xCordinateForCycle++;
            else if(i==2) xCordinateForCycle++;
            else if(i==3) iCordinate++;
            else if(i==4) iCordinate++;
            else if(i==5) xCordinateForCycle--;
            else if(i==6) xCordinateForCycle--;
            else if(i==7) yCordinateForCycle--;

            if(xCordinateForCycle>=0 && yCordinateForCycle>=0 && xCordinateForCycle<9 && yCordinateForCycle<9 )
                list.add(massivOfCells[xCordinateForCycle][yCordinateForCycle]);
        }
        return list;
    }
    public static void createCells(){
        ////вренменное решение - заполнить все ячейки значениями по умолчанию
        ArrayList<Cell> listBombsNearby = new ArrayList<>();
        for (int i = 0; i < Game.NUMBER_OF_CELLS;i++){
            for (int j = 0; j < Game.NUMBER_OF_CELLS;j++){

                if(i==0)
                    massivOfCells[i][j] = new Cell(StateOfCell.HAS_BOMB);
                else if(i==1)
                    massivOfCells[i][j] = new Cell(StateOfCell.HAS_BOMB_NEARBY);
                else
                    massivOfCells[i][j] = new Cell(StateOfCell.EMPTY);
                if(massivOfCells[i][j].stateOfCell == StateOfCell.HAS_BOMB_NEARBY)
                    listBombsNearby.add(massivOfCells[i][j]);

                //if it has a bomb nearby then we count the number of them

            }
        }
        for (int i = 0; i < Game.NUMBER_OF_CELLS;i++){
            for (int j = 0; j < Game.NUMBER_OF_CELLS;j++){

                if(massivOfCells[i][j].stateOfCell == StateOfCell.HAS_BOMB_NEARBY){
                    for(int element = 0;element < massivOfCells[i][j].aroundCells(i,j).size();element++){
                        if(massivOfCells[i][j].aroundCells(i, j).get(element).stateOfCell==StateOfCell.HAS_BOMB)
                            massivOfCells[i][j].aroundCells(i, j).get(element).incrementNumberOfMines();
                    }
                }
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
