package pertemuan5;

import java.util.Arrays;
import java.util.Scanner;

class Soal3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        int[][] company = new int[8][7];
        int rowLen = company.length;
        int colLen = company[0].length;

        String[] companySum = new String[rowLen];

        // Loop for input and sum
        int rowSum;
        for (int row = 0; row < rowLen; row++) {
            // Reset rowSum
            rowSum = 0;

            for (int col = 0; col < colLen; col++) {
                // Input
                company[row][col] = scanner.nextInt();
                // Sum
                rowSum += company[row][col];
            }

            builder.append(rowSum).append("_").append(row);
            companySum[row] = builder.toString();
            builder.setLength(0);
        }

        Arrays.sort(companySum);

        // Display sorted employee in company
        int index;
        for (int row = 0; row < rowLen; row++) {
            index = Integer.parseInt(companySum[row].split("_")[1]);
            System.out.print("Employee " + index + " :");
            displayArr1D(company[index]);
        }

        builder = null;
        scanner.close();

    }

    private static void displayArr1D (int[] dataArr) {
        int len = dataArr.length;
        for (int i = 0; i < len ; i++) {
            System.out.print(" "+ dataArr[i]);
        }
        System.out.println();
    }
}
