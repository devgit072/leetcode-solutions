public class LC97_StringInterleaving {
    public static boolean isInterleaveUtil(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        if(k==s3.length() && i==s1.length() && j==s2.length()) {
            memo[i][j] = true;
            return true;
        }
        int matched = -1;
        if(i < s1.length() && k < s3.length()) {
            if(s1.charAt(i) == s3.charAt(k)) {
                matched = 0;
            }
        }
        if(j < s2.length() && k < s3.length()) {
            if(s2.charAt(j) == s3.charAt(k)) {
                if(matched == 0) {
                    matched = 2;
                } else {
                    matched = 1;
                }
            }
        }
        if(matched == -1) {
            memo[i][j] = false;
            return false;
        }
        if(matched == 2) {
            boolean value =  isInterleaveUtil(s1, s2, s3, i+1, j, k+1, memo) || isInterleaveUtil(s1, s2, s3, i, j+1, k+1, memo);
            memo[i][j] = value;
        } else if(matched == 1) {
            memo[i][j] =  isInterleaveUtil(s1, s2, s3, i, j+1, k+1, memo);
        } else {
            memo[i][j] =  isInterleaveUtil(s1, s2, s3, i+1, j, k+1, memo);
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Boolean[][] memo = new Boolean[6][6];
        //isInterleaveUtil(s1, s2, s3, 0, 0, 0, memo);
        isInterleaveUtil("aabcc", "dbbca", "aadbbcbcac", 0, 0, 0, memo);
        //isInterleaveUtil("aabcc", "dbbca", "aadbbbaccc", 0, 0, 0, memo);
        if(memo[5][5] == null || !memo[5][5]) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
        //System.out.println();
        //System.out.println(isInterleaveUtil("a", "aaaa", "aa", 0, 0, 0));
    }
}
