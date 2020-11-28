package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

 任何左括号 ( 必须有相应的右括号 )。
 任何右括号 ) 必须有相应的左括号 ( 。
 左括号 ( 必须在对应的右括号之前 )。
 * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 一个空字符串也被视为有效字符串。
 */
public class T678 {

    public static void main(String args[]){

        T678 t = new T678();
        System.out.println(t.checkValidString("()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))"));
    }

    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.empty()){
                    if(list.size() <= 0) {
                        return false;
                    }else{
                        list.remove(0);
                    }
                }else{
                    stack.pop();
                }
            }else{
                list.add(i);
            }
        }


        while(!stack.empty()){
            if(list.size() == 0){
                return false;
            }
            if(list.get(list.size() - 1) > stack.peek()){
                stack.pop();
                list.remove(list.size() - 1);
            }else{
                return false;
            }
        }
        return true;
    }
}
