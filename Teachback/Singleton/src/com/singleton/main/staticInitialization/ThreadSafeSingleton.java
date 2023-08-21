//Using static initialization:

package com.singleton.main.staticInitialization;

public class ThreadSafeSingleton {

    // Private static instance variable to hold the single instance
    private static final ThreadSafeSingleton instance = new ThreadSafeSingleton();

    // Private constructor to prevent instantiation from other classes
    private ThreadSafeSingleton() {
        // Initialization code
    }

    // Public static method to get the instance
    public static ThreadSafeSingleton getInstance() {
        return instance;
    }

    // Other methods of the Singleton class
    public void showMessage() {
        System.out.println("Hello, I am a thread-safe Singleton using static initialization!");
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        singleton.showMessage();
    }
}

