package JAVA.GraphTheory;

public class Question5 {
    public static void main(String[] args){
        int g = 4;
        int p = 3;
        int result = 0;
        int[] parents = new int[g+1];
        for(int i=0; i<g+1; i++){
            parents[i] = i; 
        }
        int[] data = {2, 2, 3, 3, 4, 4};
        for(int i : data){
            int parent0 = find_paretns(parents, i);
            if(parents[i] == 0){
                break;
            }
            int parent1 = find_paretns(parents, parent0);
            int parent2 = find_paretns(parents, parent0-1);
            parents[parent1] = (parent1 > parent2) ? parent2 : parent1;   
            parents[parent2] = (parent1 > parent2) ? parent2 : parent1;
            result += 1;
        }
        
        System.out.println(result);
    }
    public static int find_paretns(int[] parents, int node){
        if(node != parents[node]){
            parents[node] = find_paretns(parents, parents[node]);
        }
        return parents[node];
    }
}
