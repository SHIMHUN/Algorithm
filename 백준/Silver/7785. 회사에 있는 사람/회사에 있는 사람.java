import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(Collections.reverseOrder());

        while(n-- > 0){
//            String[] s = br.readLine().split(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            if(cmd.equals("enter")) set.add(name);
            else set.remove(name);
        }

//        List<String> al = new ArrayList<>(set);
//        Collections.sort(al, Collections.reverseOrder());
//
//        for(String s : al){
//            sb.append(s).append("\n");
//        }
        for(String s : set){
            sb.append(s).append("\n");
        }

//        set.forEach(s -> sb.append(s).append("\n"));
        System.out.print(sb);
    }
}