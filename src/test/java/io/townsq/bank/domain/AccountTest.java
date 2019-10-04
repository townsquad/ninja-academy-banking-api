package io.townsq.bank.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountTest {


    @Test
    public void hasAmount_ShouldFail_WhenRequestedValueIsBiggerThanAvailable() {
        // Arrange
        double available = 200;
        Account underTest = new Account("123", "joao", available);

        double requested = 250;

        // Act
        boolean result = underTest.has(requested);

        //Assert
        assertFalse(result);
    }

    @Test
    public void has_ShouldPass_WhenRequestedValueIsLessOrEqualThanAvailable(){
        // Arrange
        double available = 200;
        Account underTest = new Account("123", "joao", available);

        double requested = 200;

        // Act
        boolean result = underTest.has(requested);

        //Assert
        assertTrue(result);
    }
}
