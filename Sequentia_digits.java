class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
         List<Integer> res = new ArrayList<>();
        String s = "123456789";
        for (int l = 2; l <= s.length(); l++) {  // Corrected termination condition
            for (int j = 0; j <= s.length() - l; j++) {
                int num = Integer.parseInt(s.substring(j, j + l));
                if (num > high) return res;
                if (num >= low) res.add(num);
            }
        }
        return res;
    
    }
}
