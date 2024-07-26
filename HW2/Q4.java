

import java.util.Scanner;

class Komaki {


    private int[] A = new int[200000];
    private int c =0 ;

    void reverse (int k ){

        for(int i = c-k+1 ; i < c-k/2; i++)
        {
            int temp = A[i];
            A[i] = A[c-k/2 - i - 1];
            A[c-k/2 - i - 1] = temp;
        }
    }
    void add(int x){
      A[c]=x;
      c++;
    }
    void display(){
        for(int i=0 ; i<=c ;i++ ){
            System.out.printf("%d ",A[i]);


        }

    }


}
public class Main {

    public static void main(String[] args) {

        Komaki saf = new Komaki();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int r=0 ;
        int k=0;
        int n=0;
        String[] ss = s.split(" ");
        for( String a : ss){
            if(r==1){

                 k = Integer.parseInt(a);
            }
            if(r==0){

                 n = Integer.parseInt(a);
                r=1;
            }
        }

        for( int i =0 ; i<n ; i++){

            String s1 = sc.nextLine();
            if(s1.equals("REVERSE")){

               saf.reverse(k);
            }
            else{
                String[] s2= s1.split(" ");
                int t=0;
                for(String b : s2){

                    if(t==1){
                        saf.add(Integer.parseInt(b));
                    }
                    if(t==0){
                        t=1;
                    }

                }

            }



        }

        saf.display();

    }
}
