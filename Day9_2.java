import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day9_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("9.txt")));

        long[] num = new long[1000];

        int counter = 0;
        while (s.hasNextLine()) {
            num[counter] = Long.parseLong(s.nextLine());
            counter++;
        }

        s.close();
        
        long max = 0;
        long min = 0;
        for(int i = 0; i < 504; i++) {
            long sum = 0;
            int count = i;
            while(sum < 14144619) {
                sum += num[count];
                count++;
            }
            if(sum == 14144619) {
                long[] soon = new long[count - i + 1];
                for(int a = i; a <= count; a++) {
                    soon[a - i] = num[a];
                }
                max = soon[0];
                min = soon[0];
                for(int a = 1; a < soon.length; a++) {
                    if(soon[a] > max) {
                        max = soon[a];
                    }
                    else if(soon[a] < min) {
                        min = soon[a];
                    }
                }
            }
        }

        System.out.println(max + min);

    }
}
