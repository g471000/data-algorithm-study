package ch_03_stack_and_queue.q03_multi_stack;

public class Runner {
    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        for (int n : nums) {
            stacks.push(n);
            stacks.print();
            System.out.println();
        }


        for (int i = 0; i < 5; i++) {
            stacks.pop();
            stacks.print();
            System.out.println();
        }
        stacks.print();
        System.out.println();
    }
}
