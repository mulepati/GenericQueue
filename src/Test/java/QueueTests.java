import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;


public class QueueTests {
    @Test
    public void increaseCapacity() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Assert.assertEquals(12, stack.size());
        Assert.assertEquals((Integer) 11, stack.get(11));
    }

    @Test
    public void popElement() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Assert.assertEquals((Integer) 0, stack.remove());
        Assert.assertEquals(11, stack.size());
    }

    @Test
    public void peekElement() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Assert.assertEquals((Integer) 0, stack.peek());
        Assert.assertEquals(12, stack.size());
    }

    @Test
    public void equals() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Queue<Integer> stack2 = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack2.add(i);
        }

        Assert.assertTrue(stack.equals(stack2));
        Assert.assertTrue(stack2.equals(stack));
    }

    @Test
    public void notEqualsSameSizeAndType() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Queue<Integer> stack2 = new Queue<>();
        for (int i = 11; i <= 0; i--) {
            stack2.add(i);
        }

        Assert.assertFalse(stack.equals(stack2));
        Assert.assertFalse(stack2.equals(stack));
    }

    @Test
    public void notEqualsDifferentSize() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Queue<Integer> stack2 = new Queue<>();
        for (int i = 0; i <= 10; i++) {
            stack2.add(i);
        }

        Assert.assertFalse(stack.equals(stack2));
        Assert.assertFalse(stack2.equals(stack));
    }

    @Test
    public void notEqualsDifferentType() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        Queue<Character> stack2 = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack2.add('a');
        }

        Assert.assertFalse(stack.equals(stack2));
        Assert.assertFalse(stack2.equals(stack));
    }

    @Test
    public void remove() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        stack.remove();

        Assert.assertEquals((Integer) 8, stack.get(7));
        Assert.assertEquals(11, stack.size());
    }

    @Test
    public void removeAll() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i / 2);
        }

        Assert.assertEquals((Integer) 3, stack.get(6));
        Assert.assertEquals((Integer) 3, stack.get(7));
        stack.removeAll(3);
        Assert.assertEquals((Integer) 4, stack.get(6));
        Assert.assertEquals((Integer) 4, stack.get(7));
        Assert.assertEquals(10, stack.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void popElementEmptyStack() {
        Queue<Integer> stack = new Queue<>();
        stack.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void getOutOfBounds() {
        Queue<Integer> stack = new Queue<>();
        for (int i = 0; i <= 11; i++) {
            stack.add(i);
        }

        stack.get(12);
    }

    @Test
    public void removeDuplicates() {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < 10; i++) {
            q.add(i % 5);
        }
        q.removeDuplicates();

        Assert.assertEquals((Integer) 0, q.remove());
        Assert.assertEquals((Integer) 1, q.remove());
        Assert.assertEquals(5, q.size());

    }

}
