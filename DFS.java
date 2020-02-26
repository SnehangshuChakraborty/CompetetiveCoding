/*Given N nodes and E edges of a graph. The task is to do depth first traversal of the graph.

Note: Use recursive approach.

Input:
First line of input contains number of testcases T. For each testcase. First line of each testcase contains number of nodes and edges seperated by space and next line contains N pairs of integers (X and Y each) where X Y means an edge from X to Y.

Output:
For each testcase, print the nodes while doing DFS starting from node 0.

Your task:
The task is to complete the function dfs() which should do the depth first traversal of given graph and prints the node in DFS order.

Constraints:
1 <= T <= 100
1 <= N <= 200

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
4 3
0 1 1 2 0 3

Output:
0 1 2 4 3    // dfs from node 0
0 1 2 3

Explanation:
Testcase 1: There is  one test cases.  First line of each test case represent an integer N denoting number of edges and then in the next line N pairs of values a and b are fed which denotes there is an edge from a to b.
*/
// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            new Traversal().dfs(0, list, vis);
            System.out.println();
        }
    }
}

// } Driver Code Ends
//User function Template for Java


/*
*ArrayList<ArrayList<Integer>> list: which represents graph
* src: represents source vertex
*vis[]: boolean array 
*/

class Traversal
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
        if(!vis[src]){
            System.out.println("Src "+src);
            vis[src]=true;
        }
       
       ArrayList<Integer> curr = list.get(src);
       for(int i = 0; i< curr.size() ; i++){
           if(!vis[curr.get(i)])
           dfs(curr.get(i),list,vis);
       }
    }
}

