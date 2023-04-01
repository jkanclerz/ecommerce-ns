package pl.jkanclerz.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal limit;

    public CreditCard(String cardNumber) {

    }

    public void assignCredit(BigDecimal credit) {

        if (isCreditAlreadyAssigned()) {
            throw new CantResignCreditException();
        }

        if (isCreditBelowThreshold(credit)) {
            throw new CreditBelowThresholdException();
        }

        this.limit = credit;
    }

    private boolean isCreditBelowThreshold(BigDecimal credit) {
        return BigDecimal.valueOf(100).compareTo(credit) >= 0;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.limit != null;
    }

    public BigDecimal getBalance() {
        return limit;
    }
}
