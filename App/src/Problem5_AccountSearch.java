public class Problem5_AccountSearch{
    public static int linearFirst(String[] arr,String target){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(target)){return i;}
        }
        return -1;
    }
    public static int linearLast(String[] arr,String target){
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].equals(target)){return i;}
        }
        return -1;
    }
    public static int binarySearch(String[] arr,String target){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid].equals(target)){return mid;}
            else if(arr[mid].compareTo(target)<0){low=mid+1;}
            else{high=mid-1;}
        }
        return -1;
    }
    public static int countOccurrences(String[] arr,String target){
        int count=0;
        for(String s:arr){
            if(s.equals(target)){count++;}
        }
        return count;
    }
    public static void main(String[] args){
        String[] logs={"accA","accB","accB","accC","accD"};
        System.out.println("Linear First accB: "+linearFirst(logs,"accB"));
        System.out.println("Linear Last accB: "+linearLast(logs,"accB"));
        System.out.println("Binary Search accB: "+binarySearch(logs,"accB"));
        System.out.println("Count accB: "+countOccurrences(logs,"accB"));
    }
}
