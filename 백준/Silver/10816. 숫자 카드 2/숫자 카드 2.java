import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            int card = Integer.parseInt(st.nextToken());
            map.put(card, map.getOrDefault(card, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int findCard = Integer.parseInt(st.nextToken());

            int getCardCnt = map.getOrDefault(findCard, 0);

            sb.append(getCardCnt + " ");
        }

        System.out.println(sb);
    }
}