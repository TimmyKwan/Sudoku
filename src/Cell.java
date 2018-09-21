import java.util.ArrayList;

public class Cell {

    private int row, col, val, boxR, boxC;
    private ArrayList<Integer> pValues;

    public Cell(int row, int col, int val){
        this.val = val;
        pValues = new ArrayList<Integer>();
        this.row = row;
        this.col = col;

        //set box values
        if (row <= 2){
            boxR = 0;
        }
        else if (row <= 5){
            boxR = 1;
        }
        else{
            boxR = 2;
        }
        if (col <= 2){
            boxC = 0;
        }
        else if (col <= 5){
            boxC = 1;
        }
        else{
            boxC = 2;
        }
        //set pValues
        if (val == 0){
            for (int i = 0; i < 9; i++) {
                pValues.add(i+1);
            }
        }
    }



    public void setVal(int val){
        this.val = val;

    }
    public int getVal(){
        return val;
    }

    public int getBoxR(){
        return boxR;
    }
    public int getBoxC(){return boxC;}

    public void setpValues(ArrayList<Integer> vals){
        pValues = vals;
    }
    public ArrayList<Integer> getpValues() {
        return pValues;
    }
}
