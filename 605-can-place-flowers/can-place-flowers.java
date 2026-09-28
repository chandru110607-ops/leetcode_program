class Solution {
    public boolean canPlaceFlowers(int[] flower, int n) {
        int ne=flower.length;
        for(int i=0;i<ne;i++){
            if(flower[i]==0&&(i==0||flower[i-1]==0)&&(i==ne-1||flower[i+1]==0)){
                flower[i]=1;
                n--;
            }
            if(n<=0){
                return true; 
            }
        }
        return n<=0;
    }
}