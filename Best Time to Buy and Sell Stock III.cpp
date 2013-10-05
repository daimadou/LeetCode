class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int>historyProfits(prices.size(), 0);
        int buy = 0;
        int max = 0;
        int profit = 0;
        
        int N = prices.size();
        for(int i = 0; i < N; i++)
        {
            buy = prices[i]<prices[buy]? i:buy;
            profit = prices[i] - prices[buy];
            max = profit>max? profit:max;
            historyProfits[i] = max;
        }
        
        int sell = N-1;
        max = 0;
        profit = 0;
        for(int i = N-1; i>-1; i--)
        {
            sell = prices[i]>prices[sell]? i:sell;
            profit = prices[sell] - prices[i]+historyProfits[i];
            max = profit>max? profit:max;
        }
        
        return max;
    }
};
