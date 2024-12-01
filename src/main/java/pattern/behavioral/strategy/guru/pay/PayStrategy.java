package pattern.behavioral.strategy.guru.pay;

/*
* 모든 strategy들의 공통 interface
* */
public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
