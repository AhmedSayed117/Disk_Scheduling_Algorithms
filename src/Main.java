import java.util.ArrayList;

public class Main {
    public static void main( final String[] args ) {
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(176);
        queue.add(79);
        queue.add(34);
        queue.add(60);
        queue.add(92);
        queue.add(11);
        queue.add(41);
        queue.add(114);
        ArrayList<Integer> queue2 = new ArrayList<>(queue);
        ArrayList<Integer> queue3 = new ArrayList<>(queue);
        ArrayList<Integer> queue4 = new ArrayList<>(queue);

        System.out.println("C_Scan => Right Direction");
        C_SCAN c_scanR=new C_SCAN(0,199,50,true,queue);
        c_scanR.Calculate();
        c_scanR.display();

        System.out.println("C_Scan => Left Direction");
        C_SCAN c_scanL=new C_SCAN(0,199,50,false,queue2);
        c_scanL.Calculate();
        c_scanL.display();

        System.out.println("Scan => Right Direction");
        SCAN scanR=new SCAN(0,199,50,true,queue3);
        scanR.Calculate();
        scanR.display();

        System.out.println("C_Scan => Left Direction");
        SCAN scanL=new SCAN(0,199,50,false,queue4);
        scanL.Calculate();
        scanL.display();


    }
}