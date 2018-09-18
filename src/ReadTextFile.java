import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadTextFile {

    private  Cell [][] arr;
    private int row, col;

    public ReadTextFile(){
        arr =new Cell[9][9];
        row=0;
        col=0;

        String[] a = new String[9];

        try {

            File f = new File("./src/s01a.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                a = readLine.split(" ");

                int[] nums = new int[9];
                for (int i = 0; i < 9; i++) {
                    int q = Integer.parseInt(a[i]);
                    nums[i]=q;

                    arr[row][col] = new Cell(row,col,nums[i]);
//                    arr[row][col].setVal(nums[i]);
                    col++;
                    if(col>8){
                        col=0;
                        row++;
                        if(row>8){
                            row=0;
                        }
                    }
                }

            }





        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    public static void main(String[] args) throws IOException {
//
//
//
//
//    }



    public Cell[][] getGrid(){
        return arr;
    }

}
