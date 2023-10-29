import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon_2661 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String seq = "";
        getGoodSequence(seq);
    }

    static void getGoodSequence(String seq) {
        if (seq.length() == N) {
            System.out.println(seq);
            System.exit(0); // 정상종료 / System.exit(1); 비정상종료
        }

        for(int i=1; i<=3; i++) {
            String newSeq = seq + i;
            if (check(newSeq)) {
                getGoodSequence(newSeq);
            }
        }
    }

    static boolean check(String seq) {
        int length = seq.length() / 2;

        for (int i=1; i<=length; i++) {
            String postString = seq.substring(seq.length() - i);
            String preString = seq.substring(seq.length() - (2 * i), seq.length() - i);

            if (postString.equals(preString)) {
                return false;
            }
        }

        return true;
    }

}
