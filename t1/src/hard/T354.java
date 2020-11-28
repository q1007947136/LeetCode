package hard;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

 说明:
 不允许旋转信封。

 */

import java.util.*;

public class T354 {
    public static void main(String args[]){
//        int a[][] = {{8,3},{8,4},{8,8},{3,20},{3,12},{3,4},{15,5},{11,2},{19,6},{9,18},{1,19},{13,3},{14,20},{6,7}}; //[[11, 2][13, 3][15, 5][19, 6]]
//        int a[][] = {{46,89},{50,53},{52,68},{72,45},{77,81}}; // [[50, 53][52, 68][77, 81]]
//        int a[][] = {{5,4},{6,4},{6,7},{2,3}}; //[[2, 3][5, 4][6, 7]]
//        int a[][] = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};// [[2, 100][3, 200][4, 300][6, 370][7, 380]]
//        int a[][] = {{17,15},{17,18},{2,8},{7,2},{17,2},{17,8},{6,15}};// [[2, 8][6, 15][17, 18]]
//        int a[][] = {{39,32},{44,48},{4,31},{29,34},{16,18},{30,3},{25,43},{28,8},{9,20},{27,10},{10,36},
//                     {17,33},{38,23},{8,2},{44,22},{12,9},{12,22},{33,5},{49,17},{1,43},{39,43},{29,4},{40,33},
//                     {47,35},{28,44},{43,48},{42,38},{29,43},{28,31},{45,12},{38,7},{1,46},{42,25},{18,33},{11,38},
//                     {43,33},{2,43},{2,32},{4,1},{1,40},{50,41},{10,38},{4,43},{19,39},{42,46}};// [[4, 1][8, 2][9, 20][10, 36][11, 38][19, 39][25, 43][28, 44][42, 46][44, 48]]
//        int a[][] ={{1,1}};
//        int a[][] = {{30,50},{12,2},{3,4},{12,15}};
        int a[][] = {{856,533},{583,772},{980,524},{203,666},{987,151},{274,802},{982,85},{359,160},{58,823},{512,381},
                {796,655},{341,427},{145,114},{76,306},{760,929},{836,751},{922,678},{128,317},{185,953},{115,845},
                {829,991},{93,694},{317,434},{818,571},{352,638},{926,780},{819,995},{54,69},{191,392},{377,180},
                {669,952},{588,920},{335,316},{48,769},{188,661},{916,933},{674,308},{356,556},{350,249},{686,851},
                {600,178},{849,439},{597,181},{80,382},{647,105},{4,836},{901,907},{595,347},{214,335},{956,382},{77,979},
                {489,365},{80,220},{859,270},{676,665},{636,46},{906,457},{522,769},{2,758},{206,586},{444,904},{912,370},
                {64,871},{59,409},{599,238},{437,58},{309,767},{258,440},{922,369},{848,650},{478,76},{84,704},{314,207},
                {138,823},{994,764},{604,595},{537,876},{877,253},{945,185},{623,497},{968,633},{172,705},{577,388},
                {819,763},{409,905},{275,532},{729,593},{547,226},{445,495},{398,544},{243,500},{308,24},{652,452},{93,885},
                {75,884},{243,113},{600,555},{756,596},{892,762},{402,653},{916,975},{770,220},{455,579},{889,68},{306,899},
                {567,290},{809,653},{92,329},{370,861},{632,754},{321,689},{190,812},{88,701},{79,310},{917,91},{751,480},
                {750,39},{781,978},{778,912},{946,559},{529,621},{55,295},{473,748},{646,854},{930,913},{116,734},{647,812},
                {426,172},{122,14},{522,843},{88,308},{719,602},{712,928},{303,890},{973,886},{276,354},{660,720},{708,387},
                {776,605},{653,815},{448,285},{549,959},{139,365},{74,952},{372,424},{642,504},{361,901},{620,612},{313,301},
                {397,225},{446,716},{17,361},{160,812},{171,529},{180,482},{454,600},{228,872},{204,492},{607,889},{86,79},
                {494,78},{442,404},{462,127},{935,402},{509,649},{458,941},{219,444},{306,57},{674,617},{79,652},{73,735},
                {900,756},{649,294},{982,754},{521,439},{356,265},{240,533},{865,44},{744,379},{97,454},{65,480},{544,191},
                {18,191},{503,38},{696,658},{61,884},{793,984},{383,364},{280,467},{888,662},{133,643},{365,512},{610,975},
                {98,584},{40,177},{548,102},{80,98},{986,951},{264,258},{583,734},{353,322},{427,551},{80,660},{273,609},
                {980,871},{739,802},{366,836},{55,509},{889,720},{857,661},{48,489},{119,26},{31,180},{472,673},{960,951},
                {383,500},{928,351},{848,705},{969,766},{311,714},{861,230},{34,596},{38,642},{1,955},{698,846},{784,791},
                {760,344},{677,239},{969,191},{539,644},{470,418},{289,357},{269,446},{668,245},{293,719},{937,103},
                {575,297},{874,656},{714,257},{934,396},{109,904},{89,635},{374,545},{316,587},{158,121},{901,969},
                {284,564},{666,568},{993,409},{370,637},{443,694},{576,160},{262,357},{590,729},{194,976},{743,376},
                {348,80},{669,527},{338,953},{236,785},{144,460},{438,457},{517,951},{545,647},{158,556},{905,591},
                {793,609},{571,643},{9,850},{581,490},{804,394},{635,483},{457,30},{42,621},{65,137},{424,864},{536,455},
                {59,492},{645,734},{892,571},{762,593},{608,384},{558,257},{692,420},{973,203},{531,51},{349,861},{804,649},
                {3,611},{6,468},{298,568},{651,767},{251,142},{173,974},{117,728},{326,562},{894,288},{814,555},{420,771},
                {20,775},{445,247},{243,592},{186,173},{101,800},{590,876},{515,534},{73,540},{333,215},{902,394},{640,787},
                {596,298},{984,712},{307,378},{540,646},{473,743},{340,387},{756,217},{139,493},{9,742},{195,25},{763,823},
                {451,693},{24,298},{645,595},{224,770},{976,41},{832,78},{599,705},{487,734},{818,134},{225,431},{380,566},
                {395,680},{294,320},{915,201},{553,480},{318,42},{627,94},{164,959},{92,715},{588,689},{734,983},{976,334},
                {846,573},{676,521},{449,69},{745,810},{961,722},{416,409},{135,406},{234,357},{873,61},{20,521},{525,31},
                {659,688},{424,554},{203,315},{16,240},{288,273},{281,623},{651,659},{939,32},{732,373},{778,728},{340,432},
                {335,80},{33,835},{835,651},{317,156},{284,119},{543,159},{719,820},{961,424},{88,178},{621,146},{594,649},
                {659,433},{527,441},{118,160},{92,217},{489,38},{18,359},{833,136},{470,897},{106,123},{831,674},{181,191},
                {892,780},{377,779},{608,618},{618,423},{180,323},{390,803},{562,412},{107,905},{902,281},{718,540},{16,966},
                {678,455},{597,135},{840,7},{886,45},{719,937},{890,173}};

                T354 test = new T354();
        System.out.print("init:");
        test.printArray(a);
//        int max = test.maxEnvelopes(a);
//        System.out.println("max:"+max);
//        test.select4(a);
//        test.select5(a);
//        test.select6(a);
//        test.select7(a);
//        test.select8(a);

//        a = test.mergeSort(a);
//        test.printArray(a);

        long starTime = System.currentTimeMillis();
        test.select9(a);
        long endTime = System.currentTimeMillis();
        System.out.println("select9执行耗时"+(endTime - starTime)+"ms!");
//        test.select10(a);
        long starTime1 = System.currentTimeMillis();
        test.select11(a);
        long endTime1 = System.currentTimeMillis();
        System.out.println("select11执行耗时"+(endTime1 - starTime1)+"ms!");
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

    public void printArray1(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public void printArray2(int [][][] arr){
        System.out.print("[");
        for (int i = 0; i< arr.length; i++) {
            printArray(arr[i]);
        }
        System.out.println("]");
    }


    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }else{
            Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
            int[] lenArr = new int[envelopes.length];
            int max = 1;
            Arrays.fill(lenArr, 1);
            for(int i=1;i<envelopes.length;i++){
                for(int j=0;j<i;j++){
                    if((envelopes[i][0] > envelopes[j][0]) && (envelopes[i][1] > envelopes[j][1])){
                        if(lenArr[j] >= lenArr[i]){
                            lenArr[i] = lenArr[j] + 1;
                        }
                    }
                }
                if(lenArr[i] > max){
                    printArray1(envelopes[i]);
                    max = lenArr[i];
                }
            }
            return max;
        }
    }

