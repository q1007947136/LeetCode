package easy;

import java.util.ArrayList;

/**
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。

 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。

 构造函数会传入一个stackSize参数，代表每个栈的大小。
 */
public class T13 {

    public static void main(String args[]){
        String []input1 = {"TripleInOne", "peek", "pop", "isEmpty", "push", "pop", "push", "push", "pop", "push", "push", "isEmpty", "pop", "peek", "push", "peek", "isEmpty", "peek", "pop", "push", "isEmpty", "pop", "peek", "peek", "pop", "peek", "isEmpty", "pop", "push", "isEmpty", "peek", "push", "peek", "isEmpty", "isEmpty", "isEmpty", "isEmpty", "peek", "push", "push", "peek", "isEmpty", "peek", "isEmpty", "push", "push", "push", "peek", "peek", "pop", "push", "push", "isEmpty", "peek", "pop", "push", "peek", "peek", "pop", "isEmpty", "pop", "peek", "peek", "push", "push"};
        int [][] input2 = {{18,0}, {1,0}, {2,0}, {1,0}, {2, 40}, {2,0}, {0, 44}, {1, 40}, {0,0}, {1, 54}, {0, 42}, {0,0}, {1,0}, {1,0}, {0, 56}, {2,0}, {0,0}, {2,0}, {2,0}, {1, 15}, {1,0}, {1,0}, {0,0}, {2,0}, {0,0}, {0,0}, {1,0}, {0,0}, {0, 32}, {0,0}, {0,0}, {0, 30}, {2,0}, {1,0}, {1,0}, {0,0}, {0,0}, {0,0}, {0, 56}, {1, 40}, {2,0}, {0,0}, {0,0}, {0,0}, {2, 11}, {0, 16}, {0, 3}, {2,0}, {0,0}, {2,0}, {0, 39}, {0, 63}, {1,0}, {2,0}, {0,0}, {2, 36}, {1,0}, {0,0}, {2,0}, {1,0}, {0,0}, {1,0}, {2,0}, {0, 8}, {0, 38}};

        T13 t = new T13();
        TripleInOne triple = null;
        for(int i = 0;i<input1.length;i++){
            switch (input1[i]){
                case "TripleInOne":
                    triple = t.new TripleInOne(input2[i][0]);
                    System.out.println("init:size = "+input2[i][0]);
                    break;
                case "push":
                    triple.push(input2[i][0], input2[i][1]);
                    System.out.println("push:"+input2[i][0]+","+ input2[i][1]);
                    break;
                case "pop":
                    int v = triple.pop(input2[i][0]);
                    System.out.println("pop "+input2[i][0]+"=> "+v);
                    break;
                case "isEmpty":
                    boolean bool = triple.isEmpty(input2[i][0]);
                    System.out.println("isEmpty "+input2[i][0]+"=> "+bool);
                    break;
                case "peek":
                    int p = triple.peek(input2[i][0]);
                    System.out.println("peek "+input2[i][0]+"=> "+p);
                    break;
                default:
                    break;
            }
        }

    }

    class TripleInOne {
        int stackSize = 0;
        ArrayList<ArrayList<Integer>> List;

        public TripleInOne(int stackSize) { // 理解半天原来是所有的栈大小都是这个
            this.stackSize = stackSize;
            List = new ArrayList<>();
            for(int i=0;i<3;i++){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                List.add(l);
            }
        }

        public void push(int stackNum, int value) {
            ArrayList<Integer> l = List.get(stackNum);
            if(l.size()<this.stackSize + 1){
                l.add(value);
            }
//            if(List.size() - 1 < stackNum){
//                ArrayList<Integer> l = new ArrayList<>();
//                l.add(stackNum);
//                l.add(value);
//                List.add(l);
//            }else{
//                ArrayList<Integer> l = List.get(stackNum);
//                if(l.size()<this.stackSize + 1){
//                    l.add(value);
//                }
//            }
        }

        public int pop(int stackNum) {
            ArrayList<Integer> l = List.get(stackNum);
            if(l.size() <= 1){
                return -1;
            }else{
                int v = l.get(l.size() - 1);
                l.remove(l.size() - 1);
                return v;
            }
//            if(List.size() - 1 < stackNum){
//                return -1;
//            }else{
//                ArrayList<Integer> l = List.get(stackNum);
//                if(l.size() <= 1){
//                    return -1;
//                }else{
//                    int v = l.get(l.size() - 1);
//                    l.remove(l.size() - 1);
//                   return v;
//                }
//            }
        }

        public int peek(int stackNum) {
            ArrayList<Integer> l = List.get(stackNum);
            if(l.size() <= 1){
                return -1;
            }else{
                return l.get(l.size() - 1);
            }
//            if(List.size() - 1 < stackNum){
//                return -1;
//            }else{
//                ArrayList<Integer> l = List.get(stackNum);
//                if(l.size() <= 1){
//                    return -1;
//                }else{
//                    return l.get(l.size() - 1);
//                }
//            }
        }

        public boolean isEmpty(int stackNum) {
            ArrayList<Integer> l = List.get(stackNum);
            return l.size() <= 1;
//            if(List.size() - 1 < stackNum){
//                return true;
//            }else{
//                ArrayList<Integer> l = List.get(stackNum);
//                return l.size() <= 1;
//            }
        }
    }

}
