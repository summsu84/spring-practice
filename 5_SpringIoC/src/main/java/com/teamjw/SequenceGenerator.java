package com.teamjw;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {

    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger couter = new AtomicInteger();
    private DatePrefixGenerator datePrefixGenerator;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(couter.getAndIncrement())
                .append(suffix)
                .append(datePrefixGenerator.getPattern());

        return builder.toString();
    }

    public void setPrefixGenerator(DatePrefixGenerator datePrefixGenerator) {
        this.datePrefixGenerator = datePrefixGenerator;
    }
}
