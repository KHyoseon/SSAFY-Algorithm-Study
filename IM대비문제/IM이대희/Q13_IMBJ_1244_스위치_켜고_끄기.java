

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1244 스위치 켜고 끄기
public class Q13_IMBJ_1244_스위치_켜고_끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<size;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j=1;j<=size/pos;j++) {
					arr[pos*j-1] -= 1;
					arr[pos*j-1] *= arr[pos*j-1];
				}
			}
			else {
				pos = pos-1;
				int cnt=0;
				while(true) {
					if(cnt == 0) {
						arr[pos] -= 1;
						arr[pos] *= arr[pos];
						cnt++;
					}
					else {
						if(pos - cnt < 0 || pos + cnt >= size)
							break;
						else {
							if(arr[pos+cnt] != arr[pos-cnt])
								break;
							arr[pos+cnt] -= 1;
							arr[pos+cnt] *= arr[pos+cnt];
							arr[pos-cnt] -= 1;
							arr[pos-cnt] *= arr[pos-cnt];
							cnt++;
						}
					}
				}
			}
		}
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
			if((i+1)%20 == 0)
				System.out.println();
		}
	}
}
