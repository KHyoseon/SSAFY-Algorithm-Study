import java.util.Scanner;

public class Algo1_구미_5반_김지혜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// Scanner 객체 생성
		int t = sc.nextInt();	// 테스트 케이스
		
		for(int tc=1; tc<=t; tc++) {	// 테스트 케이스만큼 반복
			int n = sc.nextInt();	// 종이컵의 수
			int x = sc.nextInt();	// 간식이 있는 종이컵의 위치
			int k = sc.nextInt(); 	// 종이컵 위치를 바꾸는 횟수
			int[] map = new int[n];		// 종이컵 배열
			map[x-1] = 1;				// 배열에 간식 담기
			int tmp = 0;				// 종이컵을 바꿀 때 사용할 임시공간
			
			for(int i=0; i<k; i++) {	// input값을 k번 받음
				int a = sc.nextInt();	// a, b 위치의 종이컵을 바꿈
				int b = sc.nextInt();	// a, b 위치의 종이컵을 바꿈
				tmp = map[a-1];			// a위치의 종이컵을 임시공간에 저장
				map[a-1] = map[b-1];	// b위치의 종이컵을 a위치로 이동
				map[b-1] = tmp; 		// 임시공간의 종이컵을 b로 이동
			}
			for(int i=0; i<n; i++) {	// 종이컵 배열을 돌며
				if(map[i] == 1) {		// 간식이 들어간 컵을 찾는다
					System.out.println("#"+tc+" "+ (i+1));	// 찾으면 정답을 출력
					break;				// 찾으면 더이상 반복을 하지 않고 탈출
				}
			}
		}
	}

}
