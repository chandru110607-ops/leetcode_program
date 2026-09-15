class Solution {
    public int[] countBits(int n) {
        int[] bit=new int[n+1];
        bit[0]=0;
        for(int i=0;i<=n;i++){
            int c=0;
            int num=i;
            while(num!=0){
                c+=num&1;
                num=num>>1;
            }
            bit[i]=c;
        }
        return bit;
    }
}