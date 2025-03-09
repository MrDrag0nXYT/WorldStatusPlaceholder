package zxc.mrdrag0nxyt.worldstatusplaceholder.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Config {

    public Map<String, Object> getDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("morning", "утро");
        defaults.put("day", "день");
        defaults.put("evening", "вечер");
        defaults.put("night", "ночь");

        return Collections.emptyMap();
    }

}
