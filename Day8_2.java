import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day8_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("8.txt")));

        String[] type = new String[641];
        int[] instruction = new int[641];
        boolean[] ran = new boolean[641];

        int counter = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            type[counter] = line.substring(0, line.indexOf(" "));
            instruction[counter] = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            counter++;
        }

        s.close();

        int answer = 0;
        for(int i = 0; i < 641; i++) {
            String[] type1 = Arrays.copyOf(type, 641);
            Arrays.fill(ran, false);
            if(type[i].equals("acc")) {
                continue;
            }
            else if(type[i].equals("jmp")) {
                type1[i] = "nop";
            }
            else if(type[i].equals("nop")) {
                type1[i] = "jmp";
            }
            else {
                System.out.println("reeeeeee");
            }

            int parser = 0;
            int acc = 0;
            while(true) {
                if(ran[parser] || parser == 640) { break; }
                else { ran[parser] = true; }
    
                if(type1[parser].equals("acc")) {
                    acc += instruction[parser];
                    parser++;
                }
                else if(type1[parser].equals("jmp")) {
                    parser += instruction[parser];
                }
                else if(type1[parser].equals("nop")) {
                    parser++;
                }
                else {
                    System.out.println("failure");
                    break;
                }
            }

            if(parser == 640) {
                answer = acc;
            }
        }
        
        System.out.println(answer);

    }
}
