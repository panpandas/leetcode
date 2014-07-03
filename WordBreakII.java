/*
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
*/

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> results = new ArrayList<String>();
        
        if(s == null || s.length() == 0) {
            return results;
        }    
        
        Set<Integer> failures = new HashSet<Integer>();
        
        doWordBreak(s, dict, failures, results, 0, "");
        
        return results;
    }
    
    private boolean doWordBreak(String s, Set<String> dict, Set<Integer> failures, ArrayList<String> results, int index, String result) {
        if(index == s.length()) {
            results.add(result);
            return true;
        }
        
        boolean found = false;
        for(int i = index + 1; i <= s.length(); i++) {
            if(!failures.contains(i) && dict.contains(s.substring(index, i))) {
                if(!doWordBreak(s, dict, failures, results, i, result.length() == 0 ? s.substring(index, i) : result + " " + s.substring(index, i))) {
                    failures.add(i);
                } else {
                    found = true;
                }
            }
        }
        
        return found;
    }
}
