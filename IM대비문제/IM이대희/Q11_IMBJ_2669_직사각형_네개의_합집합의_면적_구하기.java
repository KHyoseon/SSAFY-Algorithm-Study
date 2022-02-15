

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11_IMBJ_2669_직사각형_네개의_합집합의_면적_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[101][101];
		int result = 0;
		
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] position = new int[4];
			for(int j=0;j<4;j++)
				position[j] = Integer.parseInt(st.nextToken());
			for(int j=position[0];j<position[2];j++) {
				for(int k=position[1];k<position[3];k++) {
					if(arr[j][k] == false) {
						result++;
						arr[j][k] = true;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
