package gg.plugins.blockcommands.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class BlockCommand {

    private Location location;
    private List<String> commands;
    public static Map<Location, BlockCommand> blockCommands;
    public BlockCommand(Location location, List<String> commands) {
        this.location = location;
        this.commands = commands;
    }

    public Location getLocation() {
        return location;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void execute(Player player) {
        getCommands().forEach(command -> {
            command = command.replace("%player%", player.getName());
            command = command.replace("%uuid%", player.getUniqueId().toString());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        });
    }

    public static Map<Location, BlockCommand> getAll() {
        return blockCommands;
    }
}
