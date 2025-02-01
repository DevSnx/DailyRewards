package de.devsnx.dailyRewards;

import de.devsnx.dailyRewards.manager.DailyRewardManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class DailyRewards extends JavaPlugin {

    public static DailyRewards instance;
    @Getter DailyRewardManager dailyRewardManager;

    @Override
    public void onEnable() {
        instance = this;
        dailyRewardManager = new DailyRewardManager();
        getCommand("daily").setExecutor(new DailyRewards());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static DailyRewards getInstance() {
        return instance;
    }
}