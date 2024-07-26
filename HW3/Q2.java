//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] v = new int[2];
        int q1 =0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder str1 =new StringBuilder();
        str1.append(str);
        String[] convert = str1.toString().split(" ", -1);
        for (String a : convert){
            v[q1]=Integer.parseInt(a);
            q1++;
        }
        ArrayList<Integer>[] c = new ArrayList[v[1]+1];
        for (int i = 1; i <= v[1]; i++) {
            c[i] = new ArrayList<Integer>();
        }
        for(int i =0 ; i< v[0] ; i++){
            int q2=0;
            int[]  kh = new int[3];
            String str2 = sc.nextLine();
            StringBuilder str3 =new StringBuilder();
            str3.append(str2);
            String[] convert1 = str3.toString().split(" ", -1);
            for (String aa : convert1){
                kh[q2]=Integer.parseInt(aa);
                q2++;
            }
            for(int r= kh[0] ; r<= kh[1];r++){

                c[r].add(kh[2]);
            }

        }

        for(int t=1 ; t<=v[1] ; t++){

            try {
                if(c[t].size()!=0)
                    System.out.print(Collections.max(c[t]) + " ");
                else
                    System.out.print(0 + " ");

            }
            catch (ClassCastException | NoSuchElementException e) {
            }
        }

    }
}