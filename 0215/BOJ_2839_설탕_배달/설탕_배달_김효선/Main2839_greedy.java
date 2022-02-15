package ws0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2839_greedy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int bags = greedy(N);
		
		bw.write(bags+"");
		bw.flush();

	}

	private static int greedy(int N) {
		if (N%5 == 0)	return N/5;

		int ret = Integer.MAX_VALUE;
		for(int i=0; ;i++) {
			int n = N-5*i;
			if (n<0)	break;
			if (n%3 == 0) {
				ret = Math.min(ret, i+n/3);
			}
		}
		return (ret==Integer.MAX_VALUE? -1: ret);
	}

}
