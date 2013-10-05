public class Solution {
    final String[] numPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        char[] letters = new char[digits.length()];
        generateCombinations(digits, 0, letters, ret);
        return ret;
    }
    
    private void generateCombinations(String digits, int index, char[] letters, ArrayList<String> ret)
    {
        if(index == digits.length())
        {
            ret.add(new String(letters));
            return;
        }
        
        int val = digits.charAt(index) - '0';
        String s = numPad[val];
        for(int i = 0; i < s.length(); i++)
        {
            letters[index] = s.charAt(i);
            generateCombinations(digits, index + 1, letters, ret);
        }
    }
}