import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day16_1 {
    private String[] field;
    private int[][] criterion; /* [field number][min1, max1, min2, max2] */
    private int[] myTicket;
    private int[][] nearbyTickets;

    public static void main(String[] args) throws FileNotFoundException {
        Day16_1 pog = new Day16_1("16.txt");

        int[][] tickets = pog.getTicketFields();

        long sum = 0L;
        for(int i = 0; i < pog.getTicketCount(); i++) {
            for(int j = 0; j < pog.getFieldCount(); j++) {
                if(!pog.validateField(tickets[i][j])) {
                    sum += tickets[i][j];
                }
            }
        }
        
        System.out.println(sum);
    }

    public Day16_1() throws FileNotFoundException {
        this("16.txt");
    }
    
    public Day16_1(String file) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader(file)));

        List<String> fields = new ArrayList<>();
        List<String[]> criteria = new ArrayList<>();

        while(true) {
            String line = s.nextLine();
            if(line.equals("")) {
                s.nextLine();
                break;
            }

            int colon = line.indexOf(":");
            fields.add(line.substring(0, colon));

            String[] smaller = line.substring(colon + 2).replace(" or ", "-").split("-");
            String[] extrema = {
                smaller[0], smaller[1], smaller[2], smaller[3]
            };
            criteria.add(extrema);
        }

        field = new String[fields.size()];
        fields.toArray(field);
        criterion = new int[criteria.size()][4];
        for(int i = 0; i < criterion.length; i++) {
            for(int j = 0; j < 4; j++) {
                criterion[i][j] = Integer.parseInt(criteria.get(i)[j]);
            }
        }

        String[] ticketFields = s.nextLine().split(",");
        myTicket = new int[ticketFields.length];
        for(int i = 0; i < ticketFields.length; i++) {
            myTicket[i] = Integer.parseInt(ticketFields[i]);
        }

        s.nextLine();
        s.nextLine();

        List<String[]> otherTickets = new ArrayList<>();
        while(s.hasNextLine()) {
            ticketFields = s.nextLine().split(",");
            otherTickets.add(ticketFields);
        }
        nearbyTickets = new int[otherTickets.size()][field.length];
        for(int i = 0; i < nearbyTickets.length; i++) {
            for(int j = 0; j < nearbyTickets[i].length; j++) {
                nearbyTickets[i][j] = Integer.parseInt(otherTickets.get(i)[j]);
            }
        }

        s.close();
    }

    public int[][] getTicketFields() {
        return nearbyTickets;
    }

    public boolean validateField(int field) {
        for(int i = 0; i < getFieldCount(); i++) {
            if(field >= criterion[i][0] && field <= criterion[i][1]) {
                return true;
            }
            if(field >= criterion[i][2] && field <= criterion[i][3]) {
                return true;
            }
        }
        return false;
    }

    public int getFieldCount() {
        return field.length;
    }

    public int getTicketCount() {
        return nearbyTickets.length;
    }

    public String[] getField() {
        return field;
    }

    public int[][] getCriterion() {
        return criterion;
    }

    public int[] getMyTicket() {
        return myTicket;
    }
}
