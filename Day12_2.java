import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day12_2 {
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

        int shipx = 0;
        int shipy = 0;
        int wayx = 10;
        int wayy = 1;

        for(int i = 0; i < instruction.length; i++) {
            if(instruction[i].equals("N")) {
                wayy += magnitude[i];
            }
            else if(instruction[i].equals("E")) {
                wayx += magnitude[i];
            }
            else if(instruction[i].equals("S")) {
                wayy -= magnitude[i];
            }
            else if(instruction[i].equals("W")) {
                wayx -= magnitude[i];
            }
            else if(instruction[i].equals("F")) {
                shipx += magnitude[i] * wayx;
                shipy += magnitude[i] * wayy;
            }
            else if(instruction[i].equals("L")) {
                for(int rot = 0; rot < magnitude[i] / 90; rot++) {
                    int temp = wayx;
                    wayx = -wayy;
                    wayy = temp;
                }
            }
            else if(instruction[i].equals("R")) {
                for(int rot = 0; rot < magnitude[i] / 90; rot++) {
                    int temp = wayy;
                    wayy = -wayx;
                    wayx = temp;
                }
            }
            else {
                System.out.println("instruction error");
            }
        }

        System.out.println(Math.abs(shipx) + Math.abs(shipy));
    }
}
