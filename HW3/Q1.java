import java.io.*;
import java.util.*;

/*
baraye in soal man in code ro ersale nahaee mizaram choonke javabesh be nazar
kamel tar hast monteha agar ravesh piadesazi level order ba queue morede ghabool nist
ersal 2 azar saat 09:00 man ro dar nazar begirid
 */
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
class BinaryTree {

    Node root;

    // ravesh chape levelorder az net copy shode bealave taghirati
    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {


            Node tempNode = queue.poll();
            if(tempNode.data!=0){
                System.out.print(tempNode.data + " ");
                if (tempNode.left != null) {

                    queue.add(tempNode.left);
                }
                else
                    System.out.print("null ");

                if (tempNode.right != null) {

                    queue.add(tempNode.right);
                }
                else
                    System.out.print("null ");
            }

        }
    }

    Node sortedArrayToBST(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder str1 =new StringBuilder();
        str1.append(str);
        String[] convert = str1.toString().split(" ", -1);
        int[] A = new int[convert.length+1];
        int k =0 ;
        for (String a : convert){

            A[k]=Integer.parseInt(a);
            k++;

        }
        BinaryTree tree = new BinaryTree();
       tree.root = tree.sortedArrayToBST(A, 0, k);
        tree.printLevelOrder();
    }

}