import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo3_구미_5반_김지혜 {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        String[] tmp = in.readLine().split(" ");
        int[] p = new int[m];
        int result = 0;
        for(int a=0; a<=n; a++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                p[i] = Integer.parseInt(tmp[i]);
                String str = Integer.toBinaryString(p[i] ^ a);					// XOR 계산
                int safe = str.length() - str.replace("1", "").length();		// 1의 수 카운팅
                if (min > safe) {
                    min = safe;
                }
            }
            if(min > result){
                result = min;
            }
        }
        System.out.println(result);
    }
}
