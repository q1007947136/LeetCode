package easy;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class T9 {
    public static void main(String args[]){

        String []input1 = {"LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int [][] input2 = {{10,0},{10,13},{3,17},{6,11},{10,5},{9,10},{13,0},{2,19},{2,0},{3,0},{5,25},{8,0},{9,22},{5,5},{1,30},{11,0},{9,12},{7,0},{5,0},{8,0},{9,0},{4,30},{9,3},{9,0},{10,0},{10,0},{6,14},{3,1},{3,0},{10,11},{8,0},{2,14},{1,0},{5,0},{4,0},{11,4},{12,24},{5,18},{13,0},{7,23},{8,0},{12,0},{3,27},{2,12},{5,0},{2,9},{13,4},{8,18},{1,7},{6,0},{9,29},{8,21},{5,0},{6,30},{1,12},{10,0},{4,15},{7,22},{11,26},{8,17},{9,29},{5,0},{3,4},{11,30},{12,0},{4,29},{3,0},{9,0},{6,0},{3,4},{1,0},{10,0},{3,29},{10,28},{1,20},{11,13},{3,0},{3,12},{3,8},{10,9},{3,26},{8,0},{7,0},{5,0},{13,17},{2,27},{11,15},{12,0},{9,19},{2,15},{3,16},{1,0},{12,17},{9,1},{6,19},{4,0},{5,0},{5,0},{8,1},{11,7},{5,2},{9,28},{1,0},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};

        LFUCache lFUCache = null;
        for(int i = 0;i<input1.length;i++){
            switch (input1[i]){
                case "LFUCache":
                    lFUCache = new LFUCache(input2[i][0]);
//                    System.out.println("init:size = "+input2[i][0]);
                    break;
                case "put":
                    lFUCache.put(input2[i][0], input2[i][1]);
//                    System.out.println("put:"+input2[i][0]+","+ input2[i][1]);
//                    lFUCache.to_string();
                    break;
                case "get":
                    int v = lFUCache.get(input2[i][0]);
                    System.out.println("get "+input2[i][0]+"=> "+v);
//                    lFUCache.to_string();
                    break;
                default:
                        break;
            }
        }
    }

    static class LFUCache {
        int capacity;
        int createTime = 0;
        HashMap<Integer, int[]> map;// 记录键值对


        public LFUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.get(key) != null){
                int []value = map.get(key);
                value[1] += 1;
                value[2] = this.createTime;
                this.createTime++;
                map.put(key, value);
                return value[0];
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(this.capacity == 0){
                return;
            }
            if(map.get(key) == null && map.size() >= this.capacity){
                int delKey = -1;
                int callTime = Integer.MAX_VALUE;
                int createTime = -1;
                for(Map.Entry<Integer, int[]> m:map.entrySet()){
                    int k = m.getKey();
                    int []v = m.getValue();
                    if(v[1] < callTime){
                        callTime = v[1];
                        createTime = v[2];
                        delKey = k;
                    }else if(v[1] == callTime && v[2] < createTime){
                        createTime = v[2];
                        delKey = k;
                    }
                }
                map.remove(delKey);
            }
            if(map.get(key) != null){
                int[] saveValue = map.get(key);
                saveValue[0] = value;
                saveValue[1] += 1;
                saveValue[2] = this.createTime;
                this.createTime++;
                map.put(key, saveValue);
            }else {
                int[] saveValue = {value, 0, this.createTime};
                map.put(key, saveValue);
                this.createTime++;
            }
        }

        public void to_string(){
            if(map.size() == 0){
                System.out.println("map is empty!!");
            }else {
                for (Map.Entry<Integer, int[]> m : map.entrySet()) {
                    int k = m.getKey();
                    int[] v = m.getValue();
                    System.out.println("key:" + k + ";value:" + v[0] + ";call:" + v[1] + ";callTime:" + v[2]);
                }
            }
        }
    }

}
