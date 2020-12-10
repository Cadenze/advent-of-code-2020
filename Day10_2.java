import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day10_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("10.txt")));

        Integer[] adapters = new Integer[106];

        adapters[0] = 0;
        int counter = 1;
        while (s.hasNextLine()) {
            adapters[counter] = Integer.parseInt(s.nextLine());
            counter++;
        }
        adapters[105] = 171;

        Arrays.sort(adapters);

        /* partition */
        long product = 1;
        int consecutive = 1;
        for(int i = 1; i < 106; i++) {
            if(adapters[i] - adapters[i-1] == 1) {
                consecutive++;
            }
            else if(adapters[i] - adapters[i-1] == 3) {
                if(consecutive == 3) {
                    product *= 2;
                }
                else if(consecutive == 4) {
                    product *= 4;
                }
                else if(consecutive == 5) {
                    product *= 7;
                }
                else if(consecutive > 5) {
                    System.out.println("alert");
                }
                consecutive = 1;
            }
            else {
                System.out.println("ya dunce");
            }
        }
        
        System.out.println(product);
        
    }
}
