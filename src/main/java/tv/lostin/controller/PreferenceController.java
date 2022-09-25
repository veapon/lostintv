package tv.lostin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/22
 */
@RestController
public class PreferenceController {

    @GetMapping("/DisplayPreferences/clientSettings")
    public HashMap clientSetting() throws JsonProcessingException {
        String json = "{\n" +
                "    \"Id\":\"357e9744-36cc-9dc1-fc64-76865e62e417\",\n" +
                "    \"SortBy\":\"SortName\",\n" +
                "    \"RememberIndexing\":false,\n" +
                "    \"PrimaryImageHeight\":250,\n" +
                "    \"PrimaryImageWidth\":250,\n" +
                "    \"CustomPrefs\":{\n" +
                "        \"chromecastVersion\":\"stable\",\n" +
                "        \"skipForwardLength\":\"30000\",\n" +
                "        \"skipBackLength\":\"10000\",\n" +
                "        \"enableNextVideoInfoOverlay\":\"True\",\n" +
                "        \"tvhome\":\"\",\n" +
                "        \"dashboardTheme\":\"\",\n" +
                "        \"darkMode\":\"true\",\n" +
                "        \"lastSync\":\"1660917599127\",\n" +
                "        \"locale\":\"auto\"\n" +
                "    },\n" +
                "    \"ScrollDirection\":\"Horizontal\",\n" +
                "    \"ShowBackdrop\":true,\n" +
                "    \"RememberSorting\":false,\n" +
                "    \"SortOrder\":\"Ascending\",\n" +
                "    \"ShowSidebar\":false,\n" +
                "    \"Client\":\"vue\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, HashMap.class);
    }
}
