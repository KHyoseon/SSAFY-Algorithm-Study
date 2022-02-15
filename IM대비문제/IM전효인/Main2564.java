/**
 * 백준 2564. 경비원
 * 
 * 220212
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2564 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로 세로 길이
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// 상점 개수
		int N = Integer.parseInt(br.readLine());
		// 상점 위치 배열(0:방향, 1:거리)
		int[][] shop = new int[N][2];
		//경비원 위치
		int[] x=new int[2];
		//상점, 경비원 위치 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			shop[i][0] = Integer.parseInt(st.nextToken());
			shop[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		x[0] = Integer.parseInt(st.nextToken());
		x[1] = Integer.parseInt(st.nextToken());
		
		//최단 거리 합
		int sum=0;
		//경비원과 상점과의 최단 거리 찾기
		for(int i=0;i<N;i++) {
			sum+=calcMinLen(shop[i],x,R,C);
		}
		//결과 출력
		System.out.println(sum);
	}
	
	public static int calcMinLen(int[] shop,int[] x,int R,int C) {
		//같은 방향에 있으면 거리 차이: (1,1), (2,2), (3,3), (4,4)
		if(shop[0]==x[0]) {
			return Math.abs(shop[1]-x[1]);
		}
		
		//방향의 합을 지표로 사용
		int idx=shop[0]+x[0];
		//상점, 경비원 거리 합
		int len=shop[1]+x[1];
		
		switch(idx) {
		case 3:	//(1,2)
			return Math.min(R+len,R+2*C-len);
		case 7:	//(3,4)
			return Math.min(C+len,C+2*R-len);
		case 4:	//(1,3)
			return len;
		case 6:	//(2,4)
			return R+C-len;
		}
		
		//방향 합이 5인 경우: (2,3), (1,4)
		//l1:방향번호 작은 쪽 거리, l2:방향번호 큰 쪽 거리
		int l1=(shop[0]<x[0])?shop[1]:x[1];
		int l2=(shop[0]>x[0])?shop[1]:x[1];

		if(Math.abs(shop[0]-x[0])==1) {
			return R-l2+l1;	//(2,3)
		}else {
			return C-l1+l2;	//(1,4)
		}
	}
}
