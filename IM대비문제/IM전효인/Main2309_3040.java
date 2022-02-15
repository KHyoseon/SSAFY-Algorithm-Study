/**
 * 백준 2309. 일곱 난쟁이 / 백준 3040. 백설 공주와 일곱 난쟁이
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309_3040 {
	static int[] nine;
	static int[] seven;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 아홉 난쟁이 키 배열
		nine = new int[9];
		for (int i = 0; i < 9; i++) {
			nine[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nine);

		// 선택한 일곱 난쟁이 배열
		seven = new int[7];
		//아홉 난쟁이의 선택 여부
		isSelected = new boolean[9];
		//결과 찾기
		select(0,0,0);
		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			sb.append(seven[i]).append("\n");
		}
		System.out.println(sb.toString());
		return;
	}
	
	//아홉 난쟁이 중 키 합이 100되는 일곱 난쟁이 찾기
	//idx: 현재 선택 대상인 난쟁이
	//count: 현재 선택된 난쟁이 수
	//sum: 선택된 난쟁이들 키 합
	public static void select(int idx,int count, int sum) {
		// 기저조건
		if(count==7 && sum==100) {
			int j = 0;
			for (int i = 0; i < 9; i++) {
				if (isSelected[i]) {
					seven[j++] = nine[i];
				}
			}
		}
		if (idx >= 9) {
			return;
		}

		// 선택
		isSelected[idx] = true;
		select(idx + 1,count+1,sum+nine[idx]);
		// 비선택
		isSelected[idx] = false;
		select(idx + 1,count,sum);
	}
}
