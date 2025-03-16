import java.util.*;
import java.io.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String calc_type = st.nextToken();

            int calc_cnt = 0; // 기본값 설정
            if (st.hasMoreTokens()) { // 토큰이 존재하는 경우에만 숫자 읽기
                calc_cnt = Integer.parseInt(st.nextToken());
            }

            switch(calc_type){
                case "add":
                    add(calc_cnt);
                    break;
                case "remove":
                    remove(calc_cnt);
                    break;
                case "check":
                    check(calc_cnt);
                    break;
                case "toggle":
                    toggle(calc_cnt);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        System.out.println(sb);

    }

    public static void add(int x){
        if(!set.contains(x)) {
            set.add(x);
        }
    }

    public static void remove(int x){
        if(set.contains(x)){
            set.remove(x);
        }
    }

    public static void check(int x){
        if(set.contains(x)){
            sb.append(1).append("\n");
        }else{
            sb.append(0).append("\n");
        }
    }

    public static void toggle(int x){
        if(set.contains(x)){
            set.remove(x);
        }else{
            set.add(x);
        }
    }

    public static void all(){
        set.clear();
        for(int i=1; i<=20; i++){
            set.add(i);
        }
    }

    public static void empty(){
        set.clear();
    }
}