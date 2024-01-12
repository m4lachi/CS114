import java.util.ArrayList;

class CircularQueue {
    private int size, front, rear;
    private ArrayList<String> queue;

    public CircularQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        queue = new ArrayList<>();
    }

    public void enQueue(String data) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1 + size) % size)) {
            System.out.println("Queue is full");
        } else if (front == -1) {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, data);
        } else {
            rear = (rear + 1) % size;
            if (front <= rear) {
                queue.add(rear, data);
            } else {
                queue.set(rear, data);
            }
        }
    }

    public String deQueue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return null;
        }
        String temp = queue.get(front);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        return temp;
    }

    public void displayQueue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Elements in the circular queue are: ");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue.get(i) + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(queue.get(i) + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue.get(i) + " ");
            }
        }
        System.out.println();
    }

    public int size() {
        return (front == -1) ? 0 : (rear >= front) ? (rear - front + 1) : (size - front + rear + 1);
    }

    public static String hotPotato(String[] nameList, int musical_num) {
        CircularQueue simQueue = new CircularQueue(nameList.length);

        for (String name : nameList) {
            simQueue.enQueue(name);
        }
        simQueue.displayQueue();
        for (int pass = 0; pass < musical_num; pass++) {
            String removed = simQueue.deQueue(); // remove person at head
            System.out.println(removed + " is out of the game.");
            simQueue.enQueue(removed);
            simQueue.displayQueue(); // printing for debugging purposes
        }
        return simQueue.deQueue();
    }

    public static void main(String[] args) {
        String[] people = {"Bill", "David", "Susan", "Jane", "Kent", "Brad"};
        String lastPerson = hotPotato(people, 3);
        System.out.println("Last person is " + lastPerson + ".");
    }
}
