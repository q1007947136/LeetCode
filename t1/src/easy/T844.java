package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 */
public class T844 {

    public static void main(String[] args) {
        T844 t = new T844();
        /**
         * "c#a#c"
         * "c"
         */
        System.out.println(t.backspaceCompare("c#a#c","c"));
    }

    public boolean backspaceCompare(String S, String T) {
        // 从后往前遍历，双指针
        char[] cs = S.toCharArray();
        char[] ct = T.toCharArray();
        int indexS = cs.length - 1;
        int indexT = ct.length - 1;
        int ignorS = 0;
        int ignorT = 0;
        while(indexS >= 0 || indexT >= 0){
            if(indexS == -1){
                if(ct[indexT] == '#'){
                    ignorT++;
                    indexT--;
                }else{
                    if(ignorT > 0){
                        ignorT--;
                        indexT--;
                    }else{
                        return false;
                    }
                }
            }else if(indexT == -1){
                if(cs[indexS] == '#'){
                    ignorS++;
                    indexS--;
                }else{
                    if(ignorS > 0){
                        ignorS--;
                        indexS--;
                    }else{
                        return false;
                    }
                }
            }else if(cs[indexS] == '#'){
                ignorS++;
                indexS--;
                if(ct[indexT] == '#'){
                    ignorT++;
                    indexT--;
                }else{
                    if(ignorT > 0){
                        ignorT--;
                        indexT--;
                    }
                }
            }else{
                if(ignorS > 0){
                    ignorS--;
                    indexS--;
                }else if(ct[indexT] == '#'){
                    ignorT++;
                    indexT--;
                }else{ // 两个都不为#
                    if(ignorT > 0){
                        ignorT--;
                        indexT--;
                    }else{
                        if(cs[indexS] != ct[indexT]){
                            return false;
                        }
                        indexS--;
                        indexT--;
                    }
                }
            }

        }

        return true;

        /*

        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for (char c:cs){
            if(c == '#'){
                if(ss.length() > 0){
                    ss.deleteCharAt(ss.length() - 1);
                }
            }else{
                ss.append(c);
            }
        }
        for (char c:ct){
            if(c == '#'){
                if(st.length() > 0){
                    st.deleteCharAt(ss.length() - 1);
                }
            }else{
                st.append(c);
            }
        }
        return ss.toString().equals(st.toString());

         */
    }

}
