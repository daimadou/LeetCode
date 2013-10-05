public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int numRows = rowIndex + 1;
        Integer []ret = new Integer[numRows];
        Arrays.fill(ret, 1);
        for(int i = 0; i < numRows; i++)
        {
            for(int j = i-1; j > 0; j--)
            {
                ret[j] = ret[j-1]+ret[j];
            }
        }
        return new ArrayList<Integer>(Arrays.asList(ret));
        
    }
}