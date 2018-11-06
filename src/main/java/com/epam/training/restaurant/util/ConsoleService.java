package com.epam.training.restaurant.util;

import java.util.Scanner;

public class ConsoleService {
    private Scanner scanner = new Scanner(System.in);

    public void print(String line) {
        System.out.println(line);
    }

    public String readValue(String message) {
        String res;
        print(message);
        while (!(scanner.hasNext() && !(res = scanner.next()).isEmpty())) {
            print(message);
        }
        return res;
    }

    private ConsoleService() {
    }

    public static ConsoleService getInstance() {
        return HOLDER.INSTANCE;
    }


    private static class HOLDER {
        private final static ConsoleService INSTANCE = new ConsoleService();
    }
}
