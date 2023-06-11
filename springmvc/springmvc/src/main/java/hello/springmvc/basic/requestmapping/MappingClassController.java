package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    // localhost:8080/mapping/users,  @GetMapping
    @GetMapping
    public String user() {
        return "get users";
    }

    // localhost:8080/mapping/users,  @PostMapping
    @PostMapping
    public String addUser() {
        return "post user";
    }

    // localhost:8080/mapping/users/{userId},  @GetMapping
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }

    // localhost:8080/mapping/users/{userId},  @PatchMapping
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }

    // localhost:8080/mapping/users/{userId},  @DeleteMapping
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }

}
