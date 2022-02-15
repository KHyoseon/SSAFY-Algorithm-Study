/**
 * SWEA 1984. 중간 평균값 구하기
 * 
 * 220212
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1984 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			//10개의 수(0~10000)
			int[] data=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			//10개 수의 합, 최대, 최소 구하기
			int sum=Arrays.stream(data).sum();
			int max=Arrays.stream(data).max().getAsInt();
			int min=Arrays.stream(data).min().getAsInt();
			//10개 수 합에서 최대, 최소 빼기
			sum-=max+min;

			//8개 수의 평균 구하기
			double avg=(double)sum/(data.length-2);
			
			//평균 반올림해서 결과 저장
			sb.append(Math.round(avg)).append("\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
