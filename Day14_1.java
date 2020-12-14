import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day14_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("14.txt")));

        String[] instructions = new String[569];
        String[] numbers = new String[569];

        int counter = 0;
        while(s.hasNextLine()) {
            String[] parse = s.nextLine().split(" = ");
            instructions[counter] = parse[0];
            numbers[counter] = parse[1];
            counter++;
        }

        s.close();

        long[] memory = new long[70000];
        Arrays.fill(memory, 0L);
        String mask = "";
        for(int i = 0; i < 569; i++) {
            if(instructions[i].equals("mask")) {
                mask = numbers[i];
            }
            else {
                String number = Long.toString(Long.parseLong(numbers[i]), 2);
                String newnumber = "";
                while(number.length() < mask.length()) {
                    number = "0".concat(number);
                }
                for(int j = 0; j < mask.length(); j++) {
                    if(mask.substring(j, j+1).equals("X")) {
                        newnumber = newnumber.concat(number.substring(j, j+1));
                    }
                    else {
                        newnumber = newnumber.concat(mask.substring(j, j+1));
                    }
                }
                memory[Integer.parseInt(instructions[i].substring(instructions[i].indexOf("[") + 1, instructions[i].indexOf("]")))] = Long.parseLong(newnumber, 2);
            }
        }

        long sum = 0L;
        for(int i = 0; i < 70000; i++) {
            sum += memory[i];
        }

        System.out.println(sum);
    }
}
