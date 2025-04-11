class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            front = (front + 1) % capacity;
        } else {
            size++;
        }

        buffer[rear] = value;
        rear = (rear + 1) % capacity;
    }

    public void displayBuffer() {
        System.out.print("Buffer: [");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(buffer[i]);
            if (count < size - 1) System.out.print(", ");
            i = (i + 1) % capacity;
        }
        System.out.println("]");
    }
}

public class Circular_buffer {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3); // Buffer size 3

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.displayBuffer();

        buffer.insert(4);
        buffer.displayBuffer();

        buffer.insert(5);
        buffer.displayBuffer();
    }
}
