import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int last = 0;
        int num = 0;
        Queue<Integer> queue = new LinkedList<>();

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    last = x;
                    break;
                case "pop":
                    num = queue.isEmpty() ? -1 : queue.poll();
                    sb.append(num).append("\n");
                    break;
                case "size":
                    num = queue.size();
                    sb.append(num).append("\n");
                    break;
                case "empty":
                    num = queue.isEmpty() ? 1 : 0;
                    sb.append(num).append("\n");
                    break;
                case "front":
                    num = queue.isEmpty() ? -1 : queue.peek();
                    sb.append(num).append("\n");
                    break;
                case "back":
                    num = queue.isEmpty() ? -1 : last;
                    sb.append(num).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}