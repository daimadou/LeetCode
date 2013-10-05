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
    vector<vector<int> >result;
    vector<int> oneResult;
    
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        result.clear();
        oneResult.clear();
        if(root)
            checkPathSum(root, sum, false);
        return result;
    }
    
    void checkPathSum(TreeNode *root, int sum, bool isLeaf)
    {
   
        oneResult.push_back(root->val);
        int val = sum - root->val;
        if(root->left==NULL&&root->right==NULL)
        {
            if(val==0)
                result.push_back(oneResult);
        }
        else
        {
            if(root->left)
                checkPathSum(root->left, val, isLeaf);
            if(root->right)
                checkPathSum(root->right, val, isLeaf);
        }
        
        
        oneResult.pop_back();
        
    }
};