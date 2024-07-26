package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


  /*  private static int count2=0;
    private static int count1=0;
    private static int count=0;

    static int bs(int l  ,int n , int k){
        boolean salem  ;
        int mid ;
        //int count=0  ;
        mid = Math.floorDiv((k-l),2) +l ;
        while(n>=1) {
            salem = true;
            if (salem) {
                count++;
                l = mid;
                if( n==1){

                    count += k-l+1 ;
                }
                else
                bs(l, n, k);
                count1 = count ;

            }
            salem = false;
            if (!salem) {
                count++;
                n-- ;
                k=mid ;
                if( n==1){

                    count += k-l+1 ;
                }
                else
                bs(l, n, k);
                count2 = count ;
            }
        }

        return Math.max(count2 , count1) ;

    }*/

    static int function (int n , int k ){
        if(n!=1){ for(int i =0 ; i<= n-2 ;i++){
            k = Math.floorDiv((k-1),2)   ;
        }
            return k-1 + n-1 ;
        }
        else
            return k ;

    }
   /* public static int function2 ( int n , int k){

        return (n-2) + Math.floorDiv(k,(int)Math.pow(2,n-1)) ;
    }*/
    public static void main(String[] args) throws StackOverflowError {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
       // StringBuilder str1 = new StringBuilder();
        //str1.append(str);
        //String[] convert = str1.toString().split(" ", -1);
        String[] convert =str.split(" ", -1);
        ArrayList<Integer> list = new ArrayList<>();
        for (String a : convert) {
            list.add(Integer.parseInt(a));
        }
        int k = list.get(0);
        int n = list.get(1);
      //  System.out.print(n);
       // System.out.print(k);
       //int f = bs(1,n,k);
           System.out.print((int)Math.max(function(n,k),Math.ceil((int)(Math.log(k) / Math.log(2)))));
          // System.out.print(function2(n,k));


    }
}
