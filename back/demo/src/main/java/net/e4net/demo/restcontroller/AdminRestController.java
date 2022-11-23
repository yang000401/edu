package net.e4net.demo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "admin-rest-controler", description = "ADMIN 권한이 사용할수 있는 api")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {
    @Operation(summary = "테스트", description = "테스트")
    @GetMapping("/test")
    public String test() {
        return "test스트링";
    }
}
