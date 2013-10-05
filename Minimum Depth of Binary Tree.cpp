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
    int minDepth(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if(root==NULL)
            return 0;
        
        int depth = 0;
        
        if(root->left||root->right)
        {
            int left = INT_MAX;
            int right = INT_MAX;
            if(root->left)
            {
                left = minDepth(root->left);
            }
            if(root->right)
            {
                right = minDepth(root->right);
            }
            
            depth = min(left, right);
    
            
        }
        
        return depth+1;
    }
};