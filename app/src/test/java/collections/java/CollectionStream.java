package collections.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CollectionStream {
    

    @Test
    @DisplayName("intermidate / terminal operation")
    public void operationType(){
        List<Widget> widgets = List.of(
            new Widget("minyoung input", "input", Color.RED, 12),
            new Widget("minyoung table", "table", Color.RED, 32),
            new Widget("minyoung link", "link", Color.GREEN,72)
        );

        int sum = widgets.stream()
                .filter(w->Color.RED.equals(w.color()))
                .mapToInt(w->w.weight)
                .sum();
        assertEquals(44, sum);
    }

    /**
     * Wid
     * String title, String type, Color color, int weightget
     */
    public record Widget(
        String title, String type, Color color, int weight
    ) {}

    enum Color{
        RED, WHITE, BLACK,GREEN, BLUE
    }

}
