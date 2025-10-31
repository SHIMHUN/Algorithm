import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;

            switch(cmd){
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    num = dq.isEmpty()? -1 : dq.pollFirst();
                    sb.append(num).append("\n");
                    break;
                case "pop_back":
                    num = dq.isEmpty()? -1 : dq.pollLast();
                    sb.append(num).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    num = dq.isEmpty()? 1 : 0;
                    sb.append(num).append("\n");
                    break;
                case "front":
                    num = dq.isEmpty()? -1 : dq.peekFirst();
                    sb.append(num).append("\n");
                    break;
                case "back":
                    num = dq.isEmpty()? -1 : dq.peekLast();
                    sb.append(num).append("\n");
                    break;
            }
        }

        System.out.print(sb);

    }
}