package lists;

public class EmployeeLinkedList {
    private EmployeeNode head;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.println(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }


}
