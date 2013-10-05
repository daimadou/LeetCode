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
    bool isSameTree(TreeNode *p, TreeNode *q) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(p==NULL&&q==NULL)
        {
            return true;  
        }
        else if(p&&q)
        {
            if(p->val !=q->val)
            {
                return false;
            }
            else{
                bool left = isSameTree(p->left, q->left);
                if(left==false)
                    return false;
                else
                {
                    bool right = isSameTree(p->right, q->right);
                    return right&&left;
                }
            }
        }
        else
        {
            return false;
        }
    }
};