    private int findElement(int[] e, int[][] arr, int len, int max){
        for(int i=0;i<arr.length;i++){
            int newLen;
            if((e[0] < arr[i][0]) && (e[1] < arr[i][1])){
                newLen = len + 1;
                if(newLen > max){
                    max = newLen;
                }
                max = findElement(arr[i], arr, newLen, max);
            }
        }
        return max;
    }

    private void sort(int[][] envelopes){
        for (int i = 0; i< envelopes.length; i++) {
            for (int j=0; j < envelopes.length - 1; j++) {
                if(envelopes[j][1] < envelopes[j + 1][1]){
                    int[] temp = envelopes[j];
                    envelopes[j] = envelopes[j + 1];
                    envelopes[j + 1] = temp;
                }
            }
        }
    }


    public int select2(int[][] arrx, int[][] result){
        int acc = 1;
        for(int i=0;i<arrx.length;i++){
            int temp = 1;
            int[] value1 = arrx[i];
            int[][] tempArr = new int[arrx.length][2];
            tempArr[0] = value1;
            for (int j=(i + 1);j<arrx.length;j++){
                int[] value2 = arrx[j];
                if((value1[1] < value2[1]) && (value1[0] != value2[0])){
                    boolean flag = true;
                    for(int x = 0;x<tempArr.length;x++){
                        int[] check = tempArr[x];
                        if(check[0] == value2[0]){ //当x相等时，优先选择所有相同y值中较少的
                            int checkCount = countOfY(check[1], arrx);
                            int valueCount = countOfY(value2[1], arrx);
                            if(checkCount > valueCount){
                                tempArr[x] = value2;
                            }
                            flag = false;
                            break;
                        }
                        if(check[1] >= value2[1]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        tempArr[temp] = value2;
                        temp++;
                    }
                }
            }
            if(temp > acc){
                result = tempArr;
                acc = temp;
            }
        }
        printArray(result);
        return acc;
    }

    public int countOfY(int y, int[][] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int[] v = arr[i];
            if(v[1] == y){
                count++;
            }
        }
        return count;
    }


