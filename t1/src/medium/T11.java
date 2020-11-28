package medium;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器。
 */
public class T11 {
    public static void main(String args[]){
        int[] a = {1,8,6,2,5,4,8,3,7};
        T11 t = new T11();
        int result = t.maxArea(a);
        System.out.println("result = "+result);
    }

    public int maxArea(int[] height) {
        int left = height[0];
        int leftIndex = 0;
        int right = height[height.length - 1];
        int rightIndex = height.length - 1;
        int w = rightIndex - leftIndex;
        int h = Math.min(left, right);
        int area = w * h;
        while (rightIndex > leftIndex){
            if(left > right){
                rightIndex = rightIndex - 1;
                right = height[rightIndex];
                h = Math.min(left, right);
            }else{
                leftIndex = leftIndex + 1;
                left = height[leftIndex];
                h = Math.min(left, right);
            }
            w = rightIndex - leftIndex;
            if((w * h) > area){
                area = w * h;
            }

        }
        return area;
    }
}
