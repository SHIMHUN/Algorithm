import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static int N;
    static String[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = Integer.parseInt(s);
        arr = new String[N];

        //입력된 값을 배열에 저장
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        /*
        * compared 함수 반환 타입에 따라 위치를 바꿀지 결정
        * > 0 정렬 알고리즘에 의해 바꿈
        * <= 0 안바꿈
        * */
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){

                //단어 길이가 같은 경우 따로 처리
                if(s1.length() == s2.length()){
                    //문자열 비교시 comparedTo 함수는 사전 순으로 비교하여 처리하게 된다
                    return s1.compareTo(s2);
                }

                //앞의 값이 뒤의 값보다 길이가 긴 경우 값 교환
                else{
                    return s1.length() - s2.length();
                }
            }
        });

        sb = new StringBuilder();
        sb.append(arr[0]).append("\n");

        for(int i=1; i<N; i++){
            if(!arr[i].equals(arr[i-1])){
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}