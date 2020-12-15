import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day15_2 {
    public static void main(String[] args) {
        int[] array = {1,0,16,5,17,4};
        int answer = game(array, 30000000);
        System.out.println(answer);
    }

    public static int game(int[] starting, int index) {
        List<Integer> dictionary = new ArrayList<>();

        /* initialize */
        int[] numbers = Arrays.copyOf(starting, index);
        for(int i = 0; i < starting.length - 1; i++) {
            while(dictionary.size() <= numbers[i]) {
                dictionary.add(-1);
            }
            dictionary.set(numbers[i], i);
        }

        /* continue */
        for(int i = starting.length; i < index; i++) {
            while(dictionary.size() <= numbers[i-1]) {
                dictionary.add(-1);
            }
            Integer occur = dictionary.get(numbers[i-1]);
            if(occur != -1) {
                numbers[i] = i - 1 - occur;
            }
            dictionary.set(numbers[i-1], i-1);
        }

        return numbers[index - 1];
    }
}
