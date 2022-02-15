import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q23_SWEA_11315_오목판정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			int size = Integer.parseInt(br.readLine());
			String[] str = new String[size];
			for(int i=0;i<size;i++) 
				str[i] = br.readLine();
			boolean trigger = false;
			
			for(int i=0;i<size&&!trigger;i++) {		//가로로 오목 카운트. 다섯개 이상이면 trigger를 true로 변경
				int count = 0;
				for(int j=0;j<size;j++) {
					if(str[i].charAt(j) == 'o') {
						count++;
						if(count >= 5) {
							trigger = true;
							break;
						}
					}else {
						if(count != 0)
							count = 0;
					}
				}
			}
			for(int i=0;i<size&&!trigger;i++) {		//세로로 오목 카운트. 다섯개 이상이면 trigger를 true로 변경.
				int count = 0;
				for(int j=0;j<size;j++) {
					if(str[j].charAt(i) == 'o') {
						count++;
						if(count >= 5) {
							trigger = true;
							break;
						}
					}else {
						if(count != 0)
							count = 0;
					}
				}
			}
			for(int i=0;i<=size-5&&!trigger;i++) {		//왼쪽 위에서 오른쪽 아래로 가는대각선 방향 오목 카운트. 다섯개 이상 카운트되면 trigger를 true로 변경.
				for(int j=0;j<=size-5&&!trigger;j++) {
					if(str[i].charAt(j) == 'o'&&str[i+1].charAt(j+1) == 'o'&&str[i+2].charAt(j+2) == 'o'&&str[i+3].charAt(j+3) == 'o'&&str[i+4].charAt(j+4) == 'o')
						trigger = true;
				}
			}
			for(int i=0;i<=size-5&&!trigger;i++) {		//오른쪽 위에서 왼쪽 아래로 가는 대각선 방향 오목 카운트. 다섯개 이상 카운트되면 trigger를 true로 변경.
				for(int j=size-1;j>=4&&!trigger;j--) {
					if(str[i].charAt(j) == 'o'&&str[i+1].charAt(j-1) == 'o'&&str[i+2].charAt(j-2) == 'o'&&str[i+3].charAt(j-3) == 'o'&&str[i+4].charAt(j-4) == 'o')
						trigger = true;
				}
			}
			sb.append(trigger?"YES":"NO").append("\n");
		}
		System.out.print(sb.toString());
	}
}
