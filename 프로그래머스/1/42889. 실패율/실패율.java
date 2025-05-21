import java.util.*;

class Solution {
    static int challenge[];
    static int unclear[];
    static TreeMap<Integer, Double> map = new TreeMap<>();
    
    public int[] solution(int N, int[] stages) {
        int len = stages.length;
        
        challenge = new int[N + 1];  // 1부터 N까지의 스테이지
        unclear = new int[N + 1];    // 1부터 N까지의 스테이지

        // 각 스테이지에 대한 사용자 수를 구함
        for (int user : stages) {
            for (int i = 1; i < user; i++) {
                challenge[i]++;  // 해당 스테이지보다 앞서서 클리어한 사람
            }
            if (user <= N) {
                unclear[user]++;  // 해당 스테이지에서 멈춘 사람
            }
        }
        
        // 실패율 계산 및 TreeMap에 저장
        for (int i = 1; i <= N; i++) {
            if (unclear[i] == 0) {
                map.put(i, 0.0);  // 실패율이 0인 경우
            } else {
                map.put(i, (double) unclear[i] / (challenge[i] + unclear[i]));  // 실패율 계산
            }
        }

        // 실패율 내림차순으로 정렬
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        // 정렬된 리스트를 배열로 변환하여 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}