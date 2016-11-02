package com.algo.done.utility;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class KnapsackUtility 
{
    public int max(int a, int b) 
    { 
        return (a > b)? a : b; 
    }
    public int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int [][]K = new int[n+1][W+1];
 
	   // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
 
        return K[n][W];
    }
 
   
}
