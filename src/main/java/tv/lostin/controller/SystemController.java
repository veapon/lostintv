package tv.lostin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/19
 */
@RestController
@RequestMapping("/System")
public class SystemController {

    @GetMapping("/Info/Public")
    public HashMap<String, Object> publicInfo() {
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("LocalAddress", "http://localhost:8080/");
        obj.put("ServerName", "Jellyfin Server");
        obj.put("ProductName", "jellyfin");
        obj.put("Version", "10.8.0");
        obj.put("OperatingSystem", "MacOS");
        obj.put("Id", "1");
        obj.put("StartupWizardCompleted", true);
        return obj;
    }
}
