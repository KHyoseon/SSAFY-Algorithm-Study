/**
 * 백준 2605. 줄 세우기
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2605 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//학생 수
		int N=Integer.parseInt(br.readLine());
		//학생들이 줄 선 순서
		List<Integer> line=new ArrayList<>();
		//학생들이 뽑은 번호 보면서 줄 세우기
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int num=Integer.parseInt(st.nextToken());
			//뽑은 번호만큼 앞으로 가기
			line.add(i-1-num,i);
		}
		
		//출력
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(line.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
