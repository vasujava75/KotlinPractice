package practice.completable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CarwashStatService {

    private final CarwashDataService carwashDataService;

    public CarwashStatService() {
        carwashDataService = new CarwashDataService();
    }

    // This function calculates and returns the average amount paid by customers for car wash services.
    public CompletableFuture<Double> getAverageAmountPaid() {
        // Implement the function here
        return carwashDataService.getCarwashes()
                .thenApply(data->data.stream()
                        .mapToDouble(Carwash::getAmountPaid).average()
                        .getAsDouble());
    }

    // This function determines the most common car color among all the cars that were washed.
    public String getMostCommonCarColor() throws ExecutionException, InterruptedException {
        // Implement the function here
        return carwashDataService.getCarwashes()
                .thenApply(data->data.stream()
                .collect(Collectors.groupingBy(Carwash::getCarColor,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get()
                .getKey()).get();
    }
}
