package ru.dmitriymx.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import ru.dmitriymx.plugin.command.BanCommand;
import ru.dmitriymx.plugin.command.UnbanCommand;

@SuppressWarnings("unused")
public class BanHammerPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("ban").setExecutor(new BanCommand(this.getLogger()));
		this.getCommand("unban").setExecutor(new UnbanCommand(this.getLogger()));
	}
}
