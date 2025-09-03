public class LookAndSayMiddleVersion1 {

    /**
     * 목적 : 기능 구현
     * L1 = "1"에서 시작하여 n번째까지 문자열을 차례로 생성한다.
     * 마지막 문자열에서 가운데 두 자리를 추출해 반환합니다.
     * 가장 직관적이고 단순한 구현입니다.
     * 시간 복잡도: O(M)
     * M = n번째 문자열의 길이
     * @param n
     * @return
     */
    public static int middleTwoDigits(int n) {
        if (n <= 0) throw new IllegalArgumentException("n 은 양수여야 합니다.");

        String s = "21";    // n 이 3인 경우 가정
        for (int i = 4; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            for (int p = 0; p < s.length(); ) {
                char d = s.charAt(p);
                int q = p + 1;
                while (q < s.length() && s.charAt(q) == d) q++;
                int cnt = q - p;
                next.append(cnt).append(d); // (count, digit)
                p = q;
            }
            s = next.toString();
        }

        int len = s.length();
        int midRight = len / 2;
        int midLeft = midRight - 1;

        return Integer.parseInt(String.valueOf(s.charAt(midLeft)) + s.charAt(midRight));
    }
}
