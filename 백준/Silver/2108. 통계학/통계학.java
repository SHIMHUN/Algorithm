import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //N은 홀수라고 가정

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<N; i++){
            //값 존재하지 않으면 새로 추가 or 이미 존재하는 값이면 해당 값을 가져와서 + 1
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        // 최빈값 리스트 구하기
        int maxFreq = Collections.max(map.values());
        List<Integer> freqList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                freqList.add(entry.getKey());
            }
        }

        // 여러 개면 두 번째로 작은 값, 하나면 그대로 출력
        Collections.sort(freqList);
        Arrays.sort(arr);

        int avg = (int)Math.round((double)Arrays.stream(arr).sum() / N);
        int mid = arr[N/2];
        int freq = (freqList.size() == 1) ? freqList.get(0) : freqList.get(1);
        int range = arr[N-1] - arr[0];


        StringBuilder sb = new StringBuilder();
        sb.append(avg + "\n").append(mid + "\n").append(freq + "\n").append(range + "\n");
        System.out.println(sb);
    }
}