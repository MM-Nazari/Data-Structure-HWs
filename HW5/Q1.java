package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

// algorithm peida kardane maximum zarb do masir az net komak gerefte shode
public class Main {
    static int curMax;

    // Returns maximum length path in
// subtree rooted at u after
// removing edge connecting u and v
    static int dfs(Vector<Integer>[] g,
                   int u, int v) {

        // To find lengths of first and
        // second maximum in subtrees.
        // currMax is to store overall
        // maximum.
        int max1 = 0, max2 = 0, total = 0;

        // Loop through all neighbors of u
        for (int i = 0; i < g[u].size(); i++) {

            // If neighbor is v, then skip it
            if (g[u].get(i) == v)
                continue;

            // Call recursively with current
            // neighbor as root
            total = Math.max(total, dfs(
                    g, g[u].get(i), u));

            // Get max from one side and update
            if (curMax > max1) {
                max2 = max1;
                max1 = curMax;
            } else
                max2 = Math.max(max2, curMax);
        }

        // Store total length by adding max
        // and second max
        total = Math.max(total, max1 + max2);

        // Update current max by adding 1, i.e.
        // current node is included
        curMax = max1 + 1;
        return total;
    }

    // Method returns maximum product of
// length of two non-intersecting paths
    static int maxProductOfTwoPaths(Vector<Integer>[] g, int N) {
        int res = Integer.MIN_VALUE;
        int path1, path2;

        // One by one removing all edges and
        // calling dfs on both subtrees
        for (int i = 1; i < N + 2; i++) {
            for (int j = 0; j < g[i].size(); j++) {

                // Calling dfs on subtree rooted at
                // g[i][j], excluding edge from g[i][j]
                // to i.
                curMax = 0;
                path1 = dfs(g, g[i].get(j), i);

                // Calling dfs on subtree rooted at
                // i, edge from i to g[i][j]
                curMax = 0;
                path2 = dfs(g, i, g[i].get(j));

                res = Math.max(res, path1 * path2);
            }
        }
        return res;
    }

   /* public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }*/

    // Utility function to add an
// undirected edge (u,v)
    static void addEdge(Vector<Integer>[] g,
                        int u, int v) {
        g[u].add(v);
        g[v].add(u);
    }

    //  Driver code
    public static void main(String[] args) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int[][] edges = new int[x - 1][2];
        ArrayList<Integer> list = new ArrayList<>();
        //int k2;
        for (int j = 0; j <= x - 2; j++) {
            // k2=0;
            String str00 = sc.nextLine();
            // StringBuilder str111 = new StringBuilder();
            //str111.append(str00);
            //String[] convert00 = str111.toString().split(" ", -1);
            String[] convert00 = str00.split(" ");
            for (String zzz : convert00) {
               /* if(k2==0){
                    edges[j][k2]=Integer.parseInt(zzz);
                    k2++;}
                    else{
                    edges[j][k2]=Integer.parseInt(zzz);
                }*/
                list.add(Integer.parseInt(zzz));
            }
            edges[j][0]=list.get(j*2);
            edges[j][1]=list.get((j*2)+1);

        }
       /* int edges[][] = { { 1, 8 }, { 2, 6 },
                { 3, 1 }, { 5, 3 },
                { 7, 8 }, { 8, 4 },
                { 8, 6 } };*/

                int N = edges.length;
                //int N =x ;
                // There are N edges, so +1 for nodes
                // and +1 for 1-based indexing
                @SuppressWarnings("unchecked")
                Vector<Integer>[] g = new Vector[N + 2];
                for (int i = 0; i < g.length; i++)
                    g[i] = new Vector<>();

                for (int[] edge : edges) addEdge(g, edge[0], edge[1]);

                System.out.print(maxProductOfTwoPaths(g, N));
                // print2D(edges);
            }
        }
