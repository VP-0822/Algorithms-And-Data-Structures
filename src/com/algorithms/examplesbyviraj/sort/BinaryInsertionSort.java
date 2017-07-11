package com.algorithms.examplesbyviraj.sort;

import java.util.Scanner;

public class BinaryInsertionSort {
	
	//Search where to put key element, by using binary search algorithm
	static int binarySearchItem(int low,int high,int[] unsortedArray,int key)
	{
		//if less than or equal to high end
		if(high <= low)
		{
			//return low position +1 as key is greater than lowest element
			if(key > unsortedArray[low])
			{
				return low+1;
			}
			//return low position as key is lowest
			else
			{
				return low;
			}
		}
		
		//Find mid point
		int mid = (high+low)/2;
		
		//If key element is equal to mid point element, then return midpoint+1 position as location for key element
		if(key == unsortedArray[mid])
		{
			return mid+1;
		}
		
		if(key > unsortedArray[mid])
		{
			//If key element is greater than mid element than search in right side array of mid point
			return binarySearchItem(mid+1, high, unsortedArray, key);
		}
		else
		{
			//If key element is lesser than mid element than search in left side array of mid point
			return binarySearchItem(low, mid-1, unsortedArray, key);
		}
	}
	
	static void binaryInsertionSort(int[] unsortedArray)
	{
		int length = unsortedArray.length;
		int locationOfKey;
		//Iterate for all elements except 1st
		for(int i = 1; i <length ;i++)
		{
			int key = unsortedArray[i];
			int high = i -1;
			
			//Find location for key (current element);
			locationOfKey = binarySearchItem(0, high, unsortedArray, key);
			
			//move all elements whose value is greater than key to right side by one position in sorted array
			while(high >= locationOfKey)
			{
				unsortedArray[high+1] = unsortedArray[high];
				high--;
			}
			//Place key at right place in sorted array
			unsortedArray[high+1] = key;
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
		
		binaryInsertionSort(unsortedArray);
		
		//Sorted Array
		for(int n : unsortedArray)
		{
			System.out.print(n + " ");
		}
	}

}
