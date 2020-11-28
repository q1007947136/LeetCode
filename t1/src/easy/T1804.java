package easy;

/**
 * 面试题 05.07. 配对交换
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 */
public class T1804 {

    public static void main(String args[]){
        System.out.println(exchangeBits(1));
    }

    public static int exchangeBits(int num) {

        return (num & 0x55555555) << 1 | (num & 0xaaaaaaaa) >> 1;
    }
}
