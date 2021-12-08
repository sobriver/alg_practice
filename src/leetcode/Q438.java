package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * s 和 p 仅包含小写字母
 */
public class Q438 {


    /**
     * 滑动窗口方法
     * pCount用来统计p中所有字符出现的次数
     * SCount用来统计s中字符出现的次数， 从s头部开始， 每次循环之前先要将数组全部用0填充
     */
    public List<Integer> selfFindAnagrams(String s, String p) {
        List<Integer> re = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return re;
        }
        int[] pCount = new int[26];
        for (int i=0; i < pLen; i++){
            pCount[p.charAt(i) - 'a']++;
        }

        int[] sCount = new int[26];
        for (int i=0; i < sLen-pLen+1; i++){
            Arrays.fill(sCount, 0);
            for (int j=0; j < pLen; j++){
                sCount[s.charAt(i+j) - 'a']++;
            }

            if (Arrays.equals(pCount, sCount)){
                re.add(i);
            }
        }
        return re;
    }

    /**
     * 双指针法
     * TODO 不是很理解
     */
    public List<Integer> findAnagrams1(String s, String p){
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        while (hi < s.length()) {
            if (cnt[s.charAt(hi)] > 0) {
                cnt[s.charAt(hi++)]--;
                if (hi - lo == p.length()) res.add(lo);
            } else {
                cnt[s.charAt(lo++)]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q438().selfFindAnagrams("cbaebabacd", "abc"));
        System.out.println(new Q438().selfFindAnagrams("abab", "ab"));
    }
}
