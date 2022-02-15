/**
 * SWEA 4047. 영준이의 카드 카운팅
 * 
 * 220212
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		// 결과 저장할 문자열
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			// 입력받은 카드 정보
			String[] data = br.readLine().split("");
			// 카드 덱: 네 무늬(S:0, D:1, H:2, C:3) / 1~13번 
			int[][] card=new int[4][14];

			//입력받은 카드 있는지 확인
			for (int i = 0; i < data.length; i += 3) {
				switch (data[i]) {
				case "S":
					card[0][toNum(data[i+1],data[i+2])]++;
					break;
				case "D":
					card[1][toNum(data[i+1],data[i+2])]++;
					break;
				case "H":
					card[2][toNum(data[i+1],data[i+2])]++;
					break;
				case "C":
					card[3][toNum(data[i+1],data[i+2])]++;
					break;
				}
			}
			
			//겹치는 카드 있는지 확인
			//있으면 다음 테케로 건너뛰기
			if(checkDuplicate(card)) {
				sb.append("ERROR\n");
				continue;
			}
			
			//무늬 별 부족한 카드 수 계산해서 결과 문자열에 저장
			for(int i=0;i<4;i++) {
				sb.append(13-Arrays.stream(card[i]).sum()).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		//결과 출력
		System.out.println(sb.toString());
	}
	
	//String 숫자를 Integer로 변환
	//예) ("1", "2") -> return 12
	public static int toNum(String ten,String one) {
		return Integer.parseInt(ten)*10+Integer.parseInt(one);
	}
	
	//겹치는 카드 있으면 true 반환
	public static boolean checkDuplicate(int[][] card) {
		for(int i=0;i<4;i++) {
			for(int j=1;j<=13;j++) {
				if(card[i][j]>1) {
					return true;
				}
			}
		}
		
		return false;
	}
}
