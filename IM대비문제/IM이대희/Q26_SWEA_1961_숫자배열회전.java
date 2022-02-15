import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q26_SWEA_1961_숫자배열회전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append("\n");
			int size = Integer.parseInt(br.readLine());
			String[][] arr = new String[size][size];
			String[][][]result = new String[3][size][size];
			for(int i=0;i<size;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++) {
					arr[i][j] = st.nextToken();
				}
			}
			for(int i=0;i<size;i++) {							//각각의 배열을 회전시킨다.
				for(int j=0;j<size;j++) {
					result[2][i][j] = arr[j][size-i-1];
					result[1][i][j] = arr[size-i-1][size-j-1];
					result[0][i][j] = arr[size-j-1][i];
				}
			}
			for(int i=0;i<size;i++) {
				String[] resultStr = {"","",""};
				for(int j=0;j<size;j++) {					//resultStr에 각각의 정보를 입력받은 후에, 한줄씩 추가해준다.
					resultStr[0]+=result[0][i][j];
					resultStr[1]+=result[1][i][j];
					resultStr[2]+=result[2][i][j];
				}
				sb.append(resultStr[0]+" "+resultStr[1]+" "+resultStr[2]).append("\n");
			}
			
		}
		System.out.print(sb.toString());
	}
}
