package BOJ.웹엑스수업;

import java.util.*;

public class BOJ_1260 {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static ArrayList<Integer> resultDFS = new ArrayList<>();
    static ArrayList<Integer> resultBFS = new ArrayList<>();
    static int N;

    private static void dfs(int idx, ArrayList<Integer> result, boolean[] visited) {
        visited[idx] = true;
        result.add(idx + 1);
        for (int a : map.get(idx)) {
            if (!visited[a]) {
                dfs(a, result, visited);
            }
        }
    }

    private static void bfs(int idx) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N];

        visited[idx] = true;
        que.offer(idx);

        while(!que.isEmpty()){
            int v = que.poll();
            resultBFS.add(v+1);         // 다시 정점을 1부터 시작할 수 있도록 +1
            for(int a: map.get(v)){
                if(!visited[a]){
                    que.offer(a);
                    visited[a] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt() - 1;               // 인덱스와 맞추기 위해 -1

        for(int i=0; i<N; i++){
            map.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt() - 1;           // 인덱스와 맞추기 위해 -1
            int b = sc.nextInt() - 1;           // 인덱스와 맞추기 위해 -1
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int i=0; i<map.size(); i++){             // 정렬하기 -> 정점 번호가 작은 것부터 먼저 방문하도록 하기 위해
            Collections.sort(map.get(i));
        }

        dfs(v, resultDFS, new boolean[N]);
        for(int r: resultDFS){
            System.out.print(r+" ");
        }
        System.out.println();
        bfs(v);

        for(int r: resultBFS){
            System.out.print(r+" ");
        }
    }
}
