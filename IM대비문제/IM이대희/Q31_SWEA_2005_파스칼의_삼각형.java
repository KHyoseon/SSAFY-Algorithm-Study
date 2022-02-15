import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31_SWEA_2005_파스칼의_삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append("\n");
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][10];
			for(int i=0;i<size;i++) {
				if(i == 0)						//첫번째랑 두번째는 임의로 생성
					arr[i][0] = 1;
				else if(i == 1) {
					arr[i][0] = 1;
					arr[i][1] = 1;
				}
				else {							//그렇지 않은 경우에 첫 자리, 마지막 자리는 1로 지정.
					arr[i][0] = 1;
					arr[i][i] = 1;
					for(int j=1;j<size-1;j++) {					//중간에 있는 값은 윗줄의 동일한 위치의 값과, 동일한 위치의 앞 값을 더한 값이 된다.
						arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
					}
				}
				for(int j=0;j<i+1;j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.print(sb.toString());
	}
}
