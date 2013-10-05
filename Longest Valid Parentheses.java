public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []chars = s.toCharArray();
        Stack<Integer> pStack = new Stack<Integer>();
        int maxLen = 0;
        int len = 0;
        int lastInvalid = -1;
        for(int i=0; i < chars.length; i++)
        {
            if(chars[i] == '(')
            {
                pStack.push(i);
            }
            else
            {
                if(!pStack.isEmpty())
                {
                    pStack.pop();
                    int left = 0;
                    if(pStack.isEmpty())
                    {
                        left = lastInvalid; 
                    }
                    else
                    {
                        left = pStack.peek();
                    }
                    len = i - left;
                    maxLen = Math.max(len, maxLen);
                }
                else
                {
                    lastInvalid = i;
                }
            }
        }
        return maxLen;
    }
}