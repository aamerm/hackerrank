/*

https://www.hackerrank.com/challenges/components-in-graph

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DisJoint graph = new DisJoint(2*n);
        for(int k = 0 ; k<n ; k++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph.Union(node1,node2);            
        }
        
        for(int i=1;i<=n;i++){
            graph.Rank[i]=graph.Rank[graph.Find(i)];
        }
        
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(graph.Rank[i]!=1){
                min=Math.min(graph.Rank[i],min);
                max=Math.max(graph.Rank[i],max);
            }
        }
        System.out.print(min+" "+max);
    }
}

class DisJoint{
    public int Count;
    public int[] Parent;
    public int[] Rank;
    public DisJoint(int count){
        this.Count = count;
        this.Parent = new int[this.Count+1];
        this.Rank = new int[this.Count+1];
        for (int i = 1; i < this.Count+1; i++) {
            this.Parent[i] = i;
            this.Rank[i] = 1;
        }
    }
    public int Find(int i){
        if(i == Parent[i]){
            return Parent[i];
        }
        else{
           int result = Find(Parent[i]);
           Parent[i] = result;
           return result;
        }
    }

    public void  Union(int a, int b){
        int aroot = this.Find(a);
        int broot = this.Find(b);
        
        if (aroot == broot){
           return;
        }
        if(aroot>broot){
            int tmp = aroot;
            aroot = broot;
            broot = tmp;
        }
        this.Rank[aroot] += this.Rank[broot];
        this.Parent[broot] = aroot;
    }

}