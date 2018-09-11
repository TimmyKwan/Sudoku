import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel {

    public Main(int w,int h) {
        setSize(w, h);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 1440;
        int height = 800;
        frame.setPreferredSize(new Dimension(width, height + 24));

        JPanel panel = new Main(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }


}
