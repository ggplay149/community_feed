package common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ggplay149.common.domain.PositiveIntegerCounter;
import org.junit.jupiter.api.Test;

public class PositiveIntegerCounterTest {

    @Test
    void givenCreated_whenIncrease_thenCountIsOne(){
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        //when
        counter.increase();
        //then
        assertEquals(1,counter.getCount());
    }

    @Test
    void givenCreated_whenIncreaseAndDecrease_thenCountIsOne(){
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        //when
        counter.increase();
        counter.decrease();
        //then
        assertEquals(0,counter.getCount());
    }

    @Test
    void givenCreated_whenDecrease_thenCountIsOne(){
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        //when
        counter.decrease();
        //then
        assertEquals(0,counter.getCount());
    }

}
