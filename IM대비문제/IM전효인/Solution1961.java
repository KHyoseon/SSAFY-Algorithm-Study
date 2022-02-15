/**
 * SWEA 1961. 숫자 배열 회전
 * 
 * 220212
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1961 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();

		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append("\n");
			//가로 세로 길이(3~7)
			int N=Integer.parseInt(br.readLine());
			
			//NxN 행렬
			int[][] data=new int[N][N];
			for(int i=0;i<N;i++) {
				data[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			int[][] rot90=rot90(data,N);
			int[][] rot180=rot90(rot90,N);
			int[][] rot270=rot90(rot180,N);
			
			//결과를 출력할 문자열로 만들기
			for(int i=0;i<N;i++) {
				sb.append(Arrays.toString(rot90[i]).replaceAll("[^0-9]", "")).append(" ");
				sb.append(Arrays.toString(rot180[i]).replaceAll("[^0-9]", "")).append(" ");
				sb.append(Arrays.toString(rot270[i]).replaceAll("[^0-9]", "")).append("\n");
			}
		}
		//결과 출력
		System.out.println(sb.toString());
	}
	
	//해당 행렬을 90도 회전시켜서 반환
	public static int[][] rot90(int[][] data,int N) {
		int[][] rotated=new int[N][N];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				rotated[c][N-1-r]=data[r][c];
			}
		}
		
		return rotated;
	}
}
