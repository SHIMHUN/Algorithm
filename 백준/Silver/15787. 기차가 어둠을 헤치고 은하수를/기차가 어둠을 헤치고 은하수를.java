import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = reader.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        /*
         * 기차에 사람이 타있으면 1, 없으면 0
         * */

        int[][] arr = new int[N+1][21];

        for(int i=0; i<M; i++){ //M개의 명령 실행
            String[] line = reader.readLine().split(" ");
            int train_i = Integer.parseInt(line[1]);

            switch (line[0]){
                case "1" :
                    first(arr, train_i, Integer.parseInt(line[2]));
                    break;
                case "2" :
                    second(arr, train_i, Integer.parseInt(line[2]));
                    break;
                case "3" :
                    third(arr, train_i);
                    break;
                case "4" :
                    fourth(arr, train_i);
                    break;
                default:
                    break;
            }
        }

        //배열들을 set으로 중복처리
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= N; i++) { // i = 1부터 시작
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<21; j++){
                sb.append(arr[i][j]);
            }
//            String s = Arrays.toString(arr[i]);
            set.add(sb.toString());
        }

        writer.write(set.size() + "\n");
        writer.flush();
        writer.close();

//        System.out.println(set.size());

    }

    public static void first(int[][] arr, int i, int x){ //해당 칸 승차
        arr[i][x] = 1;
    }

    public static void second(int[][] arr, int i, int x){ //해당 칸 하차
        arr[i][x] = 0;
    }

    public static void third(int[][] arr, int i){ //한칸 씩 뒤로 이동
        for(int j=20; j>1; j--){
            arr[i][j] = arr[i][j-1];
        }
        arr[i][1] = 0;
    }

    public static void fourth(int[][] arr, int i){ //한칸 씩 앞으로 이동
        for(int j=1; j<20; j++){
            arr[i][j] = arr[i][j+1];
        }
        arr[i][20] = 0;
    }
}
