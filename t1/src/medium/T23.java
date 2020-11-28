package medium;

import java.util.*;

/**
 * 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。

 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 */
public class T23 {

    public static void main(String args[]){
        T23 t = new T23();
        StockSpanner ss = t.new StockSpanner();
        int[] a = {100, 80, 60, 70, 60, 75, 85};
        for(int x:a){
            System.out.print(ss.next(x) + ", ");
        }
    }

    class StockSpanner {

//        List<Integer> list;
//        Map<Integer, Integer> map;
        Stack<Integer> prices; // 存价格
        Stack<Integer> length; // 存长度
        public StockSpanner() {
//            list = new ArrayList<>();
//            map = new HashMap<>();
            prices = new Stack<>();
            length = new Stack<>();

        }

        public int next(int price) {
            // 方法1 5%
//            int len = 1;
//            for(int i=list.size() - 1;i>=0;i--){
//                if(list.get(i)<=price){
//                    len++;
//                }else{
//                    break;
//                }
//            }
//            list.add(price);
//            return len;

            // 方法2 31%
//            int index = list.size() - 1;
//            if(index == -1){
//                list.add(price);
//                map.put(list.size() - 1, 1);
//                return 1;
//            }
//            int len = 1;
//            if(price >= list.get(index)) {
//                len += map.get(index);
//                int nextIndex = index - map.get(index);
//                if(nextIndex < 0){
//                    list.add(price);
//                    map.put(list.size() - 1, len);
//                }else {
//                    boolean flag = true;
//                    for (int i = nextIndex; i >= 0; i--) {
//                        if (list.get(i) <= price) {
//                            len++;
//                        } else {
//                            flag = false;
//                            list.add(price);
//                            map.put(list.size() - 1, len);
//                            break;
//                        }
//                    }
//                    if (flag) {
//                        list.add(price);
//                        map.put(list.size() - 1, len);
//                    }
//                }
//            }else{
//                list.add(price);
//                map.put(list.size() - 1, len);
//            }
//            return len;

            // 方法3 栈 73%
            int len = 1;
            while(!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                len += length.pop();
            }
            prices.push(price);
            length.push(len);
            return len;
        }
    }
}
