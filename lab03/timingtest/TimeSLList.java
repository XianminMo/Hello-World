package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        SLList<Integer> testSllist = new SLList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int N = 1000; // beginning amount of items
        int M = 10000; // amount of the calling of getLast method
        while (N <= 64000) {
            Ns.addLast(N);
            double timeInSeconds = computeTime(N, testSllist, M);
            times.addLast(timeInSeconds);
            N = N * 2;
        }
        for (int i = 0; i < Ns.size(); i += 1) {
            opCounts.addLast(M);
        }
        printTimingTable(Ns, times, opCounts);
    }

    private static double computeTime(int N, SLList<Integer> testSllist, int M) {
        for (int i = 0; i < N; i += 1) {
            testSllist.addLast(i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < M; i += 1) {
            testSllist.getLast();
        }
        double timeInSeconds = sw.elapsedTime();

        return timeInSeconds;
    }

}
