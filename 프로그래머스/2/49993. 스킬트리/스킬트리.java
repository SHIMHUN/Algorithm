import java.util.*;

class Solution {
    HashSet<Character> set = new HashSet<>();
    HashSet<String> possibleSkillTrees = new HashSet<>();
    
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        String s = "";
        
        for(int i=0; i<skill.length(); i++){
            char c = skill.charAt(i);
            
            set.add(c);
            s+=c;
            possibleSkillTrees.add(s);
        }
        
        int cnt = 0;
        
        for(String str : skill_trees){
            String skillTree = "";
            
            for(char c : str.toCharArray()){
                if(set.contains(c)){
                    skillTree+=c;
                }
            }
            
            // if(possibleSkillTrees.contains(skillTree)){
            //     cnt++;
            // }
            if (skill.startsWith(skillTree)) {
                cnt++;
            }
        }
        
        return cnt;
    }
}