import java.io.*;
import java.util.HashMap;

public class Main {
    static HashMap<Character, Integer> hashMap;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine()); // 메뉴 옵션 개수

        for (int i = 0; i < N; i++) {
            boolean find = false;
            String words = br.readLine();
            String[] word = words.split(" ");

            // 첫 번째 규칙: 각 단어의 첫 글자를 단축키로 지정
            for (int j = 0; j < word.length; j++) {
                char firstChar = Character.toLowerCase(word[j].charAt(0)); // 대소문자 구분 없이 처리
                if (!hashMap.containsKey(firstChar)) {
                    hashMap.put(firstChar, 1); // 단축키 등록
                    word[j] = "[" + word[j].charAt(0) + "]" + word[j].substring(1); // 첫 글자 감싸기
                    find = true;
                    break; // 단축키 지정되면 종료
                }
            }

            // 두 번째 규칙: 단어 내에서 다른 글자를 단축키로 지정
            if (!find) {
                for (int j = 0; j < word.length; j++) {
                    for (int k = 1; k < word[j].length(); k++) { // 첫 글자는 이미 확인했으므로 1부터 시작
                        char c = Character.toLowerCase(word[j].charAt(k));
                        if (!hashMap.containsKey(c)) {
                            hashMap.put(c, 1); // 단축키 등록
                            word[j] = word[j].substring(0, k) + "[" + word[j].charAt(k) + "]" + word[j].substring(k + 1); // 단어 내 글자 감싸기
                            find = true;
                            break;
                        }
                    }
                    if (find) break; // 단축키를 찾으면 종료
                }
            }

            // 세 번째 규칙: 단축키를 찾지 못한 경우
            if (!find) {
                sb.append(words).append("\n");
            } else {
                sb.append(String.join(" ", word)).append("\n");
            }
        }

        // 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
