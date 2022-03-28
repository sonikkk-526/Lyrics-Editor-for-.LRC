package com.lrc.menu;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {
    // instance variables
    private String icon;
    private String name;
    private MenuType type;
    
    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
    
    // Constructor
    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    // Accessor Methods
    public String getIcon() {
        return icon;
    }
    
    public String getName() {
        return name;
    }
    
    public MenuType getType() {
        return type;
    }
    
    // Mutator Methods
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
    
    // Others
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/com/lrc/icon/" + icon + ".png"));
    }
}
