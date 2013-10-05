/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isBalanced(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(checkBalanced(root)==-1)
            return false;
        else
            return true;
    }
    
    int checkBalanced(TreeNode *root)
    {
        if(root==NULL)
            return 0;
        
        int left = checkBalanced(root->left);
        
        if(left==-1)
            return -1;
        else
        {
            int right = checkBalanced(root->right);
            
            if(right==-1)
                return -1;
            else
            {
                int val = left-right;
                if(val<-1||val>1)
                    return -1;
                else
                {
                    val = left>right?left:right;
                    return val+1;
                }
                    
            }
                
        }
      
    }
};