public class SingleLinkList {
    // private ListNode head; // head node to hold the list

    //given a listnode , print all element it hold
    public void display(ListNode head){
        if (head == null){
            return;
        }

        ListNode current = head;
        //loop each element till end of the list
        //last node point to null
        while (current != null){
            System.out.print(current.data + " --> ");//print current element data
            //move to next element
            current = current.next;
        }
        System.out.println(current); //here current will be null
    }

    //given a listnode head , find out length of linked list
    public int length(ListNode head){
        if (head == null){
            return 0;
        }
        //create a count variable to hold length
        int count = 0;
        //loop each element and increment the count till list end
        ListNode current = head;
        while (current != null){
            count++;
            //move to next node
            current = current.next;
        }
        return count;
    }

    //insert node at beggining of linked list
    public ListNode insertAtBeggining(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        if (head == null){
            return newNode;
        }
        newNode.next = head;
        head = newNode;

        return head; //this head will be new head, having new node at beggining
    }

    //insert node at the end of linked list
    public ListNode insertAtTheEnd(ListNode head, int data){
       ListNode newNode =  new ListNode(data);
       if (head == null){
           return newNode;
       }

       ListNode current = head;
       while(current.next != null){
           current = current.next;
       }
       current.next = newNode;

       return head;
    }

    //insert after given node in java
    public void insertAfter(ListNode previous, int data){
        if (previous == null){
            System.out.println("the given previous node cannot be null. ");
            return;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = previous.next;
        previous.next = newNode;
    }

    //insert node at custom position
    public ListNode insertAtPosition(ListNode head, int data, int position){
        //perform boundary check
        int size = length(head);
        if (position > size + 1 || position < 1){
            System.out.println("invalid Position");
            return head;
        }

        ListNode newNode = new ListNode(data);
        if(position == 1){
            newNode.next = head;
            return newNode;
        }else {
            ListNode previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
            return head;
        }
    }

    // it contains a static inner class listnode
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main (String [] argument){
        //lets create a linked list
        //10 --> 8 --> 1 --> 11 --> null
        //10 as head node  of linked list
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);

        // attach them together to form a list
        head.next = second; // 10 --> 8
        second.next = third; // 10 --> 8 --> 1
        third.next = fourth; // 10 --> 8 --> 1 --> 11 --> null

        SingleLinkList singleLinkList = new SingleLinkList();
        head = singleLinkList.insertAtPosition(head, 333,3);
        singleLinkList.display(head);

        ListNode newHead = singleLinkList.insertAtBeggining(head, 15);
        ListNode lastNode = singleLinkList.insertAtTheEnd(head, 20);

        singleLinkList.display(newHead);
        singleLinkList.display(lastNode);
        //System.out.println("single of linked list is - " + singleLinkList.length(head));
    }
}


