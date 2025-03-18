import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static Map<String, String> address = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            address.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(address.get(st.nextToken())).append("\n");
        }

        System.out.println(sb);
    }
}