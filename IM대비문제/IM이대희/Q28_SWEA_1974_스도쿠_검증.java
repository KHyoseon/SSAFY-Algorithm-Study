import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq
public class Q28_SWEA_1974_스도쿠_검증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			boolean result = true;
			int[][] arr = new int[9][9];
			for(int i=0;i<9;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<9;i++) {		//가로열의 합이 45인경우 옳음.근데 사실은 카운트로 하는게 맞는듯?
				if(arr[i][0]+arr[i][1]+arr[i][2]+arr[i][3]+arr[i][4]+arr[i][5]+arr[i][6]+arr[i][7]+arr[i][8] != 45) {
					result = false;
					break;
				}						//세로열의 합
				if(arr[0][i]+arr[1][i]+arr[2][i]+arr[3][i]+arr[4][i]+arr[5][i]+arr[6][i]+arr[7][i]+arr[8][i] != 45) {
					result = false;
					break;
				}
			}							//3x3사이즈의 검증
			for(int i=0;i<3&&result;i++) {
				for(int j=0;j<3;j++) {
					if(arr[i*3][j*3]+arr[i*3][j*3+1]+arr[i*3][j*3+2]+arr[i*3+1][j*3]+arr[i*3+1][j*3+1]+arr[i*3+1][j*3+2]+arr[i*3+2][j*3]+arr[i*3+2][j*3+1]+arr[i*3+2][j*3+2] != 45) {
						result = false;
						break;
					}
				}
			}
			if(result)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
			
		System.out.print(sb.toString());
	}
}
