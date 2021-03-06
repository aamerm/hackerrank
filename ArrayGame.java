/*
Problem Statement

In this problem you will test your knowledge on the Java 1D array.

You are playing a game on your cellphone. You are given an array of length n, indexed from 0 to n−1. Each element of the array is either 0 or 1. You can only move to an index which contains 0. At first you are at the 0th position. In each move you can do one of the following things:

Walk one step forward or backward.
Make a jump of exactly length m forward.
That means you can move from position x to x+1, x−1 or x+m in one move. The new position must contain 0. Also you can move to any position greater than n-1.

You can't move backward from position 0. If you move to any position greater than n−1, you win the game.

Given the array and the length of the jump, you need to determine if it's possible to win the game or not.

Input Format

In the first line there will be an integer T denoting the number of test cases. Each test case will consist of two lines. The first line will contain two integers, n and m. On the second line there will be n space-separated integers, each of which is either 0 or 1.

Constraints:

1<=T<=5000
2≤n≤100
0≤m≤100
The first integer of the array is always 0.

Output Format

For each case output "YES" if it's possible to win the game, output "NO" otherwise.

Sample Input

4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO
Explanation

In the first case you can just walk to reach the end of the array.
In the second case, you can walk to index 1 or 2 and jump from there. In the third case, jump length is too low, you can't reach the end of the array. In the fourth case, jump length is 1, so it doesn't matter if you jump or walk, you can't reach the end.

*/





import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayGame {

   public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int cases=input.nextInt();
		int n=0, m=0;
		int[] a;
		List<Integer> validPositions;
		
		for(int x=0;x<cases;x++){
			validPositions=new ArrayList<Integer>();
			n=input.nextInt();
			m=input.nextInt();
			a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=input.nextInt();
			
			validPositions.add(0);
			for(int j=1;j<n;j++){
				if(a[j]==0 && canJump(j, m, validPositions, n)){
					validPositions.add(j);
					scanNewValidPositions(j,a,validPositions);
				}
			}
			
			if(canJump(n, m, validPositions, n))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}


	public static boolean canJump(int currPos, int jump, List<Integer> validPositions, int totalSize){
		int temp=0;
		if(currPos==totalSize){
			for(int i=0;i<validPositions.size();i++){
				temp=validPositions.get(i);
				if(temp+1>=totalSize || temp+jump>=totalSize)
					return true;
			}
		}
		else{	
			for(int i=0;i<validPositions.size();i++){
				temp=validPositions.get(i);
				if(temp+1==currPos || temp+jump==currPos)
					return true;
			}	
		}
		return false;
	}
	
	public static void scanNewValidPositions(int end,int[] a, List<Integer> validPositions){
		for(int i=end;i>=0;i--){
			if(a[i]==0)
				validPositions.add(i);
			else
				break;
		}
	}
}