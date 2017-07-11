package com.algorithms.examplesbyviraj.sort;

import java.util.Scanner;

public class SelectionSort {

	static void selectionSort(int[] unsortedArray)
	{
		int length = unsortedArray.length;
		
		//Iterate for each element in array
		for(int i = 0 ; i <length; i++)
		{
			//assign index
			int index = i ;
			//iterate from next element of index to end.
			for(int j =i+1 ; j < length ; j++)
			{
				//if element is less than index element, assign new index for local loop
				if(unsortedArray[j] < unsortedArray[index])
				{
					index = j;
				}
				
			}
			//swap with smallest element  
			int temp = unsortedArray[i];
			unsortedArray[i] = unsortedArray[index];
			unsortedArray[index] = temp;
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
		
		selectionSort(unsortedArray);
		
		//Sorted Array
		for(int n : unsortedArray)
		{
			System.out.print(n + " ");
		}
	}

}
