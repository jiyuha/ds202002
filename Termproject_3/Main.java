import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
	   
       Random r = new Random();
       Scanner sc = new Scanner(System.in);
          
       System.out.print("N 값 입력하슈 >>> ");
       int N = sc.nextInt();
          
       int[] arr = new int[N];
          
       System.out.print("K 값 입력하슈 >>> ");
       int K = sc.nextInt();
          
        long t = System.currentTimeMillis();
       
       System.out.println("-----------------------------");
       System.out.println("<<< N개의 데이터 >>>");
       
       for(int i=0; i<arr.length; i++) {
          arr[i] = r.nextInt(100)+1;
          System.out.println(arr[i]);
       }
       
      long temp_sum[]=new long[N];
      
       for(int i=0;i<N;i++) {
          if(i==0) temp_sum[i]=arr[i];
          else temp_sum[i]=temp_sum[i-1]+arr[i];
       }
       
       //for(int i=0;i<temp_sum.length;i++)System.out.print(temp_sum[i]+" ");
       //System.out.println();
       
       System.out.println("-----------------------------");
       System.out.println("<<< K개의 구간 >>>");
          
       int[] a = new int[K];
       int[] b = new int[K];
         
          for(int i=0;i<K;i++) {
             a[i]=r.nextInt(N)+1;
             while(true) {
                b[i]=r.nextInt(N)+1;
                if(a[i]!=b[i]) break;
             }
             if(a[i]<b[i]) {
                int tmp=a[i];
                a[i]=b[i];
                b[i]=tmp;
             }
          }
          for(int i=0;i<K;i++) System.out.println(b[i]+"부터 "+a[i]);
          System.out.println("-----------------------------");
          
          int max[]=new int[K];
          int min[]=new int[K];
          long sum[]=new long[K];
          
          for(int i=0;i<K;i++) {
             max[i]=arr[b[i]-1];
             min[i]=arr[b[i]-1];
             for(int j=b[i];j<a[i];j++) {
                if(max[i]<arr[j]) max[i]=arr[j];
                if(min[i]>arr[j]) min[i]=arr[j];
             }
             
             if(b[i]==1) sum[i]=temp_sum[a[i]-1];
             else sum[i]=temp_sum[a[i]-1]-temp_sum[b[i]-2];
             
          }
          
          long f = System.currentTimeMillis();
          
          for(int i=0;i<K;i++) {
             System.out.println("<<< "+(i+1)+"구간 >>>");
             System.out.println("최소값 : "+min[i]+" 최대값 : "+max[i]+" 합계 : "+(sum[i]));
          }
          System.out.println();
          System.out.println("Elapsed time : "+(f-t)+"ms");

   }
  
}