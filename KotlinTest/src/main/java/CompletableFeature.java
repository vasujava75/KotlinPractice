
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

    public class CompletableFeature {

        /**
         * Invoke your code. This example shows simple main method.
         * Although this can be HTTP Resouce, Or JMS/Kafka Listener
         * @param args
         */
        public static void main(String[] args) {

            var number_of_calculations_needed = 100;

            var receipts = new ArrayList<>(number_of_calculations_needed);
        /*
            We want to fetch 100 Interesting numbers.
            Fetching these numbers is IO intensive task, and will have waiting times.
            Once the interesting number is fetched, we want to first double it and later divide it by 100.
         */
            for (int i = 0; i < number_of_calculations_needed; i++) {

                var receipt = find_interesting_number()
                        .thenApply(CompletableFeature::double_it)
                        .thenApply(CompletableFeature::divide_by_100)
                        .thenAccept(CompletableFeature::pretty_print_result);

                receipts.add(receipt);
            }

            System.out.println("Submitted Work, Now waiting for results....");

        /*
            Collect all the receipts
         */
            var all_receipts = CompletableFuture.allOf(receipts.toArray(new CompletableFuture[number_of_calculations_needed]));

        /*
            Wait for actual results. Here the main thread will wait, till we get all the results.
         */
            all_receipts.join();

            System.out.println("Fetched Results ..");
        }

        /**
         * Method that does post processing on result.
         * @param input
         * @return integer
         */
        private static Integer double_it(Integer input) {
            return input * 2;
        }

        /**
         * Method that does post processing on previous result.
         * @param input
         * @return integer
         */
        private static Integer divide_by_100(Integer input) {
            return Math.floorDiv(input, 100);
        }

        /**
         * Method that prints the result
         * @param input
         */
        private static void pretty_print_result(Integer input) {
            System.out.printf("Result is %d. Done by Thread %s\n", input, Thread.currentThread().getName());
        }

        /**
         * Method doing complex work, that takes some time to finish.
         * @return CompletableFuture of the result
         */
        public static CompletableFuture<Integer> find_interesting_number() {
            return CompletableFuture.supplyAsync(() -> {
                System.out.printf("Working hard to find interesting number on Thread %s\n", Thread.currentThread().getName());
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return new Random().nextInt(9999);
            });
        }


    }