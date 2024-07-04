
import java.util.Scanner;

/**
 * 이 클래스는 1x1, 2x1 및 3x1 타일을 사용하여 주어진 크기의 보드를 타일하는 방법의 수를 계산합니다.
 */
public class BoardTiling {

    /**
     * main 메서드는 사용자로부터 보드 크기를 읽고, 보드를 타일하는 방법의 수를 계산하여 결과를 출력합니다.
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boardSize = scanner.nextInt();

        int[] dp = new int[boardSize + 1];
        dp[0] = 1; // nothing to do
        dp[1] = 1; // only one tile
        dp[2] = 2; // two tiles
        dp[3] = 4; // three tiles

        for (int i = 4; i <= boardSize; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        System.out.println(dp[boardSize]);
        scanner.close();
    }
}
