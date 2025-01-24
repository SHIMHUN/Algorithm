import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //map을 사용하여 저장하기?
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        
        /*
        * TreeMap은 HashMap과 달리 순서가 있는 자료구조-> 사전순 정렬 가능
        * 생성자의 인자로 주는 값에 따라 원하는 기준으로 정렬이 가능하답니다 -> 디폴트는 사전순
        * 1. Comparator.comparingInt(String::length) -> 길이 기준 정렬
        * 2. Collections.reverseOrder() -> 역순 정렬
        * 3. Comparator<String> comparator = Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder());
        *    -> TreeMap<>(comparator) 
        *    -> 복합적인 정렬 가능(카의 길이 기준 정렬 후 사전 순으로 정렬)
        * */
        TreeMap<String, Integer> result = new TreeMap<>();
        
        /*
         * 처음 추가되는 확장자 -> value 1로 세팅
         * 기존에 추가되어있는 확장자 -> value+1
         * */
        for(int i=0; i<n; i++){
            String line = reader.readLine();
            String[] split = line.split("\\.");
            if(result.containsKey(split[1])){
                result.put(split[1], result.get(split[1])+1);
            }else{
                result.put(split[1], 1);
            }
        }

        result.forEach((key,value) -> System.out.println(key + " " + value));
    }
}