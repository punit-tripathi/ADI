package ADIlec10;

public class Main {
    public static void main(String[] args) {

    }
    static int binarySearch(int []arr,int low,int high,int target){
            if(low > high) return -1;
            int mid= (low+high)/2;

            if(arr[mid] == target) return mid;
            if(arr[mid] < target){
                return binarySearch(arr,mid+1,high,target);
            }
            if(arr[mid] > target){
                return binarySearch(arr,low,mid-1,target);
            }

            return -1;
    }


  static void quickSort(int []arr,int st,int end){
        if(st > end) return;

        int pi = partition(arr,st,end);

        quickSort(arr,st,pi-1);
        quickSort(arr,pi+1,end);
  }

  static int partition(int []arr,int st,int end){
        int pivot=arr[end];
        int i=st-1;

        for(int j=st;j <     end;j++){
            if(arr[j] < pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i] = temp;
            }
        }
//        i++;
        int temp=arr[end];
        arr[end]=arr[i+1];
        arr[i+1]=temp;

        return i+1;
  }
}
