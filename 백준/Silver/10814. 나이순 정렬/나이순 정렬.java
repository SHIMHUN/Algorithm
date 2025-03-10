import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, List<String>> group = new HashMap<>();
    static int N;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String member = st.nextToken();
//            String[] member_str = br.readLine().split(" ");
//            int age = Integer.parseInt(member_str[0]);
//            String member = member_str[1];

            group.putIfAbsent(age, new ArrayList<>());
            group.get(age).add(member);
        }

        for(Map.Entry<Integer, List<String>> entry : group.entrySet()){
            List<String> value = entry.getValue();
            int key = entry.getKey();

            for(int i = 0; i<value.size(); i++){
                sb.append(key + " " + value.get(i) + "\n");
            }
        }

        System.out.println(sb);
    }
}