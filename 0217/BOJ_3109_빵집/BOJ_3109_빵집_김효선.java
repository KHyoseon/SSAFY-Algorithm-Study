package ws0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 3109. 빵집

public class Main3109 {

	static int R, C;
	static int pipe1 = 0, pipe2 = 0;
	static int move[] = {-1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char map[][] = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		char m[][] = new char[R][C];
		for(int i=0; i<R; i++) {
			m[i] = Arrays.copyOf(map[i], C);
		}
		for(int i=0; i<R; i++) {
			if(findRoute1(i, 0, m))
				pipe1++;
		}
			
		bw.write(pipe1+"");
		bw.flush();

	}
	
	// r, c에 놓았고 다음에 어디로 갈지
	public static boolean findRoute1(int r, int c, char map[][]) {
		if(map[r][c]=='.') {
			map[r][c] = 'x';
			if(c==C-1) {
				return true;
			}
			for(int i=0; i<3; i++) {
				if(0<=r+move[i] && r+move[i]<R && c<C-1)
					if(findRoute1(r+move[i], c+1, map)) {
						return true;
					}
			}
		}
		
		return false;
	}
	
}
