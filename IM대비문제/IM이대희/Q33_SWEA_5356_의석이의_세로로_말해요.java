import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q33_SWEA_5356_의석이의_세로로_말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			String[] str = new String[5];
			int maxLen = -1;
			for (int i = 0; i < 5; i++) {
				str[i] = br.readLine();
				if (str[i].length() > maxLen)				//전체 문장에서 제일 길이가 긴 값을 구한다.
					maxLen = str[i].length();
			}
			String result = "";
			for (int i = 0; i < maxLen; i++) {				//각문장의 최대길이를 넘지 않았을때, 각각 한글자씩 추가되게 한다.
				if (i < str[0].length()) {
					result += str[0].charAt(i);
				}
				if (i < str[1].length()) {
					result += str[1].charAt(i);
				}
				if (i < str[2].length()) {
					result += str[2].charAt(i);
				}
				if (i < str[3].length()) {
					result += str[3].charAt(i);
				}
				if (i < str[4].length()) {
					result += str[4].charAt(i);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
}
