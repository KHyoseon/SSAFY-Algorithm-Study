package ws0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2839_recursive {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int bags=0;
		
		// N를 3, 5로 나누었을 때 나오는 수의 개수
		bags = recurse(N, 0);
		
		bw.write((bags==Integer.MAX_VALUE? -1: bags)+"");
		bw.flush();

	}

	private static int recurse(int n, int bags) {
		if(n<0)				return Integer.MAX_VALUE;
		if(n==0)			return bags;
		if(n%5==0)			return bags + n/5;
		if(n==3 || n==5)	return bags + 1;
		
		int ret1 = recurse(n-3, bags+1);
		int ret2 = recurse(n-5, bags+1);
	
		return (ret1<ret2 ? ret1 : ret2);
	}

}
