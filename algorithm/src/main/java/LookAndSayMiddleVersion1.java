public class LookAndSayMiddleVersion1 {

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
