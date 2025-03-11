import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Map<Integer, List<Integer>> map = new TreeMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.putIfAbsent(y, new ArrayList<>());
            map.get(y).add(x);
        }

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            Collections.sort(values);

            for(int i=0; i<values.size(); i++){
                sb.append(values.get(i) + " " + key + "\n");
            }
        }

        System.out.println(sb);
    }
}