    private int select3(int[][] arr,int width, int max){
        for(int i=0;i<arr.length;i++){
            int[] v1 = arr[i];
            int[][] set = new int[arr.length][2];
            int index = 0;
            for(int j=0;j<arr.length;j++){
                int[] v2 = arr[j];
                if((v2[0] > v1[0]) && (v2[1] > v1[1])){
                    set[index] = v2;
                    index++;
                }
            }
            int[][] newSet = trimArray(set);
            if(newSet.length != 0){
//                System.out.print("[" + v1[0] + ", " + v1[1] + "]的newSet:");
                System.out.println("[" + v1[0] + ", " + v1[1] + "]下一级个数:"+newSet.length);
//                printArray(newSet);
                if((width + 1) > max) {
                    max = select3(newSet, width + 1, width + 1);
                }else{
                    max = select3(newSet, width + 1, max);
                }
            }

        }
        return max;
    }

    private int select4(int[][] arr){
        int[][] count = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            int[] v1 = arr[i];
            int index = 0;
            for(int j=0;j<arr.length;j++){
                int[] v2 = arr[j];
                if((v2[0] > v1[0]) && (v2[1] > v1[1])){
                    index++;
                }
            }
            count[i][0] = i;
            count[i][1] = index;
        }
        System.out.print("count:");
        printArray(count);
        sort(count);
        System.out.print("count:");
        printArray(count);
        int[][] newArr = new int[arr.length][2];
        for(int i=0;i<count.length;i++){//重排序
            int index = count[i][0];
            newArr[i] = arr[index];
        }
        System.out.print("newArr:");
        printArray(newArr);
        int[][] result = new int[newArr.length][2];
        result[0] = newArr[0];
        int resultIndex = 0;
        for(int i=1;i<newArr.length;i++){
            System.out.println("i-1:[" + result[resultIndex][0] + ", " + result[resultIndex][1] + "]");
            System.out.println("i:[" + newArr[i][0] + ", " + newArr[i][1] + "]");
            if((result[resultIndex][0] < newArr[i][0]) && (result[resultIndex][1] < newArr[i][1])){
                resultIndex ++;
                result[resultIndex] = newArr[i];
            }
        }
        System.out.println("resultIndex:"+(resultIndex + 1));
        printArray(result);
        return resultIndex + 1;
    }

    // 去除数组的0元素
    private int[][] trimArray(int[][] arr){
        int[][] tempArr = new int[arr.length][2];
        int index = 0;
        for (int i=0;i<arr.length;i++){
            int[] v = arr[i];
            if(v[0] != 0 && v[1] != 0){
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

    // 去除数组的0元素
    private int[] trimArray2(int[] arr){
        int[] tempArr = new int[arr.length];
        int index = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                tempArr[index] = arr[i];
                index++;
            }
        }
        int[] resultArr = new int[index];
        for (int i=0;i<resultArr.length;i++){
            resultArr[i] = tempArr[i];
        }
        return resultArr;
    }

    // 去除数组的0元素
    private int[][][] trimArray3(int[][][] arr){
        for (int i=0;i<arr.length;i++){
            int[][] temp = trimArray(arr[i]);
            arr[i] = temp;
        }
        return arr;
    }

    private int select5(int[][] arr){
        MyArray[] myArrays = new MyArray[arr.length];
        for (int i=0;i<arr.length;i++){
            MyArray ma = new MyArray();
            ma.setIndex(i);
            int[] child = new int[arr.length];
            int index = 0;
            System.out.print("["+arr[i][0]+","+arr[i][1]+"] child => [");
            for (int j=0;j<arr.length;j++){
                if((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])){
                    System.out.print("["+arr[j][0]+","+arr[j][1]+"]");
                    child[index] = j + 1;// 数组默认值为0，为了保存的值不为0，这里+1，使用的时候应当-1
                    index++;
                }
            }
            System.out.println("]");
//            printArray1(child);
//            printArray1(trimArray2(child));
            ma.setChild(trimArray2(child));
            myArrays[i] = ma;
        }
        printMyArray(myArrays);
        myArrays = sortArr(myArrays);
        int max = finalSort(arr, myArrays);
        return max;
    }

    private void printMyArray(MyArray[] myArrays){
        for (int i=0;i<myArrays.length;i++){
            if(myArrays[i] != null) {
                System.out.println(myArrays[i].toString());
            }
        }
    }

    private int finalSort(int[][] arr, MyArray[] myArrays){
        int[][] result = new int[arr.length][2];
        result[0] = arr[myArrays[0].getIndex()];
        int resultIndex = 0;
        for(int i=1;i<myArrays.length;i++){
//            System.out.println("i-1:[" + result[resultIndex][0] + ", " + result[resultIndex][1] + "]");
//            System.out.println("i:[" + arr[myArrays[i].getIndex()][0] + ", " + arr[myArrays[i].getIndex()][1] + "]");
            if((result[resultIndex][0] < arr[myArrays[i].getIndex()][0]) && (result[resultIndex][1] < arr[myArrays[i].getIndex()][1])){
                resultIndex ++;
                result[resultIndex] = arr[myArrays[i].getIndex()];
            }
        }
        System.out.println("resultIndex:"+(resultIndex + 1));
        printArray(result);
        return resultIndex + 1;
    }

    private MyArray[] sortArr(MyArray[] arr){
        for (int i = 0; i< arr.length; i++) {
            for (int j=0; j < arr.length - 1; j++) {
                MyArray[] result = compare(arr, arr[j], arr[j+1]);
                arr[j] = result[1];
                arr[j + 1] = result[0];
//                System.out.println("sort:");
//                printMyArray(arr);
            }
        }
        return arr;
    }

    private MyArray[] compare(MyArray[] arr,MyArray ma1,MyArray ma2){//ma1 < ma2时交换位置
        MyArray[] mArr = new MyArray[2];
//        System.out.println("compare:");
//        System.out.println(ma1.toString());
//        System.out.println(ma2.toString());
        if(ma1.getChild().length < ma2.getChild().length){//ma2 > ma1
            mArr[0] = ma1;
            mArr[1] = ma2;
        }else if((ma1.getChild().length == 0) && (ma2.getChild().length == 0)){// ma2 = ma1
            mArr[0] = ma2;
            mArr[1] = ma1;
        }else if(ma1.getChild().length == ma2.getChild().length){// 后代数量相等，则比较各自后代的后代
            MyArray child1 = getMaxOfChild(arr,ma1.getChild());
            MyArray child2 = getMaxOfChild(arr,ma2.getChild());
            MyArray[] result = compare(arr,child1,child2);
            if(result[0].getIndex() == child1.getIndex()){//child1 < child2
                mArr[0] = ma1;
                mArr[1] = ma2;
            }else{
                mArr[0] = ma2;
                mArr[1] = ma1;
            }
        }else{// ma1 > ma2
            mArr[0] = ma2;
            mArr[1] = ma1;
        }
        return mArr;
    }

    private MyArray getMaxOfChild(MyArray[] arr,int[] child){
        MyArray ma = new MyArray();
        int max = 0;
        for(int i=0;i<child.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j].getIndex() == child[i]){
                    if(arr[j].getChild().length > max){
                        max = arr[j].getChild().length;
                        ma = arr[j];
                    }
                }
            }
        }
        return ma;
    }

    private class MyArray{
        int index;
        int[] child;
        int best;

        MyArray(){
            this.index = 0;
            this.child = new int[0];
            this.best = 0;
        }

        @Override
        public String toString() {
            String childStr = "[";
            for(int i=0;i<this.child.length;i++){
                if(i == this.child.length - 1){
                    childStr += this.child[i];
                }else {
                    childStr += this.child[i] + ",";
                }
            }
            return "index = "+this.index+",child = "+childStr+"],best = "+this.best;
        }

        public int getIndex(){
            return this.index;
        }
        public int[] getChild(){
            return child;
        }

        public int getBest() {
            return best;
        }

        public void setChild(int[] child) {
            this.child = child;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setBest(int best) {
            this.best = best;
        }
    }

    private int select6(int[][] arr){
        MyArray[] myArrays = new MyArray[arr.length];
        int ceng = 1;
        for(int i=0;i<arr.length;i++){
            MyArray ma = new MyArray();
            ma.setChild(arr[i]);
            boolean flag = false; // 最大层数是否改变
            if(i==0){
                ma.setIndex(ceng);
            }else {
                for (int j = ceng; j >= 1; j--) {
                    for (int k = 0; k < myArrays.length; k++) {
                        if (myArrays[k] != null) {
                            if (myArrays[k].getIndex() == ceng) {
                                    if ((myArrays[k].getChild()[0] < ma.getChild()[0]) && (myArrays[k].getChild()[1] < ma.getChild()[1])) {
                                        flag = true;
                                        ma.setIndex(ceng + 1);
                                        break;
                                    } else if ((myArrays[k].getChild()[0] > ma.getChild()[0]) && (myArrays[k].getChild()[1] > ma.getChild()[1])) {
                                        break;
                                    } else {
                                        ma.setIndex(ceng);
                                    }
                            }
                        }
                    }
                }
                if(flag){
                    for(int k = 0; k < myArrays.length; k++){
                        if(myArrays[k] != null) {
                            if (myArrays[k].getIndex() >= ma.getIndex()) {
                                myArrays[k].setIndex(myArrays[k].getIndex() + 1);
                            }
                        }
                    }
                }
            }
            if(flag){
                ceng++;
            }
            myArrays[i] = ma;
            System.out.println("==================");
            printMyArray(myArrays);
            System.out.println("==================");
        }
//        printMyArray(myArrays);
        System.out.println("ceng:"+ceng);
        return ceng;
    }

    private int select7(int[][] arr){
        int maxLen;
        if(arr.length == 0){
            maxLen = 0;
        }else{
            maxLen = 1;
        }
        for(int i=0;i<arr.length;i++){
            String str = "[["+arr[i][0]+", "+arr[i][1]+"]";
            int[][] bestArr = new int[arr.length][2];
            bestArr[0] = arr[i];
            maxLen = findElement(arr[i], arr, 1, maxLen, str, bestArr);
        }
        System.out.print("maxLen:"+maxLen);
        return maxLen;
    }

    private int findElement(int[] e, int[][] arr, int len, int max, String str, int[][] bestArr){
//        System.out.println("当前查找：[" + e[0] + ", " + e[1] + "]");
//        System.out.println("当前路径：" + str);
//        boolean isFind = false;
        System.out.println("start：" + max);
        for(int i=0;i<arr.length;i++){
            String newStr;
            int newLen;
            if((e[0] < arr[i][0]) && (e[1] < arr[i][1])){
                newStr = str + "[" + arr[i][0] + ", " + arr[i][1] + "]";
                newLen = len + 1;
                if(newLen > max){
                    bestArr[len - 1] = arr[i];
                    max = newLen;
//                    newStr += "]\n";
//                    System.out.print(newStr);
                }
                max = findElement(arr[i], arr, newLen, max, newStr, bestArr);
                newStr += "]\n";
                System.out.print(newStr);
//                if(!isFind) {
//                    newStr = str + "[" + arr[i][0] + ", " + arr[i][1] + "]";
//                    len = findElement(arr[i], arr, len + 1, newStr);
//                    newStr += "]\n";
//                    System.out.print(newStr);
////                    System.out.println("当前len:"+len);
//                }else{
//                    newStr = str + "[" + arr[i][0] + ", " + arr[i][1] + "]";
//                    len = findElement(arr[i], arr, len, newStr);
//                    newStr += "]\n";
//                    System.out.print(newStr);
////                    System.out.println("当前len:"+len);
//                }
//                isFind = true;//本次循环len只+1
            }
        }
//        System.out.println("[" + e[0] + ", " + e[1] + "]没有后续");
//        System.out.println("当前len:"+len);
        System.out.println("end max:"+max);
//        str += "]\n";
//        System.out.print(str);
        return max;
    }

    private int select8(int[][] arr){
        Map<int[],MyArray1> map = new HashMap<int[],MyArray1>();
        List<Integer> lenList = new ArrayList<>();
//        MyArray1[] myArrays = new MyArray1[arr.length];
        int max = 0;
        for(int i=0;i<arr.length;i++){
//            System.out.println("START");
            int len = 1;
            len = findChildre(arr, arr[i], map, len, lenList);
            if(len > max){
                max = len;
            }
        }
//        for(int i=0;i<arr.length;i++){
//            map.get(arr[i]).print();
//        }

        for (int x:lenList) {
            if(x > max){
                max = x;
            }
        }
        System.out.println("max:"+max);
//        map.get(arr[0]).print();
        return max;
    }

    private int findChildre(int[][] arr, int[] value, Map<int[],MyArray1> map, int len, List<Integer> lenList){
//        System.out.print("value:");
//        printArray1(value);
//        System.out.print("arr:");
//        printArray(arr);
        if(map.get(value) == null) {
            MyArray1 ma = new MyArray1();
            ma.setSelf(value);
//            ma.setLength(len);
            int[][] childs = new int[arr.length][2];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i][0] > value[0]) && (arr[i][1] > value[1])) {
                    childs[index] = arr[i];
                    index ++;
                }
            }
            if(index != 0) {
                int[][] newChildes = trimArray(childs);
                ma.setChild(newChildes);
                for (int i = 0; i < newChildes.length; i++) {
                    int newLen = len + 1;
                    newLen = findChildre(newChildes, newChildes[i], map, newLen, lenList);
//                    System.out.println("newLen:"+newLen);
//                    if(newLen > max){
//                        max = newLen;
//                    }
//                    if(ma.getLength() < len){
//                        printArray1(newChildes[i]);
////                        System.out.println("set len:"+newLen);
//                        ma.setLength(len);
//                    }
                }
                len++;
            }else{
                lenList.add(len);
            }
            map.put(ma.getSelf(), ma);
        }else{
            if(map.get(value).getChild().length != 0) {
                for (int i = 0; i < map.get(value).getChild().length; i++) {
                    int newLen = len + 1;
                    newLen = findChildre(map.get(value).getChild(), map.get(value).getChild()[i], map, newLen, lenList);
//                    System.out.println("newLen:"+newLen);
//                    if(newLen > max){
//                        max = newLen;
//                    }
//                    if(map.get(value).getLength() < len){
////                        printArray1(map.get(value).getChild()[i]);
////                        System.out.println("set len:"+newLen);
//                        map.get(value).setLength(len);
//                    }
                }
                len++;
            }else{
                lenList.add(len);
            }
        }
