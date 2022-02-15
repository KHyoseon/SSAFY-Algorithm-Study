/**
 * 백준 14696. 딱지놀이
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14696 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//라운드 수
		int N=Integer.parseInt(br.readLine());
		//출력할 결과
		StringBuilder sb=new StringBuilder();
		
		//낸 딱지 정보 입력받으면서 라운드 별 승자 찾기
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			//A, B의 종류별 딱지 개수(행:AB, 열:종류별 딱지 개수)
			int[][] data=new int[2][5];
			//A, B 딱지 입력받기
			for(int j=0;j<2;j++) {
				st=new StringTokenizer(br.readLine());
				//낸 딱지 개수
				int n=Integer.parseInt(st.nextToken());
				for(int k=0;k<n;k++) {
					int type=Integer.parseInt(st.nextToken());
					data[j][type]++;
				}
			}
			
			//우선순위 큰 딱지부터 보면서 승부 결정하기
			for(int j=4;j>=1;j--) {
				if(data[0][j]>data[1][j]) {
					sb.append("A\n");
					break;
				}else if(data[0][j]<data[1][j]) {
					sb.append("B\n");
					break;
				}
			}
			//승부 결정 안난 경우 무승부 처리
			if(sb.length()!=2*(i+1)) {
				sb.append("D\n");
			}
		}
		//출력
		System.out.println(sb.toString());
	}
}
