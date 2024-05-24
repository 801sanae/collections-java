package collections.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionIsObject {
    
    @Test
    @DisplayName("매개변수를 값으로 전달")
    public void primitiveParameterTest(){
        int age = 100;
        int newAge = changeAge(age);

        assertEquals(30, newAge);

        // age = 200;
        assertEquals(100, age);
    }

    private int changeAge(int age){
        age = 10;
        int newAge = age + 20;
        return newAge;
    }
    @Test
    @DisplayName("매개변수를 참조로 전달")
    public void referenceObjectTest(){
        var names = new ArrayList<String>(List.of("matthew", "alison", "simon", "mijin"));
        assertEquals("matthew", names.get(0));

        var newNames = changeName(names, 0, "minyoung");
        assertEquals("minyoung", newNames.get(0));
        assertEquals("matthew", names.get(0));
    }

    private <T> List<T> changeName(List<T> names, int index, T name){
        names.set(index, name);
        List<T> newNames = new ArrayList<>(names);
        return newNames;
    }
}
