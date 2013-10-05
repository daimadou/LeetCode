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
    void flatten(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL;
        build(root, pre);
    }
    
    void build(TreeNode *root, TreeNode *&pre)
    {
        if(root==NULL)
        {
            return;
        }
        
        build(root->right, pre);
        build(root->left, pre);
        root->right = pre;
        root->left  = NULL;
        pre = root;
    }
};