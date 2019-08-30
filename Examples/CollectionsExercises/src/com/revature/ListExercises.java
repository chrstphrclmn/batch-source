package com.revature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class ListExercises {

	public static void main(String[] args) {
		
		ArrayList<String> arrlist1 = new ArrayList<String>();
		arrlist1.add("hg");
		arrlist1.add("df");
		arrlist1.add("po");
		print(arrlist1);
		System.out.println(alphaIndex(new ArrayList<String>()));
		
		LinkedList<Integer> linklist1 = new LinkedList<Integer>();
		for (int i = 0 ; i < 50 ; i ++) {
			
			linklist1.add((i + 13) * 2041 % 71);
		}
		printsl(linklist1);
		mergeSort(linklist1);
		printsl(linklist1);
	}
	
	public static <T extends Collection<E>, E> void print(T list) {
		
		for(E element : list) {
			
			System.out.println(element);
		}
	}
	
	public static <T extends Collection<E>, E> void printsl(T list) {
		
		for(E element : list) {
			
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static int alphaIndex(ArrayList<String> list) {
		
		int ret = -1;
		int ord = 200;
		char temp = 0;
		
		for(int i = 0 ; i < list.size(); i++) {
			
			temp = list.get(i).toLowerCase().toCharArray()[0];
			
			if(temp < ord) {
				
				ord = temp;
				ret = i;
			}
		}
		
		return ret;
	}
	
	public static void mergeSort(LinkedList<Integer> list) {
		
		Integer[] arr = list.toArray(new Integer[0]);
		int len = list.size();
		sortHelper(arr, 0, len - 1);
		
		for(Integer i : arr) {
			
			list.poll();
			list.add(i);
		}
	}
	
	public static void sortHelper(Integer[] arr, int lowidx, int highidx) {
		
		if(lowidx < highidx) {
			
			int mididx = (highidx + lowidx) / 2;
			
			sortHelper(arr, lowidx, mididx);
			sortHelper(arr, mididx + 1, highidx);
			
			mergeHelper(arr, lowidx, mididx, highidx);
		}
		
		return;
		
	}
	
	public static void mergeHelper(Integer[] arr, int lowidx, int mididx, int highidx) {
		
		int n1 = mididx - lowidx + 1;
		int n2 = highidx - mididx;
		
		Integer[] templeft = new Integer[n1];
		Integer[] tempright = new Integer[n2];
		
		for(int i = 0 ; i < n1 ; i++) {
			
			templeft[i] = arr[lowidx + i];
		}
		
		for(int i = 0 ; i < n2 ; i++) {
			
			tempright[i] = arr[mididx + 1 + i];
		}
		
		int i = 0, j = 0;
		
		int k = lowidx;
		
		while(i < n1 && j < n2) {
			
			if(templeft[i] <= tempright[j]) {
				
				arr[k] = templeft[i];
				i++;
			}
			
			else {
				
				arr[k] = tempright[j];
				j++;
			}
			
			k++;
		}
		
		while(i < n1) {
			
			arr[k] = templeft[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			
			arr[k] = tempright[j];
			j++;
			k++;
		}
		
	}
}
