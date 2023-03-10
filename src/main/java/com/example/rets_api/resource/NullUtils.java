package com.example.rets_api.resource;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NullUtils {

    public static <T> void updateIfChanged(Consumer<T> consumer, T value, Supplier<T> supplier) {
        Predicate<T> predicate = input -> (!input.equals(value));
        if (supplier.get() == null || (value != null && !value.equals(0) && predicate.test(supplier.get()))) {
            consumer.accept(value);
        }
    }
}
