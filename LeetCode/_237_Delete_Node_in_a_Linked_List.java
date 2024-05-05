package LeetCode;

public class _237_Delete_Node_in_a_Linked_List {
    public void deleteNodeFunctional1(ListNode node) {
        //All the values of the linked list are unique
        //given node node is not the last node in the linked list.
        while(node.next != null) {
            node.val = node.next.val;
            if(node.next.next == null) {
                node.next = null;
                break;
            } else  {
                node = node.next;
            }
            
        }
    }

    public void deleteNodeFunctional2(ListNode node) {
        //All the values of the linked list are unique
        //given node node is not the last node in the linked list.
        while(node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    //OFICIAL SOLUTION
    public void deleteNode(ListNode node) {
        // Overwrite data of next node on current node.
        node.val = node.next.val;
        // Make current node point to next of next node.
        node.next = node.next.next;
    }


}


