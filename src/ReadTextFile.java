import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadTextFile {

    private static int[][][][] arr;

    public ReadTextFile(){
        arr =new int[3][3][3][3];
    }


    public static void main(String[] args) throws IOException {

        int boxRow, boxCol, cellRow, cellCol;

        boxRow=0;
        boxCol=0;
        cellRow=0;
        cellCol=0;

        String[] a = new String[9];

        try {

            File f = new File("./src/s01a.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                a = readLine.split(" ");

                int[] nums = new int[9];
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        for (int k = 0; k < 3; k++) {
//                            for (int l = 0; l < 3; l++) {
//                                int q = Integer.parseInt(a[i]);
//                                nums[i]=q;
//                                array [i][k][j][l] = q;
//                            }
//
//                        }
//
//                    }
//
//                }
                for (int i = 0; i < 9; i++) {
                    int q = Integer.parseInt(a[i]);
                    nums[i]=q;

                    arr[boxRow][boxCol][cellRow][cellCol] = nums[i];
                    cellCol++;
                    if(cellCol>2){
                        cellCol=0;
                        boxCol++;
                        if(boxCol>0){
                            boxCol=0;
                            cellRow++;
                            if(cellRow>2){
                                cellRow=0;
                                boxRow++;
                                if(boxRow>2){
                                    boxRow=0;

                                }
                            }
                        }
                    }

                }

                System.out.println(Arrays.toString(arr));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public int[][][][] getGrid(){
        return arr;
    }

}
