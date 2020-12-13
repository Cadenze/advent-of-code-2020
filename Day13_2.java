public class Day13_2 {
    public static void main(String[] args) {
        String input = "19,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,521,x,x,x,x,x,x,x,23,x,x,x,x,x,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,523,x,x,x,x,x,37,x,x,x,x,x,x,13";
        String[] id = input.split(",");

       
        long time = 0L;
        long holding = 1L;
        for(int i = 0; i < id.length; i++) {
            if(!id[i].equals("x")) {
                int modulus = Integer.parseInt(id[i]);
                while((time + i) % modulus != 0) {
                    time += holding;
                }
                holding *= modulus;
            }
        }
        System.out.println(time);
    }
}
