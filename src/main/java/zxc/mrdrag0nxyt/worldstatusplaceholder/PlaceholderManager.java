package zxc.mrdrag0nxyt.worldstatusplaceholder;

import org.bukkit.World;
import zxc.mrdrag0nxyt.worldstatusplaceholder.config.Config;

public class Logic {

    private Config config;

    public Logic(Config config) {
        this.config = config;
    }

    public String getWeather(World world) {
        boolean isStorm = world.hasStorm();
        boolean isThunder = world.isThundering();

        if (isThunder) {
            return "гроза";
        } else if (isStorm) {
            return "дождь";
        } else {
            return "ясно";
        }
    }

    public String getTime(World world) {
        long time = world.getTime();
        String timeFormatted = null;

        if (time > 0 && time < 12000) {
            timeFormatted = "день";
        } else if (time >= 12000 && time < 13000) {
            timeFormatted = "вечер";
        } else if (time >= 13000 && time < 22300) {
            timeFormatted = "ночь";
        } else if (time >= 22300 && time <= 24000) {
            timeFormatted = "утро";
        }

        return timeFormatted;
    }
}
