package easy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 866. 回文素数
 * 求出大于或等于 N 的最小回文素数。
 * // 1 <= N <= 10^8
 * 做法：先找出大于N的最小回文数，然后判断是否为质数(麻烦得一逼，做起来心态都崩了)
 */

public class T16_undone {

    public static void main(String args[]){
        T16_undone t = new T16_undone();
        Solution s = t.new Solution();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while(N != 0) {
            System.out.println(s.primePalindrome(N));
            N = scanner.nextInt();
        }
    }

    class Solution {
        ArrayList<Integer> HuiWenSuShu;

        public Solution(){
            HuiWenSuShu = new ArrayList<>();
            HuiWenSuShu.add(2);
        }

        public int primePalindrome(int N) {
            int Num;
            int index = HuiWenSuShu.size() - 1;
            if(HuiWenSuShu.get(index) == 2){
                Num = 3;
            }else{
                Num = HuiWenSuShu.get(index) + 2;
            }
            if(Num > N) {
                int result = 0;
                while (index >= 0) {
                    if (HuiWenSuShu.get(index) > N) {
                        result = HuiWenSuShu.get(index);
                        index -= 1;
                    } else {
                        return HuiWenSuShu.get(index);
                    }
                }
                return result;
            }else if(Num == N){
                return N;
            }else {
                while (true) {
                    if (isHuiWen(Num)) {
                        if (isSuShu(Num)) {
                            HuiWenSuShu.add(Num);
                            if (Num >= N) {
                                break;
                            }
                        }
                    }
                    Num += 2;
                }
                return Num;
            }
        }

//        public int findNextHuiwen(int N){
//            String numS = Integer.toString(N);
//            if((numS.length() & 1) == 0){
//
//            }else{
//                char[] cArr =  numS.toCharArray();
//                for(int i=0;i<cArr.length/2;i++){
//                    if(Integer.parseInt(String.valueOf(cArr[i])) > Integer.parseInt(String.valueOf(cArr[numS.length() - 1 - i]))){
//                        cArr[numS.length() - 1 - i] = cArr[i];
//                    }else if(Integer.parseInt(String.valueOf(cArr[i])) < Integer.parseInt(String.valueOf(cArr[numS.length() - 1 - i]))){
//                        cArr[numS.length() - 1 - i] = cArr[i];
//
//                    }
//                }
//            }
//
//        }

        public boolean isSuShu(int num){
            for(int i=2;i<=num/2;i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }

        public boolean isHuiWen(int num){
            String numS = Integer.toString(num);
            for(int i=0;i<numS.length()/2;i++){
                if(numS.charAt(i) != numS.charAt(numS.length() - 1 - i)){
                    return false;
                }
            }
            return true;
        }

    }
}
