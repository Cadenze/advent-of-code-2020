import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day3_1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner s = new Scanner(new BufferedReader(new FileReader("3.txt")));

        String[] row = new String[323];

        int counter = 0;
        while (s.hasNextLine()) {
            row[counter] = s.nextLine();
            counter++;
        }

        int pos = 0;
        int sum = 0;
        for(int i = 0; i < 323; i++) {
            if(row[i].substring(pos, pos + 1).equals("#")) {
                sum++;
            } 
            pos = (pos + 3) % row[i].length();
        }

        System.out.println(sum);
    }
}
