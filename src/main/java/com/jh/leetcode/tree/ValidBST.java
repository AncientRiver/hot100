package com.jh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return isValidBST(root, list);
    }

    private boolean isValidBST(TreeNode root, List<Integer> list) {
        if (root == null) return true;
        boolean flag = true;
        if (root.left != null) {
            flag = flag && isValidBST(root.left, list);
        }
        if (list.isEmpty() || root.val > list.get(list.size() - 1)) {
            list.add(root.val);
        } else {
            return false;
        }

        if (root.right != null) {
            if (root.right.val > root.val) {
                flag = flag && isValidBST(root.right, list);
            } else {
                return false;
            }

        }
        return flag;
    }

    /** 该算法未考虑左右子树的值 和 上层根节点的关系
     * @param root
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        boolean flag = true;
//        if (root.left != null) {
//            flag = flag && (root.left.val < root.val);
//            flag = flag && isValidBST(root.left);
//        }
//        if (root.right != null) {
//            flag = flag && (root.right.val > root.val);
//            flag = flag && isValidBST(root.right);
//        }
//        return flag;
//    }
}
