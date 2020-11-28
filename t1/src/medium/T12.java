package medium;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

 */
public class T12 {
    public static void main(String args[]){
        T12 t = new T12();
        String str = t.intToRoman(10);
        System.out.println(str);
    }

    public String intToRoman(int num) {
        String s = "";
        String[][] romanChars = {{"I","V","X"},{"X","L","C"},{ "C","D","M"},{ "M"}};
        int[] romanNum =    { 1,  5,  10};
        int div;
        int rem;
        int x = 10;
        int index = 0;
        while((num / x) != 0 || (num % x) != 0){
            div = num / x;
            rem = num % x;
            if(rem == 0){
                num = div;
                index++;
                continue;
            }
            String tempS = "";
            for(int i=romanNum.length - 1;i>=0;i--){
                if(rem == romanNum[i]){
                    tempS = romanChars[index][i]+"";
                    break;
                }else if((romanNum[i] - rem) == 1){
                    tempS = romanChars[index][0] + romanChars[index][i] + "";
                    break;
                }else if((rem - romanNum[i]) > 0){
                    int times = rem - romanNum[i];
                    tempS = romanChars[index][i]+"";
                    while (times > 0){
                        tempS = tempS + romanChars[index][0];
                        times--;
                    }
                    break;
                }
            }
            s = tempS + s;
            num = div;
            index++;
        }
        return s;
    }
}
