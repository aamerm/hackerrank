
public class SpiralDemo {
    public static void printSpiral(int[][] a,int m,int n){
        int t=0,b=m-1,l=0,r=n-1;
        int dir=0;
        while(t<=b&& l<=r){
            if(dir==0){
                for(int i=l;i<=r;i++)
                    System.out.println(a[t][i]);
                t++;
            }
            if(dir==1){
                for(int i=t;i<=b;i++)
                    System.out.println(a[i][r]);
                r--;
            }
            if(dir==2){
                for(int i=r;i>=l;i--)
                    System.out.println(a[b][i]);
                b--;
            }
            if(dir==3){
                for(int i=b;i>=t;i--)
                    System.out.println(a[i][l]);
                l++;
            }
            dir=(dir+1)%4;
        }        
    }
    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiral(a,a.length,a[0].length);        
    }
}