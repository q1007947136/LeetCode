package easy;

/**
 * 223. 矩形面积
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 */
public class T223 {
    public static void main(String args[]){
        T223 t = new T223();
        Solution s = t.new Solution();
        int area = s.computeArea(-2,-2,2,2,-3,-3,3,-1);
        System.out.println(area);
    }

    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int area1 = (C - A) * (D - B);
            int area2 = (G - E) * (H - F);
            if(area1 == 0){
                return area2;
            }
            if(area2 == 0){
                return area1;
            }
            int width = 0;
            int length = 0;
            if(E <= A && A < G && E < C && C <= G){
                length = C - A;
            }else if(A <= E && E < C && A < G && G <= C){
                length = G - E;
            }else if(E <= A && A < G){
                length = G - A;
            }else if(A <= E && E < C){
                length = C - E;
            }else if(E < C && C <= G){
                length = C - E;
            }else if(A < G && G <= C){
                length = G - A;
            }
            if(F <= B && B < H && F < D && D <= H){
                width = D - B;
            }else if(B <= F && F < D && B < H && H <= D){
                width = H - F;
            }else if(F <= B && B < H){
                width = H - B;
            }else if(F < D && D <= H){
                width = D - F;
            }else if(B <= F && F < D){
                width = D - F;
            }else if(B < H && H <= D){
                width = H - B;
            }
            int area3 = width * length;
            return area1 + area2 - area3;
        }
    }
}


