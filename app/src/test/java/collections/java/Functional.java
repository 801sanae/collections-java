package collections.java;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Functional {
    
    private Integer integer;

    // consumer
    // input O, output X , <- void하게 실행만
    @Test
    @DisplayName("consumer")
    public void consumer(){
        // input의 타입
        Consumer<String> eat = food -> System.out.println(food);
        // Consumer<String> eat = (food) -> System.out.println(food);
        // Consumer<String> eat = (food) -> {System.out.println(food)};
        eat.accept("apple"); //consumer
    }

    // supplier
    // input X, output O
    @Test
    @DisplayName("supplier")
    public void supplier(){
        // output의 타입
        Supplier<Integer> salary = () -> 300;
        int result = salary.get();
        assertEquals(300, result);
    }
    // function
    // input O, output O
    @Test
    @DisplayName("function")
    public void function(){
        // Function<inputType, outputType>
        // Function<BigDecimal, BigDecimal> exchange = (dallar) -> 
        //     dallar.multiply(BigDecimal.valueOf(1600));
        
        Function<BigDecimal, BigDecimal> exchange = (dallar) -> {
            return dallar.multiply(BigDecimal.valueOf(1600));
        }; 
            
        BigDecimal exchanged = exchange.apply(BigDecimal.valueOf(43.27));

        assertEquals(BigDecimal.valueOf(69232).doubleValue(), exchanged.doubleValue());

    }
    // predicate
    // input O, output O -> return Boolean
    @Test
    @DisplayName("predicate")
    public void predicate(){
        // Predicate<String> predicate = (name) -> "minyoung".equals(name);
        Predicate<String> predicate = (name) -> {
            return "minyoung".equals(name);
        };

        boolean result = predicate.test("minyoung");

        assertTrue(result);

    }
    // 응용
    @Test
    @DisplayName("응용")
    public void 응용(){
        Function<Integer, Grade> schoolFunction = (score) ->{
            int num = score / 10;
            Grade result = switch (num) {
                case 9 -> Grade.A;
                case 8 -> Grade.B;
                case 7 -> Grade.C;
                case 6 -> Grade.D;            
                default -> Grade.F;
            };
            return result;
        };


        Grade result = getGradeByScore(67, (score)-> Grade.A);
        assertEquals(Grade.A, result);
    }

    private Grade getGradeByScore(int score, Function<Integer, Grade> calculater){
        return calculater.apply(score);
    }

    enum Grade{
        A,B,C,D,F
    }
}
