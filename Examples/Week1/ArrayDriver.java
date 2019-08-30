//package com.revature.types;

public class ArrayDriver{

    public static void main(String[] args){

        // Java Assignment Convention
        int[] a1 = new int[5];

        // C/C++ Assignment Convention
        int a2[] = new int[5];

        // Explicit Assignment
        int[] a3 = {4, 5, 6};

        for (int i : a3){

            System.out.printf("%d ", i);
        }
        System.out.println();

        int[][] a4 = {{1,2,3},{4,5,6},{7,8,9}};

        for(int[] i : a4){ 

            for(int j : i){

                System.out.printf("%d ", j);

            }
            System.out.println();
        }

    }
}