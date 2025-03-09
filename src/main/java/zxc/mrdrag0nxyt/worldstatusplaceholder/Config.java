package zxc.mrdrag0nxyt.worldstatusplaceholder;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;

public class Config {

    private final WorldStatusPlaceholder plugin;

    @Getter
    private Map<String, Object> defaults = new HashMap<>();

    @Getter
    private World world = null;
    private String worldName = "world";

    @Getter
    private String morning = "утро",
            day = "день",
            evening = "вечер",
            night = "ночь";

    @Getter
    private String cleanWeather = "ясно",
            raining = "дождь",
            thundering = "гроза";

    public Config(WorldStatusPlaceholder plugin) {
        this.plugin = plugin;

        defaults.put("world", worldName);

        defaults.put("morning", morning);
        defaults.put("day", day);
        defaults.put("evening", evening);
        defaults.put("night", night);

        defaults.put("cleanWeather", cleanWeather);
        defaults.put("raining", raining);
        defaults.put("thundering", thundering);
    }

    public void initValues() {
        worldName = plugin.getString("world", worldName);
        if (!worldName.isEmpty()) {
            world = Bukkit.getWorld(worldName);
        }

        morning = plugin.getString("morning", morning);
        day = plugin.getString("day", day);
        evening = plugin.getString("evening", evening);
        night = plugin.getString("night", night);

        cleanWeather = plugin.getString("cleanWeather", cleanWeather);
        raining = plugin.getString("raining", raining);
        thundering = plugin.getString("thundering", thundering);
    }

}
