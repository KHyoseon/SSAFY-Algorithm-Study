/**
 * 백준 2116. 주사위 쌓기
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2116 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//주사위 개수
		int N=Integer.parseInt(br.readLine());
		//주사위 정보 입력받기
		//각 주사위의 자기(인덱스) 반대쪽 숫자 저장하는 2차원 배열
		//주사위: 0~N-1번, 눈 숫자: 1~6
		int[][] dices=new int[N][7];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			//입력받은 숫자 순서대로 임시 저장
			int[] temp=new int[6];
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				temp[j]=Integer.parseInt(st.nextToken());
			}
			//인덱스의 반대쪽 눈 저장
			dices[i][temp[0]]=temp[5];
			dices[i][temp[1]]=temp[3];
			dices[i][temp[2]]=temp[4];
			dices[i][temp[3]]=temp[1];
			dices[i][temp[4]]=temp[2];
			dices[i][temp[5]]=temp[0];
		}
		
		
		//총 N개 주사위 옆면 합
		int sum=0;
		//총 N개 주사위 옆면 합의 최대
		int max=0;
		//0번째 주사위 여섯면에 대해서 다 시도
		for(int i=1;i<=6;i++) {
			//0번째 주사위 아랫면 지정
			int bottom=i;
			int top=dices[0][bottom];
			//0번째 주사위 4면 중 최대값 찾아서 더해두기
			sum=findSideMax(top, bottom);
			
			//현재 주사위의 윗면을 다음 주사위 아랫면으로해서 남은 주사위에도 반복
			for(int n=1;n<N;n++) {
				bottom=top;
				top=dices[n][bottom];
				
				sum+=findSideMax(top, bottom);
			}
			
			//이번 경우가 옆면 합 커진 경우, 최대값 갱신
			if(sum>max) {
				max=sum;
			}
		}
		
		//결과 출력
		System.out.println(max);
	}
	
	public static int findSideMax(int top, int bottom) {
		int sideMax=0;
		for(int i=1;i<=6;i++) {
			//윗면, 아랫면은 건너뛰기
			if(i==top || i==bottom)
				continue;
			if(i>sideMax) 
				sideMax=i;
		}
		return sideMax;
	}
}
