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
    bool isValidBST(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL;
        return isValidBST(root, pre);
        
    }
    
    bool isValidBST(TreeNode *root, TreeNode *&pre)
    {
        if(root==NULL)
        {
            return true;
        }
        
        bool left = isValidBST(root->left, pre);
        if(!left)
            return false;
        if(pre)
        {
            if(pre->val >= root->val)
                return false;
        }
        pre = root;
        bool right = isValidBST(root->right, pre);
        return right&&left;
    }
};