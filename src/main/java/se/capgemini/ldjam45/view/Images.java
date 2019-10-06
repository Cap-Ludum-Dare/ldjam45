package se.capgemini.ldjam45.view;

import javax.swing.*;
import java.awt.*;

public enum Images {
    GRASS_0("./src/main/resources/images/background/grass (8).png"),
    GRASS_1("./src/main/resources/images/background/grass (1).png"),
    GRASS_2("./src/main/resources/images/background/grass (2).png"),
    GRASS_3("./src/main/resources/images/background/grass (3).png"),
    GRASS_4("./src/main/resources/images/background/grass (4).png"),
    GRASS_5("./src/main/resources/images/background/grass (5).png"),
    GRASS_6("./src/main/resources/images/background/grass (6).png"),
    GRASS_7("./src/main/resources/images/background/grass (7).png"),
    GRASS_8("./src/main/resources/images/background/grass (8).png"),
    GRASS_9("./src/main/resources/images/background/grass (9).png"),
    GRASS_10("./src/main/resources/images/background/grass (10).png"),
    GRASS_11("./src/main/resources/images/background/grass (11).png"),
    GRASS_12("./src/main/resources/images/background/grass (12).png"),
    GRASS_13("./src/main/resources/images/background/grass (13).png"),
    WATER_0("./src/main/resources/images/background/water (4).png"),
    WATER_1("./src/main/resources/images/background/water (1).png"),
    WATER_2("./src/main/resources/images/background/water (2).png"),
    WATER_3("./src/main/resources/images/background/water (3).png"),
    WATER_4("./src/main/resources/images/background/water (4).png"),
    WATER_5("./src/main/resources/images/background/water (5).png"),
    WATER_6("./src/main/resources/images/background/water (6).png"),
    WATER_7("./src/main/resources/images/background/water (7).png"),
    WATER_8("./src/main/resources/images/background/water (8).png"),
    WATER_9("./src/main/resources/images/background/water (9).png"),
    WATER_10("./src/main/resources/images/background/water (10).png"),
    WATER_11("./src/main/resources/images/background/water (11).png"),
    WATER_12("./src/main/resources/images/background/water (12).png"),
    WATER_13("./src/main/resources/images/background/water (13).png"),
    TREE_0("./src/main/resources/images/trees/tree (4).png"),
    TREE_1("./src/main/resources/images/trees/tree (1).png"),
    TREE_2("./src/main/resources/images/trees/tree (2).png"),
    TREE_3("./src/main/resources/images/trees/tree (3).png"),
    TREE_4("./src/main/resources/images/trees/tree (4).png"),
    TREE_5("./src/main/resources/images/trees/tree (5).png"),
    TREE_6("./src/main/resources/images/trees/tree (6).png"),
    TREE_7("./src/main/resources/images/trees/tree (7).png"),
    TREE_8("./src/main/resources/images/trees/tree (8).png"),
    TREE_9("./src/main/resources/images/trees/tree (9).png"),
    TREE_10("./src/main/resources/images/trees/tree (10).png"),
    TREE_11("./src/main/resources/images/trees/tree (11).png"),
    TREE_12("./src/main/resources/images/trees/tree (12).png"),
    HERO_0("./src/main/resources/images/hero/walks/walk_down/down1.png"),
    LEVEL1PHONE_0("./src/main/resources/images/items/level1/smarthphone.png"),
    WIN("./src/main/resources/images/win.png");

    public static final int TILE_SIZE = 50;
    public static final int HERO_HEIGHT = 80;
    public static final int ITEM_SIZE = 30;
    public static final int WIN_X_SIZE = 500;
    public static final int WIN_Y_SIZE = 300;

    public static final String SEPARATOR = "_";
    
    public static Images defaultImage() {
    	return GRASS_8;
    }
    
    public static Images getImage(String key) {
    	for (Images images : Images.values()) {
    		if (("" + images.name().toUpperCase().charAt(0))
    				.equals(("" + key).toUpperCase())) {
    			return images;
    		}
    	}
    	
    	return Images.defaultImage();
    }
    
    private Image image;
    private boolean isWalkable;

    private Images(String path){
        if(path.contains("hero")){
            this.image = new ImageIcon(path).getImage().getScaledInstance(TILE_SIZE, HERO_HEIGHT, Image.SCALE_DEFAULT);
            this.isWalkable = false;
        } else if(path.contains("items")){
            this.image = new ImageIcon(path).getImage().getScaledInstance(ITEM_SIZE, ITEM_SIZE, Image.SCALE_DEFAULT);
            this.isWalkable = true;
        } else if(path.contains("road")){
            this.isWalkable = true;
        } else if(path.contains("win")){
            this.image = new ImageIcon(path).getImage().getScaledInstance(WIN_X_SIZE, WIN_Y_SIZE, Image.SCALE_DEFAULT);
        } else {
            this.image = new ImageIcon(path).getImage().getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
            this.isWalkable = false;
        }
    }
    
    public Image getImage(){
        return this.image;
    }
    
    public boolean getIsWalkable(){
        return isWalkable;
    }
    
}
