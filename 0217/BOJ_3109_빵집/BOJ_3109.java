package BOJ.웹엑스수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3109 {
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static String[][] map;
    static int r;
    static int c;

    private static boolean dfs(int x, int y){
        for(int j=0; j<dx.length; j++){
            int nx = x + dx[j];
            int ny = y + dy[j];

            if(nx >= 0 && nx < r && ny < c && map[nx][ny].equals(".")){         // 건물이 없는 경우
                if(ny == c-1){                                                  // 빵집에 도착했을 때
                    return true;
                }
                map[nx][ny] = "x";
                if(dfs(nx, ny)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = in.readLine().split(" ");
        r = Integer.parseInt(tmp[0]);
        c = Integer.parseInt(tmp[1]);
        map = new String[r][c];
        int result = 0;

        for(int i=0; i<r; i++){
            String str = in.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.substring(j,j+1);
            }
        }

        for(int i=0; i<r; i++){
            if(dfs(i,0)){
                result+=1;
            }
        }
        System.out.println(result);
    }
}
