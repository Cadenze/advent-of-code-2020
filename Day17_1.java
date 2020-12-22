import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day17_1 {
    private List<List<String>> field;

    public Day17_1() throws FileNotFoundException {
        this("17.txt");
    }

    public Day17_1(String file) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader(file)));

        List<String> fields = new ArrayList<>();

        while(s.hasNextLine()) {
            fields.add(s.nextLine());
        }

        field = new ArrayList<>();
        field.add(fields);

        s.close();
    }

    /**
     * @param x = position in String
     * @param y = position in row
     * @param z = position in layer
     * @return state = true/active; false/inactive
     */
    public boolean getActivity(int x, int y, int z) {
        return field.get(z).get(y).substring(x,x+1).equals("#");
    }

    /**
     * Pads x y z with .
     */
    public void expansion() {
        String rowadd = "";
        List<String> layeradd = new ArrayList<>();

        for(int i = 0; i < field.size(); i++) {
            for(int j = 0; j < field.get(i).size(); j++) {
                field.get(i).set(j, ".".concat(field.get(i).get(j).concat(".")));
            }

            for(int j = 0; j < field.get(i).get(0).length(); j++) {
                rowadd = rowadd.concat(".");
            }
            field.get(i).add(0, rowadd);
            field.get(i).add(rowadd);
        }

        for(int i = 0; i < field.get(0).size(); i++) {
            layeradd.add(rowadd);
        }
        field.add(0, layeradd);
        field.add(layeradd);
    }

    /**
     * Removes padding if it is all empty
     */
    public void declension() {
        String forcount = "";
        for(int i = 0; i < field.get(0).size(); i++) {
            forcount = forcount.concat(field.get(0).get(i));
        }
        if(count(forcount) == 0) {
            field.remove(0);
        }

        forcount = "";
        for(int i = 0; i < field.get(field.size()-1).size(); i++) {
            forcount = forcount.concat(field.get(field.size()-1).get(i));
        }
        if(count(forcount) == 0) {
            field.remove(field.size()-1);
        }

        forcount = "";
        for(int i = 0; i < field.size(); i++) {
            forcount = forcount.concat(field.get(i).get(0));
        }
        if(count(forcount) == 0) {
            for(int i = 0; i < field.size(); i++) {
                field.set(i, field.get(i).remove(0));
            }
        }
        
    }

    /**
     * Counts active cells
     * @param row = String of cells
     * @return = Number of active cells
     */
    public int count(String row) {
        return row.length() - row.replace("#", "").length();
    }
}
