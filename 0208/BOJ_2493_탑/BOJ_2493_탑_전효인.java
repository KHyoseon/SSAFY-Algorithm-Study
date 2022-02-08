
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		//탑의 수(1~500,000)
		int N=Integer.parseInt(br.readLine());
		
		//탑들 번호 저장된 스택
		Stack<Integer> tower=new Stack<>();
		//탑들의 높이 저장된 스택(1~100,000,000)
		Stack<Integer> height=new Stack<>();
		//0번째 탑 높이가 최대값(100,000,000)이라고 가정
		tower.push(0);
		height.push(100_000_000);
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			//현재 탑 높이
			int curH=Integer.parseInt(st.nextToken());
			
			//앞에 애가 나보다 작으면 나보다 큰애 찾기
			while(height.peek()<curH) {
				tower.pop();
				height.pop();
			}
			//찾은 나보다 큰 애 출력 후, 스택에 내 번호 넣기
			sb.append(tower.peek()+" ");
			tower.push(i);
			height.push(curH);
		}
		
		//결과 출력
		System.out.println(sb.toString());
	}
}
