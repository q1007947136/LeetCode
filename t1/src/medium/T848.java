package medium;

/**
 * 848. 字母移位
 * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。

 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。

 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。

 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。

 返回将所有这些移位都应用到 S 后最终得到的字符串。

 @notice
    String转成char[] 计算会节省下非常多的效率
    修改一个String，把他转成char[] 再修改对应下标的值会比新建一个String然后append快很多

 */
public class T848 {

    public static void main(String args[]) {
        T848 t = new T848();
        String S = "ruu";
        int[] shifts = {26,9,17};
        System.out.println(t.shiftingLetters(S, shifts));
    }

    public String shiftingLetters(String S, int[] shifts) {
        int bit = 0;
        char[] ca = S.toCharArray();
        for(int i=shifts.length - 1;i>=0;i--){
            bit =  (bit + shifts[i]) % 26;
            char c = (char)(ca[i] + bit);
            ca[i] = (char)((c - 'a') % ('z' - 'a' + 1) + 'a');
        }
        return new String(ca);
    }
}
