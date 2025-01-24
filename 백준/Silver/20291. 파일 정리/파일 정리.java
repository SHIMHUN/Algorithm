import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //map을 사용하여 저장하기?

        /*
        * 처음 추가되는 확장자 -> value 1로 세팅
        * 기존에 추가되어있는 확장자 -> value+1
        * */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        Map<String, Integer> result = new HashMap<>();

        for(int i=0; i<n; i++){
            String line = reader.readLine();
            String[] split = line.split("\\.");
            if(result.containsKey(split[1])){
                result.put(split[1], result.get(split[1])+1);
            }else{
                result.put(split[1], 1);
            }
        }

        //TreeMap 자료구조로 변환 -> 사전순 정렬
        TreeMap<String, Integer> convert = new TreeMap<>(result);

        convert.forEach((key,value) -> System.out.println(key + " " + value));
    }
}