import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q29_SWEA_1859_백만장자_프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			long result = 0;										//결과값을 long으로 선언해야 터지지 않는다.
			int size = Integer.parseInt(br.readLine());
			int []arr = new int[size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<size;i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			int max = -1;
			for(int i=size-1;i>=0;i--) {						//배열의 끝에서부터 거꾸로 가면서, 최댓값 이하의 값이 들어온경우 최댓값과의 차만큼 결과값 +, 기존최댓값보다 큰 값이 들어온 경우 최댓값 변경
				if(arr[i]>max) {								//최댓값보다 큰 경우 최댓값 변경
					max = arr[i];
				}
				else if (arr[i] == max){						//최댓값이랑 동일한경우 통과
					continue;
				}
				else {											//결과값에 차익만큼 더해주기.
					result += max-arr[i];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
}
