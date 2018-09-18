public class Cell {

    private int row, col, val, boxR, boxC;
    private int[][] grid;

    public Cell(int row, int col, int val){
        this.val = val;
        if (row <= 2){
            boxR = 0;
        }
        else if (row >= 3 && row <= 5){
            boxR = 1;
        }
        else if (row >= 7){
            boxR = 2;
        }
        if (col <= 2){
            boxC = 0;
        }
        else if (col >= 3 && col <= 5){
            boxC = 1;
        }
        else if (col >= 7){
            boxC = 2;
        }
    }

    public void setVal(int val){
        this.val = val;

    }

    public int getVal(){
        return val;
    }




}
