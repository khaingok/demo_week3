package uit.csbu112.demo_week3;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("hello")
    public Student sayHello() {
        return new Student("Khai", "20127606");
    }
}