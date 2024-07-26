//package com.company;

/*
man ebteda nemidoonestam faghat bayad ba bst ya heap kar konam va baad fahmidam
va ba heap sort kar karadam , agar in ravesh morede ghabool nist ersale 1 azar
saat 14:36 ro barresi konid
va inke har se code man dorost kar minkone monteha run time mide
mamnoon misham ham dar in soal va dar do soal dige code man ro dasti
tashih befarmaeed chonke baraye hameye voroodi haye khodam dorost kar mikone
nemidonam run time moshkel az queras ya pichidegie code man
dast shoma dard nakone
 */

import java.util.*;

// in ghesmat az internet copy shode
class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

}


public class Main {

    public static void main(String[] args) throws NumberFormatException {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {

            ArrayList<Integer> temp = new ArrayList<Integer>();
            String str = sc.nextLine();
            String[] convert = str.split(" ", -1);
            for (String a : convert) {
                try{
                    temp.add(Integer.parseInt(a));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    break;
                }

            }
            list.addAll(temp);

        }

        Integer[] array =  list.toArray(new Integer[0]);
        int[] arr = new int[list.size()];
        for(int i = 0 ;i < array.length ; i++)
        {

            arr[i] = array[i];
        }

        HeapSort ob = new HeapSort();
        ob.sort(arr);
        ob.printArray(arr);
      //  Collections.sort(list);
        //for (int i =0 ; i< list.size() ; i++){

          //  System.out.print(list.get(i)+" ");
        //}

    }
}