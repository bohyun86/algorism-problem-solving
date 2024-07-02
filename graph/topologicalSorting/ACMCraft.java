package graph.topologicalSorting;

import java.io.*;
import java.util.*;

public class ACMCraft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스
        while (T-- > 0) {
            // 입력
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            
            // 건물 짓는 시간, 진입 차수, 그래프 초기화
            int[] buildTime = new int[N];
            int[] indegree = new int[N];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N);
            
            // 건물 짓는 시간 입력
            input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                buildTime[i] = Integer.parseInt(input[i]);
                graph.add(new ArrayList<>());
            }
            
            // 간선 정보 입력
            for (int i = 0; i < K; i++) {
                input = br.readLine().split(" ");
                int X = Integer.parseInt(input[0]) - 1;
                int Y = Integer.parseInt(input[1]) - 1;
                graph.get(X).add(Y);
                indegree[Y]++;
            }
            
            // 목표 건물
            int W = Integer.parseInt(br.readLine()) - 1;
            
            // 위상 정렬 및 DP
            int[] resultTime = new int[N];
            Queue<Integer> queue = new LinkedList<>();
            
            // 초기 진입 차수가 0인 정점을 큐에 삽입
            for (int i = 0; i < N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    resultTime[i] = buildTime[i];
                }
            }
            
            // 위상 정렬
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : graph.get(current)) {
                    indegree[next]--;
                    resultTime[next] = Math.max(resultTime[next], resultTime[current] + buildTime[next]);
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            
            // 출력
            sb.append(resultTime[W]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
