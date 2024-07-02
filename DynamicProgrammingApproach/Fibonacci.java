package dynamicProgrammingApproach;
import java.util.Scanner;

/**
 * Fibonacci
 * 재귀적인 방법으로 피보나치 수열을 구했을 경우, 0과 1이 몇 번 호출되는지 구하는 문제
 * 재귀적인 방식으로 접근하면 비효율적이며 시간복잡도가 O(2^n)이기 때문에 동적 프로그래밍을 사용하여 풀어야 한다.
 * 동적 프로그래밍을 사용하면 시간복잡도가 O(n)이 된다.
 * 0과 1일 호출되는 횟수는 각각 피보나치 수열의 n-1번째와 n번째 수이다.
 */

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
