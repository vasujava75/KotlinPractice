package practice.Strings;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Transaction {
    private Date date;
    private double amount;
    private String item;
    private String description;

    public Transaction(String input) {
        // Parse the input string
        String[] parts = input.split(" ");
        String dateString = parts[0];
        String amountString = parts[1].substring(1); // Remove the dollar sign
        String itemString = parts[2];
        String descriptionString = parts[3];

        // Parse date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Parse amount
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try {
            amount = decimalFormat.parse(amountString).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Assign other fields
        item = itemString;
        description = descriptionString;
    }

    // Getters for fields (you can add setters if needed)

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        String input1 = "01/02/1988 $100.30 apple (goods& health)";
        String input2 = "01/02/1988 $120.30 apple (retail)";
        String input3 = "01/02/1988 $130.30 apple (retail)";

        List<Transaction> transactions = Arrays.asList(input1, input2, input3)
                .stream()
                .map(Transaction::new)
                .collect(Collectors.toList());

        transactions.forEach(System.out::println);

        // Define date range (e.g., from 01/01/1988 to 01/03/1988)
        Date startDate = new Date("01/01/1988") /* Your start date */;
        Date endDate = new Date(" 01/03/1988")/* Your end date */;

        // Filter transactions within the date range
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.getDate().compareTo(startDate) >= 0 && t.getDate().compareTo(endDate) <= 0)
                .collect(Collectors.toList());

        // Calculate total amount
        double totalAmount = filteredTransactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        //System.out.println("Total amount: $" + totalAmount);

        Map<String,List<Transaction>> dataasdf =  transactions.stream().collect(Collectors.groupingBy(Transaction::getDescription,Collectors.toList()));
        List<Double> doubles = dataasdf.entrySet().stream().map(entry->entry.getValue().stream().mapToDouble(Transaction::getAmount).sum()).collect(Collectors.toList());
        System.out.println(doubles);
    }
}
