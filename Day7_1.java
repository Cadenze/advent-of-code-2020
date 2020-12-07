import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("7.txt")));

        String[] rules = new String[594];

        int counter = 0;
        while (s.hasNextLine()) {
            rules[counter] = s.nextLine();
            counter++;
        }

        List<String> bags = new ArrayList<String>();
        bags.add("shiny gold");
        for(int i = 0; i < bags.size(); i++) {
            for(int j = 0; j < 594; j++) {
                if(rules[j].contains(bags.get(i))) {
                    String colour = rules[j].substring(0, rules[j].indexOf(" bags contain"));
                    if(!(bags.contains(colour))) {
                        bags.add(colour);
                    }
                }
            }
        }

        System.out.println(bags.size() - 1);
    }
}
