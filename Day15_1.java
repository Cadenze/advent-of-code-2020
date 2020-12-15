import java.util.Arrays;

public class Day15_1 {
    public static void main(String[] args) {
        int[] array = {1,0,16,5,17,4};
        int answer = game(array, 2020);
        System.out.println(answer);
    }

    public static int game(int[] starting, int index) {
        int[] numbers = Arrays.copyOf(starting, index);

        for(int i = starting.length; i < index; i++) {
            numbers[i] = i - 1 - reverseSearch(numbers[i-1], numbers, i-2);
        }

        return numbers[index - 1];
    }

    public static int reverseSearch(int param, int[] values, int from) {
        for(int i = from; i >= 0; i--) {
            if(values[i] == param) {
                return i;
            }
        }
        return from + 1;
    }
}
