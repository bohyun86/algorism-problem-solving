위상 정렬(Topological Sorting)은 방향성 비순환 그래프(DAG, Directed Acyclic Graph)의 노드들을 선형적으로 정렬하는 방법입니다. 위상 정렬은 그래프의 모든 간선 (u, v) 에 대해 정렬된 순서에서 u가 v보다 앞에 오도록 합니다. 이는 주로 작업 스케줄링, 컴파일러에서의 종속성 해결 등에 사용됩니다.

### 위상 정렬의 특성
- 방향성 비순환 그래프(DAG)에서만 수행할 수 있습니다.
- DAG는 사이클이 없기 때문에 위상 정렬이 가능합니다.
- 여러 개의 위상 정렬 결과가 존재할 수 있습니다.

### 위상 정렬 알고리즘
위상 정렬에는 크게 두 가지 알고리즘이 있습니다: **Kahn's Algorithm**과 **DFS 기반의 알고리즘**.

#### 1. Kahn's Algorithm
이 알고리즘은 진입 차수(indegree)를 사용하여 위상 정렬을 수행합니다.

**알고리즘 단계**:
1. 모든 노드의 진입 차수를 계산합니다.
2. 진입 차수가 0인 노드를 큐에 넣습니다.
3. 큐에서 노드를 하나씩 꺼내어 결과 리스트에 추가하고, 해당 노드에서 출발하는 간선을 그래프에서 제거하면서 연결된 노드들의 진입 차수를 감소시킵니다.
4. 진입 차수가 0이 된 노드를 큐에 추가합니다.
5. 큐가 빌 때까지 반복합니다.

**코드 예시**:

```java
import java.util.*;

public class TopologicalSortKahn {
    public static void main(String[] args) {
        int V = 6; // 노드의 수
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 추가
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        
        topologicalSort(graph, V);
    }

    public static void topologicalSort(List<List<Integer>> graph, int V) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : graph.get(i)) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 출력
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
```

#### 2. DFS 기반의 알고리즘
DFS를 사용하여 위상 정렬을 수행합니다.

**알고리즘 단계**:
1. 각 노드를 방문하면서 DFS를 수행합니다.
2. 노드의 모든 인접 노드를 재귀적으로 방문한 후, 현재 노드를 스택에 추가합니다.
3. DFS가 완료된 후, 스택에서 노드를 하나씩 꺼내어 정렬된 순서를 얻습니다.

**코드 예시**:

```java
import java.util.*;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        int V = 6; // 노드의 수
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 추가
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        
        topologicalSort(graph, V);
    }

    public static void topologicalSort(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, graph);
            }
        }

        // 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[v] = true;

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                topologicalSortUtil(next, visited, stack, graph);
            }
        }

        stack.push(v);
    }
}
```

### 요약
위상 정렬은 방향성 비순환 그래프(DAG)의 노드들을 선형적으로 정렬하는 방법입니다. Kahn's Algorithm과 DFS 기반의 알고리즘을 사용하여 위상 정렬을 수행할 수 있습니다. 위상 정렬은 작업 스케줄링, 종속성 해결 등 여러 문제에서 유용하게 사용됩니다.