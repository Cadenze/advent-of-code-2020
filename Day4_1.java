import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("4alt.txt")));

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
        String[] passports = new String[input.size()];
        passports = input.toArray(passports);
        
        int sum = 0;
        for(int i = 0; i < input.size(); i++) {
            if(valid(passports[i])) {
                sum++;
            }
        }
        
        System.out.println(sum);
    }

    public static boolean valid(String passport) {
        return passport.contains("byr:") && passport.contains("iyr:") && passport.contains("eyr:") && passport.contains("hgt:")
            && passport.contains("hcl:") && passport.contains("ecl:") && passport.contains("pid:");
    }
}
