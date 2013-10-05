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
    int maxPathSum(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int max = INT_MIN;
        findMaxSum(root,max);
        return max;
    }
    
    int findMaxSum(TreeNode *root, int &max)
    {
        if(root == NULL)
        {
            return 0;
        }
        else
        {
            int lvalue = findMaxSum(root->left, max);
            int rvalue = findMaxSum(root->right, max);
            int returnValue = lvalue>rvalue? lvalue:rvalue;
            int value = 0;
            if(lvalue>0&&rvalue>0)
            {
                value = lvalue+rvalue+root->val;
            }else
            {
                returnValue = returnValue>0?returnValue:0;
                value = returnValue+root->val;
                
            }
            max = value>max? value:max;
            returnValue+=root->val;
            return returnValue;

            
            return returnValue;
        } 
    }
};
