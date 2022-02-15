package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo2_구미_5반_김효선 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		/*
		 * N: 신청 들어온 동아리의 수
		 * S: 팀원 3명의 능력치 합의 제한
		 * M: 개인 능력치의 제한
		 */
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 정상적으로 등록할 수 있는 동아리의 총 개수
		int total=0;
		// 등록된 동아리 회원의 각 능력치
		ArrayList<Integer> std = new ArrayList<>();
		
		for(int t=0; t<N; t++) {
			int team[] = new int[3];
			
			st = new StringTokenizer(br.readLine());
			team[0] = Integer.parseInt(st.nextToken());
			team[1] = Integer.parseInt(st.nextToken());
			team[2] = Integer.parseInt(st.nextToken());
			
			// 만약 팀원 셋의 능력 합이 S를 넘지 못하면 등록 실패
			if(team[0]+team[1]+team[2] < S)			continue;
			// 만약 각 팀원의 능력이 M를 넘지 못하면 등록 실패
			if(team[0]<M || team[1]<M || team[2]<M)	continue;
			
			// 위 두 조건을 만족시킨 경우 동아리 등록
			++total;
			std.add(team[0]);
			std.add(team[1]);
			std.add(team[2]);
		}
		
		sb.append(total+"\n");
		for(int s: std)
			sb.append(s+" ");
		
		bw.write(sb.toString());
		bw.flush();

	}

}
