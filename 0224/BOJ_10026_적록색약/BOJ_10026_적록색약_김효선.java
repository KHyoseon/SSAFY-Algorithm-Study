package hw0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 10026. 적록색약

public class Main10026 {

	static char area[][];
	static boolean checked[][];
	static int move[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int N, num_n, num_ab;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		area = new char[N][N];

		for (int i = 0; i < N; i++) {
			area[i] = br.readLine().toCharArray();
		}
		
		checked = new boolean[N][N];
		dfs_normal();
		checked = new boolean[N][N];
		dfs_abnormal();

		bw.write(num_n+" "+num_ab);
		bw.flush();

	}

	public static void dfs_normal() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!checked[i][j]) {
					char color = area[i][j];
					dfs_normal(color, i, j);
					++num_n;
				}
			}
		}
	}
	private static void dfs_normal(char color, int i, int j) {
		for(int m=0; m<4; m++) {
			int nx = i+move[m][0];
			int ny = j+move[m][1];
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(!checked[nx][ny] && area[nx][ny]==color) {
					checked[nx][ny] = true;
					dfs_normal(color, nx, ny);
				}
			}
		}
	}
	
	public static void dfs_abnormal() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!checked[i][j]) {
					boolean isblue = (area[i][j]=='B'? true: false);
					dfs_abnormal(isblue, i, j);
					++num_ab;
				}
			}
		}
	}
	private static void dfs_abnormal(boolean isblue, int i, int j) {
		for(int m=0; m<4; m++) {
			int nx = i+move[m][0];
			int ny = j+move[m][1];
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(!checked[nx][ny] && (area[nx][ny]=='B')==isblue) {
					checked[nx][ny] = true;
					dfs_abnormal(isblue, nx, ny);
				}
			}
		}
	}
}
