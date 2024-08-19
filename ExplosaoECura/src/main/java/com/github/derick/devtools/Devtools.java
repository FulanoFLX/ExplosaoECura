package com.github.derick.devtools;

import commands.cura;
import entrada.entrada;
import inventario.Inventario;
import org.bukkit.plugin.java.JavaPlugin;

public final class Devtools extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("curar").setExecutor(new cura());
     this.getCommand("inventario").setExecutor(new Inventario());
        this.getServer().getPluginManager().registerEvents(new entrada(),this);
    }

    @Override
    public void onDisable() {
    }
}
