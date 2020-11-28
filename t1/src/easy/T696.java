package easy;

/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

 重复出现的子串要计算它们出现的次数。

 */
public class T696 {
    public static void main(String args[]){
        String s = "100111001";
        T696 t = new T696();
        int count = t.countBinarySubstrings(s);
        System.out.println("count = "+count);
    }

    public int countBinarySubstrings(String s) {
        int result = 0;
        char preC = s.charAt(0);
        int count = 1;
        int anotherCount = 0;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(anotherCount == 0) {
                if (c == preC) {
                    count++;
                } else {
                    anotherCount = count - 1;
                    count = 1;
                    result++;
                }
            }else{
                if (c == preC) {
                    result++;
                    count++;
                    anotherCount = anotherCount - 1;
                } else {
                    anotherCount = count - 1;
                    count = 1;
                    result++;
                }
            }
            preC = c;
        }
        return result;
    }
}
