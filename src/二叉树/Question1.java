package 二叉树;

import javax.swing.tree.TreeNode;

/**
 * 求二叉树中的节点个数
 *
 * @author Tainy
 * @date 2018/10/31 17:40
 */
public class Question1 {

    public int getNodeNum(TreeNode root){
        if(root == null){
            return 0;
        }

        return getNodeNum(root.getChildAt(1));
    }
}
