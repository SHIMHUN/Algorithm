import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringTokenizer st;
    static TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.putIfAbsent(key, new ArrayList<>()); //키 존재 x
            map.get(key).add(value); //value 저장
        }


        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int x = entry.getKey();
            List<Integer> values = entry.getValue();
            Collections.sort(values);

            for(int i=0; i<values.size(); i++){
                sb.append(x + " " + values.get(i) + "\n");
            }

        }

        System.out.println(sb);

    }
}