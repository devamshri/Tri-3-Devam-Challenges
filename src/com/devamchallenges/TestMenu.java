package com.devamchallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.RunnableFuture;

public class TestMenu {
    String title;
    Runnable action;

    public TestMenu(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }

    public Runnable getAction() {
        return this.action;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, TestMenu> menu = new HashMap<>();

        menu.put(1, new TestMenu("Matrix", () -> Matrix.main(null) ) );
        menu.put(2, new TestMenu("Calculator", () -> IntByReference.main(null) ) );

        System.out.println("Menu:");
        for (Map.Entry<Integer, TestMenu> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }

        int input = sc.nextInt();
        TestMenu m = menu.get(input);
        m.getAction().run();
    }
}