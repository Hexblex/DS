package queue;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(Theories.class)
public class QueueTest
{
    @DataPoint
    public static IQueue<Integer> queue = new QueueCircularArray<>();

    @Theory
    public void shouldEnqueueElement(IQueue<Integer> queue)
    {
        int valToAdd = 5;

        queue.enqueue(valToAdd);

        assertThat(queue.dequeue()).isEqualTo(valToAdd);
    }

    @Test
    public void shouldThrowQueueFullExceptionWhenEnqueuingToFullStack()
    {
        int valToAdd = 5;
        int valOtherToAdd = 6;
        IQueue<Integer> queue = new QueueCircularArray<>(1);

        queue.enqueue(valToAdd);
        Throwable throwable = catchThrowable(() -> queue.enqueue(valOtherToAdd));

        assertThat(throwable.getClass()).isEqualTo(QueueFullException.class);
    }

    @Test
    public void shouldThrowQueueEmptyExceptionWhenDequeuingFromEmptyStack()
    {
        Throwable throwable = catchThrowable(this.queue::dequeue);

        assertThat(throwable.getClass()).isEqualTo(QueueEmptyException.class);
    }
}