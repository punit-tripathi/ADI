package ADIlec11;

public class main {
    public static void main(String[] args) {

    }
    static void mergeSort(int[] arr,int left,int right){
        if(left >= right) return;

        int mid=(left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }

    static void merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] larr=new int[n1];
        int[] rarr=new int[n2];

        for(int i=0;i<n1;i++){
            larr[i] = arr[left+i];
        }
        for(int i=0;i<n1;i++){
            rarr[i] = arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=left;
        while(i < n1 && j < n2){
            if(larr[i] <= rarr[j]){
                arr[k] = larr[i];
                i++;
            }
            else{
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = larr[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = rarr[j];
            j++;
            k++;
        }
    }
}
