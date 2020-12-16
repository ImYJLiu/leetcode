290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true


我的方法：
-------------------------------------------------------------------
point: 辅助的数据结构set
时间复杂：
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if(s1.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < s1.length ; i++){
            if(!map.containsKey(pattern.charAt(i))) { //如果没有包含key
                if (! set.contains(s1[i])){
                    map.put(pattern.charAt(i), s1[i]);
                    set.add(s1[i]);
                }
                else{
                    return false;
                }
                
            }
            else if(!map.get(pattern.charAt(i)).equals(s1[i])){
                return false;
            }
        }
        return true;


    }
}
