package org.example;

import org.example.service.IntegerListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var arr = new Integer[40];
        fillArray(arr);
        var asd = new IntegerListImpl(arr);
        System.out.println(Arrays.toString(asd.toArray()));
        asd.contains(1);
        System.out.println(Arrays.toString(asd.toArray()));
    }

    private static void fillArray(Integer[] arr) {var rng = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = rng.nextInt(10);
        }
    }
}
