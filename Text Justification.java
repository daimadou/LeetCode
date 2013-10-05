public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(words.length==0||L==0)
        {
            ret.add("");
            return ret;
        }
        
        int len = 0;
        int i = 0;
        int start = 0;
        int wordsLength = 0;
        while(i < words.length)
        {
            len += words[i].length() + 1;
            wordsLength += words[i].length();
            if(len >= L+1)
            {
                if(len > L + 1)
                {
                    wordsLength = wordsLength - words[i].length();
                    i--;
                }    
                String s = buildSentence(words, start, i+1, wordsLength, L);
                ret.add(s);
                start = i+1;
                len = 0;
                wordsLength = 0;
            }
            else
            {
                if(i == words.length - 1)
                {
                    String s = buildSentence(words, start, i+1, wordsLength, L);
                    ret.add(s);
                }
            }
            i++;
        }
        
        return ret;
    }
    
    private String buildSentence(String [] words, int start, int end, int wordsLength, int L)
    {
        boolean isLastSentence = (end==words.length)? true: false;
        int wordCount = end - start;
        int spaceNumCount = wordCount - 1;
        int spaceTotalLen = L - wordsLength;
        int spaceLen = 0;
        int spaceExtraTotalLen = 0;
        if(spaceNumCount > 0)
        {
            spaceLen = isLastSentence? 1 : spaceTotalLen/spaceNumCount;
            spaceExtraTotalLen = isLastSentence? 0 : spaceTotalLen%spaceNumCount;
        }
        char []space = new char[spaceLen];
        if(spaceLen > 0)
        {
            Arrays.fill(space, ' ');   
        }
        StringBuffer sb =new StringBuffer();
        for(int i = start; i < end; i++)
        {
            sb.append(words[i]);
            if(spaceNumCount > 0)
            {
                sb.append(space);
                if(spaceExtraTotalLen>0)
                {
                    sb.append(" ");
                    spaceExtraTotalLen--;
                }
                spaceNumCount--;
            }
        }
        
        int num = L - sb.length();
        if(num > 0)
        {
            space = new char[num];
            Arrays.fill(space, ' ');
            sb.append(space);
        }
        String ret = sb.toString();
        return ret;
    }
}