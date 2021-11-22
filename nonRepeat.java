import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class nonRepeat {

    public static void main(String[] args) {

        System.out.println("  Please  enter  the  input  string  :");
        Scanner in = new Scanner(System.in); // read from System input
        String input = in.nextLine();
        Character firstNonRepeatedChar = logic(input);
        System.out.println("The  first  non  repeated  character  is  :    " + firstNonRepeatedChar);
        in.close();
    }

    private static Character logic(String input) {
        Character result =  input.chars()      //string stream
                .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst().get();

        return result;
    }
}
