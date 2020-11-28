package ceshi;

public class t3 {
    public static void main(String args[]){
        boolean[][] a = {{true,true,true,true,true},
                            {true,true,true,true,false},
                            {true,true,true,true,true},
                            {true,true,true,true,true},
                            {true,true,true,true,true}};
        t3 t = new t3();
        t.findRoad(a);
    }

    private void findRoad(boolean[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]){
                    int[][] road = new int[arr.length * arr.length][2];
                    for(int x=0;x<road.length;x++) {
                        road[x][0] = -1;
                        road[x][1] = -1;
                    }
                    road[0][0] = i;
                    road[0][1] = j;
                    road = next(road[0],road,1, arr);
                    if(road != null){
                        System.out.print("road = ");
                        printArray(road);
                    }else{
                        System.out.println("无解！！！");
                    }
                }
            }
        }

    }

    private int[][] next(int[] point,int[][] road,int index,boolean[][] arr){
//        System.out.println("point = ["+point[0]+", "+point[1]+"]");
//        System.out.println("index = "+index);
//        System.out.print("road = ");
//        printArray(road);
        int[] next1 = {point[0] - 1, point[1]};
        int[] next2 = {point[0] + 1, point[1]};
        int[] next3 = {point[0], point[1] - 1};
        int[] next4 = {point[0], point[1] + 1};
        int[][] next = {next1, next2, next3, next4};
//        System.out.print("next = ");
//        printArray(next);
        for(int i=0;i<next.length;i++){
            if((next[i][0] < 0) || (next[i][1] >= arr.length) || (next[i][1] < 0) || (next[i][0] >= arr.length)){
                continue;
            }else if(search(next[i], road)){
                continue;
            }else{
                if (arr[next[i][0]][next[i][1]]) {
                    road[index] = next[i];
                    int tempIndex = index + 1;
                    next(next[i], road, tempIndex, arr);
                }else{
                    continue;
                }
            }
        }
        road = trimArray(road);
//        printArray(road);
        if(road.length == ((arr.length * arr.length) - 1)){
            return road;
        }else{
           return null;
        }
    }

    // 去除数组的0元素
    private int[][] trimArray(int[][] arr){
        int[][] tempArr = new int[arr.length][2];
        int index = 0;
        for (int i=0;i<arr.length;i++){
            int[] v = arr[i];
            if(v[0] != -1 && v[1] != -1){
                tempArr[index] = v;
                index++;
            }
        }
        int[][] resultArr = new int[index][2];
        for (int i=0;i<resultArr.length;i++){
            resultArr[i] = tempArr[i];
        }
        return resultArr;
    }

    private boolean search(int[] point, int[][]arr){
        for(int[] x:arr){
            if((x[0] == point[0]) && (x[1] == point[1])){
                return true;
            }
        }
        return false;
    }

    public void printArray(int [][] arr){
        System.out.print("[");
        for (int i = 0; i< arr.length; i++) {
            System.out.print("[");
            for (int j=0; j < arr[i].length; j++) {
                if(j == (arr[i].length - 1)){
                    System.out.print(arr[i][j]);
                }else {
                    System.out.print(arr[i][j] + ", ");
                }
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
}
