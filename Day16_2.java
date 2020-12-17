import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day16_2 extends Day16_1{
    private String[] field;
    private int[][] criterion; /* [field number][min1, max1, min2, max2] */
    private int[] myTicket;
    private int[][] nearbyValidTickets;

    public static void main(String[] args) throws FileNotFoundException {
        Day16_2 pog = new Day16_2("16.txt");

        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                if(pog.possibleField(i,j)) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public Day16_2(String file) throws FileNotFoundException {
        Day16_1 pog = new Day16_1(file);

        field = pog.getField();
        criterion = pog.getCriterion();
        myTicket = pog.getMyTicket();

        int[][] tickets = pog.getTicketFields();
        boolean[] valid = new boolean[tickets.length];
        Arrays.fill(valid, true);

        for(int i = 0; i < pog.getTicketCount(); i++) {
            for(int j = 0; j < pog.getFieldCount(); j++) {
                if(!pog.validateField(tickets[i][j])) {
                    valid[i] = false;
                    break;
                }
            }
        }

        int trues = 0;
        for(int i = 0; i < valid.length; i++) {
            if(valid[i]) {
                trues++;
            }
        }

        nearbyValidTickets = new int[trues][pog.getFieldCount()];
        int oldlength = 0;
        int newlength = 0;
        while(newlength < trues) {
            if(valid[oldlength]) {
                nearbyValidTickets[newlength] = tickets[oldlength];
                newlength++;
            }
            oldlength++;
        }
    }

    public int[] possibleFields(int fieldNumber) {
        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < getFieldCount(); i++) {
            if(possibleField(fieldNumber, i)) {
                count.add(i);
            }
        }
        int[] answer = new int[count.size()];
        for(int i = 0; i < count.size(); i++) {
            answer[i] = count.get(i);
        }
        return answer;
    }

    public boolean possibleField(int fieldNumber, int matchingField) {
        for(int i = 0; i < getTicketCount(); i++) {
            if(nearbyValidTickets[i][fieldNumber] < criterion[matchingField][0] || 
              (nearbyValidTickets[i][fieldNumber] > criterion[matchingField][1] && 
              nearbyValidTickets[i][fieldNumber] < criterion[matchingField][2]) ||
              nearbyValidTickets[i][fieldNumber] > criterion[matchingField][3]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[][] getTicketFields() {
        return nearbyValidTickets;
    }

    @Override
    public int getTicketCount() {
        return nearbyValidTickets.length;
    }
}
