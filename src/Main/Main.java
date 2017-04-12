package Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main
        extends JavaPlugin {
    public void onEnable() {
        getCommand("blocks").setExecutor(new BlocksCommand());

        getCommand("trash").setExecutor(new trashCommand());
    }

    public void onDisable() {
    }
}
