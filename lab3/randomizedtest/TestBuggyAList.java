package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        int[] addSequence = {4, 5, 6};
        boolean flag = true;
        AListNoResizing<Integer> AList = new AListNoResizing<>();
        BuggyAList<Integer> BList = new BuggyAList<>();
        for(int num : addSequence) {
            AList.addLast(num);
            BList.addLast(num);
        }
        for(int num : addSequence) {
            assertEquals(AList.removeLast(), BList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = B.size();
                assertEquals(sizeL, sizeB);
//                System.out.println("size: " + sizeL);
            } else if (operationNumber == 2 && L.size() > 0) {
                int itemL = L.getLast();
                int itemB = B.getLast();
                assertEquals(itemL, itemB);
//                System.out.println("getLast(" + itemL + ")");
            } else if (operationNumber == 3 && L.size() > 0) {
                int itemL = L.removeLast();
                int itemB = B.removeLast();
                assertEquals(itemL, itemB);
//                System.out.println("removeLast(" + itemL + ")");
            }
        }
    }
}
