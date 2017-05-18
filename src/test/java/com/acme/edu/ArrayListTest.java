package com.acme.edu;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ilya on 18/05/2017.
 */
public class ArrayListTest {
    //should OUTCOME When STIMULUS
    @Test(timeout = 10000)
    public void shouldSizeIncrementedAndElementSavedAtTailWhenSutIsEmpty() {
        //region Given
        ArrayList<Object> sut = new ArrayList<Object>();
        Object dummy = new Object();
        //endregion

        assumeTrue(sut.isEmpty()); //AssumptionViolatedException

        //region When
        sut.add(dummy);
        //endregion

        //region Then
        assertEquals(1,sut.size()); //AssertionError
        //endregion
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotCreateWhenCapacityIsNegative() {
        new ArrayList(-1);

    }
    @Test @Ignore
    public void shouldSizeBeZeroWhenCreated() {}

    @Test
    public void shouldUseElementsToStringWhenToString() {
        //region Given
        ArrayList<Object> sut = new ArrayList<Object>();
        Object stub = mock(Object.class);
        when(stub.toString())
                .thenReturn("test string 1")
                .thenReturn("test string 2");
        sut.add(stub);
        //endregion

        //region When
        String result = sut.toString();
        //endregion

        //region Then
        assertTrue(result.contains("test string"));
        //endregion
    }
}
