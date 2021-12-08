package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。
 */
public class Q500 {


    /**
     * 先将所有26个英文字母对应在键盘上的行数表示出来
     * 首先获取第一个字符对应的行数是多少， 后续一直遍历， 只要出现不一样的， 就说明不在同一行， 直接退出循环
     * 注意，计算字符对应的行数的方法
     */
    public String[] findWords(String[] words) {
        String rowIdx = "12210111011122000010020202";

        List<String> re = new ArrayList<>();
        for (String word: words){
            String tmp = word.toLowerCase();
            char c = rowIdx.charAt(tmp.charAt(0) - 'a');
            boolean valid = true;
            for (int i=1; i < tmp.length(); i++){
                if (c != rowIdx.charAt(tmp.charAt(i) - 'a')){
                    valid = false;
                    break;
                }
            }
            if (valid) {
                re.add(word);
            }
        }
        return re.toArray(new String[0]);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q500().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

}
