import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("4.txt")));

        List<String[]> input = new ArrayList<String[]>();

        String temp = "";
        while (s.hasNextLine()) {
            String a = s.nextLine();
            if(a.equals("")) {
                String [] fields = new String[7];
                if (temp.contains("byr:")) { fields[0] = temp.substring(temp.indexOf("byr:") + 4, temp.indexOf(" ", temp.indexOf("byr:"))); } else { fields[0] = ""; }
                if (temp.contains("iyr:")) { fields[1] = temp.substring(temp.indexOf("iyr:") + 4, temp.indexOf(" ", temp.indexOf("iyr:"))); } else { fields[1] = ""; }
                if (temp.contains("eyr:")) { fields[2] = temp.substring(temp.indexOf("eyr:") + 4, temp.indexOf(" ", temp.indexOf("eyr:"))); } else { fields[2] = ""; }
                if (temp.contains("hgt:")) { fields[3] = temp.substring(temp.indexOf("hgt:") + 4, temp.indexOf(" ", temp.indexOf("hgt:"))); } else { fields[3] = ""; }
                if (temp.contains("hcl:")) { fields[4] = temp.substring(temp.indexOf("hcl:") + 4, temp.indexOf(" ", temp.indexOf("hcl:"))); } else { fields[4] = ""; }
                if (temp.contains("ecl:")) { fields[5] = temp.substring(temp.indexOf("ecl:") + 4, temp.indexOf(" ", temp.indexOf("ecl:"))); } else { fields[5] = ""; }
                if (temp.contains("pid:")) { fields[6] = temp.substring(temp.indexOf("pid:") + 4, temp.indexOf(" ", temp.indexOf("pid:"))); } else { fields[6] = ""; }
                input.add(fields);
                temp = "";
            }
            else {
                temp = temp + a + " ";
            }
        }

        s.close();
        
        int sum = 0;
        for(int i = 0; i < input.size(); i++) {
            if(valid(input.get(i))) {
                sum++;
            }
        }
        
        System.out.println(sum);
    }

    public static boolean valid(String[] passport) {
        if(passport[0].length() != 4 || !(isNumeric(passport[0])) || Integer.valueOf(passport[0]) < 1920 || Integer.valueOf(passport[0]) > 2002) {
            return false;
        }
        if(passport[1].length() != 4 || !(isNumeric(passport[1])) || Integer.valueOf(passport[1]) < 2010 || Integer.valueOf(passport[1]) > 2020) {
            return false;
        }
        if(passport[2].length() != 4 || !(isNumeric(passport[2])) || Integer.valueOf(passport[2]) < 2020 || Integer.valueOf(passport[2]) > 2030) {
            return false;
        }
        if(passport[3].contains("cm")) {
            if(Integer.valueOf(passport[3].substring(0, passport[3].indexOf("cm"))) < 150 || Integer.valueOf(passport[3].substring(0, passport[3].indexOf("cm"))) > 193) {
                return false;
            }
        }
        else if(passport[3].contains("in")) {
            if(Integer.valueOf(passport[3].substring(0, passport[3].indexOf("in"))) < 59 || Integer.valueOf(passport[3].substring(0, passport[3].indexOf("in"))) > 76) {
                return false;
            }
        }
        else {
            return false;
        }
        if(passport[4].startsWith("#")) {
            String colour = passport[4];
            colour = colour.replace("#","");
            if(!(colour.matches("[0-9a-f]+"))) {
                return false;
            }
        }
        else {
            return false;
        }
        if(passport[5].length() == 3) {
            String eye = passport[5];
            eye = eye.replace("amb","");
            eye = eye.replace("blu","");
            eye = eye.replace("brn","");
            eye = eye.replace("gry","");
            eye = eye.replace("grn","");
            eye = eye.replace("hzl","");
            eye = eye.replace("oth","");
            if(!(eye.equals(""))) {
                return false;
            }
        }
        else {
            return false;
        }
        if(passport[6].length() != 9 || !(isNumeric(passport[6]))) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
      }
}
