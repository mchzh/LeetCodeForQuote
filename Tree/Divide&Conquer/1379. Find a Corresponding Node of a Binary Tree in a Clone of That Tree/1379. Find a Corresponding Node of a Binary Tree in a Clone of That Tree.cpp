class Solution {
public:
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        if( original == nullptr)
            return original;
        
        if( original == target){
            return cloned;
        }
        TreeNode* one = getTargetCopy(original->left,cloned->left,target);
        if( one != nullptr)
            return one;
        TreeNode* two =getTargetCopy(original->right,cloned->right,target);
        return two;
    }
};
