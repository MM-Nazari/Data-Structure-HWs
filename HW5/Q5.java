package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static boolean allElementsTheSame(int[] array) {
        if (array.length == 0) {
            return true;
        } else {
            int first = 1;
            for (int element : array) {
                if (element != first) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> list1 = new ArrayList<>();
        for(int i =0 ; i<=n-1 ; i++){
            String str = sc.nextLine();
            list1.add(str) ;
        }
       int k = Integer.parseInt(sc.nextLine());;
      /*  ArrayList<String> list2 = new ArrayList<>();
        for(int i =0 ; i<=k-1 ; i++){
            String str2 = sc.nextLine();
            list2.add(str2) ;
        }*/
        //ArrayList<Integer> shahr = new ArrayList<>();







        int[] distinct = new int[n];
        Arrays.fill(distinct,0);
       /* for(int i =0 ; i<=n-1 ; i++){
            System.out.print(distinct[i]);
        }*/

        //int[] x = new int[]{0,1};
       // Arrays.fill(x,1);
       // System.out.print(allElementsTheSame(x));
        int r = 0;
        int transition =0 ;
        for(int i =0 ; i<=k-1 ; i++){
            String str2 = sc.nextLine();
             for(int j =0 ;j<=n-1 ; j++){
                    if(str2.equals(list1.get(j)))
                        distinct[j] = 1 ;
                        r = j ;
             
             }
            if(allElementsTheSame(distinct)){
               transition++ ;
                Arrays.fill(distinct,0);
                distinct[r]=1 ;
            }

        }
        System.out.print(transition);









     /*   String[] convert = str.split(" ", -1);
        for (String a : convert) {
        } */
       /* for (String s : list1) {
            System.out.print(s);
        }*/
    }
}
