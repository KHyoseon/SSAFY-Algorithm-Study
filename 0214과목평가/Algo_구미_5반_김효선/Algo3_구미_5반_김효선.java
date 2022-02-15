package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo3_구미_5반_김효선 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 관리자 패스워드 최댓값
		int N = Integer.parseInt(br.readLine());
		// 해커가 사용한 패스워드 개수
		int M = Integer.parseInt(br.readLine());
		// 해커가 시도한 패스워드 집합
		int tries[]= new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int m=0; m<M; m++)
			tries[m] = Integer.parseInt(st.nextToken());
		
		// 운영자가 만들 수 있는 모든 경우의 패스워드의 보안성 집합
		int mins[] = new int[N+1];
		// 최댓값으로 초기화 시킴 (최솟값을 구해야 하므로 비교하기 쉽게 만들기 위함)
		Arrays.fill(mins, Integer.MAX_VALUE);
		
		// i: 운영자가 만든 패스워드, tries[j]: 해커가 사용한 패스워드
		for(int i=0; i<=N; i++) {
			for(int j=0; j<M; j++) {
				// i와 tries[j]의 이진수에서 각 자릿수가 서로 다르면 1, 같으면 0을 주었을 때 나오는 결과값(10진수)
				int tmp = i^tries[j];
				
				// tries에 대한 i의 보안 척도. (tmp을 이진수로 만들었을 때 나오는 1의 개수)
				tmp = (tmp & 0x55555555) + ((tmp >> 1) & 0x55555555);
				tmp = (tmp & 0x33333333) + ((tmp >> 2) & 0x33333333);
				tmp = (tmp & 0x0f0f0f0f) + ((tmp >> 4) & 0x0f0f0f0f);
				tmp = (tmp & 0x00ff00ff) + ((tmp >> 8) & 0x00ff00ff);
				tmp = (tmp & 0x0000ffff) + ((tmp >> 16) & 0x0000ffff);
				
				// 운영자가 선택한 패스워드(i)에서 나올 수 있는 가장 낮은 보안척도를 저장
				// == i의 보안성
				mins[i] = Math.min(mins[i], tmp);
			}
		}
		
		int MAX=0;
		// 모든 i에 대해서 가장 보안성이 높은 값을 고른다.
		for(int max: mins)
			MAX = Math.max(MAX, max);
			
		bw.write(MAX+"");
		bw.flush();

	}

}
