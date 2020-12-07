import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7_2 {
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
                String colour = rules[j].substring(0, rules[j].indexOf(" bags contain"));
                if(colour.equals(bags.get(i))) {
                    String[] contents = rules[j].substring(rules[j].indexOf("contain") + 8).split(", ");
                    for(int k = 0; k < contents.length; k++) {
                        String number = contents[k].substring(0, 1);
                        if(!(number.equals("n"))) {
                            for(int l = 0; l < Integer.parseInt(number); l++) {
                                bags.add(contents[k].substring(contents[k].indexOf(" ") + 1, contents[k].indexOf(" bag")));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(bags.size() - 1);
    }
}
