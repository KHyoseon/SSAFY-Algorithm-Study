import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().split(" ");
        StringBuilder result = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(str[i]);
            int idx = i;
            if(stack.isEmpty()){
                result.append(0+" ");
            }else {
                while (true) {
                    if(stack.isEmpty()){
                        result.append(0+" ");
                        break;
                    }
                    if (stack.peek()[1] < num) {
                        stack.pop();
                    } else if (stack.peek()[1] > num) {
                        result.append(stack.peek()[0] + " ");
                        break;
                    }
                }
            }
            stack.push(new int[] {idx+1, num});
        }
        System.out.println(result.toString());
    }
}