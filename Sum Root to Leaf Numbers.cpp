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
   
    int sumNumbers(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int num = 0;
        vector<int> result;
        findSum(root, num, result);
        int sum = 0;
        for (int i = 0; i< result.size(); i++)
        {
            sum += result[i];
        }
        return sum;
    }
    
    void findSum(TreeNode*root, int num, vector<int> &result)
    {
        if(root==NULL)
        {
            return;
        }
        else
        {
            int newnum = num*10 + root->val;
            if(root->left==NULL&&root->right==NULL)
                result.push_back(newnum);
            findSum(root->left, newnum, result);
            findSum(root->right, newnum, result);
        }
    }
    
};