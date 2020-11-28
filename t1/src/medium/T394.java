package medium;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。

 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 可优化，可使用栈

 */
public class T394 {


    public static void main(String args[]){
        T394 t = new T394();
        System.out.println(t.decodeString("3[a]2[bc]", 1));
    }

    int index = 0;
    public String decodeString(String s, int sTimes){
        String str = "";
        String num = "";
        char c = s.charAt(index);
        while(c != ']') {
            if (c >= '0' && c <= '9') {
                num += c;
                index++;
            } else if(c == '['){
                index++;
                int times = Integer.parseInt(num);
                num = "";
                str+=decodeString(s, times);
            }else{
                str+=c;
                index++;
            }
            if(index >= s.length()){
                break;
            }else {
                c = s.charAt(index);
            }
        }
        index++;
        String res = "";
        for(int i=0;i<sTimes;i++){
            res+=str;
        }
        return res;
    }
}
