package ws0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달_recursive {
	static int min = 99999;					//최솟값 지정
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sugar(N, 0);
		System.out.println(min!=2000?min:-1);
	}
	private static void sugar(int N, int cnt) {
		if(N == 0) {							//N이 나눠떨어진 경우
			if(cnt < min)						//cnt값과 기존 최소값을 비교한 뒤에
				min = cnt;						//최소값을 갱신해준다
			return;
		}
		else if(N < 0)							//N이 0보다 작아지는 경우 나눠떨어진것이 아니기 때문에 그냥 return
			return;
		else {
			sugar(N-5, cnt+1);					//N에서 5를 뺀 경우로 넘어감.
			sugar(N-3, cnt+1);					//N에서 3을 뺀 경우로 넘어감.
		}
	}
}
