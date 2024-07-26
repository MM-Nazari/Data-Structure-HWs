package com.company;

import java.util.*;


// class graph az internet copy shode ama tanha ta wazn 2 ra poshtibani mikard ke ba
// algorithm moshabeh ta wazn 10 updatesh kardam
 class Graph
{
    int V; // No. of vertices
    Vector<Integer>[] adj; // No. of vertices

    static int level;

    // Constructor
    @SuppressWarnings("unchecked")
    Graph(int V)
    {
        this.V = V;
        this.adj = new Vector[10 * V];

        for (int i = 0; i < 10 * V; i++)
            this.adj[i] = new Vector<>();
    }

    // adds an edge
    public void addEdge(int v, int w, int weight)
    {

        if(weight == 10 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(v + 4 * this.V);
            adj[v + 4 * this.V].add(v + 5 * this.V);
            adj[v + 5 * this.V].add(v + 6 * this.V);
            adj[v + 6 * this.V].add(v + 7 * this.V);
            adj[v + 7 * this.V].add(v + 8 * this.V);
            adj[v + 8 * this.V].add(v + 9 * this.V);
            adj[v + 9 * this.V].add(w);

        }
        if(weight == 9 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(v + 4 * this.V);
            adj[v + 4 * this.V].add(v + 5 * this.V);
            adj[v + 5 * this.V].add(v + 6 * this.V);
            adj[v + 6 * this.V].add(v + 7 * this.V);
            adj[v + 7 * this.V].add(v + 8 * this.V);
            adj[v + 8 * this.V].add(w);

        }

        if(weight == 8 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(v + 4 * this.V);
            adj[v + 4 * this.V].add(v + 5 * this.V);
            adj[v + 5 * this.V].add(v + 6 * this.V);
            adj[v + 6 * this.V].add(v + 7 * this.V);
            adj[v + 7 * this.V].add(w);

        }
        if(weight == 7 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(v + 4 * this.V);
            adj[v + 4 * this.V].add(v + 5 * this.V);
            adj[v + 5 * this.V].add(v + 6 * this.V);
            adj[v + 6 * this.V].add(w);

        }

        if(weight == 6 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(v + 4 * this.V);
            adj[v + 4 * this.V].add(v + 5 * this.V);
            adj[v + 5 * this.V].add(w);

        }

        if(weight ==5 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(v + 4 * this.V);
            adj[v + 4 * this.V].add(w);

        }

        if(weight ==4 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(v + 3 * this.V);
            adj[v + 3 * this.V].add(w);

        }
        if(weight ==3 ){

            adj[v].add(v + this.V);
            adj[v + this.V].add(v + 2 * this.V);
            adj[v + 2 * this.V].add(w);

        }
        if (weight == 2)
        {
            adj[v].add(v + this.V);
            adj[v + this.V].add(w);
        }
        if( weight == 1)
            adj[v].add(w);
    }

    // print shortest path from a source vertex 's' to
    // destination vertex 'd'.
    public int printShortestPath(int[] parent, int s, int d)
    {
        level = 0;

        // If we reached root of shortest path tree
        if (parent[s] == -1)
        {
            //System.out.printf("Shortest Path between"+
             //       "%d and %d is %s ", s, d, s);
            return level;
        }

        printShortestPath(parent, parent[s], d);

        level++;
        //if (s < this.V)
           // System.out.printf("%d ", s);

        return level;
    }

    // finds shortest path from source vertex 's' to
    // destination vertex 'd'.

    // This function mainly does BFS and prints the
    // shortest path from src to dest. It is assumed
    // that weight of every edge is 1
    public int findShortestPath(int src, int dest)
    {
        boolean[] visited = new boolean[10 * this.V];
        int[] parent = new int[10 * this.V];

        // Initialize parent[] and visited[]
        for (int i = 0; i < 10 * this.V; i++)
        {
            visited[i] = false;
            parent[i] = -1;
        }

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty())
        {

            // Dequeue a vertex from queue and print it
            int s = queue.peek();

            if (s == dest)
                return printShortestPath(parent, s, dest);
            queue.poll();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int i : this.adj[s])
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = s;
                }
            }
        }
        return 0;
    }
}
public class Main {

    public static void main(String[] args) throws NumberFormatException {
        int[] array = new int[2] ;
        int[] array2 = new int[3] ;
        int k=0  ;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder str1 = new StringBuilder();
        str1.append(str);
        String[] convert = str1.toString().split(" ", -1);
        for (String a : convert) {
             array[k]= Integer.parseInt(a);
             k++;
        }
        Graph g = new Graph(array[0]);
        for(int i=0 ; i< array[1] ; i++){

            String str2 = sc.nextLine();
            StringBuilder str11 = new StringBuilder();
            str11.append(str2);
            String[] convert1 = str11.toString().split(" ", -1);
            int r=0;
            for (String aa : convert1) {
                array2[r]= Integer.parseInt(aa);
                r++;
            }
            g.addEdge(array2[0],array2[1],array2[2]);
        }
        int source = sc.nextInt();
        int[] array3 = new int[array[0]];
        for(int y =1 ; y<= array[0] ; y++){
            array3[y-1] = g.findShortestPath(source,y);
        }
        for(int u =0 ; u<array[0] ; u++){
            System.out.print(array3[u] + " ") ;
        }
    }
}
