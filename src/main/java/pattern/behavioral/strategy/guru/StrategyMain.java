package pattern.behavioral.strategy.guru;

import pattern.behavioral.strategy.guru.order.Order;
import pattern.behavioral.strategy.guru.pay.PayByCocoaPay;
import pattern.behavioral.strategy.guru.pay.PayByCreditCard;
import pattern.behavioral.strategy.guru.pay.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// REFACTORING GURU - Strategy in Java 코드 참고하여 일부 변형(https://refactoring.guru/design-patterns/strategy/java/example#example-0--Demo-java)
/*
* 클라이언트 코드
* */
public class StrategyMain {
    public static void main(String[] args) throws IOException {
        new ShoppingApplication().start();
    }

    static class ShoppingApplication {

        private final Map<Integer, Integer> priceOnProducts = new HashMap<>();
        private final Order order = new Order();
        private PayStrategy payStrategy;

        private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public ShoppingApplication() {
            priceOnProducts.put(1, 2200);
            priceOnProducts.put(2, 2000);
            priceOnProducts.put(3, 1800);
            priceOnProducts.put(4, 1600);
        }

        public void start() throws IOException {
            while (!order.isClosed()) {
                int cost;

                String continueChoice;
                do {
                    System.out.println("""
                            Please, select a product:
                            1 - Mother board
                            2 - CPU
                            3 - HDD
                            4 - Memory
                            """);

                    int choice = Integer.parseInt(reader.readLine());
                    cost = priceOnProducts.get(choice);

                    System.out.print("Count: ");
                    int count = Integer.parseInt(reader.readLine());
                    order.setTotalCost(cost * count);

                    System.out.print("Do you wish to continue selecting products? Y/N: ");
                    continueChoice = reader.readLine();
                } while (continueChoice.equalsIgnoreCase("Y"));

                if (payStrategy == null) {
                    System.out.println("""
                            Please, select a payment method:
                            1 - Cocoa Pay
                            2 - Credit Card
                            """);
                    String paymentMethod = reader.readLine();

                    // 클라이언트 코드에서 사용자의 input, 애플리케이션 설정 등등에 따라 다른 전략을 생성
                    if (paymentMethod.equals("1")) {
                        payStrategy = new PayByCocoaPay();
                    } else {
                        payStrategy = new PayByCreditCard();
                    }
                }

                /*
                 * Order 객체는 processOrder() 메서드 내에서 선택된 PayStrategy 객체에 payment data를 처리하는 것을 위임
                 * - payment를 처리하기 위해 무엇이 필요한지는 PayStrategy 타입 객체들만이 알고 있음
                 * */
                order.processOrder(payStrategy);

                System.out.printf("Pay %d dollars or Continue shopping? P/C: ", order.getTotalCost());
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                    // 최종적으로 PayStrategy 객체가 payment를 처리
                    if (payStrategy.pay(order.getTotalCost())) {
                        System.out.println("Payment has been successful!");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    order.setClosed();
                }
            }
        }
    }
}


