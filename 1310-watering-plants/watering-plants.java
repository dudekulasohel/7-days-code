class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0;
        int temp = capacity;
        for(int i=0;i<plants.length;i++){
            if(capacity<plants[i]){
                step += 2*(i+1)-1;
                capacity = temp-plants[i];
            }else{
                step +=1;
                capacity -= plants[i];
            }
        }
        return step;
    }
}