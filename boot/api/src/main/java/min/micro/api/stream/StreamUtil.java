package min.micro.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtil {
   public List<String> arrayToList(String [] arr){
       return Arrays.asList("a").stream().sorted().collect(Collectors.toList());
   }
}
