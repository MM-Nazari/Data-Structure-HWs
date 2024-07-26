package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String a = sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        StringBuilder str2 =new StringBuilder();
        str2.append(s2);
        StringBuilder str1 =new StringBuilder();
        str1.append(s1);
        str1.reverse();
        String[] convert = str1.toString().split(" ", -1);
        String[] convert2 = str2.toString().split(" ", -1);
        int i =0 ;
        int r =0 ;
        Object[] A1 = new Object[Integer.parseInt(a)];
        Object[] A2 = new Object[Integer.parseInt(a)];

        for (String aa : convert){

          A1[i]=Integer.parseInt(aa);
          i++;

        }
        for (String bb : convert2){

            list.add(Integer.parseInt(bb));

        }

        for(int k=1 ; k<=Integer.parseInt(a);k++ ){

            Collections.rotate(list,k);
             A2 = list.toArray();
            if(Arrays.equals(A2, A1)){
                r=1 ;
                break;
            }
        }


        if(r==0){
            System.out.println("false");
        }
        if(r==1){
            System.out.println("true");
        }

    }
}
