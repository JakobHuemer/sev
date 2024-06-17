package schuli.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    @Test
    void push() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    void pop() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    void peek() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        stack.pop();
        assertEquals(2, stack.peek());
    }

    @Test
    void peekEmpty() {
        CustomStack<Integer> stack = new CustomStack<>();
        assertNull(stack.peek());
    }

    @Test
    void popEmpty() {
        CustomStack<Integer> stack = new CustomStack<>();
        assertNull(stack.pop());
    }

    @Test
    void pushNull() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(null);
        assertNull(stack.peek());
    }

    @Test
    void pushPop() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }


}