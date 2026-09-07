/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l=0;
        int r=n;
        int mid=l+(r-l)/2;
        int res=guess(mid);
        while(res!=0){
            if(res==-1){
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
            mid=l+(r-l)/2;
            res=guess(mid);
        }
        return mid;
        
    }
}