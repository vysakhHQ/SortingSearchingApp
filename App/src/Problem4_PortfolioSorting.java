class Asset{
    String name;
    double returnRate;
    double volatility;
    Asset(String name,double returnRate,double volatility){
        this.name=name;
        this.returnRate=returnRate;
        this.volatility=volatility;
    }
}
public class Problem4_PortfolioSorting{
    public static void mergeSort(Asset[] arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void merge(Asset[] arr,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        Asset[] left=new Asset[n1];
        Asset[] right=new Asset[n2];
        for(int i=0;i<n1;i++){left[i]=arr[l+i];}
        for(int j=0;j<n2;j++){right[j]=arr[m+1+j];}
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i].returnRate<=right[j].returnRate){
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
    public static void quickSort(Asset[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    public static int partition(Asset[] arr,int low,int high){
        Asset pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].returnRate>pivot.returnRate || (arr[j].returnRate==pivot.returnRate && arr[j].volatility<pivot.volatility)){
                i++;
                Asset temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        Asset temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public static void print(Asset[] arr){
        for(Asset a:arr){
            System.out.println(a.name+" | Return: "+a.returnRate+" | Volatility: "+a.volatility);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Asset[] assets={
                new Asset("AAPL",12,5),
                new Asset("TSLA",8,9),
                new Asset("GOOG",15,4),
                new Asset("MSFT",12,3)
        };
        System.out.println("Original:");
        print(assets);
        mergeSort(assets,0,assets.length-1);
        System.out.println("After Merge Sort (Return Asc):");
        print(assets);
        quickSort(assets,0,assets.length-1);
        System.out.println("After Quick Sort (Return Desc + Volatility Asc):");
        print(assets);
    }
}