package min.micro.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamUtil {
   public static List<String> arrayToList(String [] arr){
       return Arrays.asList("a").stream().sorted().collect(Collectors.toList());
   }

//    public int compareTo(Map<String, Object> map) {
//        Student student = (Student) map.get("student");
//        String prop = (String)map.get("prop");
//        String option = (String)map.get("option");
//        switch(prop){
//            case "name" : break;
//            case "username" : break;
//            case "grade" : return  student.getGrade()-this.getGrade();
//            case "score" : break;
//        }
//        Student o = null;
//        return null;
//    }
}
