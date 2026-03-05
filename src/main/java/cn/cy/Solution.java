package cn.cy;

// 链表节点定义
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int 整型
     * @return ListNode 类
     */
    public ListNode getList (int n) {
        // n = 1 时无解
        if (n == 1) {
            return null;
        }
        
        // 构造模式：0, 1, 0, 1, ..., 1, 1, 0
        // 前 2n-2 个节点交替排列 (奇数位 0，偶数位 1)
        // 第 2n-1 位放 1(与第 2n-2 位的 1 形成唯一相邻相同对)
        // 第 2n 位放 0
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int i = 1; i <= 2 * n; i++) {
            int val;
            if (i < 2 * n - 1) {
                // 前 2n-2 个节点：交替放置 0, 1, 0, 1, ...
                // 奇数位置放 0，偶数位置放 1
                if (i % 2 == 1) {
                    val = 0;
                } else {
                    val = 1;
                }
            } else if (i == 2 * n - 1) {
                // 倒数第二个节点放 1，与前面的位置 2n-2 的 1 形成相邻相同
                val = 1;
            } else {
                // 最后一个节点放 0
                val = 0;
            }
            
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return dummy.next;
    }
};
