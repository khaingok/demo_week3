package uit.csbu112.demo_week3;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
public class addition {
@GetMapping("/add/{a}/{b}")
public int addPath(
        @PathVariable @Pattern(regexp = "^-?\\d+$", message = "a must be an integer") String a,
        @PathVariable @Pattern(regexp = "^-?\\d+$", message = "b must be an integer") String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    @PostMapping("/add")
    public int addPost(@Valid @RequestBody AdditionRequest request) {
        return Integer.parseInt(request.getA()) + Integer.parseInt(request.getB());
    }

    // Inner class to represent the request body
    public static class AdditionRequest {
        @Pattern(regexp = "^-?\\d+$", message = "a must be an integer")
        private String a;

        @Pattern(regexp = "^-?\\d+$", message = "b must be an integer")
        private String b;

        // Getters and setters
        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
