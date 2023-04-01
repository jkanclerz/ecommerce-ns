package pl.jkanclerz.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignInitialCredit() {
        //arrange
        CreditCard card = new CreditCard("1234-5678");
        //act
        card.assignCredit(BigDecimal.valueOf(1000));
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itAllowsToAssignInitialCreditV2() {
        //arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        //act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(2000));

        assert card1.getBalance().equals(BigDecimal.valueOf(1000));
        assert card2.getBalance().equals(BigDecimal.valueOf(2000));
    }

    @Test
    void itDenyCreditLimitBelowThreshold() {
        CreditCard card = new CreditCard("1234-5678");
        try {
            card.assignCredit(BigDecimal.valueOf(100));
            fail("it should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }
    @Test
    void itDenyCreditLimitBelowThresholdV1() {
        CreditCard card = new CreditCard("1234-5678");

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10))
        );

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(100))
        );

        assertDoesNotThrow(
                () -> card.assignCredit(BigDecimal.valueOf(101))
        );
    }

    @Test
    void itDenyToAssignLimitTwice() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(2000));

        assertThrows(
                CantResignCreditException.class,
                () -> card.assignCredit(BigDecimal.valueOf(2500))
        );
    }

    @Test
    void lestCheckDoubel() {
        double d1 = 0.3;
        double d2 = 0.2;
        double result = (d1 - d2);
    }

    @Test
    void lestCheckFloat() {
        float f1 = 0.3f;
        float f2 = 0.2f;
        float result = (f1 - f2);
    }

    @Test
    void lestCheckBigDecimal() {
        BigDecimal bd1 = new BigDecimal("0.03");
        BigDecimal bd2 = new BigDecimal("0.02");
        BigDecimal result = bd1.subtract(bd2);
    }
}
