import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int[] HnM = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int H = HnM[0];
        int M = HnM[1];

        int origin_minute = H * 60 + M;

        int convert_minute = (origin_minute - 45 < 0)? origin_minute + (24 * 60) - 45 : origin_minute - 45;

        int hour = convert_minute / 60;
        int minute = convert_minute % 60;

        sb.append(hour).append(" ").append(minute);
        System.out.println(sb.toString());
    }
}