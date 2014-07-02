/*
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

*/


public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start == null || end == null || start.length() == 0 || start.length() != end.length() || dict == null || dict.size() == 0) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> steps = new LinkedList<Integer>();
        
        queue.add(start);
        steps.add(1);
        dict.add(end);
        
        
        while(!queue.isEmpty()) {
            String s = queue.remove();
            int step = steps.remove();
            if(s.equals(end)) {
                return step;
            }
            
            for(int i = 0; i < start.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    char[] array = s.toCharArray();
                    if(array[i] == c) {
                        continue;
                    }
                    
                    array[i] = c;
                    String replaced = String.valueOf(array);
                    if(dict.contains(replaced)) {
                        queue.add(replaced);
                        steps.add(step+1);
                        dict.remove(replaced);
                    }
                }
            }
        }
        
        return 0;
    }
}
