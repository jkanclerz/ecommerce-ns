package pl.jkanclerz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Greeter greeter = new Greeter();

        List<String> names = Arrays.asList("Agnieszka", "Michal", "Ola", "Barbara", "Aleksander");

        //imperatywny
        List<String> ladies = new ArrayList<>();
        for (String name : names) {
            if (name.endsWith("a")) {
                ladies.add(name);
            }
        }
        for (String name : ladies) {
            greeter.greet(name);
        }


        List<String> uppercasedLadies = names.stream()
                .filter(name -> name.endsWith("a")) // lambda name: name[-1] == 'a'
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //greet only ladies
        uppercasedLadies.forEach(greeter::greet);
    }
}
