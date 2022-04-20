import java.util.ArrayList;

public class Main {
    public static void main( final String[] args ) {
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(82);
        queue.add(170);
        queue.add(43);
        queue.add(140);
        queue.add(24);
        queue.add(16);
        queue.add(190);
        C_LOOK scanAlgorithm = new C_LOOK(0,199,50,false,queue);
        scanAlgorithm.Calculate();
        scanAlgorithm.display();
    }
}