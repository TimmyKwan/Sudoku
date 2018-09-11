import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Grid {

    private int[][][][] grid;

    public Grid(){
        grid = new int[3][3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        grid[i][j][k][l] = 0;
                    }
                }
            }
        }

    }

    public void draw(Graphics2D g2){
        //cell group
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g2.drawRect(i*240,j*240,240,240);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {

                    }
                }
            }

        }
    }
}
