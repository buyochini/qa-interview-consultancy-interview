package taxcalc;

import java.util.Objects;

public class TaxCalc {

    private final int percent;

    TaxCalc(int percent) {
        this.percent = percent;
    }

    @SafeVarargs
    public final Pair<Integer, String> calculateNetAmount(Pair<Integer, String> first, Pair<Integer, String>... rest) {

        Pair<Integer, String> total = first;
        if (total.first == null || total.second == null) {
            throw new ApplicationException("Invalid value or currency");
        }

        for (Pair<Integer, String> next : rest) {
            if (next.first == null || next.second == null) {
                throw new ApplicationException("Invalid value or currency");
            }
            if (!Objects.equals(next.second, total.second)) {
                throw new ApplicationException("Invalid currency comparison");
            }
            total = new Pair<>(total.first + next.first, next.second);
        }

        Double amount = total.first * (percent / 100d);
        Pair<Integer, String> tax = new Pair<>(amount.intValue(), first.second);

        if (Objects.equals(total.second, tax.second)) {
            return new Pair<>(total.first - tax.first, first.second);
        } else {
            throw new ApplicationException("Invalid currency comparison");
        }
    }

    public static class Pair<A, B> {
        final A first;
        final B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

    }
}