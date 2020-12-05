import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Day5_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("5.txt")));

        String[] passes = new String[845];

        int counter = 0;
        while (s.hasNextLine()) {
            passes[counter] = s.nextLine();
            counter++;
        }

        int[] seat = convert(passes);

        for(int i = 1; i < 1023; i++) {
            if(!(check(seat, i))) {
                if(check(seat, i-1) && check(seat, i+1)) {
                    System.out.println(i);
                }
            }
        }
    }

    public static int[] convert(String[] passes) {
        int[] seat = new int[845];
        for(int i = 0; i < 845; i++) {
            seat[i] = Integer.parseInt(passes[i].replace("B", "1").replace("F", "0").replace("R", "1").replace("L", "0"), 2);
        }
        return seat;
    }

    public static boolean check(int[] seats, int id) {
        for(int i = 0; i < 845; i++) {
            if(id == seats[i]) {
                return true;
            }
        }
        return false;
    }
}
