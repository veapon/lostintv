package tv.lostin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/19
 */
@RestController
@RequestMapping("/Branding")
public class BrandingController {

    @GetMapping("/Configuration")
    public HashMap<String, Object> configuration() {
        return new HashMap<>();
    }
}
