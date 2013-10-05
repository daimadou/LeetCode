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
    void recoverTree(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL;
        TreeNode *firstwrong = NULL;
        TreeNode *secondwrong = NULL;
        findwrong(root, pre, firstwrong, false);
        pre = NULL;
        findwrong(root, pre, secondwrong, true);
        
        if(firstwrong&&secondwrong)
        {
            int val = firstwrong->val;
            firstwrong->val = secondwrong->val;
            secondwrong->val = val;
        }
    }
    
    //be careful!!! when finish the left check, something time result may change!!!!!!
    // for tree we should check result, when we finsih the first left or right!!!!!!!
    void findwrong(TreeNode *root, TreeNode *&pre, TreeNode *&wrong, bool reverse)
    {
        if(root==NULL||wrong)
            return;
        
        if(!reverse)
        {
            findwrong(root->left, pre, wrong, reverse);
            if(wrong==NULL&&pre&&root->val < pre->val)
            {
                wrong = pre;
            }
            pre = root;
            findwrong(root->right, pre, wrong, reverse);
        }
        else
        {
            
            findwrong(root->right, pre, wrong, reverse);
            if(wrong==NULL&&pre&&root->val > pre->val)
            {
                wrong = pre;
            }
            pre = root;
            findwrong(root->left, pre, wrong, reverse);
        }
    }
};