
import java.io.*;
import java.util.*;

// in bakhsh az code az internet copy shode
class Sort {

    public static boolean isSorted(Stack<Integer> s) {
        boolean isSorted = true;
        if (s.size() == 1 || s.isEmpty()) {
            return isSorted;
        }

        Stack<Integer> auxiliaryStack = new Stack<Integer>();
        while (!s.isEmpty()) {
            int s1 = s.pop();
            if (!s.isEmpty()) {
                int s2 = s.peek();
                isSorted &= s2 >= s1;
            }
            auxiliaryStack.push(s1);
        }

        while (!auxiliaryStack.isEmpty()) {
            s.push(auxiliaryStack.pop());
        }

        return isSorted;
    }

}

public class Main {

    public static void main(String[] args) {

       // Sort ss = new Sort();
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>() ;
        Stack<Integer> s2 = new Stack<>() ;
        String str = sc.nextLine();
        StringBuilder str1 =new StringBuilder();
        str1.append(str);
        str1.reverse();
        String[] convert = str1.toString().split(" ", -1);
        int k =0 ;
        for (String a : convert){

            s1.push(Integer.parseInt(a));
            k++;

        }

        if(Sort.isSorted(s1)){
            System.out.println("yes");

        }
        else{
            while(s1.peek()!=1)
            {

                s2.push(s1.peek());
                s1.pop();

            }

            s1.pop();

            for(int i=2;i<=s1.size();i++){

                if( !Sort.isSorted(s2)){
                    System.out.println("no");
                    break;
                }
                else{
                   if(Sort.isSorted(s1)){
                       System.out.println("yes");
                       break;
                   }
                   else{
                       if(s1.contains(i)){
                           while(s1.peek()!=i)
                           {

                               s2.push(s1.peek());
                               s1.pop();

                           }

                           s1.pop();
                       }

                   }
                }


            }

        }


    }
}
