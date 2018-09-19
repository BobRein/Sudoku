//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.*;

public class Main {


    public static void main(String[] args) {
        int[][] myArray = new int[9][9];
        Random randy = new Random();
        Scanner reader= new Scanner(System.in);
        int failspot = 0;
        int backDist = 1;
        int a;
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                int x = 0;


                do {
                    a = randy.nextInt(9) + 1;
                    ++x;
                } while(x < 100 && !isLegalMove(myArray, a, i, j));

                if (x < 100) {
                    myArray[i][j] = a;
                } else {
                    if (failspot == i * 9 + j) {
                        ++backDist;
                    } else {
                        backDist = 1;
                        failspot = i * 9 + j;
                    }

                    for(int z = failspot; z >= failspot - backDist; --z) {
                        myArray[z / 9][z % 9] = 0;
                        i = (z - 1) / 9;
                        j = (z - 1) % 9;
                    }
                }
            }
        }
        printMySudokuUnsolved(myArray);

        System.out.println("\n Enter 1 if you want to see the completed version.");
        a= reader.nextInt();
        if (a==1)
            printMySudoku(myArray);
    }

    public static boolean isLegalMove(int[][] myArray, int num, int a, int b) {
        boolean returnVal = true;
        if (myArray[a][b] != 0) {
            returnVal = false;
        }

        int i;
        for(i = 0; i < 9; ++i) {
            if (myArray[i][b] == num || myArray[a][i] == num) {
                returnVal = false;
            }
        }

        for(i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if (myArray[i + 3 * (a / 3)][j + 3 * (b / 3)] == num) {
                    returnVal = false;
                }
            }
        }

        return returnVal;
    }

    public static void printMySudoku(int[][] myArray) {
        for(int i = 0; i < 9; ++i) {
            if (i % 3 == 0) {
                System.out.println("");
            }

            System.out.println("");

            for(int j = 0; j < 9; ++j) {
                if (j % 3 == 0) {
                    System.out.print("\t");
                }

                System.out.print(myArray[i][j]);
            }
        }

    }
    public static void printMySudokuUnsolved(int[][] myArray)
    {
        Random rand = new Random();

        for(int i = 0; i < 9; ++i)
        {
            if (i % 3 == 0)
            {
                System.out.println("");
            }
            System.out.println("");

            for(int j = 0; j < 9; ++j)
            {
                if (j % 3 == 0)
                {
                    System.out.print("\t");
                }
                if(rand.nextInt(2) ==1)
                {
                    System.out.print(myArray[i][j]);
                }
                else
                {
                    System.out.print(0);
                }
            }
        }

    }
}