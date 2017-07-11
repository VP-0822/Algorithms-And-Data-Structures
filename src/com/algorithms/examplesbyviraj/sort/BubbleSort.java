package com.algorithms.examplesbyviraj.sort;

import java.util.Scanner;

public class BubbleSort {

	static void bubbleSort(int[] unsortedArray)
	{
		int length = unsortedArray.length;
		
		//Iterate for no of elements
		for(int i = 0; i < length ; i++)
		{
			boolean anyElementSwapped = false;
			//walk-through array
			for(int j = 0 ; j < length-1 ; j++)
			{ 
				//Swap elements in array if not in ascending order.
				if(unsortedArray[j] > unsortedArray[j+1])
				{
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
					anyElementSwapped = true;
				}
			}
			if(anyElementSwapped == false)
			{
				//array is sorted now.
				break;
			}
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
		
		bubbleSort(unsortedArray);
		
		//Sorted Array
		for(int n : unsortedArray)
		{
			System.out.print(n + " ");
		}
	}

}
