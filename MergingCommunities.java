/*
Problem Statement

People connect with each other in a social network. A connection between Person I and Person J is represented as M I J. When two persons belonging to different communities connect, the net effect is the merger of both communities which I and J belongs to.

At the beginning, there are N people representing N communities. Suppose person 1 and 2 connected and later 2 and 3 connected, then 1,2, and 3 will belong to the same community.

There are two type of queries:

M I J⟹ communities containing person I and J merged (if they belong to different communities).

Q I⟹ print the size of the community to which person I belongs.

Input Format

The first line of input will contain integers N and Q, i.e. the number of people and the number of queries.
The next Q lines will contain the queries.

Constraints :
1≤N≤105
1≤Q≤2×105

Output Format

The output of the queries.

Sample Input

3 6
Q 1
M 1 2
Q 2
M 2 3
Q 3
Q 2
Sample Output

1
2
3
3
Explanation

Initial size of each of the community is 1.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nPeople = sc.nextInt();
        DisJoint comm = new DisJoint(nPeople);
        int queries = sc.nextInt();
        for(int k = 0 ; k<queries ; k++){
            char query = sc.next().charAt(0);
            if(query == 'Q'){
               int person = sc.nextInt(); 
               int personParent = comm.Find(person);
               int community = comm.Rank[personParent];
               System.out.println(community);
            }
            if(query == 'M'){
                int person1 = sc.nextInt();
                int person2 = sc.nextInt();
                comm.Union(person1,person2);
            }
        }

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
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int aroot = this.Find(a);
        int broot = this.Find(b);
        int arank = Rank[aroot];
        int brank = Rank[broot];

        if (aroot == broot){
           return;
        }
        this.Rank[broot] += this.Rank[aroot];
        this.Parent[aroot] = broot;
    }

}