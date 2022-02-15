/**
 * 백준 2578. 빙고
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2578 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 빙고판 입력받기(각 숫자의 위치 저장)
		int[][] bingo = new int[26][2];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				bingo[num][0] = i;
				bingo[num][1] = j;
			}
		}

		// 각 행, 열, 대각선에 불린 개수
		//5 되면 한줄 완성
		int[] row=new int[5];
		int[] col=new int[5];
		int x1=0;
		int x2=0;
		// 부르는 번호 입력받으면서 빙고 체크
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				//불린 번호
				int num = Integer.parseInt(st.nextToken());
				//불린 번호 위치
				int r=bingo[num][0];
				int c=bingo[num][1];
				//해당 줄에 불린 개수 추가(5개 되면 한줄)
				row[r]++;
				col[c]++;
				if(r==c) x1++;
				if(r+c==4) x2++;
				
				// 3줄 가능한 최소 개수인 12개부터 빙고 확인
				if (i * 5 + j+1 >= 12) {
					int count=check(row)+check(col)+check(x1)+check(x2);
					//3줄 완성되면 숫자 총 몇개 불렀는지 출력 후 종료
					if(count>=3) {
						System.out.println(i * 5 + j+1);
						return;
					}
				}
			}
		}
	}

	public static int check(int[] arr) {
		int count=0;
		//완성된 줄(5개 된 줄) 몇개인지 세서 반환
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=5) {
				count++;
			}
		}
		return count;
	}
	
	public static int check(int line) {
		//줄 완성됐으면 1(완성된 줄 수) 반환
		if(line>=5) 
			return 1;
		else
			return 0;
	}
}
