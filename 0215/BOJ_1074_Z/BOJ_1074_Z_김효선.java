package ws0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1074 {

	static int order=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		searchZ((int)Math.pow(2, N), 0, 0, r, c);

		bw.write(order+"");
		bw.flush();

	}

	private static boolean searchZ(int N, int x, int y, int r, int c) {
		if(x+N<r || y+N<c) {
			order += N*N;
			return false;
		}
		if(N==2) {
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					if(x+i==r && y+j==c)	return true;
					++order;
				}
			}
		}
		else {
			if(searchZ(N/2, x, y, r, c))			return true;
			if(searchZ(N/2, x, y+N/2, r, c))		return true;
			if(searchZ(N/2, x+N/2, y, r, c))		return true;
			if(searchZ(N/2, x+N/2, y+N/2, r, c))	return true;
		}
		return false;
	}

}
