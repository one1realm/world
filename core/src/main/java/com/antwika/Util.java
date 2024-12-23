package com.antwika;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private Util() {
    }

    public static <T> List<T> newPrefilledList(int size, T fill) {
        final var list = new ArrayList<T>();
        for (int i = 0; i < size; i++) list.add(fill);
        return list;
    }
}
