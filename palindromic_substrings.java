class Solution {
    static int ispalindrome(char c[],int i, int j) {
        int count=0;
        while(i>=0 && j<c.length && c[i--]==c[j++]) {
            count++;
        } return count;
    }
    public int countSubstrings(String s) {
        char[] c= s.toCharArray();
        int res=0;
        for(int i=0;i<s.length();i++) {
            res +=ispalindrome(c,i,i);
            res +=ispalindrome(c,i,i+1);
            
        }
        return res;
    }
}
