package ADIlec3;

public class main {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
         heapsort h1=new heapsort();
         h1.sort(arr);

         for(int i=0;i<arr.length;i++){
             System.out.println(arr[i]);
         }
    }
}
class heapsort{
    void sort(int arr[]){
        int n=arr.length;
        for(int i= n/2 -1; i>=0; i--){
            heapify(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,i,0);
        }
    }
    void heapify(int arr[],int n,int idx){
        int parent =idx;
        int left= parent*2 +1;
        int right=parent*2 +2;

        if(left < n && arr[parent] < arr[left]){
            parent =left;
        }
        if(right < n && arr[parent] <arr[right]){
            parent = right;
        }

        if(parent != idx){
            int temp=arr[parent];
            arr[parent]=arr[idx];
            arr[idx]=temp;

            heapify(arr,n,parent);
        }
    }


}