import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;

public class DrawTriangleMethod {
    public static void drawTriangle(int n) {
        int row = 0;
        int col = 0;
        while (row < n) {
            while (col <= row) {
                System.out.print('*');
                col += 1;
            }
            System.out.println();
            row += 1;
            col = 0;
        }
    }

    public static void main(String[] args) {
        drawTriangle(5);

    }
}