package com.singleton.main;

public class Singleton {
    // Private static instance variable to hold the single instance
    private static Singleton instance;
    
    // Private constructor to prevent instantiation from other classes
    private Singleton() {
        // Initialization code, if needed
    }
    
    // Public static method to get the instance
    public static Singleton getInstance() {
        // If the instance is null, create a new instance
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // Other methods of the Singleton class
    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
    
    // Main method to test the Singleton
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton = Singleton.getInstance();
        
        // Call methods on the instance
        singleton.showMessage();
    }
}

