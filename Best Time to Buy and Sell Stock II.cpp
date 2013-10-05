class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int profit = 0;
        int N = prices.size();
        
        for(int i = 1; i < N; i++)
        {
            if(prices[i]>prices[i-1])
            profit +=prices[i]-prices[i-1];
        }
        
        return profit;
    }
};
