import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        int result = 0;

        String[] split = br.readLine().split("");
        for(int i=0;i<N;i++){
            if(!stack.isEmpty()){
//                System.out.println(stack.peek() + " " + split[i]);

                if(stack.peek().equals("E") && split[i].equals("W")){
//                    System.out.println("test");
                    result++;
                }
            }
            stack.push(split[i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}