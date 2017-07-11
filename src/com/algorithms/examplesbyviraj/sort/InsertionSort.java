package com.algorithms.examplesbyviraj.sort;

import java.util.Scanner;

public class InsertionSort {

	static void insertionSort(int[] unsortedArray)
	{
		int n = unsortedArray.length;
		//Left of i is always sorted.
        for (int i=1; i<n; ++i)
        {
        	//Get ith element as key
            int key = unsortedArray[i];
            //mark start of while from left element of j
            int j = i-1;
            //while jth element is greater than key move to j+1th element
            while (j>=0 && unsortedArray[j] > key)
            {
            	unsortedArray[j+1] = unsortedArray[j];
            	//decrement j
                j = j-1;
            }
            //assign key to j+1 element
            unsortedArray[j+1] = key;
        }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Length of array.
		int length = sc.nextInt();
		
		int[] unsortedArray = new int[length];
		
		for(int i = 0 ; i < length; i++)
		{
			unsortedArray[i] = sc.nextInt();
		}
		
		insertionSort(unsortedArray);
		
		//Sorted Array
		for(int n : unsortedArray)
		{
			System.out.print(n + " ");
		}
	}

}
