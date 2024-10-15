package ADIlec4;

import ADIlec3.Priorityqueue;

import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
        //leetcode 215
        int arr[] ={4,5,6,1,2,3};
        int k=3;

        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        System.out.println(pq.peek());
        //973
        //347
        //378

    }
}
