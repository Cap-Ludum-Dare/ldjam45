package se.capgemini.ldjam45.view;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public enum Images {
    GRASS_0("/images/background/grass (8).png"),
    GRASS_1("/images/background/grass (1).png"),
    GRASS_2("/images/background/grass (2).png"),
    GRASS_3("/images/background/grass (3).png"),
    GRASS_4("/images/background/grass (4).png"),
    GRASS_5("/images/background/grass (5).png"),
    GRASS_6("/images/background/grass (6).png"),
    GRASS_7("/images/background/grass (7).png"),
    GRASS_8("/images/background/grass (8).png"),
    GRASS_9("/images/background/grass (9).png"),
    GRASS_10("/images/background/grass (10).png"),
    GRASS_11("/images/background/grass (11).png"),
    GRASS_12("/images/background/grass (12).png"),
    GRASS_13("/images/background/grass (13).png"),
    WATER_0("/images/background/water (4).png"),
    WATER_1("/images/background/water (1).png"),
    WATER_2("/images/background/water (2).png"),
    WATER_3("/images/background/water (3).png"),
    WATER_4("/images/background/water (4).png"),
    WATER_5("/images/background/water (5).png"),
    WATER_6("/images/background/water (6).png"),
    WATER_7("/images/background/water (7).png"),
    WATER_8("/images/background/water (8).png"),
    WATER_9("/images/background/water (9).png"),
    WATER_10("/images/background/water (10).png"),
    WATER_11("/images/background/water (11).png"),
    WATER_12("/images/background/water (12).png"),
    WATER_13("/images/background/water (13).png"),
    TREE_0("/images/trees/tree (4).png"),
    TREE_1("/images/trees/tree (1).png"),
    TREE_2("/images/trees/tree (2).png"),
    TREE_3("/images/trees/tree (3).png"),
    TREE_4("/images/trees/tree (4).png"),
    TREE_5("/images/trees/tree (5).png"),
    TREE_6("/images/trees/tree (6).png"),
    TREE_7("/images/trees/tree (7).png"),
    TREE_8("/images/trees/tree (8).png"),
    TREE_9("/images/trees/tree (9).png"),
    TREE_10("/images/trees/tree (10).png"),
    TREE_11("/images/trees/tree (11).png"),
    TREE_12("/images/trees/tree (12).png"),
    HERO_0("/images/hero/walks/walk_down/down1.png"),
    BACKPACK("/images/items/level1/backpack.png"),
    BOOK("/images/items/level1/book.png"),
    COMPUTER("/images/items/level1/computer.png"),
    JOYSTICK("/images/items/level1/joystick.png"),
    JUICE("/images/items/level1/juice.png"),
    NOTEPAD("/images/items/level1/notepad.png"),
    REMOTE("/images/items/level1/remote.png"),
    SCREWDRIVER("/images/items/level1/screwdriver.png"),
    SMARTPHONE("/images/items/level1/smartphone.png"),
    TOOTHBRUSH("/images/items/level1/toothbrush.png"),
    BLENDER("/images/items/level2/blender.png"),
    BRUSH("/images/items/level2/brush.png"),
    CALCULATOR("/images/items/level2/calculator.png"),
    CHEMISTRY("/images/items/level2/chemics.png"),
    COFFEE("/images/items/level2/coffee.png"),
    HEADSET("/images/items/level2/headset.png"),
    PAN("/images/items/level2/pan.png"),
    PEPPER("/images/items/level2/pepper.png"),
    WHEEL("/images/items/level2/wheel.png"),
    WINE("/images/items/level2/wine.png"),
    BACKEND("/images/items/level3/backend.png"),
    BELL("/images/items/level3/bell.png"),
    COLOR("/images/items/level3/color.png"),
    FRONTEND("/images/items/level3/frontend.png"),
    KEY("/images/items/level3/key.png"),
    KEYBOARD("/images/items/level3/keyboard.png"),
    PEN("/images/items/level3/pen.png"),
    SCREEN("/images/items/level3/screen.png"),
    STACK("/images/items/level3/stack.png"),
    VIDEO_GAMES("/images/items/level3/video_games.png"),
    LEVEL1PHONE_0("/images/items/level1/smartphone.png"),
    WIN("/images/win.png");

    public static final int TILE_SIZE = 50;
    public static final int HERO_HEIGHT = 80;
    public static final int HERO_WIDTH = 50;
    public static final int ITEM_SIZE = 30;
    public static final int WIN_X_SIZE = 500;
    public static final int WIN_Y_SIZE = 300;

    public static final String SEPARATOR = "_";
    
    public static Images defaultImage() {
    	return GRASS_8;
    }
    
    public static Images defaultWater() {
    	return Images.WATER_0;
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
    public Images background;

    private Images(String path){

    	try {
    		URL url = this.getClass().getResource(path);
			image = new ImageIcon(url).getImage();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to load: " + path);
			image = Images.defaultImage().image;
		}
    	
        if (path.contains("hero")){
            this.image = image.getScaledInstance(HERO_WIDTH, HERO_HEIGHT, Image.SCALE_DEFAULT);
            this.isWalkable = false;
        } else if(path.contains("items")){
        	this.image = image.getScaledInstance(ITEM_SIZE, ITEM_SIZE, Image.SCALE_DEFAULT);
            this.isWalkable = true;
        } else if(path.contains("road")){
            this.isWalkable = true;
        } else if(path.contains("win")){
        	this.image = image.getScaledInstance(WIN_X_SIZE, WIN_Y_SIZE, Image.SCALE_DEFAULT);
        } else if(path.contains("grass")){
        	this.image = image.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
            this.isWalkable = true;
        } else {        	
        	this.image = image.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
            this.isWalkable = false;
        }
        
    	if (path.contains("tree")) {
    		background = Images.defaultImage();
    	} else if (path.contains("bridge")) {
    		background = Images.defaultWater();
    	}
    }
    
    public Image getImage(){
        return this.image;
    }
    
    public boolean isWalkable(){
        return isWalkable;
    }
    
}
