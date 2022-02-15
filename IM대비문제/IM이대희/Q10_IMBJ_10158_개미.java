

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10158	개미
public class Q10_IMBJ_10158_개미 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int maxX = Integer.parseInt(st.nextToken());
		int maxY = Integer.parseInt(st.nextToken());
		
		int[] direction = {1,1};
		int[] antpos = new int[2];
		
		st = new StringTokenizer(br.readLine());
		antpos[0] = Integer.parseInt(st.nextToken());
		antpos[1] = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T%(maxX*2);i++) {
			if((i==0) && antpos[0] == maxX)
				direction[0] *= -1;
			antpos[0] += direction[0];
			if(antpos[0] == maxX || antpos[0] == 0)
				direction[0] *= -1;
			
		}
		for(int i=0;i<T%(maxY*2);i++) {
			if((i==0) && antpos[1] == maxY)
				direction[1] *= -1;
			antpos[1] += direction[1];
			if(antpos[1] == maxY || antpos[1] == 0)
				direction[1] *= -1;
			
		}
		
		System.out.println(antpos[0]+" "+antpos[1]);
	}
}
