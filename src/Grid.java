import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(grid[i][j].getVal());
//            }
//        }

    }

//    public void solver(){
//        ArrayList[][][][]list = new ArrayList[9][9][9][9];
//        for (int i = 1; i < 10; i++) {
//            if(list[i].)
//        }
//
//    }


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
                        g2.drawString(Integer.toString(grid[i+k][j+l].getVal()),k*81 + i*243 + 28, l*81 + j*243 + 55);
                    }
                }
            }

        }
    }

}
