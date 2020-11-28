package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。

 丑数就是质因数只包含 2, 3, 5 的正整数。
 */
public class T264 {
    public static void main(String args[]){
        System.out.println(nthUglyNumber(11));
    }

    public static int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int start = 1;
        while(set.size() < n){
            start++;
            if(start % 2 == 0 && start % 3 == 0 && start % 5 == 0){
                set.add(start);
            }
        }
        return start;
    }
}
