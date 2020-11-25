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
	   
	   System.out.println("-----------------------------");
	   System.out.println("<<< K개의 구간 >>>");
	   
	   int[] a = new int[K];
	   int[] b = new int[K];
	   
	   for(int i=0; i<K; i++) {
		   a[i] = r.nextInt(N)+1;
		   while(true) {
			   b[i] = r.nextInt(N)+1;
			   if(a[i] != b[i]) break;
		   }
	   }
	   
	   for(int i=0; i<K; i++) {
		   if(a[i] > b[i]) {
			   System.out.println(b[i]+"부터 "+a[i]);
		   }
		   else {
			   System.out.println(a[i]+"부터 "+b[i]);
		   }
	   }
	   
	   System.out.println("-----------------------------");
	   
	   int[] array = new int[K];
	   
	   for(int i=0; i<K; i++) {
		   int sum = 0;
		   if(a[i] > b[i]) {
			   array = Arrays.copyOfRange(arr, b[i]-1, a[i]);
		   }
		   else {
			   array = Arrays.copyOfRange(arr, a[i]-1, b[i]);
		   }
		   
		   for(int j=0; j<array.length; j++) {
			   sum += array[j];
		   }
		   
		   Arrays.parallelSort(array);
		   
		   System.out.println("<<< "+(i+1)+"구간 >>>");
		   
		   if(a[i] > b[i]) {
			   System.out.println("최소값 : "+array[0]+" 최대값 : "+array[a[i]-b[i]]+" 합계 : "+sum);
		   }
		   else {
			   System.out.println("최소값 : "+array[0]+" 최대값 : "+array[b[i]-a[i]]+" 합계 : "+sum);
		   }
		   
		   System.out.println("-----------------------------");
	   }
	   
	   long f = System.currentTimeMillis();
	   System.out.println("<<< Elapsed time is "+(f-t)+"ms. >>>");
	   
   }

}