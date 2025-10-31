import java.util.*;
import java.io.*;

public class Main {
    static Stack<Integer> arr = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    customPush(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(customPop()).append("\n");
                    break;
                case "size":
                    sb.append(customSize()).append("\n");
                    break;
                case "empty":
                    sb.append(customEmpty()).append("\n");
                    break;
                case "top":
                    sb.append(customTop()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    static void customPush(int n){
        arr.push(n);
    }

    static int customPop(){
        if(arr.isEmpty()) return -1;
        else return arr.pop();
    }

    static int customSize(){
        return arr.size();
    }

    static int customEmpty(){
        if(arr.isEmpty()) return 1;
        else return 0;
    }

    static int customTop(){
        if(arr.isEmpty()) return -1;
        else return arr.peek();
    }
}