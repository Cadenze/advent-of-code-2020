import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day9_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("9.txt")));

        long[] num = new long[1000];

        int counter = 0;
        while (s.hasNextLine()) {
            num[counter] = Long.parseLong(s.nextLine());
            counter++;
        }

        s.close();
        boolean reached = false;
        long answer = 0;
        int line = 0;
        for(int i = 25; i < 1000; i++) {
            for(int j = i - 25; j < i; j++) {
                for (int k = j + 1; k < i; k++) {
                    if(num[j] + num[k] == num[i]) {
                        reached = true;
                        break;
                    }
                }
                if(reached) {
                    break;
                }
            }
            if(!(reached)) {
                answer = num[i];
                line = i;
                break;
            }
            else {
                reached = false;
            }
        }

        System.out.println(answer);
        System.out.println(line);
    }
}
