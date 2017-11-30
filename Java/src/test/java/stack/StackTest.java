package stack;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(Theories.class)
public class StackTest
{
    @DataPoint
    public static IStack<Integer> stack = new StackArray<>();

    @Theory
    public void shouldAddToElementToStack(IStack<Integer> stack)
    {
        int valToPush = 5;

        stack.push(valToPush);

        assertThat(stack.pop()).isEqualTo(5);
    }

    @Theory
    public void shouldAddMultipleElementsToStack(IStack<Integer> stack)
    {
        int valA = 5;
        int valB = 6;

        stack.push(valA);
        stack.push(valB);

        assertThat(stack.pop()).isEqualTo(valB);
        assertThat(stack.pop()).isEqualTo(valA);
    }

    @Theory
    public void shouldThrowEmptyStackExceptionWhenPoppingFromEmptyStack(IStack<Integer> stack)
    {
        Throwable throwable = catchThrowable(stack::pop);

        assertThat(throwable.getClass()).isEqualTo(EmptyStackException.class);
    }

    @Test
    public void shouldPeekAtTopElement()
    {
        int valA = 5;
        int valB = 6;

        stack.push(valA);
        stack.push(valB);

        assertThat(stack.peek()).isEqualTo(valB);
    }
}