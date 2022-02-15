import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q35_SWEA_1979_어디에_단어가_들어갈_수_있을까 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			int result = 0;
			String [][] arr = new String[size][size];
			for(int i=0; i<size;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++) {
					arr[i][j] = st.nextToken();
				}
			}
			for(int i=0; i<size;i++) {					//각 문장별 가로에서 1이 연속된 구간을 찾는다.
				int cnt = 0;
				for(int j=0;j<size;j++) {
					if(arr[i][j].equals("1"))			//1이 들어온 경우 카운트 값을 늘려주다가
						cnt++;
					else {
						if(cnt != 0) {					//연속된 구간이 끝났을 때 1이 연속된 구간의 길이를 비교한다
							if(cnt == len) {			//정확하게 단어길이와 일치하는 경우 결과값 추가
								result++;
								cnt = 0;
							}
							else						
								cnt = 0;
						}
					}
				}
				if(cnt == len)							//탐색이 다 끝난 경우에도 따로 확인해서 추가해주어야 한다.
					result++;
			}
			for(int i=0; i<size;i++) {					//각 문장별 세로에서 1이 연속된 구간을 찾는다.
				int cnt = 0;
				for(int j=0;j<size;j++) {
					if(arr[j][i].equals("1"))
						cnt++;
					else {
						if(cnt != 0) {
							if(cnt == len) {
								result++;
								cnt = 0;
							}
							else
								cnt = 0;
						}
					}
				}
				if(cnt == len)
					result++;
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
}
