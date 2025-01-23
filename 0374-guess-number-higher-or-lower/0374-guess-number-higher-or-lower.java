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
        if(guess(1)==0)
        {
            return 1;
        }
        if(guess(n)==0)
        {
            return n;
        }
        int first=1,last=n;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(guess(mid)==1)
            {
                first=mid+1;
            }
            else if(guess(mid)==-1)
            {
                last=mid-1;
            }
            else if(guess(mid)==0)
            {
                return mid;
            }
        }
        return -1;
    }
}