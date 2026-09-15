class Solution {
    public int[] countBits(int n) {
        int[] bit=new int[n+1];
    bit[0]=0;
    for(int i=0;i<=n;i++){
        bit[i]=bit[i/2]+(i%2);
    }
    return bit;
    }
}