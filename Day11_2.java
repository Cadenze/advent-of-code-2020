import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day11_2 {
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

    public static String radiate(String[] seats, int row, int column) {
        String adjacent = "";

        /* search param */
        int r = row - 1;
        int c = column - 1;

        /* search */
        while(adjacent.length() == 0) {
            if(r < 0 || c < 0) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                r--;
                c--;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row - 1;
        c = column;
        while(adjacent.length() == 1) {
            if(r < 0) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                r--;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row - 1;
        c = column + 1;
        while(adjacent.length() == 2) {
            if(r < 0 || c > seats[r].length() - 1) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                r--;
                c++;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row;
        c = column - 1;
        while(adjacent.length() == 3) {
            if(c < 0) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                c--;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row;
        c = column + 1;
        while(adjacent.length() == 4) {
            if(c > seats[r].length() - 1) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                c++;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row + 1;
        c = column - 1;
        while(adjacent.length() == 5) {
            if(r > 94 || c < 0) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                r++;
                c--;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row + 1;
        c = column;
        while(adjacent.length() == 6) {
            if(r > 94) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                r++;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        r = row + 1;
        c = column + 1;
        while(adjacent.length() == 7) {
            if(r > 94 || c > seats[r].length() - 1) {
                adjacent = adjacent + ".";
            }
            else if(seats[r].substring(c, c+1).equals(".")) {
                r++;
                c++;
            }
            else {
                adjacent = adjacent + seats[r].substring(c, c+1);
            }
        }

        if(adjacent.length() != 8) {
            System.out.println("error radiate");
        }

        return adjacent;
    }

    public static String[] step(String[] state) {
        String[] newstate = new String[95];
        for(int i = 0; i < 95; i++) {
            newstate[i] = "";
            for(int j = 0; j < state[i].length(); j++) {
                if(state[i].substring(j,j+1).equals(".")) {
                    newstate[i] = newstate[i] + ".";
                }
                else if(state[i].substring(j,j+1).equals("L")) {
                    if(radiate(state, i, j).contains("#")) {
                        newstate[i] = newstate[i] + "L";
                    }
                    else {
                        newstate[i] = newstate[i] + "#";
                    }
                }
                else {
                    String results = radiate(state, i, j);
                    if(results.length() - results.replaceAll("#", "").length() > 4) {
                        newstate[i] = newstate[i] + "L";
                    }
                    else {
                        newstate[i] = newstate[i] + "#";
                    }
                }
            }
        }

        return newstate;
    }
}
