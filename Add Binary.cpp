class Solution {
public:
    string addBinary(string a, string b) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(a.empty()&&b.empty())
        {
            return "0";
        }
        
        if(a.size()>b.size())
        {
            string zeros;
            zeros.append(a.size()-b.size(), '0');
            b = zeros+b;
        }
        else if(b.size()>a.size())
        {
            string zeros;
            zeros.append(b.size()-a.size(), '0');
            a = zeros+a;
        }
        
        int carryout = 0;
        int n = a.size();
        string result;
        for(int i = n-1; i> -1; i--)
        {
            int val1 = a[i]-'0';
            int val2 = b[i]-'0';
            int ret = val1^val2;
            ret = ret^carryout;
            carryout = (val1&val2)|(val2&carryout)|(val1&carryout);
            result.insert(result.begin(), ret+'0');
        }
        
        if(carryout>0)
        {
            result.insert(result.begin(), carryout+'0');
        }
        
        return result;
    }
};
