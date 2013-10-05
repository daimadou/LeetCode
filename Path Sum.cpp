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
    bool hasPathSum(TreeNode *root, int sum) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return checkPathSum(root, sum, false);
        
    }
    
    
    bool checkPathSum(TreeNode *root, int sum, bool isLeaf)
    {
        if(root==NULL)
        {
            if(isLeaf)
                return sum==0?true:false;
            else
                return false;
        }
        
        if(root->left==NULL&&root->right==NULL)
            isLeaf = true;
        
        int val = sum - root->val;
        
        bool left = checkPathSum(root->left, val, isLeaf);
        if(left)
            return true;
        else
        {
            bool right = checkPathSum(root->right, val, isLeaf);
            return right;
        }
        
    }
};