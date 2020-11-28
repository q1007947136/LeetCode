package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

 使用哈希表可以减少很多遍历
 关于一个字符串是否包含另一个字符串的需求可以使用哈希表来解决

 */
public class T76 {

    public static void main(String args[]) {
        T76 t = new T76();
        System.out.println(t.minWindow("ADOBECODEBANC","ABC"));
    }

    /*
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        // 滑动窗口
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int right = 0;
        boolean flag = true; // 默认移动right指针
        String temp = "";
        while(right < s.length() || !flag){
            if(flag){
                temp += s.charAt(right);
                Integer need = map.get(s.charAt(right));
                if(need != null){
                    map.put(s.charAt(right), need - 1);
                    boolean f = true;
                    for(int v:map.values()){
                        if(v > 0) f = false;
                    }
                    if(f){ // 子串包含了全部t的字符
                        if(res.equals("") || temp.length() < res.length()){
                            res = temp;
                        }
                        flag = false;
//                        left++;
                    }
                }
                right++;
            }else{
                Integer need = map.get(s.charAt(left));
                if(need != null){
                    map.put(s.charAt(left), need + 1);
                    boolean f = false;
                    for(int v:map.values()){
                        if(v > 0) {
                            f = true;
                            break;
                        }
                    }
                    if(f){ // 新子串不包含全部字符，重新开始移动right
                        flag = true;
                        if(res.equals("") || temp.length() < res.length()){
                            res = temp;
                        }
                    }
                }
                temp = temp.substring(1);
                left++;
            }
        }
        return res;
    }
    */

    // 滑动窗口+哈希表
    public String minWindow(String s, String t) {
        int[] hashS = new int[128]; // 存s中的字符个数
        int[] hashT = new int[128]; // 存t中的字符个数
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        String res = "";
        int len = s.length();
        for(char x:ta){ // 构建哈希表
            hashT[x]++; // 记录每个字符的个数
        }
        // 准备工作完成
        // 开始遍历s
        // 双指针构建滑动窗口
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < sa.length){
            char c = sa[right];
            hashS[c]++;
            // 当窗口中字符个数小于等于需要的字符个数时，累加它们的数量
            // 如果出现不在t里的字符，需要的个数为0，判断自然为false，如果窗口中的数量超过了所需的就无需累加
            // 判断t中的字符全部出现的条件为count = t.length
            if(hashS[c] <= hashT[c]){
                count++;
            }
            // 窗口开始缩小，缩小到窗口中不包含t中的所有字符
            while (count == ta.length) {
                // 取结果
                /**
                 * 每次都截取字符串长度，可优化
                String tempS = s.substring(left, right+1);
                if(tempS.length() < res.length() || res.equals("")){
                    res = tempS;
                }
                */
                // 可以根据left和right计算出本次字符串的长度，先与res的长度比较，避免不必要的截取操作
                // 因为题目保证了答案唯一，所以这里可以取等号
                if(len >= right + 1 - left){
                    len = right + 1 - left;
                    res = s.substring(left, right+1);
                }
                char temp = sa[left];
                hashS[temp]--;
                if (hashS[temp] < hashT[temp]) {
                    count--;
                }
                left++;
                if(left > right) break;
            }
            right++;
        }
        return res;
    }

}
