package min.micro.api.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {


        Date date = new Date();

        return new SimpleDateFormat("y-MM-dd HH:mm").format(new Date());
    }
}
