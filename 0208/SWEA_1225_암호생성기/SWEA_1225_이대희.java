package ws0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_이대희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<=10;i++) {
			
			boolean trigger = true;
			int T = Integer.parseInt(br.readLine());
			int[] arr = new int[8];
			int min = 2147483647;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<8;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if(min>arr[j])
					min = arr[j];
			}
			
			for(int j=0;j<8;j++) {						//전처리. 7바퀴 돌면 무조건 15씩 다 빠지게 되어있어서, 최솟값 1 이상으로 남게 만들어줌.
				arr[j] -= ((min/15)-1)*15;
				queue.offer(arr[j]);
			}
			
			
			
			while(trigger) {					
				int temp;
				for(int k=1;k<=5;k++) {			//계속해서 1~5까지 빼는 사이클을 반복
					temp = queue.poll();
					if(temp-k<=0) {				//queue에서 k를 뺀 값이 0 이하가 될 경우
						temp = 0;				//음수가 됐을 경우에도 0으로 바꿔주고
						queue.offer(temp);		//해당 값을 queue에 삽입한 뒤에
						trigger = false;		//trigger를 false로 바꿔서 while문을 탈출한다.
						break;
					}
					else
						queue.offer(temp-k);
				}
			}
			System.out.println("#"+i+" "+queue.poll()+" "+queue.poll()+" "+queue.poll()+" "+queue.poll()+" "+queue.poll()+" "+queue.poll()+" "+queue.poll()+" "+queue.poll());
			
		}
	}
}
