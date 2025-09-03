public class LookAndSayMiddleVersion2 {

    /**
     * 목적 : 메서드 분리
     * @param n
     * @return
     */
    public static int middleTwoDigits(int n) {
        if (n < 4 || n >= 100) throw new IllegalArgumentException("n은 4 이상 100 미만이어야 합니다. 입력: " + n);

        String s = generate(n);

        return parseMiddle(s);
    }

    /**
     * n 번째 문자열 생성
     * @param n
     * @return
     */
    private static String generate(int n) {
        String s = "1";    // 기본값 세팅
        for (int i = 2; i <= n; i++) {
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
        return s;
    }

    /**
     * 가운데 두자리 수 파싱
     * @param s
     * @return
     */
    private static int parseMiddle(String s) {
        int len = s.length();
        int midRight = len / 2;
        int midLeft = midRight - 1;

        int leftDigit = Character.getNumericValue(s.charAt(midLeft));
        int rightDigit = Character.getNumericValue(s.charAt(midRight));
        return leftDigit * 10 + rightDigit;
    }
}