//        System.out.print("value:");
//        printArray1(value);
//        System.out.println("max:"+max);
        return len;
    }

    private class MyArray1{
        int[] self;
        int[][] child;
        int[] bestNext;
        int length;

        MyArray1(){
            this.self = new int[0];
            this.child = new int[0][0];
            this.bestNext = new int[0];
            this.length = 0;
        }

        public void print(){
            System.out.print("self:");
            printArray1(this.self);
            System.out.print("child:");
            printArray(this.child);
//            System.out.print("length:"+this.length);
//            System.out.println();
            System.out.println();
        }

        public int getLength() {
            return length;
        }

        public int[] getBestNext() {
            return bestNext;
        }

        public int[] getSelf() {
            return self;
        }

        public int[][] getChild() {
            return child;
        }

        public void setChild(int[][] child) {
            this.child = child;
        }

        public void setBestNext(int[] bestNext) {
            this.bestNext = bestNext;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setSelf(int[] self) {
            this.self = self;
        }
    }


    /* LIS算法：求最大上升/下降子串
        1、先对目标进行排序
        2、默认每个目标的子串长度为1
        3、检测目标与目标之前的元素进行比较，如果目标之前的元素子串大于当前目标的子串长度，则将当前目标和之前的元素拼接
     */

    private int select9(int[][] arr){
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
//        printArray(arr);
        int[] lenArr = new int[arr.length];
        int max = 1;
        Arrays.fill(lenArr, 1);
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if((arr[i][0] > arr[j][0]) && (arr[i][1] > arr[j][1])){
                    if((lenArr[j] + 1) > lenArr[i]){
                        lenArr[i] = lenArr[j] + 1;
                    }
                }
            }
//            lenArr[i] = len+1;
            if(lenArr[i] > max){
                max = lenArr[i];
            }
        }
        System.out.println("max:"+max);
        return max;
    }

    private int select10(int[][] arr){
        if(arr.length == 0){
            return 0;
        }else {
            int max = 1;
            sortArray(arr);
            int[] dp = new int[arr.length];// 用来保存每个元素的子串长度
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;// 默认每个子串长度为1
            }
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) { // 用当前元素和它之前的所有元素比较
                    if ((arr[i][0] > arr[j][0]) && ((arr[i][1] > arr[j][1]))) { // 满足条件的元素，则取当前元素的子串长度和目标元素的子串长度+1的最大值
                        if (dp[i] < (dp[j] + 1)) {
                            dp[i] = (dp[j] + 1);
                        }
                    }
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
            System.out.println("max:" + max);
            return max;
        }
    }

    // LIS算法
    private int select11(int[][] arr){
        if(arr.length == 0){
            return 0;
        }else {
//            sortArray(arr);//按x升序y降序排列
            arr = mergeSort(arr);
            int[][] dp = new int[arr.length][2];// 用来保存每个元素的子串长度
            dp[0] = arr[0];
            int index = 1;
            for (int i = 1; i < arr.length; i++) {
                if(dp[index - 1][1] < arr[i][1]){
                    dp[index] = arr[i];
                    index++;
                }else{
                    int tempIndex = -1;
                    int start = 0;
                    int end = index - 1;
                    int mid;
                    while((end >= start)){
                        mid = (end + start) / 2;
                        if(dp[mid][1] >= arr[i][1]) {
                            tempIndex = mid;
                            end = mid - 1;
                        }else{
                            start = mid + 1;
                        }

                    }
                    if(tempIndex != -1){
                        dp[tempIndex] = arr[i];
                    }
                }
            }
            int[][] result = new int[index][2];
            for (int i=0;i<result.length;i++){
                result[i] = dp[i];
            }
            printArray(result);
//            max = dp.length;
            System.out.println("max:" + index);
            return index;
        }
    }

    // 冒泡排序时间复杂度为O(n^2)
    private int[][] sortArray(int[][] arr){
        for(int i=0;i<(arr.length-1);i++){
            for(int j=1;j<(arr.length-i);j++){
                if(arr[j - 1][0] > arr[j][0]){
                    int[] temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }else if((arr[j - 1][0] == arr[j][0]) && (arr[j - 1][1] < arr[j][1])){
                    int[] temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private int[][] mergeSort(int[][] arr){
        int mid = arr.length / 2;
        if(mid == 0){
            return arr;
        }else{
            int[][] left = Arrays.copyOfRange(arr, 0, mid);
            int[][] right = Arrays.copyOfRange(arr, mid, arr.length);
            int[][] resultLeft = mergeSort(left);
            int[][] resultRight = mergeSort(right);
            int indexLeft = 0;
            int indexRight = 0;
            int[][] temp = new int[resultLeft.length + resultRight.length][2];
            for(int i=0;i<temp.length;i++){
                if(indexLeft == (resultLeft.length)){
                    temp[i] = resultRight[indexRight];
                    indexRight++;
                }else if(indexRight == (resultRight.length)){
                    temp[i] = resultLeft[indexLeft];
                    indexLeft++;
                }else {
                    if ((resultLeft[indexLeft][0]) < (resultRight[indexRight][0])) {
                        temp[i] = resultLeft[indexLeft];
                        indexLeft++;
                    } else if (((resultLeft[indexLeft][0]) == (resultRight[indexRight][0])) && ((resultLeft[indexLeft][1]) > (resultRight[indexRight][1]))) {
                        temp[i] = resultLeft[indexLeft];
                        indexLeft++;
                    } else {
                        temp[i] = resultRight[indexRight];
                        indexRight++;
                    }
                }
            }
            return temp;
        }
    }
}
