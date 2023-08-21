//Using synchronized block:

package com.singleton.main.synchronizedBlock;

public class ThreadSafeSingleton {

    // Private static instance variable to hold the single instance
    private static ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation from other classes
    private ThreadSafeSingleton() {
        // Initialization code
    }

    // Public static method to get the instance
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Other methods of the Singleton class
    public void showMessage() {
        System.out.println("Hello, I am a thread-safe Singleton using Synchronized block!");
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        singleton.showMessage();
    }
}
