/*
Problem Statement

The median of a finite list of numbers can be found by arranging all the integers from lowest to highest value and picking the middle one. For example, the median of {3,3,5,9,11} is 5. If there is an even number of integers, then there is no single middle value, and the median is then usually defined to be the mean of the two middle values. For examples, the median of {3,5,7,9} is (5+7)2=6.

Given that integers are read from a data stream, find the median of elements read so far in an efficient way.

Input Format

The first line of input will contain integer N, i.e. the number of integers in the data stream.
Each of the next N lines will contain an integer ai.
Constraints 
1≤N≤105 
0≤ai≤105
Output Format

Print N integers, i.e. the median after each of the input. Report it with precision up to 10−1.

Sample Input

10
1
2
3
4
5
6
7
8
9
10
Sample Output

1.0
1.5
2.0
2.5
3.0
3.5
4.0
4.5
5.0
5.5
Explanation

See the sorted list after each input.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
PriorityQueue<Integer> upperQueue;
PriorityQueue<Integer> lowerQueue;

    public Solution(int capacity)
    {
        lowerQueue=new PriorityQueue<Integer>(capacity,new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return -o1.compareTo(o2);
            }
        });
        upperQueue=new PriorityQueue<Integer>();
        upperQueue.add(Integer.MAX_VALUE);
        lowerQueue.add(Integer.MIN_VALUE);
    }

    public double getMedian(int num)
    {
        //adding the number to proper heap
            if(num>=upperQueue.peek())
                upperQueue.add(num);
            else
                lowerQueue.add(num);
        //balancing the heaps
        if(upperQueue.size()-lowerQueue.size()==2)
            lowerQueue.add(upperQueue.poll());
        else if(lowerQueue.size()-upperQueue.size()==2)
            upperQueue.add(lowerQueue.poll());
        //returning the median
        if(upperQueue.size()==lowerQueue.size())
            return(upperQueue.peek()+lowerQueue.peek())/2.0;
        else if(upperQueue.size()>lowerQueue.size())
            return upperQueue.peek();
        else
            return lowerQueue.peek();
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int count=in.nextInt();
        Solution s=new Solution(count);
        for(int i=0;i<count;i++)
        {
            int num=in.nextInt();
            System.out.println(s.getMedian(num));
        }
    }  
}