import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            Map<String, Integer> clothes = new HashMap<>();
            int cnt = Integer.parseInt(br.readLine()); //의상 갯수
            for(int j=0; j<cnt; j++){
                String[] s = br.readLine().split(" ");
                clothes.put(s[1], clothes.getOrDefault(s[1],0)+1);
            }

            int result = 1;
            for(int value : clothes.values()){
                result *= (value + 1);
            }
            sb.append(result-1 + "\n");
        }


        System.out.println(sb);
    }
}