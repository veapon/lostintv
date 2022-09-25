package tv.lostin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/23
 */
@RestController
@RequestMapping("/Items")
public class ItemController {

    public HashMap<String, Object> query() {
        HashMap<String, Object> result = new HashMap<>();
        return result;
    }
}
