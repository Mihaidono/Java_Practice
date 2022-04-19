package Mihaidono;

public class ChainedList {
    public Node head = null;
    public Node tail = null;

    public int size() {
        int size = 0;
        Node auxNode = head;
        if (auxNode == null) {
            return 0;
        } else {
            size = 1;
            while (auxNode != null) {
                size++;
                auxNode = auxNode.next;
            }
        }
        return size;
    }

    public Node getNode(int value){
        Node newHead=head;
        while(newHead!=null){
            if(newHead.value==value)
                return newHead;
            newHead=newHead.next;
        }
        return new Node(-1);
    }
    public void addSon(Node parent,Node son){
        parent.sons.add(son);
        son.parent=parent;
    }

    public void addNode(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void InsertPos(int position, int data) {
        Node node = new Node(data);
        node.next = null;

        if (this.head == null) {
            if (position != 0) {
                return;
            } else {
                this.head = node;
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
        previous.next = node;
    }


    public void display() {
        Node main = head;
        if (head == null) {
            System.out.println("The List is empty");
        } else {
            System.out.println("The List's nodes are: ");
            while (main != null) {
                System.out.print(main.value + " ");
                main = main.next;
            }
        }
    }

    public void delete(int index) {
        if (head != null) {
            Node aux = head;
            if (index == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < index - 1 && aux != null; i++) {
                    aux = aux.next;
                }
                if (aux != null && aux.next != null) {
                    aux.next = aux.next.next;
                }
            }
        }
    }
}
