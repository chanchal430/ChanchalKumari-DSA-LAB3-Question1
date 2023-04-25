package com.greatlearning.driver;
import java.util.Scanner;
import java.util.Stack;

/*Driver class of program */
public class DriverApp {

	/* Main method to execute code */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Expression:");
		String input = sc.next();

		/*
		 * Comparing each expression and checking whether inserted input is valid or not
		 */
		if (checkExpression(input))
			System.out.println("The Entered String has  Balanced Brackets");
		else
			System.out.println("The Entered String do not contain  Balanced Brackets");
	}

	/* Function for expression checking through stack */
	private static boolean checkExpression(String input) {
		Stack<Character> stack = new Stack<>();
		for (char k : input.toCharArray()) {

			/* Pushing expression in stack */
			if (k == '{' || k == '[' || k == '(') {
				stack.push(k);
				continue;
			}

			/* if Stack is empty then return false */
			if (stack.isEmpty())
				return false;

			/* popping from stack when closing brackets came */
			char z;
			switch (k) {
			case '}':
				z = stack.pop();
				if (z == '[' || z == '(')
					return false;
				break;

			case ']':
				z = stack.pop();
				if (z == '{' || z == '(')
					return false;
				break;
			case ')':
				z = stack.pop();
				if (z == '{' || z == '[')
					return false;
				break;
				
			}
			
		}
		/* checking the stack status after completion of function */
		return (stack.isEmpty());
        
	}
}
