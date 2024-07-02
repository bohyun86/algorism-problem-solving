package graph;

import java.io.*;
import java.util.*;

public class ACMCraft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[] buildTime = new int[N];
            int[] indegree = new int[N];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N);
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;
                graph.get(X).add(Y);
                indegree[Y]++;
            }
            
            int W = Integer.parseInt(br.readLine()) - 1;
            
            // 위상 정렬 및 DP
            int[] resultTime = new int[N];
            Queue<Integer> queue = new LinkedList<>();
            
            for (int i = 0; i < N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    resultTime[i] = buildTime[i];
                }
            }
            
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
            
            sb.append(resultTime[W]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
