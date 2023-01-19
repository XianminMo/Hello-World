package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> testAlist = new AListNoResizing<>();
        BuggyAList<Integer> testBuggyAlist = new BuggyAList<>();

        for (int i = 4; i <= 6; i += 1) {
            testAlist.addLast(i);
            testBuggyAlist.addLast(i);
        }

        for (int i = 0; i < 3; i += 1) {
            int returnTestAlist = testAlist.removeLast();
            int returnTestBuggyAlist = testBuggyAlist.removeLast();
            assertEquals(returnTestAlist, returnTestBuggyAlist);
        }

        assertEquals(testAlist.size(), testBuggyAlist.size());
    }

    @Test
    public void radomizedTest() {
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
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2 && L.size() != 0) {
                // getLast
                int lastItem1 = L.getLast();
                int lastItem2 = B.getLast();
                assertEquals(lastItem1, lastItem2);
            } else if (operationNumber == 3 && L.size() != 0) {
                // removelast
                int removeLastItem1 = L.removeLast();
                int removeLastItem2 = B.removeLast();
                assertEquals(removeLastItem1, removeLastItem2);
            }
        }
    }
}
