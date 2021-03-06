import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2_2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner s = new Scanner(new BufferedReader(new FileReader("2.txt")));

        int[] low = new int[1000];
        int[] high = new int[1000];
        String[] key = new String[1000];
        String[] pw = new String[1000];
        
        int counter = 0;
        while (s.hasNextLine()) {
            String str = s.nextLine();
            low[counter] = Integer.parseInt(str.substring(0, str.indexOf("-")));
            high[counter] = Integer.parseInt(str.substring(str.indexOf("-") + 1, str.indexOf(" ")));
            key[counter] = str.substring(str.indexOf(" ") + 1, str.indexOf(":"));
            pw[counter] = str.substring(str.indexOf(": ") + 2);
            counter++;
        }

        int sum = 0;

        for(int i = 0; i < 1000; i++) {
            String a = pw[i].substring(low[i] - 1, low[i]);
            String b = pw[i].substring(high[i] - 1, high[i]);
            if(!(a.equals(key[i]) && b.equals(key[i]))) {
                if(a.equals(key[i]) || b.equals(key[i])) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}