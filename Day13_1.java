public class Day13_1 {
    public static void main(String[] args) {
        int time = 1000495;
        String input = "19,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,521,x,x,x,x,x,x,x,23,x,x,x,x,x,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,523,x,x,x,x,x,37,x,x,x,x,x,x,13";
        String[] id = input.split(",");

        int wait = 1000;
        int bus = 0;
        for(int i = 0; i < id.length; i++) {
            if(!id[i].equals("x")) {
                int potential = Integer.parseInt(id[i]);
                if(potential - time % potential < wait) {
                    wait = potential - time % potential;
                    bus = potential;
                }
            }
        }

        System.out.println(wait * bus);
    }
}
