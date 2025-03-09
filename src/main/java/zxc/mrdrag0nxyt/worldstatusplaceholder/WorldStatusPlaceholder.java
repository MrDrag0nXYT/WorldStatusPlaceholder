package zxc.mrdrag0nxyt.worldstatusplaceholder;

import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public final class WorldStatusPlaceholder extends PlaceholderExpansion implements Configurable {

    private Config config;
    private PlaceholderManager placeholderManager;

    @Override
    public boolean canRegister() {
        config = new Config(this);
        placeholderManager = new PlaceholderManager(config);

        return true;
    }
    
    @Override
    public @NotNull String getIdentifier() {
        return "worldstatus";
    }

    @Override
    public @NotNull String getAuthor() {
        return "MrDrag0nXYT (drakoshaslv)";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public Map<String, Object> getDefaults() {
        return config.getDefaults();
    }


    @Override
    public @Nullable String onRequest(OfflinePlayer offlinePlayer, @NotNull String params) {
        config.initValues();
        World world = config.getWorld();

        if (world == null) {
            Player player = offlinePlayer.getPlayer();
            if (player == null) {
                return null;
            }

            world = player.getWorld();
        }

        switch (params.toLowerCase()) {
            case "weather": {
                return placeholderManager.getWeather(world);
            }
            case "daytime": {
                return placeholderManager.getDayTime(world);
            }
            default: {
                return null;
            }
        }
    }
}
