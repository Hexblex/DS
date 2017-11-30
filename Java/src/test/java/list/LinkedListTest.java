package list;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest
{
    LinkedList<Integer> list = new LinkedList<>();

    @Test
    public void shouldAddSingleElementToList() throws Exception
    {
        list.add(5, 0);

        assertThat(list.contains(5)).isTrue();
    }

    @Test
    public void shouldInitializeListWithoutAnyElements() throws Exception
    {
        assertThat(list.getHead()).isNull();
    }

    @Test
    public void shouldAddMultipleElementsToList() throws Exception
    {

        list.add(5,0);
        list.add(10, 1);

        assertThat(list.contains(5)).isTrue();
        assertThat(list.contains(10)).isTrue();
    }

    @Test
    public void shouldAddElementAtBeginning() throws Exception
    {
        list.addToHead(5);
        list.addToHead(10);

        assertThat(list.getHead().getVal()).isEqualTo(10);
    }

    @Test
    public void shouldDeleteFirst() throws Exception
    {
        list.add(5,0);
        list.add(10,1);

        list.removeFirst();

        assertThat(list.contains(5)).isFalse();
    }

    @Test
    public void shouldDeleteElementInMiddle() throws Exception
    {
        list.add(0, 0);
        list.add(1,1);
        list.add(2,2);

        list.remove(1);

        assertThat(list.contains(1)).isFalse();
    }

    @Test
    public void shouldDeleteElementsAtBeginning() throws Exception
    {

        list.add(0, 0);
        list.add(1,1);
        list.add(2,2);

        list.remove(0);

        assertThat(list.contains(0)).isFalse();
    }

    @Test
    public void shouldDeleteElementsAtEnd() throws Exception
    {

        list.add(0, 0);
        list.add(1,1);
        list.add(2,2);

        list.remove(2);

        assertThat(list.contains(2)).isFalse();
    }
}