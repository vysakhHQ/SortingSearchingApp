import java.util.ArrayList;
class Transaction{
    String id;
    double fee;
    String timestamp;
    Transaction(String id,double fee,String timestamp){
        this.id=id;
        this.fee=fee;
        this.timestamp=timestamp;
    }
}
public class Problem1_TransactionSorting{
    public static void bubbleSort(ArrayList<Transaction> list){
        int n=list.size();
        int swaps=0;
        int passes=0;
        for(int i=0;i<n-1;i++){
            boolean swapped=false;
            passes++;
            for(int j=0;j<n-i-1;j++){
                if(list.get(j).fee>list.get(j+1).fee){
                    Transaction temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                    swapped=true;
                    swaps++;
                }
            }
            if(!swapped){break;}
        }
        System.out.println("Bubble Sort -> Passes: "+passes+" Swaps: "+swaps);
    }
    public static void insertionSort(ArrayList<Transaction> list){
        int n=list.size();
        for(int i=1;i<n;i++){
            Transaction key=list.get(i);
            int j=i-1;
            while(j>=0 && (list.get(j).fee>key.fee || (list.get(j).fee==key.fee && list.get(j).timestamp.compareTo(key.timestamp)>0))){
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,key);
        }
    }
    public static void findHighFee(ArrayList<Transaction> list){
        System.out.println("High Fee Transactions (>50):");
        for(Transaction t:list){
            if(t.fee>50){
                System.out.println(t.id+" -> "+t.fee);
            }
        }
    }
    public static void printList(ArrayList<Transaction> list){
        for(Transaction t:list){
            System.out.println(t.id+" | Fee: "+t.fee+" | Time: "+t.timestamp);
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayList<Transaction> transactions=new ArrayList<>();
        transactions.add(new Transaction("T1",10.5,"10:00"));
        transactions.add(new Transaction("T2",25.0,"09:30"));
        transactions.add(new Transaction("T3",5.0,"10:15"));
        transactions.add(new Transaction("T4",25.0,"08:45"));
        transactions.add(new Transaction("T5",60.0,"11:00"));
        System.out.println("Original Data:");
        printList(transactions);
        bubbleSort(transactions);
        System.out.println("After Bubble Sort (Fee Asc):");
        printList(transactions);
        insertionSort(transactions);
        System.out.println("After Insertion Sort (Fee + Time):");
        printList(transactions);
        findHighFee(transactions);
    }
}