package LeetCode;
// https://leetcode.com/problems/happy-number/

public class HappyNumber {
    private int square(int n) {
        int ans = 0;
        
        while(n != 0) {
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        
        return ans;
    }
    // linked list cycle detection
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow != fast);
        
        if(slow == 1){
            return true;
        } 
        return false;
    }

    // public boolean isHappy(int n) {
    //     HashSet<Integer> hs = new HashSet<>();
    //     int temp;
    //     boolean val = true;
        
    //     while(true){
    //         temp = square(n);
    //         if(temp == 1){
    //             break;
    //         }
    //         if(!hs.add(temp)){
    //             val = false;  
    //             break;
    //         }
    //         n = temp;
    //     }      
    //     return val;
    // }
}
