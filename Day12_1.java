import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day12_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("12.txt")));

        String[] instruction = new String[790];
        int[] magnitude = new int[790];

        int counter = 0;
        while(s.hasNextLine()) {
            String line = s.nextLine();
            instruction[counter] = line.substring(0,1);
            magnitude[counter] = Integer.parseInt(line.substring(1));
            counter++;
        }
 
        s.close();

        int x = 0;
        int y = 0;
        int direction = 1; /* 0N 1E 2S 3W */

        for(int i = 0; i < instruction.length; i++) {
            if(instruction[i].equals("N")) {
                y += magnitude[i];
            }
            else if(instruction[i].equals("E")) {
                x += magnitude[i];
            }
            else if(instruction[i].equals("S")) {
                y -= magnitude[i];
            }
            else if(instruction[i].equals("W")) {
                x -= magnitude[i];
            }
            else if(instruction[i].equals("F")) {
                if(direction == 0) {
                    y += magnitude[i];
                }
                else if(direction == 1) {
                    x += magnitude[i];
                }
                else if(direction == 2) {
                    y -= magnitude[i];
                }
                else if(direction == 3) {
                    x -= magnitude[i];
                }
                else {
                    System.out.println("direction error");
                }
            }
            else if(instruction[i].equals("L")) {
                direction = Math.floorMod(direction - (magnitude[i] / 90), 4);
            }
            else if(instruction[i].equals("R")) {
                direction = Math.floorMod(direction + (magnitude[i] / 90), 4);
            }
            else {
                System.out.println("instruction error");
            }
        }

        System.out.println(Math.abs(x) + Math.abs(y));
    }
}
