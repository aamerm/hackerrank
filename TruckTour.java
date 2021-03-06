/*
Problem Statement

Suppose there is a circle. There are N petrol pumps on that circle. Petrol pumps are numbered 0 to (N−1) (both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.

Input Format

The first line will contain the value of N.
The next N lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.

Constraints:
1≤N≤105
1≤amount of petrol, distance≤109
Output Format

An integer which will be the smallest index of the petrol pump from which we can start the tour.

Sample Input

3
1 5
10 3
3 4
Sample Output

1
Explanation

We can start the tour from the second petrol pump.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TruckTour {

    public static void main(String[] args) {
Scanner in=new Scanner(System.in);
    int pumps=in.nextInt();
        int[] litres=new int[pumps];
        int[] distance=new int[pumps];
        for(int i=0;i<pumps;i++){
            litres[i]=in.nextInt();
            distance[i]=in.nextInt();
        }
        
        int fuel,count;
        for(int i=0;i<pumps;i++){
            if(litres[i]-distance[i]<0)
                continue;
            fuel=0;
            count=0;
            for(int j=i;count<pumps;j=(j+1)%pumps){
                fuel+=litres[j];
                fuel-=distance[j];
                if(fuel<0) break;
                count++;
            }
            if(fuel>=0){
                System.out.println(i);
                break;                
            }
        }
        
    }
}