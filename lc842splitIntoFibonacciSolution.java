// 本以为是动轨，结果是回溯
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc842splitIntoFibonacciSolution {
    int len;
    public List<Integer> splitIntoFibonacci(String S) {
        len = S.length();
        List<Integer> res = new ArrayList<>();
        return dfs(0, S, res) ? res : new ArrayList<>();
    }

    
    private boolean dfs(int p, String S, List<Integer> res) { //(p是什么？)
        int size = res.size();
        if (p == len) {
            return size > 2;
        }
        int num = 0;
        for (int i = p; i < len; i ++) {
            num = 10 * num + S.charAt(i) - '0';
            //判断是否溢出
            if (num < 0) {
                return false;
            }
            if (size < 2 || num == res.get(size -1) + res.get(size -2)) {
                res.add(num);
                if (dfs(i + 1, S, res)) {
                    return true;
                }
                res.remove(size);
            }
            //判断是否以0开头，阻止循环到下一位
            if (S.charAt(i) - '0' == 0 && i == p) {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new lc842splitIntoFibonacciSolution().splitIntoFibonacci("123456579"));
    }

}



