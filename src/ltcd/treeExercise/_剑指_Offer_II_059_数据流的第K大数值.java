package ltcd.treeExercise;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _剑指_Offer_II_059_数据流的第K大数值 {

    private int[] minHeap;
    //记录堆的规模
    private final int k;
    //定义堆的最后一个元素的索引
    private int lastIndex;

    public _剑指_Offer_II_059_数据流的第K大数值(int k, int[] nums) {
        this.k = k;
        this.minHeap = new int[k + 1];
        for(int i = 1; i <= k && i <= nums.length; i++){
            this.minHeap[i] = nums[i -1];
            this.lastIndex = i;
        }

        //如果小顶堆被填满了，就继续添加元素，并使堆有序
        if(lastIndex == k){
            order();
            for(int i = k; i < nums.length; i++){
                add(nums[i]);
            }
        }
    }

    public int add(int val) {
        //如果堆还没有被填满（由题意，堆会在最多一个add后被填满），则将元素放在无序的堆的末尾，然后将堆有序化
        if(lastIndex == k - 1){
            minHeap[++lastIndex] = val;
            order();
        } else if(val > minHeap[1]){
            //如果新元素大于堆中的第k大的元素(minHeap[1]，即堆顶元素)。则替换它
            minHeap[1] = val;
            sink(1);
        }
        return minHeap[1];
    }
    //堆的有序化
    private void order(){
        for(int i = k / 2; i >= 1; i--){
            sink(i);
        }
    }

    //堆的下沉
    private void sink(int root){
        while(root * 2 <= k){
            int child = root * 2;
            //找小的子节点
            if(child < k && minHeap[child] > minHeap[child + 1]){
                child++;
            }

            if(minHeap[root] > minHeap[child]){
                int temp = minHeap[root];
                minHeap[root] = minHeap[child];
                minHeap[child] = temp;

                root = child;
            }else{
                break;
            }
        }
    }
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
