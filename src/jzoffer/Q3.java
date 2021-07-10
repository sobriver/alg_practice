package jzoffer;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    /**
     * 找出数组中重复的数字
     */


    /**
     * 使用HashSet来处理
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     */
    public static int s1(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums){
            if (s.contains(n)){
                return n;
            } else {
                s.add(n);
            }
        }
        return 0;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     */
    public static int s2(int[] nums) {
        return 0;
    }


    public static void main(String[] args) {
        int[] a1 = {2, 3, 1, 0, 2, 5, 3};
        int[] a2 = {1,2,3};
        int[] a3 = {2, 11, 78, 11, 3, 23};
        System.out.println(s1(a1));
        System.out.println(s1(a2));
        System.out.println(s1(a3));
    }
}
