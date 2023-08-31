import java.util.*;

class TwoStacks {
	int[] arr;
	int size;
	int top1, top2;

	TwoStacks(int n)
	{
		size = n;
		arr = new int[n];
		top1 = n / 2 + 1;
		top2 = n / 2;
	}

	void pushStack1(int x)
	{

		if (top1 > 0) {
			top1--;
			arr[top1] = x;
		}
		else {
			System.out.println("Stack Overflow"
							 + x);
			return;
		}
	}

	void pushStack2(int x)
	{

	//there is atleast one element 
		if (top2 < size - 1) {
			top2++;
			arr[top2] = x;
		}
		else {
			System.out.println("Stack Overflow"
							 + x);
			return;
		}
	}
//pop element from first stack
	int popStack1()
	{
		if (top1 <= size / 2) {
			int x = arr[top1];
			top1++;
			return x;
		}
		else {
			System.out.print("Stack UnderFlow");
			System.exit(1);
		}
		return 0;
	}

//pop element from second stack
	int popStack2()
	{
		if (top2 >= size / 2 + 1) {
			int x = arr[top2];
			top2--;
			return x;
		}
		else {
			System.out.print("Stack UnderFlow");
			System.exit(1);
		}
		return 1;
	}
};
class TwoStackFun {

	public static void main(String[] args)
	{
		TwoStacks ts = new TwoStacks(5);
		ts.pushStack1(5);
		ts.pushStack2(10);
		ts.pushStack2(15);
		ts.pushStack1(11);
		ts.pushStack2(7);
		System.out.println("Popped element from stack1 is "
						+ ": " + ts.popStack1());
		ts.push2(40);
		System.out.println("Popped element from stack2 is "
						+ ": " + ts.popStack2());
	}
}

