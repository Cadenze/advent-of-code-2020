import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day10_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("10.txt")));

        int[] adapters = new int[104];

        int counter = 0;
        while (s.hasNextLine()) {
            adapters[counter] = Integer.parseInt(s.nextLine());
            counter++;
        }

        Arrays.sort(adapters);

        int one = 1;
        int three = 1;
        for(int i = 1; i < 104; i++) {
            int diff = adapters[i] - adapters[i - 1];
            if(diff == 1) {one++;}
            else if(diff == 3) {three++;}
            else if(diff > 3) {System.out.println("error");}
        }

        System.out.println(one * three);
    }
}
