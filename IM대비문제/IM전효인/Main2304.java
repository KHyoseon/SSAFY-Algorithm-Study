/**
 * 백준 2304. 창고 다각형
 * 
 * 220213
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main2304 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//기둥 개수(1~1000)
		int N=Integer.parseInt(br.readLine());

		//0:각 기둥의 시작 위치 L(1~1000), 1:높이 H(1~1000) 이차원 배열
		int[][] data=new int[N][2];
		for(int i=0;i<N;i++) {
			data[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		//시작 위치 순으로 정렬(오름차순)
		Arrays.sort(data,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		//왼쪽부터 시작해서 높이가 커질때만 스택에 추가
		Stack<int[]> left=new Stack<>();
		left.push(data[0]);
		for(int i=1;i<N;i++) {
			if(left.peek()[1]<data[i][1]) {
				left.push(data[i]);

			}
		}
		
		//오른쪽부터 시작해서 높이가 커질때만 스택에 추가
		Stack<int[]> right=new Stack<>();
		right.push(data[N-1]);
		for(int i=N-2;i>=0;i--) {
			if(right.peek()[1]<data[i][1]) {
				right.push(data[i]);
			}
		}

		//창고 면적
		int result=0;
		
		//최대값 기둥의 면적 계산
		//(오른쪽 최대 기둥 끝 위치-왼쪽 최대 기둥 시작 위치)*최대 기둥 높이
		result+=(right.peek()[0]-left.peek()[0]+1)*left.peek()[1];
		
		//왼쪽 면적 계산
		int size=left.size();
		for(int i=0;i<size-1;i++) {
			//스택에는 오른쪽 기둥이 마지막으로 들어감
			//오른쪽 기둥: left.pop(), 왼쪽 기둥: left.peek()
			
			//현재 기둥에서 다음 기둥까지의 면적
			//(오른쪽 기둥 시작 위치-왼쪽 기둥 시작 위치)*왼쪽 기둥 높이
			result+=(left.pop()[0]-left.peek()[0])*left.peek()[1];
		}
		
		//오른쪽 면적 계산
		size=right.size();
		for(int i=0;i<size-1;i++) {
			//스택에는 왼쪽 기둥이 마지막으로 들어감
			//왼쪽 기둥: right.pop(), 오른쪽 기둥: right.peek()
			
			//현재 기둥에서 다음 기둥까지의 면적
			//(-왼쪽 기둥 시작 위치+오른쪽 기둥 시작 위치)*오른쪽 기둥 높이
			result+=(-right.pop()[0]+right.peek()[0])*right.peek()[1];
		}
		
		System.out.println(result);
	}
}
