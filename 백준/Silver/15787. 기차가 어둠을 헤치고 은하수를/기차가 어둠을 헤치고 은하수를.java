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
//            System.out.println(line[0]);
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

//        for(int[] array : arr){
//            for(int num : array){
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }

        HashSet<String> set = new HashSet<>();
        //배열들을 map에 넣는다면?
//        for(int i=1; i<N+1; i++){
//            set.add(arr[i]);
//        }

//        for(int[] array : arr){
//            String s = Arrays.toString(array);
//            set.add(s);
//        }

//        for (int i = 1; i <= N; i++) { // i = 1부터 시작
//            for(int j=1; j<21; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= N; i++) { // i = 1부터 시작
            String s = Arrays.toString(arr[i]);
            set.add(s);
        }

        System.out.println(set.size());

    }

    public static void first(int[][] arr, int i, int x){ //해당 칸 승차
//        System.out.println("test1");

//        if(arr[i][x] == 0){
        arr[i][x] = 1;
//        }
    }

    public static void second(int[][] arr, int i, int x){ //해당 칸 하차
//        System.out.println("test2");

//        if(arr[i][x] == 1){
        arr[i][x] = 0;
//        }
    }

    public static void third(int[][] arr, int i){ //한칸 씩 뒤로 이동
//        System.out.println("test3");
        for(int j=20; j>1; j--){
            arr[i][j] = arr[i][j-1];
//            if(arr[i][j] == 1){ // 해당 좌석에 사람이 있는 경우에만
//                arr[i][j+1] = 1; // 뒤로 좌석 옮기기
//                arr[i][j] = 0;
//            }
        }
        arr[i][1] = 0;
    }

    public static void fourth(int[][] arr, int i){ //한칸 씩 앞으로 이동
//        System.out.println("test4");

        for(int j=1; j<20; j++){
            arr[i][j] = arr[i][j+1];
//            if(arr[i][j] == 1){ // 해당 좌석에 사람이 있는 경우에만
//                arr[i][j-1] = 1; //앞으로 좌석 옮기기
//                arr[i][j] = 0;
//            }
        }
        arr[i][20] = 0;
    }
}
