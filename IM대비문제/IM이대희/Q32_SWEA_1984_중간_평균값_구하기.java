import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32_SWEA_1984_중간_평균값_구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			int[] arr = new int[10];
			int min = 10001; int max = -1;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<10;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
				if(arr[i]>max)
					max = arr[i];
				if(arr[i]<min)
					min = arr[i];
			}
			sum = sum-max-min;
			double average = sum/8.0;
			
			sb.append(Math.round(average)).append("\n");
		}
		System.out.print(sb.toString());
	}
}
