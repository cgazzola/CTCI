package LeetCode;

public class LicenseKey {

    public static void main(String[] args) {
        String key = "2-5g-3-J";
        String newKey = licenseKeyFormatting(key, 2);
        System.out.println(newKey);


    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        for (int i = S.length() - 1, k = K; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch != '-') {
                if ( k == 0) {
                    result.append("-");
                    k = 2;
                }
                result.append(ch);
                k--;
            }
        }
        return result.reverse().toString().toUpperCase();
    }


}
