package Mihaidono;

public class MyDChainedList {
    public Node head = null;
    public Node tail = null;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = head.prev;
        }
    }

    public void display() {
        Node main = head;
        if (main == null) {
            System.out.println("The Double Linked List is empty");
        } else {
            System.out.println("The Double Linked List's nodes are: ");
            while (main != null) {
                System.out.print(main.value + " ");
                main = main.next;
            }
        }
    }

    public void delete(int n) {
        if (head != null) {

            Node main = head;
            int pos = n;

            for (int i = 0; i < pos; i++) {
                main = main.next;
            }

            if (main == head) {
                head = main.next;
                head.prev=tail.next;
            } else if (main == tail) {
                tail = tail.prev;
                tail.next=head.prev;
            } else {
                main.prev.next = main.next;
                main.next.prev = main.prev;
            }
            main = null;
        }
    }

    public void insertPos(int position, int data) {

        Node node = new Node(data);
        node.next = null;
        node.prev = null;

        if (this.head == null) {
            if (position == 0) {
                this.head = node;
                this.tail = node;
            }
        }

        if (head != null && position == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }

        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < position) {
            previous = current;
            current = current.next;
            if (current == null) {
                break;
            }
            i++;
        }

        node.next = current;
        current.prev=node;

        previous.next = node;
        node.prev=previous;

    }

    public int size() {
        int size = 0;
        Node auxNode = head;
        if (auxNode == null) {
            return 0;
        } else {
            while (auxNode != null) {
                size++;
                auxNode = auxNode.next;
            }
        }
        return size;
    }
}
