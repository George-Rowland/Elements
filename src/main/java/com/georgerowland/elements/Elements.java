package com.georgerowland.elements;

import commands.ExplodeCommand;
import commands.FireCommand;
import commands.LightningCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Elements extends JavaPlugin {

    public static Elements instance;
    public static Elements getInstance() {
        return Elements.instance;
    }

    static {
        Elements.instance = null;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Elements.instance = this;

        // Command Listener
        this.getCommand("fire").setExecutor(new FireCommand());
        this.getCommand("lightning").setExecutor(new LightningCommand());
        this.getCommand("explode").setExecutor(new ExplodeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
