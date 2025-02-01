package de.devsnx.dailyRewards.manager;

import org.bukkit.entity.Player;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Marvin Hänel (DevSnx)
 * @since 01.02.2025 15:20
 */

public class DailyRewardManager {

    private final Map<UUID, Long> rewardTimestamps;

    public DailyRewardManager() {
        this.rewardTimestamps = new HashMap<>();
    }

    public boolean canClaim(UUID playerUUID) {
        long now = Instant.now().getEpochSecond();
        return !this.rewardTimestamps.containsKey(playerUUID) ||
                now - this.rewardTimestamps.get(playerUUID) >= 86400;
    }

    public void claimReward(Player player, UUID playerUUID) {
        if (canClaim(playerUUID)) {
            this.rewardTimestamps.put(playerUUID, Instant.now().getEpochSecond());
            player.sendMessage("§aDu hast deine tägliche Belohnung erfolgreich abgeholt!");
        } else {
            long remainingTime = getRemainingTime(playerUUID);
            player.sendMessage("§cWarte noch: " + formatTime(remainingTime));
        }
    }

    public long getRemainingTime(UUID playerUUID) {
        if (!this.rewardTimestamps.containsKey(playerUUID)) {
            return 0;
        }
        long now = Instant.now().getEpochSecond();
        long elapsedTime = now - this.rewardTimestamps.get(playerUUID);
        return Math.max(86400 - elapsedTime, 0);
    }

    private String formatTime(long seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;
        return String.format("%02dh %02dm %02ds", hours, minutes, secs);
    }
}