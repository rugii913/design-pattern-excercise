package pattern.behavioral.strategy.guru.order;

import pattern.behavioral.strategy.guru.pay.PayStrategy;

/*
* - Order는 사용자가 선택한 구체적인 payment method(구체적인 전략)를 모름
*   - Order는 공통의 strategy interface를 사용하여 지불 데이터를 수집하는 일을 전략 객체에 위임
*   - 이는 order를 DB에 저장하는 데에 사용될 수 있음
* */
public class Order {

    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
        // 기타 order 로직...
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return this.totalCost;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public void setClosed() {
        this.isClosed = true;
    }
}
