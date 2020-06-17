package com.knoldus.algo;

// Java implementation of above approach
class Abc
{

    static int maxSum = 100;
    static int arrSize = 51;

    // variable to store
    // states of dp
    static int[][] dp = new int[arrSize][maxSum];
    static boolean[][] visit = new boolean[arrSize][maxSum];

    // To find the number of subsets with sum equal to 0
    // Since S can be negative, we will maxSum
    // to it to make it positive
    static int SubsetCnt(int i, int s, int arr[], int n)
    {
        // Base cases
        if (i == n)
        {
            if (s == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // Returns the value if a state is already solved
        if (visit[i][s + arrSize])
        {
            return dp[i][s + arrSize];
        }

        // If the state is not visited, then continue
        visit[i][s + arrSize] = true;

        // Recurrence relation
        dp[i][s + arrSize] = SubsetCnt(i + 1, s + arr[i], arr, n)
                + SubsetCnt(i + 1, s, arr, n);

        // Returning the value
        return dp[i][s + arrSize];
    }

    // Driver function
    public static void main(String[] args)
    {
        int arr[] = {2, 2, 2, -4, -4};
        int n = arr.length;

        System.out.println(SubsetCnt(0, 0, arr, n));
    }
}

