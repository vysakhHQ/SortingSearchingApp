class Trade{
    String id;
    int volume;
    Trade(String id,int volume){
        this.id=id;
        this.volume=volume;
    }
}
public class Problem3_TradeAnalysis{
    public static void mergeSort(Trade[] arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void merge(Trade[] arr,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        Trade[] left=new Trade[n1];
        Trade[] right=new Trade[n2];
        for(int i=0;i<n1;i++){left[i]=arr[l+i];}
        for(int j=0;j<n2;j++){right[j]=arr[m+1+j];}
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i].volume<=right[j].volume){
                arr[k]=left[i];
                i++;
            }else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<n1){arr[k]=left[i];i++;k++;}
        while(j<n2){arr[k]=right[j];j++;k++;}
    }
    public static void quickSort(Trade[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    public static int partition(Trade[] arr,int low,int high){
        int pivot=arr[high].volume;
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].volume>pivot){
                i++;
                Trade temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        Trade temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public static int totalVolume(Trade[] arr){
        int sum=0;
        for(Trade t:arr){sum+=t.volume;}
        return sum;
    }
    public static void print(Trade[] arr){
        for(Trade t:arr){
            System.out.println(t.id+" | Volume: "+t.volume);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Trade[] trades={
                new Trade("T1",100),
                new Trade("T2",300),
                new Trade("T3",500)
        };
        System.out.println("Original:");
        print(trades);
        mergeSort(trades,0,trades.length-1);
        System.out.println("After Merge Sort (Asc):");
        print(trades);
        quickSort(trades,0,trades.length-1);
        System.out.println("After Quick Sort (Desc):");
        print(trades);
        System.out.println("Total Volume: "+totalVolume(trades));
    }
}