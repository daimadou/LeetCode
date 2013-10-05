class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int buy = 0;
        int profits = 0;
        int maxProfits = 0;
        
        int N = prices.size();
        for(int i = 0; i < N; i++)
        {
            if(prices[buy]>prices[i])
            {
                buy = i;
            }
            
            profits = prices[i] - prices[buy];
            maxProfits = (profits>maxProfits)? profits:maxProfits;
        }
        
        return maxProfits;
    }
};
