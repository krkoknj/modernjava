package ch2_178p;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TraderMain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> collect = getTransactions(transactions);
        System.out.println("collect = " + collect);

        List<String> collect1 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println("collect1 = " + collect1);
    }

    private static List<Transaction> getTransactions(List<Transaction> transactions) {
        List<Transaction> collect = transactions.stream()
                .filter(s -> s.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getYear))
                .collect(toList());
        return collect;
    }
}
