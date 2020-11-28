package medium;

/**
 * 1358. 包含所有三种字符的子字符串数目
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
public class T1358 {

    public static void main(String args[]){
        T1358 t = new T1358();
        Solution s = t.new Solution();
        System.out.println(s.numberOfSubstrings("ababbbc"));
    }

    class Solution {
        public int numberOfSubstrings(String s) {
            int res = 0;
            // 滑动窗口
            int start = 0;
            int end = 3;
            boolean flag = true;
            while(start < s.length() - 2 && end <= s.length()){
                String str = s.substring(start, end);
                if(str.contains("a") && str.contains("b") && str.contains("c")){
                    res += s.length() - end + 1;
                    start++;
                }else{
                    if(flag) {
                        end++;
                        if(end >= s.length()){
                            flag = false;
                        }
                    }else{
                        start++;
                        end = start + 3;
                        flag = true;
                    }
                }
            }
            return res;
        }
    }
}
