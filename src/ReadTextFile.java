import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadTextFile {


    public static void main(String[] args) throws IOException {

        String[] a = new String[9];

        try {

            File f = new File("./src/s01a.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

//            String line = b.readLine();
//            System.out.println(line);
            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
//                System.out.println(Arrays.toString(line.split(" ")));
                a = readLine.split(" ");
//                System.out.println(Arrays.toString(a));

//                String number = Arrays.toString(a);
//                System.out.println(number);
//                System.out.println(a[1]);

                int[] nums = new int[9];
                for (int i = 0; i < 9; i++) {
                    int q = Integer.parseInt(a[i]);
//                    System.out.println(q);
                    nums[i]=q;
                }

                System.out.println(Arrays.toString(nums));
//                if(nums[1]==1)
//                    System.out.println(nums[1]);

//
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
