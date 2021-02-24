package pertemuan5;

import java.util.Arrays;
import java.util.Scanner;

class Soal1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points : ");
        int rowLen = scanner.nextInt();
        int colLen = 2;

        double[][] points = new double[rowLen][colLen];

        // Loop for input
        System.out.print("Enter " + rowLen + " points : ");
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                points[row][col] = scanner.nextDouble();
            }
        }


        double[][] result = getMinEuclidDistance(points);
        System.out.println("The closest two points are ("+ result[0][0] + ", " + result[0][1] +
                ") and (" + result[1][0] + ", " + result[1][1] + ")");

    }

    private static double[][] getMinEuclidDistance (double[][] dataArr) {
        int rowLen = dataArr.length;
        int colLen = dataArr[0].length;
        double[][] res = new double[colLen][colLen];

        int[] minIndex = new int[colLen];
        double min =
                Math.sqrt( Math.pow((dataArr[0][0] - dataArr[1][0]),2) + Math.pow((dataArr[0][1] - dataArr[1][1]),2
        ) );

        double tempDistance = 0;
        for (int row1 = 1; row1 < rowLen; row1++) {
            for (int row2 = row1+1; row2 < rowLen-1; row2++) {
                tempDistance =
                        Math.sqrt( Math.pow((dataArr[row1][0] - dataArr[row2][0]),2) + Math.pow((dataArr[row1][1] - dataArr[row2][1]),2
                                ) );

                if (tempDistance < min) {
                    min = tempDistance;
                    minIndex[0] = row1;
                    minIndex[1] = row2;
                }
            }
        }
        res[0] = dataArr[minIndex[0]];
        res[1] = dataArr[minIndex[1]];
        return res;
    }
}
