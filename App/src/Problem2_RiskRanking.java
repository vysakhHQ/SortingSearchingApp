class Client{
    String name;
    int riskScore;
    double balance;
    Client(String name,int riskScore,double balance){
        this.name=name;
        this.riskScore=riskScore;
        this.balance=balance;
    }
}
public class Problem2_RiskRanking{
    public static void bubbleSort(Client[] arr){
        int n=arr.length;
        int swaps=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j].riskScore>arr[j+1].riskScore){
                    Client temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swaps++;
                }
            }
        }
        System.out.println("Bubble swaps: "+swaps);
    }
    public static void insertionSort(Client[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            Client key=arr[i];
            int j=i-1;
            while(j>=0 && (arr[j].riskScore<key.riskScore || (arr[j].riskScore==key.riskScore && arr[j].balance>key.balance))){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void print(Client[] arr){
        for(Client c:arr){
            System.out.println(c.name+" | Risk: "+c.riskScore+" | Balance: "+c.balance);
        }
        System.out.println();
    }
    public static void topRisk(Client[] arr){
        System.out.println("Top Risk Clients:");
        int count=Math.min(10,arr.length);
        for(int i=0;i<count;i++){
            System.out.println(arr[i].name+" -> "+arr[i].riskScore);
        }
    }
    public static void main(String[] args){
        Client[] clients={
                new Client("A",20,5000),
                new Client("B",50,2000),
                new Client("C",80,1000),
                new Client("D",50,8000)
        };
        System.out.println("Original:");
        print(clients);
        bubbleSort(clients);
        System.out.println("After Bubble (Asc):");
        print(clients);
        insertionSort(clients);
        System.out.println("After Insertion (Desc + Balance):");
        print(clients);
        topRisk(clients);
    }
}