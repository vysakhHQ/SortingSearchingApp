public class Problem6_RiskBinaryLookup{
    public static int linearSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){return i;}
        }
        return -1;
    }
    public static int floor(int[] arr,int target){
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){return arr[mid];}
            if(arr[mid]<target){
                ans=arr[mid];
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static int ceiling(int[] arr,int target){
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){return arr[mid];}
            if(arr[mid]>target){
                ans=arr[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] risks={10,25,50,100};
        int target=30;
        System.out.println("Linear Search: "+linearSearch(risks,target));
        System.out.println("Floor of "+target+": "+floor(risks,target));
        System.out.println("Ceiling of "+target+": "+ceiling(risks,target));
    }
}