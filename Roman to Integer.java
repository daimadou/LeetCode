public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty())
        {
            return 0;
        }
        HashMap<Character, Integer> romanIntMap = new HashMap<Character, Integer>();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10); 
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
        int n = s.length();
        int sum = romanIntMap.get(s.charAt(n-1));
        for(int i = n - 2; i > -1; i--)
        {
            int val1 = romanIntMap.get(s.charAt(i));
            int val2 = romanIntMap.get(s.charAt(i+1));
            if(val1 >= val2)
            {
                sum += val1;
            }
            else
            {
                sum -= val1;
            }
        }
        return sum;
    }
}