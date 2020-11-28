package easy;

import java.util.*;

/**
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。

 每个 LED 代表一个 0 或 1，最低位在右侧。
 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

 */
public class T401 {
    public static void main(String args[]){
        readBinaryWatch(6);
    }

    /*
    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if(num > 8) return list;
        for(int i=0;i<12;i++){
            int light1 = getCount1(i);
            int light2 = num - light1;
            for(int j=0;j<60;j++){
                if(getCount1(j) == light2){
                    String jstr = j+"";
                    if(jstr.length() == 1){
                        jstr = 0+jstr;
                    }
                    list.add(i + ":" + jstr);
                    System.out.println(i + ":" + jstr);
                }
            }
        }
        return list;
    }
    */

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if(num > 8) return list;
        Map<Integer, Set<String>> mapH = new HashMap<>();
        Map<Integer, Set<String>> mapM = new HashMap<>();
        for(int i=0;i<12;i++){
            int light = getCount1(i);
            Set<String> set = mapH.get(light);
            if(set!=null){
                if(!set.contains(i+"")){
                    set.add(i+"");
                }
            }else{
                set = new HashSet<>();
                set.add(i+"");
                mapH.put(light, set);
            }
        }
        for(int i=0;i<60;i++){
            int light = getCount1(i);
            Set<String> set = mapM.get(light);
            String minStr = i+"";
            minStr = (minStr.length() == 1)?0+minStr:minStr;
            if(set!=null){
                if(!set.contains(minStr)){
                    set.add(minStr);
                }
            }else{
                set = new HashSet<>();
                set.add(minStr);
                mapM.put(light, set);
            }
        }
        int len = Math.min(3, num);
        for(int i=0;i<=len;i++){
            int light = num - i;
            Set<String> setH = mapH.get(i);
            Set<String> setM = mapM.get(light);
            if(setH!=null && setM!=null) {
                for (String h : setH) {
                    for (String m : setM) {
                        list.add(h + ":" + m);
                        System.out.println(h + ":" + m);
                    }
                }
            }
        }

        return list;
    }

    public static int getCount1(int num){
        int count = 0;
        while(num > 0){
            num &= num - 1;
            count++;
        }
        return count;
    }

}
