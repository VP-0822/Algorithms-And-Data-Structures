package com.algorithms.examplesbyviraj.sort;

import java.util.Scanner;

public class QuickSort {
	
	static void quickSort(int[] unsortedArray, int low, int high)
	{
		//Find pivot element as middle of range (low,high)
		int pivot = low + (high-low)/2;
		
		int tempLow = low;
		int tempHigh = high;
		
		int pivotElementValue = unsortedArray[pivot];
		
		//Iterate to move all smaller elements than pivot to left of array and bigger elements to right of pivot element.
		while(tempLow <= tempHigh)
		{
			//Find element bigger or equal than pivot element from left side
			while(unsortedArray[tempLow] < pivotElementValue)
			{
				tempLow++;
			}
			//Find element smaller or equal than pivot element from right side
			while(unsortedArray[tempHigh] > pivotElementValue)
			{
				tempHigh--;
			}
			//If still tempLow is left of pivot and tempHigh is right of pivot, swap elements
			//Possible that number is switched with pivot in following two cases
			//1. If left side of pivot element has smaller elements than pivot element itself and there exist atleast one element bigger than pivot on right
			//2. If Right side of pivot element has bigger elements than pivot element itself and there exist atleast one element smaller than pivot on left
			if(tempLow <= tempHigh)
			{
				int tempValue = unsortedArray[tempLow];
				unsortedArray[tempLow] = unsortedArray[tempHigh];
				unsortedArray[tempHigh] = tempValue;
				tempLow++;
				tempHigh--;
			}
			
		}
		
		//If low is still less than 
		if(low < tempHigh)
		{
			quickSort(unsortedArray, low, tempHigh);
		}
		
		//If high is still more than tempLow
		if(high > tempLow)
		{
			quickSort(unsortedArray, tempLow, high);
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
		
		quickSort(unsortedArray,0,length-1);
		
		//Sorted Array
		for(int n : unsortedArray)
		{
			System.out.print(n + " ");
		}
	}
}
