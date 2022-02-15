import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22_BJ_3985_롤_케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[len+1];
		int[][] pos = new int[N][2];
		int[] maxPos = {0,0};
		int[] truePos = {0,0};
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
			
			if(maxPos[0] < pos[i][1]-pos[i][0]) {				//입력받았을때 가장 큰 구간(기댓값이 제일 큰) 구간을 파악
				maxPos[0] = pos[i][1]-pos[i][0];
				maxPos[1] = i;
			}
			
		}
		for(int i=0;i<N;i++) {									//앞사람부터 케이크를 나눠줌.
			for(int j=pos[i][0];j<=pos[i][1];j++) {
				if(cake[j] != 0) {}						
				else {
					cake[j] = i+1;								//케이크를 나눠준 부분을 표시해서 중복으로 받아지지 않게 한다.
				}
			}
		}
		for(int i=0;i<N;i++) {									//실제로 케이크를 가장 많이 받은 사람을 구하는 과정.
			int cnt = 0;
			for(int j=pos[i][0];j<pos[i][1];j++) {
				if(cake[j] == i+1)
					cnt++;
			}
			if(cnt>truePos[0]) {
				truePos[0] = cnt;
				truePos[1] = i;
			}
		}
		System.out.println(maxPos[1]+1);
		System.out.println(truePos[1]+1);
	}
}
