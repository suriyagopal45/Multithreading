package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Example {
    public static void main(String[] args) {

        try (ForkJoinPool pool = new ForkJoinPool()) {
            int result = pool.invoke(new SumTask(1, 8));
            System.out.println(result);
        }


    }
}


class SumTask extends RecursiveTask<Integer> {

    private int start;
    private int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= 2) {

            int sum = 0;

            for (int i = start; i <= end; i++)
                sum += i;

            return sum;
        }

        int mid = (start + end) / 2;

        SumTask left = new SumTask(start, mid);
        SumTask right = new SumTask(mid + 1, end);

        left.fork();          // Execute asynchronously

        int rightResult = right.compute(); // Current thread computes

        int leftResult = left.join(); // Wait for left

        return leftResult + rightResult;
    }
}