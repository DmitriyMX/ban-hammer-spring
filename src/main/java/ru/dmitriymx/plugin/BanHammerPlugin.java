package ru.dmitriymx.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dmitriymx.plugin.command.BanCommand;
import ru.dmitriymx.plugin.command.UnbanCommand;
import ru.dmitriymx.plugin.config.BukkitYamlPlaceholderConfigurer;
import ru.dmitriymx.plugin.config.SpringConfig;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class BanHammerPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		this.saveDefaultConfig();

		ApplicationContext context = createSpringContext();

		this.getCommand("ban").setExecutor(context.getBean(BanCommand.class));
		this.getCommand("unban").setExecutor(context.getBean(UnbanCommand.class));
	}

	private ApplicationContext createSpringContext() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.setClassLoader(this.getClassLoader());
		context.addBeanFactoryPostProcessor(new BukkitYamlPlaceholderConfigurer(this.getConfig()));
		context.registerBean("bukkitLogger", Logger.class, this::getLogger);
		context.register(SpringConfig.class);
		context.refresh();

		return context;
	}
}
