import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("6.txt")));

        List<String> input = new ArrayList<String>();
        
        String temp = "";
        while (s.hasNextLine()) {
            String a = s.nextLine();
            if(a.equals("")) {
                input.add(temp);
                temp = "";
            }
            else {
                temp = temp + " " + a;
            }
        }
        s.close();

        int sum = 0;
        for(int i = 0; i < input.size(); i++) {
            sum += letters(input.get(i));
        }

        System.out.println(sum);
    }

    public static int letters(String check) {
        int sum = 0;
        for(int i = 97; i < 123; i++) {
            if (check.contains(Character.toString((char)i))) {
                sum++;
            }
        }
        return sum;
    }
}
