import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Grid {

    private Cell[][] grid, arr;
    private ReadTextFile a;

    public Grid(){
        grid = new Cell[9][9];
        a=new ReadTextFile();
        arr = a.getGrid();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Cell(i, j, arr[i][j].getVal());
            }
        }
    }

    public void solver(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j].getVal() == 0){
                    ArrayList<Integer> temp = grid[i][j].getpValues();
                    for (int k = 0; k < 9; k++) {
                        //check horizontal
                        if (temp.contains(grid[i][k].getVal())){
                            temp.remove(temp.indexOf(grid[i][k].getVal()));
                        }

                        //check vertical
                        if (temp.contains(grid[k][j].getVal())){
                            temp.remove(temp.indexOf(grid[k][j].getVal()));
                        }

                        //check boxes
                        if (temp.contains(grid[(i/3)*3 + (k/3)][(j/3)*3 + (k - ( (k/3) * 3) )].getVal())){
                            temp.remove(temp.indexOf(grid[(i/3)*3 + (k/3)][(j/3)*3 + (k - ( (k/3) * 3) )].getVal()));
                        }

                        //update
                        grid[i][j].setpValues(temp);
                        //check if one value
                        if (grid[i][j].getpValues().size() == 1)
                            grid[i][j].setVal(grid[i][j].getpValues().get(0));
                    }

                }


            }
        }
    }

    public void solver2(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ArrayList<Integer> mergedPValues = new ArrayList<Integer>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        mergedPValues.addAll(grid[i*3 + k][j*3 + l].getpValues());
                    }
                }
                ArrayList<Integer> defValues = singleValues(mergedPValues);

                for (int n : defValues) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (grid[i*3 + k][j*3 + l].getpValues().contains(n)){
                                for (int remove : grid[i*3 + k][j*3 + l].getpValues()){
                                    if (remove != n) {
                                        grid[i * 3 + k][j * 3 + l].getpValues().remove(grid[i * 3 + k][j * 3 + l].getpValues().indexOf(remove));
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

    }


    public ArrayList<Integer> singleValues(ArrayList<Integer> list){
        ArrayList<Integer> rList = new ArrayList<Integer>();

        int[] count = new int[9];
        for (int i = 0; i < 9; i++) {
            count[i] = 0;
        }

        for (int n : list) {
            for (int i = 1; i < 10; i++) {
                if (n == i)
                    count[i-1]++;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (count[i] == 1) {
                rList.add(i + 1);
            }
        }

        return rList;
    }


    public void draw(Graphics2D g2){
        g2.setFont(new Font("Lucida Grande",Font.PLAIN,38));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //draw boxes
                g2.setStroke(new BasicStroke(2));
                g2.drawRect(i*243,j*243,243,243);
                g2.setStroke(new BasicStroke(1));
                //cell
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        g2.drawRect(k*81 + i*243, l*81 + j*243, 81,81);
                        if (grid[l + j*3][k + i*3].getVal() == 0){
                        }
                        else
                            g2.drawString(Integer.toString(grid[l + j*3][k + i*3].getVal()),k*81 + i*243 + 28, l*81 + j*243 + 55);
                    }
                }
            }

        }
    }

}
