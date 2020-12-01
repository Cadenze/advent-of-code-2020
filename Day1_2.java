import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day1_2 {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner s = new Scanner(new BufferedReader(new FileReader("1-1.txt")));

        int[] array = new int[200];
        int count = 0;
        while (s.hasNextInt()) {
            array[count] = s.nextInt();
            count++;
        }

        s.close();

        System.out.println(solution(array));
    }

    public static int solution(int[] array)
    {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                for(int k = 0; k < array.length; k++) {
                    if(array[i] + array[j] + array[k]== 2020) {
                        return array[i] * array[j] * array[k];
                    }
                }   
            }
        }

        return 0;
    }
}