/**
 * Class that prints the Collatz sequence starting from a given number.
 *
 * @author YOUR NAME HERE
 */
public class Collatz {

    /**
     * Returns the nextNumber in a Collatz sequence.
     */
    public static int nextNumber(int n) {
        // TODO: Fill in this method.
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = 3 * n + 1;
        }

        return n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");

        // Some starter code to test
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();

    }
}

