package com.ssafy.w0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {

	// 시작 정점(K)에서 to까지의 거리(가중치, weight)를 저장하기 위한 클래스
	static class Dist implements Comparable<Dist>{
		int to;
		int weight;
		
		public Dist() {
			
		}
		public Dist(int to, int cost) {
			this.to = to;
			this.weight = cost;
		}
		// 거리가 가까운 순으로 나와야 하므로 오름차순으로 정렬
		@Override
		public int compareTo(Dist o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		// V: 정점의 수, E: 간성의 수, K: 시작 정점, 
		// from: 간선 정보의 출발지, to: 간선 정보의 도착지, weight: 간선의 가중치
		int V = 0, E = 0, K = 0, from = 0, to = 0, weight = 0;
		
		// 우선순위 큐(priority queue, 이하 pq)에서 front를 받을 때 사용할 임시 변수
		Dist front;
		
		// 시작 정점 K에서 각 정점으로 가는 최소 거리
		int[] dijk;
		
		// u에서 v로의 가중치 w를 저장하는 리스트
		// List의 index가 u를, Map의 key가 v를, Map의 value가 w를 의미
		// 
		// Map을 사용한 이유는 두 정점 사이에 간선이 여러 개일 수 있다는 조건에서 그 중 가장 거리가 짧은 간선만 있으면 되는데
		// 두 정점 사이에 존재하는 간선들 중 거리가 짧은 간선의 정보만 저장하는 데 Map이 도움이 될 것이라고 생각했기 때문
		// 
		// 그림으로 표현하면 다음과 같음
		// 
		//  List
		// 
		// |  .  |
		// |  .  |                          Map
		// |_____|        ________________________________________
		// |     |       |                                        |
		// |   --|-----> |{key1, value1}  {key2, value2}  ...     |
		// |_____|       |________________________________________|
		// |  .  |
		// |  .  |
		// |  .  |
		// 
		//
		List<Map<Integer, Integer>> weights;
		
		// 거리가 가장 가까운 정점을 찾기 편하도록 pq를 사용
		// -> 거리 정보가 갱신 될 때마다 pq에 삽입을 한다면
		//    갱신된 거리 정보들 중에서 가장 가까운 정점을 바로 얻을 수 있음
		PriorityQueue<Dist> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dijk = new int[V];
		
		// 가장 가까운 거리를 구하기 편하도록 충분히 큰 수로 초기화
		Arrays.fill(dijk, Integer.MAX_VALUE);
		
		weights = new ArrayList<Map<Integer,Integer>>();
		for(int i = 0; i < V; i++)
			weights.add(new HashMap<Integer, Integer>());
		
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			// Map에 해당 key값이 이미 존재할 경우 value값을 비교해서 새로 들어온 값이 작으면 갱신
			// 즉, from에서 to로 가는 간선이 여러 개일 경우 가중치가 작은 것을 저장
			if(weights.get(from - 1).containsKey(to - 1) == true) {
				if(weights.get(from - 1).get(to - 1) > weight)
					weights.get(from - 1).replace(to - 1, weight);
			
			// 해당 key값이 이전에 없었다면 입력 받은 그대로 저장
			// 즉, 이전에 from에서 to로 가는 간선이 없었다면 그대로 저장
			}else {
				weights.get(from - 1).put(to - 1, weight);
			}
		}
		
		// 시작 정점에서 시작 정점으로 가는 거리는 0
		dijk[K - 1] = 0;
		// pq에 시작 정점을 넣고 반복 시작
		pq.offer(new Dist(K - 1, 0));
		
		// pq가 비어있지 않을 경우 반복
		// 즉, 갱신된 거리 정보가 존재한다면 반복
		while(!pq.isEmpty()) {
			front = pq.poll();
			
			// pq에 들어있던 거리 정보 보다 더 짧은 거리 정보가 이미 존재한다면 다음으로 넘어감
			if(dijk[front.to] < front.weight)
				continue;

			// 이후 설명에서 pq에서 방금 꺼낸 정점을 현재 정점, 
			// 현재 정점과 인접한 정점 중 반복을 돌 때 현재 다루고 있는 정점을 다음 정점이라 함
			// 그림으로 표현하면 다음과 같음
			// 
			//               _____
			//              |     |
			//              | 다음  |
			//              |_____|
			//             /     |
			//            /      |
			//           /       |
			//          9        3
			//         /         |
			//        /          |
			//  _____/          _|___             _____
			// |     |         |     |           |     |
			// | 시작  |--- 2 ---| 현재  |---- 5 ----|     |
			// |_____|         |_____|           |_____|
			// 
			// 
			
			// 현재 정점과 인접한 정점들에 대해 탐색
			for(Integer key: weights.get(front.to).keySet()) {
				// [시작 정점(K)에서 현재 정점까지 오는 거리]와 [현재 정점에서 다음 정점으로 가는 거리]의 합이
				// [시작 정점에서 다음 정점으로 가는 거리]보다 짧으면 [시작 정점에서 다음 정점으로 가는 거리]를 갱신
				if(dijk[front.to] + weights.get(front.to).get(key) < dijk[key]) {
					dijk[key] = dijk[front.to] + weights.get(front.to).get(key);

					//갱신됐을 경우 해당 정점과 거리 정보를 pq에 삽입
					pq.offer(new Dist(key, dijk[key]));
				}
			}
		}
		
		// 반복이 끝나고 최종적으로 만들어진 거리 정보를 읽으면서 결과 출력
		for(int i = 0; i < dijk.length; i++) {
			// Integet.MAX_VALUE일 경우 거리 정보가 갱신되지 않았다는 것
			// 즉, 시작 정점 K에서 해당 정점으로 가지 못한다는 것을 의미하므로 INF를 출력
			if(dijk[i] == Integer.MAX_VALUE)
				sb.append("INF");
			// 그 외의 경우는 저장된 거리 정보를 출력
			else
				sb.append(dijk[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
