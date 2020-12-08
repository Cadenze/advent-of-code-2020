import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day8_1 {
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
            ran[counter] = false;
            counter++;
        }

        s.close();

        int parser = 0;
        int acc = 0;
        while(true) {
            if(ran[parser]) { break; }
            else { ran[parser] = true; }

            if(type[parser].equals("acc")) {
                acc += instruction[parser];
                parser++;
            }
            else if(type[parser].equals("jmp")) {
                parser += instruction[parser];
            }
            else if(type[parser].equals("nop")) {
                parser++;
            }
            else {
                System.out.println("failure");
                break;
            }
        }

        System.out.println(acc);
    }
}
