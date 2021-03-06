/*

Problem Statement

There are N buildings in a certain one-dimensional landscape. Each building has a height given by hi,i∈[1,N]. If you join K adjacent buildings, they will form a solid rectangle of area K×min(hi,hi+1,…,hi+k−1).

Given N buildings, find the greatest such solid area formed by consecutive buildings.

Input Format 
The first line contains N, the number of buildings altogether. 
The second line contains N space-separated integers, each representing the height of a building.

Constraints 
1≤N≤105 
1≤hi≤106
Output Format 
One integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5
Sample Output

9

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestRectangle {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int buildings=in.nextInt();
        int[] heights=new int[buildings];
        for(int i=0;i<buildings;i++){
            heights[i]=in.nextInt();
        }
        
        int[] count=new int[buildings];
        for(int i=0;i<buildings;i++){
            count[i]=countAdjBuildings(i,heights);
        }
          
        int max=0;
        for(int i=0;i<heights.length;i++)
            max=Math.max(max,heights[i]*count[i]);
        
        System.out.println(max);
    }
    
    public static int countAdjBuildings(int n, int[] heights){
        int temp=1;
        for(int i=n+1;i<heights.length;i++){
            if(heights[i]>=heights[n])
                temp++;
            else break;
        }
        for(int i=n-1;i>=0;i--){
            if(heights[i]>=heights[n])
                temp++;
            else break;
        }
        return temp;
    }
}