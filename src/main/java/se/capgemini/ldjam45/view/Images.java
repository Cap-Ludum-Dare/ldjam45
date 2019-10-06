package se.capgemini.ldjam45.view;

import javax.swing.*;
import java.awt.*;

public enum Images {
    GRASS_1("./src/main/resources/tiles/grass_tile_1.png"),
    GRASS_2("./src/main/resources/tiles/grass_tile_2.png"),
    GRASS_3("./src/main/resources/tiles/grass_tile_3.png"),
    SAND_1("./src/main/resources/tiles/sand_tile.png"),
    BUSH_1("./src/main/resources/tiles/bush_tile.png"),
    WATER_49("./src/main/resources/tiles/water/0.png"),
    WATER_1("./src/main/resources/tiles/water/1.png"),
    WATER_2("./src/main/resources/tiles/water/2.png"),
    WATER_3("./src/main/resources/tiles/water/3.png"),
    WATER_4("./src/main/resources/tiles/water/4.png"),
    WATER_5("./src/main/resources/tiles/water/5.png"),
    WATER_6("./src/main/resources/tiles/water/6.png"),
    WATER_7("./src/main/resources/tiles/water/7.png"),
    WATER_8("./src/main/resources/tiles/water/8.png"),
    WATER_9("./src/main/resources/tiles/water/9.png"),
    WATER_10("./src/main/resources/tiles/water/10.png"),
    WATER_11("./src/main/resources/tiles/water/11.png"),
    WATER_12("./src/main/resources/tiles/water/12.png"),
    WATER_13("./src/main/resources/tiles/water/13.png"),
    WATER_14("./src/main/resources/tiles/water/14.png"),
    WATER_15("./src/main/resources/tiles/water/15.png"),
    WATER_16("./src/main/resources/tiles/water/16.png"),
    WATER_17("./src/main/resources/tiles/water/17.png"),
    WATER_18("./src/main/resources/tiles/water/18.png"),
    WATER_19("./src/main/resources/tiles/water/19.png"),
    WATER_20("./src/main/resources/tiles/water/20.png"),
    WATER_21("./src/main/resources/tiles/water/21.png"),
    WATER_22("./src/main/resources/tiles/water/22.png"),
    WATER_23("./src/main/resources/tiles/water/23.png"),
    WATER_24("./src/main/resources/tiles/water/24.png"),
    WATER_25("./src/main/resources/tiles/water/25.png"),
    WATER_26("./src/main/resources/tiles/water/26.png"),
    WATER_27("./src/main/resources/tiles/water/27.png"),
    WATER_28("./src/main/resources/tiles/water/28.png"),
    WATER_29("./src/main/resources/tiles/water/29.png"),
    WATER_30("./src/main/resources/tiles/water/30.png"),
    WATER_31("./src/main/resources/tiles/water/31.png"),
    WATER_32("./src/main/resources/tiles/water/32.png"),
    WATER_33("./src/main/resources/tiles/water/33.png"),
    WATER_34("./src/main/resources/tiles/water/34.png"),
    WATER_35("./src/main/resources/tiles/water/35.png"),
    WATER_36("./src/main/resources/tiles/water/36.png"),
    WATER_37("./src/main/resources/tiles/water/37.png"),
    WATER_38("./src/main/resources/tiles/water/38.png"),
    WATER_39("./src/main/resources/tiles/water/39.png"),
    WATER_40("./src/main/resources/tiles/water/40.png"),
    WATER_41("./src/main/resources/tiles/water/41.png"),
    WATER_42("./src/main/resources/tiles/water/42.png"),
    WATER_43("./src/main/resources/tiles/water/43.png"),
    WATER_44("./src/main/resources/tiles/water/44.png"),
    WATER_45("./src/main/resources/tiles/water/45.png"),
    WATER_46("./src/main/resources/tiles/water/46.png"),
    WATER_47("./src/main/resources/tiles/water/47.png"),
    WATER_48("./src/main/resources/tiles/water/48.png");

    private static final int TILE_SIZE = 50;

    public static final String SEPARATOR = "_";
    
    public static Images defaultImage() {
    	return GRASS_1;
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
    
    public final Image image;

    private Images(String path){
        this.image = new ImageIcon(path).getImage().getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
    }
    
    public Image getImage(){
        return this.image;
    }
    
}
