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
    vector<TreeNode *> generateTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return generateTrees(1, n);
    }
    
    vector<TreeNode *> generateTrees(int left, int right)
    {
        vector<TreeNode *>result;
        if(left > right)
        {
            TreeNode *node = NULL;
            result.push_back(node);
        }
        else
        {
            TreeNode *root = NULL;
            for(int i = left; i <= right; i++)
            {
                
                vector<TreeNode *> leftList = generateTrees(left, i-1);
                vector<TreeNode *> rightList = generateTrees(i+1, right);
                for(TreeNode *&left:leftList)
                {
                    for(TreeNode *&right:rightList)
                    {
                        root = new TreeNode(i);
                        root->left = left;
                        root->right = right;
                        result.push_back(root);
                    }
                }
                
            }
        }
        
        return result;
    }
};