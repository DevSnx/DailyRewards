package de.devsnx.dailyRewards;

import de.devsnx.dailyRewards.commands.CommandDaily;
import de.devsnx.dailyRewards.manager.DailyRewardManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DailyRewards extends JavaPlugin {

    public static DailyRewards instance;
    public DailyRewardManager dailyRewardManager;

    @Override
    public void onEnable() {
        instance = this;
        dailyRewardManager = new DailyRewardManager();
        getCommand("daily").setExecutor(new CommandDaily());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static DailyRewards getInstance() {
        return instance;
    }

    public DailyRewardManager getDailyRewardManager() {
        return dailyRewardManager;
    }
}