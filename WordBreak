/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
*/


public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return false;
        }   
        
        Set<Integer> failures = new HashSet<Integer>();
        return doWordBreak(s, dict, 0, failures);
    }
    
    private boolean doWordBreak(String s, Set<String> dict, int index, Set<Integer> failures) {
        if(index == s.length()) {
            return true;
        }
        for(int i = index + 1; i <= s.length(); i++) {
            if(dict.contains(s.substring(index, i))) {
                if(!failures.contains(i) && doWordBreak(s, dict, i, failures)) {
                    return true;
                } else {
                    failures.add(i);
                }
            }
        }
        return false;
    }
}
