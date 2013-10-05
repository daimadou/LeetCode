class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int carryout = 1;
      
        list<int> resultlist;
        for(int i = digits.size()-1; i>-1 ; i--)
        {
            int val = (digits[i]+carryout)%10;
            resultlist.push_front(val);
            carryout = (digits[i]+carryout)/10;
        }
        if(carryout!=0)
            resultlist.push_front(carryout);
            
        vector<int> result(resultlist.begin(), resultlist.end());
        return result;
    }
};
