import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("N�� �Է��Ͻÿ�.");
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i =0; i < arr.length; i++) {
			arr[i] = r.nextInt(100)+1;
			System.out.println(arr[i]);
		}
		System.out.println("������ a, b�� �Է��Ͻÿ�.");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] arr1 = Arrays.copyOfRange(arr,a-1,b);
		
		Arrays.parallelSort(arr1);
		for(int i =0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		} System.out.println();
		
		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
		}
		System.out.println("�ּҰ� : "+arr1[0]+"\r�ִ밪 : "+arr1[b-a]+"\r�հ� : "+sum);

	}

}