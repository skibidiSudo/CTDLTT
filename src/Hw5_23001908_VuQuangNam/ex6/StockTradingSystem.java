package Hw5_23001908_VuQuangNam.ex6;

import Hw5_23001908_VuQuangNam.ex2.MinHeapPriorityQueue;
import java.util.Scanner;

public class StockTradingSystem {
    private MinHeapPriorityQueue<Double, TradeOrder> buyOrders;
    private MinHeapPriorityQueue<Double, TradeOrder> sellOrders;

    public StockTradingSystem() {
        buyOrders = new MinHeapPriorityQueue<>();
        sellOrders = new MinHeapPriorityQueue<>();
    }

    public void addOrder(TradeOrder order) {
        if (order.getType().equalsIgnoreCase("buy")) {
            buyOrders.insert(-order.getPrice(), order);
            processOrders();
        } else if (order.getType().equalsIgnoreCase("sell")) {
            sellOrders.insert(order.getPrice(), order);
            processOrders();
        } else {
            System.out.println("Invalid order type: " + order.getType());
        }
    }

    private void processOrders() {
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            TradeOrder buyOrder = buyOrders.min().getValue();
            TradeOrder sellOrder = sellOrders.min().getValue();
            if (sellOrder.getPrice() <= -buyOrders.min().getKey()) {
                int quantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
                System.out.println("Processed trade: " + quantity + " shares at $" + sellOrder.getPrice());
                if (buyOrder.getQuantity() > quantity) {
                    buyOrders.insert(-buyOrder.getPrice(), new TradeOrder("buy", buyOrder.getQuantity() - quantity, buyOrder.getPrice()));
                }
                if (sellOrder.getQuantity() > quantity) {
                    sellOrders.insert(sellOrder.getPrice(), new TradeOrder("sell", sellOrder.getQuantity() - quantity, sellOrder.getPrice()));
                }
                buyOrders.removeMin();
                sellOrders.removeMin();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        StockTradingSystem tradingSystem = new StockTradingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter order (e.g., buy 100 20.5 or sell 50 21.0) or type 'exit' to quit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                String type = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                TradeOrder order = new TradeOrder(type, quantity, price);
                tradingSystem.addOrder(order);
            } else {
                System.out.println("Invalid input format. Please try again.");
            }
        }

        scanner.close();
    }
}
