package collections.java;

import static org.junit.jupiter.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionInterfaces {
    
    //배열
    @Test
    @DisplayName("배열")
    public void array(){
        String[] name = {"matthew", "alison", "simon", "mijin"};
        assertEquals("marine", name[0]);
    }

    //iterable -> forEach..
    @Test
    @DisplayName("iterable")
    public void iterable(){
        Iterable<String> iter = Arrays.asList("matthew", "alison", "simon", "mijin");
        iter.forEach(name->{
            System.out.println(name);
        });
    }

    //collection 최상위이기에.. 상황에 맞춰 사용..
    @Test
    @DisplayName("collection")
    public void collection(){
        Collection<String> collection = new ArrayList<>();
        collection.add("minyoung");
        assertTrue(collection.contains("minyoung"));
        collection.remove("minyoung");
        assertFalse(collection.contains("minyoung"));
    }

    //List 순서고려..
    @Test
    @DisplayName("list")
    public void list(){
        var names = new ArrayList<String>();
        names.addAll(List.of("matthew", "alison", "simon", "mijin"));
        assertEquals("alison", names.get(1));
    }

    //Set 중복고려..
    @Test
    @DisplayName("set")
    public void set(){
        var coupons = new HashSet<String>();
        coupons.addAll(List.of("matthew", "alison", "simon", "mijin", "matthew")); // 중복제거
        assertEquals(4, coupons.size());
    }

    //Map 키로 확인..
    @Test
    @DisplayName("map")
    public void map(){
        Map<String, String> persons = new HashMap<>();
        persons.put("a101", "matthew");
        persons.put("a102", "alison");

        assertEquals("alison", persons.get("a102"));
    }
}
