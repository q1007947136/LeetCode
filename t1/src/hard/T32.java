package hard;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class T32 {

    public static void main(String args[]){
        T32 t = new T32();
        Solution s = t.new Solution();
        System.out.println("5+5="+s.add(5,5));
        System.out.println("~5="+s.neg(5));
        System.out.println("7-2="+s.sub(7,2));
        System.out.println("-6x9="+s.mult(-6,9));
        System.out.println("32/9="+s.div(32,9)[0]+"......"+s.div(32,9)[1]);

    }

    class Solution {
        public int add(int a, int b) {

            /**
             *  通过二进制运算来实现加法
             *  1.求res1 = a ^ b;
             *  2.求res2 = a & b;
             *  3.判断res2是否为0，如果为0则结果为res1，否则表示需要进位，将res2左移一位，然后res1和res2重复上述步骤
             *  直到res2为0为止，返回res1
             */
            int eOr = a ^ b;
            int andRes = a & b;
            while(andRes != 0) {
                andRes = andRes << 1;
                int temp = eOr ^ andRes;
                andRes = eOr & andRes;
                eOr = temp;
            }

            return eOr;
        }

        // 减法
        // a加b的相反数
        public int sub(int a, int b){
            return add(a, neg(b));
        }

        // 相反数
        // ~运算符，按位取反
        public int neg(int num){
            return add(~num, 1);
        }

        // 乘法
        // 二进制乘法竖式和十进制乘法竖式类似，用二进制a的每一位去乘以二进制b的每一位，结果错位相加。
        public int mult(int a,int b){
            if(a == 0) return 0;
            int res = 0;
            while(b != 0){ //
                if((b & 1) == 1){
                    res += a;
                }
                b = b >> 1;
                a = a << 1;
            }
            return res;
        }

        // 除法：a/b 循环执行a-b直到a<b,执行的次数就是除法的结果
        public int[] div(int a,int b){
            int[] res = new int[2];
            int count = 0;
            while(a>=b){
                a = sub(a, b);
                count ++;
            }
            res[0] = count; // 商
            res[1] = a;  // 余数
            return res;
        }
    }
}
