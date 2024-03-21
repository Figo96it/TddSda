package org.example.mock.animal;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String text) {
        super(text);
    }
}
