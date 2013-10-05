class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeLinkNode *father = root;
       
        while(father)
        {
            TreeLinkNode *current = father;
            TreeLinkNode *prev = NULL;
            TreeLinkNode *child = NULL;
            while(current)
            {
                if(current->left)
                {
                    if(child==NULL)
                        child = current->left;
                        
                    if(prev==NULL)
                    {
                        prev = current->left;
                    }
                    else
                    {
                        prev->next = current->left;
                        prev = current->left;
                    }
                }
                
                if(current->right)
                {
                    if(child==NULL)
                        child = current->right;
                    
                    if(prev==NULL)
                    {
                        prev = current->right;
                    }
                    else
                    {
                        prev->next = current->right;
                        prev = current->right;
                    }
                }
                
                current = current->next;
            }
            
            father = child;
        }
    }
};