import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
	   
	   Random r = new Random();
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("N �� �Է��Ͻ� >>> ");
	   int N = sc.nextInt();
	   
	   int[] arr = new int[N];
	   
	   System.out.print("K �� �Է��Ͻ� >>> ");
	   int K = sc.nextInt();
	   
	   long t = System.currentTimeMillis();
	   
	   System.out.println("-----------------------------");
	   System.out.println("<<< N���� ������ >>>");
	   
	   for(int i=0; i<arr.length; i++) {
		   arr[i] = r.nextInt(100)+1;
		   System.out.println(arr[i]);
	   }
	   
	   System.out.println("-----------------------------");
	   System.out.println("<<< K���� ���� >>>");
	   
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
			   System.out.println(b[i]+"���� "+a[i]);
		   }
		   else {
			   System.out.println(a[i]+"���� "+b[i]);
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
		   
		   System.out.println("<<< "+(i+1)+"���� >>>");
		   
		   if(a[i] > b[i]) {
			   System.out.println("�ּҰ� : "+array[0]+" �ִ밪 : "+array[a[i]-b[i]]+" �հ� : "+sum);
		   }
		   else {
			   System.out.println("�ּҰ� : "+array[0]+" �ִ밪 : "+array[b[i]-a[i]]+" �հ� : "+sum);
		   }
		   
		   System.out.println("-----------------------------");
	   }
	   
	   long f = System.currentTimeMillis();
	   System.out.println("<<< Elapsed time is "+(f-t)+"ms. >>>");
	   
   }

}