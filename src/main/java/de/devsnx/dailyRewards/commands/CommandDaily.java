package de.devsnx.dailyRewards.commands;

import de.devsnx.dailyRewards.DailyRewards;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * @author Marvin Hänel (DevSnx)
 * @since 01.02.2025 15:33
 */

public class CommandDaily implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        if(!(args.length == 0)) {
            return true;
        }

        Player player = ((Player) sender).getPlayer();

        DailyRewards.getInstance().getDailyRewardManager().claimReward(player, player.getUniqueId());

        return false;
    }
}