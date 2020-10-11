
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        List<Character> results = new ArrayList<>();

        int count = 1;
        boolean isAble = true;

        for (int i=0; i<n; i++) {
            int num = numbers[i];

            if (isAble) {
                while (count <= num) {
                    stack.add(count++);
                    results.add('+');
                }

                if (stack.empty()) {
                    isAble = false;
                } else {
                    while (!stack.empty() && stack.peek() >= num) {
                        stack.pop();
                        results.add('-');
                    }
                }
            }
        }
        if (isAble) {
            for (int i=0; i<results.size(); i++) {
                System.out.println(results.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
}