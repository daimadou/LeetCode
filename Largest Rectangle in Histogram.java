public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int ret = 0;
        while(i <= height.length)
        {
            int curHeight = i < height.length? height[i]:0;
            if(stack.isEmpty()||height[stack.peek()] <= curHeight)
            {
                stack.push(i++);
            }
            else
            {
                int index = stack.pop();
                int h = height[index];
                int l = stack.isEmpty()? i:(i - stack.peek() -1);
                ret = Math.max(ret, h*l);
            }
        }
        return ret;
    }
}