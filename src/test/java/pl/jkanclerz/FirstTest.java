package pl.jkanclerz;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    void baseTestSchema() {
        //Arrange     //  Given
        //Act         //  When
        //Assert      //  Then / Expected
    }

    @Test
    void itSumDigits() {
        //Arrange
        int a = 2;
        int b = 2;
        //Act
        int result = a + b;
        //Assert
        assert result == 4;
    }

    @Test
    void itGreetTheVIP() {
        //A
        String name = "Kuba";
        FooMooBooZoo greeter = new FooMooBooZoo();
        //Act
        String result = greeter.greet(name);
        //Arrange
        assert result.equals("Hello Kuba xD");
    }
}
