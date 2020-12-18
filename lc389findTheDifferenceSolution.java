389. 找不同
给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随
机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

 

示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。

#########################################################
最笨的方法写最简单的题

class Solution {
    public char findTheDifference(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a'] ++;
            
        }
        for (int i = 0; i < t.length(); i++) {
            
            ints[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) return (char)(i+'a');
        }
        return ' ';
    }
}

##############################################################
异或大法好啊
char res = ' ';
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
#############################################################
一句话异或大法好啊
class Solution {
    public char findTheDifference(String s, String t) {
        return (char)(s + t).chars().reduce(0, (a, b) -> a ^ b);
       
    }
}
