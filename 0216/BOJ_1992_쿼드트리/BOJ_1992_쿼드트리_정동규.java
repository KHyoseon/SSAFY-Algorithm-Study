package hw0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	static String res = "";
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0;
		String[] board;
		
		N = Integer.parseInt(br.readLine());
		board = new String[N];
		for(int i = 0; i < N; i++)
			board[i] = br.readLine();
		
		compress(board, N, 0, 0);
		sb.append(res);
		System.out.println(res);
	}
	
	private static void compress(String[] board, int N, int x, int y) {
		boolean success = true;
		
		check: for(int i = y; i < y + N; i++) {
			for(int j = x; j < x + N; j++) {
				if(board[i].charAt(j) != board[y].charAt(x)) {
					success = false;
					break check;
				}
			}
		}
		if(success == false) {
			res += "(";
			compress(board, N / 2, x, y);
			compress(board, N / 2, x + N / 2, y);
			compress(board, N / 2, x, y + N / 2);
			compress(board, N / 2, x + N / 2, y + N / 2);
			res += ")";
		}else {
			res += board[y].charAt(x);
		}
	}
}
