import jdk.jshell.Snippet;

import java.util.Currency;

public class PaymentGatewayGKCS {

}

class User {
    String id;

    public void create(Transaction t) {

    }
}

class Transaction {
    Status status;
    String id;
    Amount amount;
    Account senderAccount;
    Account receiverAccount;
    String description;
    PaymentMethod paymentMethod;

    public void setStatus(State newState) {
        State oldState = state;
        state = newState;
        status.notifyUsers(senderAccount, receiverAccount, oldState);
    }
}


class SuccessfulTransaction extends State {
    @Override
    void notifyUsers(Account senderAccount, Account receiverAccount, State oldState) {
        if (oldState.name.equals(StateName.IN_PROGRESS)) {
            //notify sender, and receiver
        } else if (oldState.name.equals(StateName.ON_HOLD)) {
            //notify sender and receiver through email and sms.
        }
    }
}

class FailedTransaction extends State {

    @Override
    void notifyUsers(Account senderAccount, Account receiverAccount, State oldState) {
        if (oldState.name.equals(StateName.IN_PROGRESS)) {
            //notify failed sender, and receiver
        } else if (oldState.name.equals(StateName.ON_HOLD)) {
            //notify failed sender and receiver through email and sms.
        }
    }
}

enum PaymentMethod {
    CARD, UPI, BANK_TRANSFER, GIFY
}

class Amount {
    double value;
    Currency currency;
}

abstract class State {
    abstract void notifyUsers(Account senderAccount, Account receiverAccount, State oldState);
    StateName name;
    //successful, FAILED, IN_PROGRESS, ON_HOLD
}
enum StateName {
    SUCCESSFULL, FAILED, IN_PROGRESS, ON_HOLD
}

class RuleEngine {
    public void validate(Transaction t) {
        return false;
    }

    public boolean isFraud(Transaction t) {
        return false;
    }
}

interface  Strategy {
    StrategyName strategyName;
    boolean validate(Transaction t);
}

enum StrategyName {
    CASH, CROSS_COUNTRY, ONLINE
}

class CashStrategy implements Strategy {

    @Override
    public boolean validate(Transaction t) {
        return t.amount <= 100;
    }
}

class OnlineStrategy implements Strategy {

    @Override
    public boolean validate(Transaction t) {
        return t.amount <= 10;
    }
}
class Bank {
    String id;
    String name;
    String metadata;
}






