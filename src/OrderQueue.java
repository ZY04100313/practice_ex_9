import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class OrderQueue {
    private Queue<String> orderQueue;

    public OrderQueue() {
        orderQueue = new LinkedList<>();
    }

    public void addOrder(String order) {
        orderQueue.add(order);
        System.out.println("Order added to the queue: " + order);
    }

    private String processNextOrder() {
        if (!orderQueue.isEmpty()) {
            return orderQueue.poll();
        }
        return null;
    }

    private void displayAllOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("The order queue is empty.");
        } else {
            for (String order : orderQueue) {
                System.out.println(order);
            }
        }
    }

    private boolean isQueueEmpty() {
        return orderQueue.isEmpty();
    }

    public void handleQueue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with the order queue:");
            System.out.println("1. Add a new order");
            System.out.println("2. Process the next order");
            System.out.println("3. Display all orders");
            System.out.println("4. Check if the queue is empty");
            System.out.println("Enter your choice (1 – 4)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the order details:");
                    String order = scanner.nextLine();
                    addOrder(order);
                    break;
                case 2:
                    if (!isQueueEmpty()) {
                        System.out.println("Processing order: " + processNextOrder());
                    } else {
                        System.out.println("The order queue is empty.");
                    }
                    break;
                case 3:
                    displayAllOrders();
                    break;
                case 4:
                    if (isQueueEmpty()) {
                        System.out.println("The order queue is empty.");
                    } else {
                        System.out.println("The order queue is not empty.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}    