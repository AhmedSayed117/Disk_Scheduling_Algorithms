import java.util.ArrayList;
import java.util.Collections;

public class SCAN extends Scheduling {

    public SCAN(int start, int end, int headPointer, boolean Direction, ArrayList<Integer> queue) {
        super(start, end, headPointer,Direction,queue);//Start - End - HeadPointer
    }

    //case Direction = true
    public void Calculate(){ //(16,24,43,50,82,140,170,190,End=199)
        if (Direction){ // Right
            queue.add(End);
            queue.add(HeadStart);
            Collections.sort(queue);
            int indexOfHead = queue.indexOf(HeadStart);
            int indexOfEnd = queue.indexOf(End);
            for (int i = indexOfHead ; i<indexOfEnd ;){
                TotalMovement+= Math.abs(queue.get(i+1) - queue.get(i));
                sequences.add(queue.get(i));
                queue.remove(queue.get(i));
                indexOfEnd--;
            }
            //(16,24,43,End=199)
            for (int i=indexOfEnd ;i>0;i--){
                TotalMovement+= Math.abs(queue.get(i-1) - queue.get(i));
                sequences.add(queue.get(i));
                queue.remove(queue.get(i));
            }
            sequences.add(queue.get(0));

        }//case Direction = false
        else {//(Start = 0,16,24,43,50,82,140,170,190)
            queue.add(Start);
            queue.add(HeadStart);
            Collections.sort(queue);
            int indexOfHead = queue.indexOf(HeadStart);
            int indexOfStart = queue.indexOf(Start);
            for (int i = indexOfHead ; i>Start ;i--){
                TotalMovement+= Math.abs(queue.get(i-1) - queue.get(i));
                sequences.add(queue.get(i));
                queue.remove(queue.get(i));
            }
            for (int i=indexOfStart ;i<queue.size()-1;){
                TotalMovement+= Math.abs(queue.get(i+1) - queue.get(i));
                sequences.add(queue.get(i));
                queue.remove(queue.get(i));
            }
            sequences.add(queue.get(0));
        }
    }
}