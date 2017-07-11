package com.algorithms.examplesbyviraj.sort;

import java.util.Scanner;

public class MergeSort {
	
	static void mergeParts(int[] unsortedArray, int low, int mid, int high)
	{
		//Create empty array for both parts
		int lengthOfLeftArray = mid-low +1;
		int lengthOfRightArray = high-mid;
		
		int[] left = new int[lengthOfLeftArray];
		int[] right = new int[lengthOfRightArray];
		
		//Populate left array
		for(int i = 0; i <lengthOfLeftArray ; i++)
		{
			left[i] = unsortedArray[low+i];
		}
		
		//Populate right array
		for(int i = 0 ; i <lengthOfRightArray ; i++)
		{
			right[i] = unsortedArray[mid +1 + i];
		}
		int leftIndex = 0, rightIndex = 0;
		int k = low;
		
		//Merge two parts in sorted manner
		while(leftIndex < lengthOfLeftArray && rightIndex < lengthOfRightArray )
		{
			//If left array element is smaller
			if(left[leftIndex] <= right[rightIndex])
			{
				unsortedArray[k] = left[leftIndex];
				leftIndex ++;
			}
			else
			{
				unsortedArray[k] = right[rightIndex];
				rightIndex++;
			}
			k++;
		}
		
		//Note : Order of following two while loops doesn't matter, 
		//		 as exit from above while loop only happens when one of the array (Either left or right) is completely transferred into unsorted array
		
		//move all left over elements of left array into unsortedArray
		
		while(leftIndex < lengthOfLeftArray)
		{
			unsortedArray[k] = left[leftIndex];
			leftIndex++;k++;
		}
		
		//move all left over elements of right array into unsortedArray
		
		while(rightIndex < lengthOfRightArray)
		{
			unsortedArray[k] = left[rightIndex];
			rightIndex++;k++;
		}
		
	}
	
	static void mergeSort(int[] unsortedArray, int low, int high)
	{
		//if highest position in array greater than lowest position in array
		if(low < high)
		{
			//Find mid point
			int mid = (high + low)/2;
			
			//mergeSort for left side of mid element
			mergeSort(unsortedArray, low, mid);
			
			//mergeSort for right side of mid element
			mergeSort(unsortedArray, mid+1, high);
			
			//merge above two parts
			mergeParts(unsortedArray, low, mid, high);
			
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
		
		mergeSort(unsortedArray,0,length-1);
		
		//Sorted Array
		for(int n : unsortedArray)
		{
			System.out.print(n + " ");
		}
	}
}
