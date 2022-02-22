package 과제;

import java.util.*;

public class Solution_1238_UseHashMap {
    private static void bfs(HashMap<Integer, Set<Integer>> map, int start){

        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[101];
        que.offer(new int[]{start,1});
        int result = 0;
        int tmpCnt = 0;

        while(!que.isEmpty()){
            int[] v = que.poll();
            int from = v[0];
            int cnt = v[1];
            if(tmpCnt < cnt){               // 다음번째 전화를 받을 사람이 있다면
                tmpCnt = cnt;               // 전화받는 순서를 다음번째로
                result = 0;                 // 전화받는 사람의 번호는 0으로 초기화
            }
            if(result < from){              // 같은 번째에 전화받는 사람중 번호가 큰 사람을 result에 저장
                result = from;
            }
            visited[from] = true;
            if(map.get(from) != null) {
                for (int s : map.get(from)) {
                    if (!visited[s]) {
                        que.offer(new int[]{s,cnt+1});
                        visited[s] = true;
                        result = s;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 10;

        for(int tc=1; tc<=t; tc++){
            System.out.print("#"+tc+" ");
            int dataLen = sc.nextInt();     // 데이터 길이
            int start = sc.nextInt();       // 시작점
            HashMap<Integer, Set<Integer>> map = new HashMap<>();

            for(int i=0; i<dataLen/2; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                if(map.get(from) == null){
                    Set<Integer> tmp = new HashSet<>();             // 중복 제거를 위한 set 자료구조
                    tmp.add(to);
                    map.put(from, tmp);                             // key :  from     value : to 노드들
                }
                else{
                    map.get(from).add(to);
                }
            }
            bfs(map, start);
        }
    }
}
