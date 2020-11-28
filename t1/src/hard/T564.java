package hard;

import java.util.Timer;

/**
 *564. 寻找最近的回文数
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。

 “最近的”定义为两个整数差的绝对值最小。
 */
public class T564 {

    public static void main(String args[]) {
        T564 t = new T564();
        String n = "" + Integer.MAX_VALUE;
        System.out.println(t.nearestPalindromic(n));
//        System.out.println(t.toReverseNum2(n));
//        System.out.println(t.toReverseNum3(n));
    }

    public String nearestPalindromic(String n) {
        // 3种处理方式
        long start = System.nanoTime();
        long allStart = start;
        long nuns = Long.parseLong(n);
        long num1 = toReverseNum1(n);
        long end = System.nanoTime();
        System.out.println("toReverseNum1 耗时："+ (end - start) + "ns");
        start = end;
        long num2 = toReverseNum2(n);
        end = System.nanoTime();
        System.out.println("toReverseNum2 耗时："+ (end - start) + "ns");
        start = end;
        long num3 = toReverseNum3(n);
        end = System.nanoTime();
        System.out.println("toReverseNum3 耗时："+ (end - start) + "ns");
        start = end;

//        System.out.println("num1 = "+ num1);
//        System.out.println("num2 = "+ num2);
//        System.out.println("num3 = "+ num3);
        long abs1 = Math.abs(nuns - num1) == 0 ? Integer.MAX_VALUE:Math.abs(nuns - num1);
        long abs2 = Math.abs(nuns - num2) == 0 ? Integer.MAX_VALUE:Math.abs(nuns - num2);
        long abs3 = Math.abs(nuns - num3) == 0 ? Integer.MAX_VALUE:Math.abs(nuns - num3);
//        System.out.println(abs1 + ", " + abs2 + ", " + abs3);
        end = System.nanoTime();
        System.out.println("abs 耗时："+ (end - start) + "ns");
        start = end;

        String res = "";
        if(abs1 > abs2){
            if(abs2 > abs3){
                res += num3;
            }else if(abs2 == abs3){
                res += Math.min(num2, num3);
            }else{
                res +=  num2;
            }
        }else if(abs1 == abs2){
            if(abs2 > abs3){
                res +=  num3;
            }else if(abs2 == abs3){
                res += Math.min(num1, Math.min(num2, num3));
            }else{
                res += Math.min(num1, num2);
            }
        }else{
            if(abs1 > abs3){
                res += num3;
            }else if(abs1 == abs3){
                res += Math.min(num1, num3);
            }else{
                res += num1;
            }
        }
        end = System.nanoTime();
        System.out.println("compare 耗时："+ (end - start) + "ns");
        System.out.println("总 耗时："+ (end - allStart) + "ns");
        return res;
    }

    // 1.把字符串后半段改为和前半段反过来的样子
    public long toReverseNum1(String n){
        char[] c = n.toCharArray();
        for(int i=0;i<c.length / 2;i++){
            c[c.length - 1 - i] = c[i];
        }
        return Long.parseLong(new String(c));
    }

    // 2.取字符串前半段，转为数字以后+1，在改为回文数
    public long toReverseNum2(String n){
        if(n.equals("9")) return 11;
        int sub = (n.length() & 1) == 1?n.length() / 2 + 1:n.length() / 2;
        int len = n.length() - sub;
        String left = n.substring(0, sub);
        long leftNum = Integer.parseInt(left);
        left = "" + (leftNum + 1);
        String right = "";
        for(int i=0;i<len;i++){
            right = left.charAt(i) + right;
        }
        return Long.parseLong(left + right);
    }

    // 2.取字符串前半段，转为数字以后-1，在改为回文数
    public long toReverseNum3(String n){
//        int sub = n.length() / 2 + 1;
        int sub = (n.length() & 1) == 1?n.length() / 2 + 1:n.length() / 2;
        int len = n.length() - sub;
        String left = n.substring(0, sub);
        if(left.equals("1") && len > 0) return 9;
        long leftNum = Integer.parseInt(left);
        left = "" + (leftNum - 1);
        String right = "";
        if(left.length() == sub) {
            for (int i = 0; i < len; i++) {
                right = left.charAt(i) + right;
            }
        }else{
            for (int i = 0; i < len; i++) {
                right = "9" + right;
            }
        }
        return Long.parseLong(left + right);
    }


}
