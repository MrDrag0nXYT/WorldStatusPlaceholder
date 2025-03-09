package zxc.mrdrag0nxyt.worldstatusplaceholder;

import org.bukkit.World;

public class PlaceholderManager {

    private final Config config;

    public PlaceholderManager(Config config) {
        this.config = config;
    }

    public String getWeather(World world) {
        boolean isStorm = world.hasStorm();
        boolean isThunder = world.isThundering();

        if (isThunder) {
            return config.getThundering();
        } else if (isStorm) {
            return config.getRaining();
        } else {
            return config.getCleanWeather();
        }
    }

    public String getDayTime(World world) {
        long time = world.getTime();
        String dayTime = null;

        if (time >= 23000 || time < 6000) {
            dayTime = config.getMorning();
        } else if (time < 12000) {
            dayTime = config.getDay();
        } else if (time < 14000) {
            dayTime = config.getEvening();
        } else if (time < 22300) {
            dayTime = config.getNight();
        }

        return dayTime;
    }
}
