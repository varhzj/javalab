package com.varhzj.lab.interview.stackandqueue;

import java.util.Stack;

/**
 * Created by huangzhijian on 16-8-8.
 */
// 不使用其他数据结构实现栈的逆序
public class ReverseStack {

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty())
            return result;
        else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        ReverseStack rs = new ReverseStack();
        rs.reverse(stack);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

}
