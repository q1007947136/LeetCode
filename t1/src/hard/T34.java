package hard;

/**
 * 771. 宝石与石头
 * 简单
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

 J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */

public class T34 {
    public static void main(String args[]){
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {
        /*
        // 集合求解
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<J.length();i++){
            set.add(J.charAt(i));
        }
        int result = 0;
        for(int i = 0;i<S.length();i++){
            if(set.contains(S.charAt(i))){
                result++;
            }
        }
        return result;
        */

        // 位运算求解
        long xor = 0;
        for(int i = 0;i<J.length();i++){
            // 取出J当前位置的字符，转化为AscII码值x以后，把二进制第x位设置为1
            xor |= 1L << (J.charAt(i) - 'A');
        }
        // 遍历完J以后，得到一个二进制xor串，除了J中字符的AscII码值对应位位1以外全为0，因此，只需要拿S中字符的AscII码
        // 进行与运算即可
        int result = 0;
        for(int i = 0;i<S.length();i++){
            if((xor & (1L << (S.charAt(i) - 'A'))) != 0){
                result++;
            }
        }
        return result;
    }
}

