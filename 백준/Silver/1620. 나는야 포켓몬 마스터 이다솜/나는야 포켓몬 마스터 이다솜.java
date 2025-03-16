import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static Map<Integer, String> pokemons_name = new HashMap<>();
    static Map<String, Integer> pokemons_nums = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            pokemons_name.put(i, line);
            pokemons_nums.put(line, i);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (isNumeric(s)) { //숫자인 경우
                sb.append(pokemons_name.get(Integer.parseInt(s))).append("\n");
            } else {
                sb.append(pokemons_nums.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}