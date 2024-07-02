package geometry;

import java.util.Arrays;
import java.util.Scanner;

// 두 점과 한 점에서의 거리가 주어졌을 때, 두 원이 만나는 점의 개수를 구하는 문제
// 두 원이 만나는 점의 개수는 다음과 같다.
// 1. 두 원이 만나지 않는 경우: 두 원 사이의 거리가 두 원의 반지름의 합보다 크거나 두 원의 반지름의 차보다 작을 때
// 2. 두 원이 한 점에서 만나는 경우: 두 원 사이의 거리가 두 원의 반지름의 합과 같거나 두 원의 반지름의 차와 같을 때
// 3. 두 원이 두 점에서 만나는 경우: 두 원 사이의 거리가 두 원의 반지름의 합보다 작고 두 원의 반지름의 차보다 클 때


class FindingPossiblePositions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNum = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < tryNum; i++) {
            int[] coordinatesAndDistance = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = coordinatesAndDistance[0];
            int y1 = coordinatesAndDistance[1];
            int r1 = coordinatesAndDistance[2];
            int x2 = coordinatesAndDistance[3];
            int y2 = coordinatesAndDistance[4];
            int r2 = coordinatesAndDistance[5];

            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (distance == 0 && r1 == r2) {
                System.out.println("-1");
            } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                System.out.println("1");
            } else if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) {
                System.out.println("0");
            } // else if (distance < r1 + r2 && distance > Math.abs(r1 - r2) 
            else {
                System.out.println("2");
            }
        }
        sc.close();
    }
}
