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
    vector<vector<int> > levelOrder(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int>> result;
        
        if(root!=NULL)
        {
            int cur = 1;
            int next = 0;
            vector<int> oneResult;
            list<TreeNode *> nodeList;
            nodeList.push_back(root);
            bool reverse = true;
            
            while(!nodeList.empty())
            {
                TreeNode *curNode = NULL;
                cur--;
         
                curNode = nodeList.front();
                nodeList.pop_front();
        
                if(curNode->left)
                {
                    nodeList.push_back(curNode->left);
                    next++;
                }
                
                if(curNode->right)
                {
                    nodeList.push_back(curNode->right);
                    next++;
                }
                
         
                oneResult.push_back(curNode->val);
                if(cur==0)
                {
                    result.push_back(oneResult);
                    oneResult.clear();
                    cur = next;
                    next = 0;
                }
            }
            
        }
        
        return result; 
    }
};