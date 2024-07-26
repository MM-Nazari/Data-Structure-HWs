
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Queue {
    private final int front;
    private int rear;
    private final int capacity;
    private  int queue[];

    Queue()
    {
        front = rear = 0;
        capacity = 50000;
        queue = new int[capacity];
    }

     void front() {
         if (front == rear) {
             System.out.println("no job :)");

         } else {

             System.out.println(queue[front]);
             for (int i = 0; i < rear-1 ; i++) {
                 queue[i] = queue[i + 1];
             }
             rear--;

         }
     }

     void back()
    {
        if (front == rear) {
            System.out.println("no job :)");

        }
        else {

            System.out.println(queue[rear-1]);
            rear--;
        }

    }

    void toFront(int n){

        if(capacity==rear){

            System.out.println("no more space :(");
        }
        else{

            for (int i = rear-1 ;i >=0; i--) {
                queue[i + 1] = queue[i];
            }
            rear++;
            queue[front]=n;
        }

    }

    void pushBack(int n){

        if(capacity==rear){

            System.out.println("no more space :(");
        }
        else {
            queue[rear] = n;
            rear++;
        }
    }

    void reverse()
    {

        Collections.reverse(Collections.singletonList(queue));
    }

}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
       int a = sc.nextInt();
        for(int i=0 ; i<a ; i++){

            String s = sc.nextLine();
            if(s.equals("front") || s.equals("back") || s.equals("reverse")) {
                if (s.equals("front")) {
                    q.front();
                }
                if (s.equals("back")) {
                    q.back();
                }
                if (s.equals("reverse")) {
                    q.reverse();
                }
            }

            else{
                int y =0 ;
                int z =0 ;
                String[] ss = s.split(" ");
               for(String qq : ss){
                   if(y==1){
                       if(z==1){
                           q.toFront(Integer.parseInt(qq));
                       }
                       if(z==2){
                           q.pushBack(Integer.parseInt(qq));
                       }
                   }
                   if(y==0){
                       if(qq.equals("to_front")){
                         z=1 ;
                       }
                       if(qq.equals("push_back")){
                         z=2 ;
                       }
                       y=1;
                   }


               }

            }
        }
    }

}
