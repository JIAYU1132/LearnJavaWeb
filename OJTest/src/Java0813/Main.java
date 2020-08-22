package Java0813;


// 二叉树中的列表

//给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
//
//如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
// 那么请你返回 True ，否则返回 False 。
//
//一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
//

public class Main {
     class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }


     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

     class Solution {
         public boolean isSubPath(ListNode head, TreeNode root) {
             if (head == null) {
                 return true;
             }
             if (root == null) {
                 return false;
             }
             return check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
         }

         public boolean check(ListNode head, TreeNode node) {

             if (head == null) {
                 return true;
             }
             if (node == null) {
                 return false;
             }

             if (head.val != node.val) {
                 return false;
             }

             return check(head.next, node.left) || check(head.next, node.right);
         }
     }
 }