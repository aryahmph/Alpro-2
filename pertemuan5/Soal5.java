package pertemuan5;

import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points : ");
        int rowLen = scanner.nextInt();
        int colLen = 3;

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
                ", " + result[0][2] + ") and (" + result[1][0] + ", " + result[1][1] + ", " + result[1][2] + ")");

    }

    private static double[][] getMinEuclidDistance (double[][] dataArr) {
        int rowLen = dataArr.length;

        int[] minPointIndex = new int[2];
        double min =
                Math.sqrt( Math.pow((dataArr[0][0] - dataArr[1][0]),2) + Math.pow((dataArr[0][1] - dataArr[1][1]),2
                ) + Math.pow((dataArr[0][2] - dataArr[1][2]),2) );

        double tempDistance = 0;
        for (int row1 = 1; row1 < rowLen; row1++) {
            for (int row2 = row1+1; row2 < rowLen-1; row2++) {
                tempDistance =
                        Math.sqrt( Math.pow((dataArr[row1][0] - dataArr[row2][0]),2) + Math.pow((dataArr[row1][1] - dataArr[row2][1]),2
                        ) + Math.pow((dataArr[row1][2] - dataArr[row2][2]),2) );

                if (tempDistance < min) {
                    min = tempDistance;
                    minPointIndex[0] = row1;
                    minPointIndex[1] = row2;
                }
            }
        }
        return new double[][] {
                dataArr[minPointIndex[0]],
                dataArr[minPointIndex[1]]
        };
    }

}
