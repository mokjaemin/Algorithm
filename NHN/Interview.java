package NHN;


import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Interview {

    static class Customer{
        public String id;
        public String name;
        public int cost;
        public Customer next;

        public Customer(String id, String name, int cost){
            this.id = id;
            this.name = name;
            this.cost = cost;
        }

        public void find(int limit){
            if(cost > limit){
                return;
            }
            System.out.println(this);
            next.find(limit);
        }

        public String toString(){
            return "id : " + id + ", " + "name : " + name + ", " + "cost : " + cost;
        }
    }

    public static void main(String[] args){
        Customer mok = new Customer("bamer1", "목재민", 10000);
        Customer yoon = new Customer("bamer2", "윤재민", 30000);
        Customer choi = new Customer("bamer3", "최재민", 20000);
        List<Customer> customers = new ArrayList<>();
        customers.add(mok);
        customers.add(yoon);
        customers.add(choi);

        HashMap<String, Customer> mapId = new HashMap<>();
        HashMap<String, Customer> mapName = new HashMap<>();
        List<Customer> numList = new ArrayList<>();

        for(Customer customer : customers){
            mapId.put(customer.id, customer);
            mapName.put(customer.name, customer);
            numList.add(customer);
        }

        Collections.sort(numList, Comparator.comparing(arr -> arr.cost));
        System.out.println(mapId.get("bamer1"));
        System.out.println(mapName.get("최재민"));

        for(int i=0; i<numList.size()-1; i++){
            numList.get(i).next = numList.get(i+1);
        }
        System.out.println("");

        for(int i=0; i<numList.size()-1; i++){
            if(numList.get(i).cost >= 10000){
                numList.get(i).find(20000);
                break;
            }
        }
    }

}


