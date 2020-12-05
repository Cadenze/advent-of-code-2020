import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day5_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("5.txt")));

        String[] passes = new String[845];

        int counter = 0;
        while (s.hasNextLine()) {
            passes[counter] = s.nextLine();
            counter++;
        }

        int[] seat = convert(passes);

        int max = 0;
        for(int i = 0; i < 845; i++) {
            if(seat[i] > max) {
                max = seat[i];
            }
        }

        System.out.println(max);
    }

    public static int [] convert(String[] passes) {
        int[] seat = new int[845];
        for(int i = 0; i < 845; i++) {
            seat[i] = Integer.parseInt(passes[i].replace("B", "1").replace("F", "0").replace("R", "1").replace("L", "0"), 2);
        }
        return seat;
    }
}
