import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day14_2 {
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

        List<Long> addresses = new ArrayList<>();
        List<Long> memory = new ArrayList<>();
        String mask = "";
        
        for(int i = 0; i < instructions.length; i++) {
            if(instructions[i].equals("mask")) {
                mask = numbers[i];
            }
            else {
                String[] adding = bitmasking(mask, Integer.parseInt(instructions[i].substring(instructions[i].indexOf("[") + 1, instructions[i].indexOf("]"))));
                for(int j = 0; j < adding.length; j++) {
                    long parsed = Long.parseLong(adding[j], 2);
                    if(addresses.contains(parsed)) {
                        memory.set(addresses.indexOf(parsed), Long.parseLong(numbers[i]));
                    }
                    else {
                        addresses.add(parsed);
                        memory.add(Long.parseLong(numbers[i]));
                    }
                }
            }
        }

        long sum = 0L;
        for(int i = 0; i < memory.size(); i++) {
            sum += memory.get(i);
        }

        System.out.println(sum);
    }

    public static String[] bitmasking(String mask, int address) {
        String binaryAddress = Integer.toString(address, 2);
        while(binaryAddress.length() < mask.length()) {
            binaryAddress = "0".concat(binaryAddress);
        }

        /**
         * We have:
         * binaryAddress: 36-bit address (1,0)
         * mask:          36-bit mask    (1,0,X)
         * 
         * We need:
         * List of resultant addresses
         */
        List<String> results = new ArrayList<>();
        if(mask.substring(0, 1).equals("X")) {
            results.add("0");
            results.add("1");
        }
        else {
            results.add(mask.substring(0, 1));
        }

        for(int i = 1; i < mask.length(); i++) {
            if(mask.substring(i, i+1).equals("X")) {
                int partition = results.size();
                for(int j = 0; j < partition; j++) {
                    results.add(results.get(j).concat("1"));
                    results.set(j, results.get(j).concat("0"));
                }
            }
            else if(mask.substring(i, i+1).equals("0")){
                for(int j = 0; j < results.size(); j++) {
                    results.set(j, results.get(j).concat(binaryAddress.substring(i, i+1)));
                }
            }
            else {
                for(int j = 0; j < results.size(); j++) {
                    results.set(j, results.get(j).concat("1"));
                }
            }
        }

        String[] output = new String[results.size()];
        for(int i = 0; i < results.size(); i++) {
            output[i] = results.get(i);
        }
        return output;
    }
}
