import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day11_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("11.txt")));

        String[] seats = new String[95];

        int counter = 0;
        while (s.hasNextLine()) {
            seats[counter] = s.nextLine();
            counter++;
        }

        s.close();

        int stored = 0;
        while(true) {
            String[] temp = step(seats);
            int occupied = 0;
            for(int i = 0; i < seats.length; i++) {
                for(int j = 0; j < seats[i].length(); j++) {
                    if(temp[i].substring(j, j+1).contains("#")) {
                        occupied++;
                    }
                }
            }
            seats = temp;
            if(stored == occupied) {
                System.out.println(stored);
                break;
            }
            else {
                stored = occupied;
            }
        }
    }

    public static String[] step(String[] state) {
        String[] newstate = new String[95];
        for(int i = 0; i < 95; i++) {
            newstate[i] = "";
        }
        
        /* edge case */
        if(state[0].substring(0,1).equals(".")) {
            newstate[0] = newstate[0] + (".");
        }
        else if(state[0].substring(0,1).equals("L")) {
            if(state[1].substring(0,2).contains("#") || state[0].substring(1,2).equals("#")) {
                newstate[0] = newstate[0] + ("L");
            }
            else {
                newstate[0] = newstate[0] + ("#");
            }
        }
        else {
            newstate[0] = newstate[0] + ("#");
        }
        for(int j = 1; j < state[0].length() - 1; j++) {
            if(state[0].substring(j,j+1).equals(".")) {
                newstate[0] = newstate[0] + (".");
            }
            else if(state[0].substring(j,j+1).equals("L")) {
                if(state[0].substring(j-1,j+2).contains("#") || state[1].substring(j-1,j+2).contains("#")) {
                    newstate[0] = newstate[0] + ("L");
                }
                else {
                    newstate[0] = newstate[0] + ("#");
                }
            }
            else {
                int occupied = 0;
                if(state[0].substring(j-1,j).equals("#")) { occupied++; }
                if(state[0].substring(j+1,j+2).equals("#")) { occupied++; }
                if(state[1].substring(j-1,j).equals("#")) { occupied++; }
                if(state[1].substring(j,j+1).equals("#")) { occupied++; }
                if(state[1].substring(j+1,j+2).equals("#")) { occupied++; }

                if(occupied > 3) {
                    newstate[0] = newstate[0] + ("L");
                }
                else {
                    newstate[0] = newstate[0] + ("#");
                }
            }
        }
        if(state[0].substring(92).equals(".")) {
            newstate[0] = newstate[0] + (".");
        }
        else if(state[0].substring(92).equals("L")) {
            if(state[1].substring(91).contains("#") || state[0].substring(91,92).equals("#")) {
                newstate[0] = newstate[0] + ("L");
            }
            else {
                newstate[0] = newstate[0] + ("#");
            }
        }
        else {
            newstate[0] = newstate[0] + ("#");
        }

        /* common case */
        for(int i = 1; i < 94; i++) {
            /* edge case */
            if(state[i].substring(0,1).equals(".")) {
                newstate[i] = newstate[i] + (".");
            }
            else if(state[i].substring(0,1).equals("L")) {
                if(state[i-1].substring(0,2).contains("#") || state[i+1].substring(0,2).contains("#") || state[i].substring(1,2).equals("#")) {
                    newstate[i] = newstate[i] + ("L");
                }
                else {
                    newstate[i] = newstate[i] + ("#");
                }
            }
            else {
                int occupied = 0;
                if(state[i-1].substring(0,1).equals("#")) { occupied++; }
                if(state[i-1].substring(1,2).equals("#")) { occupied++; }
                if(state[ i ].substring(1,2).equals("#")) { occupied++; }
                if(state[i+1].substring(0,1).equals("#")) { occupied++; }
                if(state[i+1].substring(1,2).equals("#")) { occupied++; }

                if(occupied > 3) {
                    newstate[i] = newstate[i] + ("L");
                }
                else {
                    newstate[i] = newstate[i] + ("#");
                }
            }

            /* common case */
            for(int j = 1; j < state[i].length() - 1; j++) {
                if(state[i].substring(j,j+1).equals(".")) {
                    newstate[i] = newstate[i] + (".");
                }
                else if(state[i].substring(j,j+1).equals("L")) {
                    if(state[i-1].substring(j-1,j+2).contains("#") || state[i].substring(j-1,j+2).contains("#") || state[i+1].substring(j-1,j+2).contains("#")) {
                        newstate[i] = newstate[i] + ("L");
                    }
                    else {
                        newstate[i] = newstate[i] + ("#");
                    }
                }
                else {
                    int occupied = 0;
                    if(state[i-1].substring(j-1,j).equals("#")) { occupied++; }
                    if(state[i-1].substring(j,j+1).equals("#")) { occupied++; }
                    if(state[i-1].substring(j+1,j+2).equals("#")) { occupied++; }
                    if(state[i].substring(j-1,j).equals("#")) { occupied++; }
                    if(state[i].substring(j+1,j+2).equals("#")) { occupied++; }
                    if(state[i+1].substring(j-1,j).equals("#")) { occupied++; }
                    if(state[i+1].substring(j,j+1).equals("#")) { occupied++; }
                    if(state[i+1].substring(j+1,j+2).equals("#")) { occupied++; }

                    if(occupied > 3) {
                        newstate[i] = newstate[i] + ("L");
                    }
                    else {
                        newstate[i] = newstate[i] + ("#");
                    }
                }
            }

            /* edge case */
            if(state[i].substring(92).equals(".")) {
                newstate[i] = newstate[i] + (".");
            }
            else if(state[i].substring(92).equals("L")) {
                if(state[i-1].substring(91).contains("#") || state[i+1].substring(91).contains("#") || state[i].substring(91,92).equals("#")) {
                    newstate[i] = newstate[i] + ("L");
                }
                else {
                    newstate[i] = newstate[i] + ("#");
                }
            }
            else {
                int occupied = 0;
                if(state[i-1].substring(91,92).equals("#")) { occupied++; }
                if(state[i-1].substring(92).equals("#")) { occupied++; }
                if(state[i].substring(91,92).equals("#")) { occupied++; }
                if(state[i+1].substring(91,92).equals("#")) { occupied++; }
                if(state[i+1].substring(92).equals("#")) { occupied++; }

                if(occupied > 3) {
                    newstate[i] = newstate[i] + ("L");
                }
                else {
                    newstate[i] = newstate[i] + ("#");
                }
            }
        }

        /* edge case */
        if(state[94].substring(0,1).equals(".")) {
            newstate[94] = newstate[94] + (".");
        }
        else if(state[94].substring(0,1).equals("L")) {
            if(state[93].substring(0,2).contains("#") || state[94].substring(1,2).equals("#")) {
                newstate[94] = newstate[94] + ("L");
            }
            else {
                newstate[94] = newstate[94] + ("#");
            }
        }
        else {
            newstate[94] = newstate[94] + ("#");
        }
        for(int j = 1; j < state[0].length() - 1; j++) {
            if(state[94].substring(j,j+1).equals(".")) {
                newstate[94] = newstate[94] + (".");
            }
            else if(state[94].substring(j,j+1).equals("L")) {
                if(state[94].substring(j-1,j+2).contains("#") || state[93].substring(j-1,j+2).contains("#")) {
                    newstate[94] = newstate[94] + ("L");
                }
                else {
                    newstate[94] = newstate[94] + ("#");
                }
            }
            else {
                int occupied = 0;
                if(state[94].substring(j-1,j).equals("#")) { occupied++; }
                if(state[94].substring(j+1,j+2).equals("#")) { occupied++; }
                if(state[93].substring(j-1,j).equals("#")) { occupied++; }
                if(state[93].substring(j,j+1).equals("#")) { occupied++; }
                if(state[93].substring(j+1,j+2).equals("#")) { occupied++; }

                if(occupied > 3) {
                    newstate[94] = newstate[94] + ("L");
                }
                else {
                    newstate[94] = newstate[94] + ("#");
                }
            }
        }
        if(state[94].substring(92).equals(".")) {
            newstate[94] = newstate[94] + (".");
        }
        else if(state[94].substring(92).equals("L")) {
            if(state[93].substring(91).contains("#") || state[94].substring(91,92).equals("#")) {
                newstate[94] = newstate[94] + ("L");
            }
            else {
                newstate[94] = newstate[94] + ("#");
            }
        }
        else {
            newstate[94] = newstate[94] + ("#");
        }

        return newstate;
    }
}
