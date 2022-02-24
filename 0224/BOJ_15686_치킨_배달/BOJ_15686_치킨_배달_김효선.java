package ws0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 15686. 치킨배달

public class Main15686 {

	static int N, M, MIN;
	static ArrayList<int[]> chickens, homes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	// M개만 남김
		
		chickens = new ArrayList<>();
		homes = new ArrayList<>();

		MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int pos[] = {i, j};
				switch(Integer.parseInt(st.nextToken())) {
					case 1:
						homes.add(pos);			break;
					case 2:
						chickens.add(pos);		break;
				}
			}
		}
				
		int dist[] = new int[M];
		Arrays.fill(dist, -1);
		f2(0, 0, dist);

		bw.write(MIN+"");
		bw.flush();

	}
	
	public static void f2(int cnt, int start, int remains[]) {
		if(cnt==M) {
			int distSum=0;
			for(int h[]: homes) {
				int dist=Integer.MAX_VALUE;
				for(int j: remains) {
					if(j<0)	break;
					int sum = Math.abs(h[0]-chickens.get(j)[0]) + Math.abs(h[1]-chickens.get(j)[1]);
					dist = Math.min(dist, sum);
				}
				distSum += dist;
			}
			MIN = Math.min(MIN, distSum);
			return;
		}

		for(int i=start, c=chickens.size(); i<c; i++) {
			remains[cnt] = i;
			f2(cnt+1, i+1, remains);
		}
	}
}
