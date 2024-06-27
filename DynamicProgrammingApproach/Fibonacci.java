package DynamicProgrammingApproach;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < tryNum; i++) {
            int num = Integer.parseInt(sc.nextLine());
            fibonacci(num);
        }
        sc.close();

    }

    public static void fibonacci(int num) {
        if (num == 0) {
            System.out.println("1 0");
            return;
        } else if (num == 1) {
            System.out.println("0 1");
            return;
        }
        int[] fib = new int[num + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println(fib[num - 1] + " " + fib[num]);
    }
}
