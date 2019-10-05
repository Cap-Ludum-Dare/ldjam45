package view;

import javax.swing.*;
import java.awt.*;

public enum Images {
    GRASS1("./src/main/resources/tiles/grass_tile_1.png"),
    GRASS2("./src/main/resources/tiles/grass_tile_2.png"),
    GRASS3("./src/main/resources/tiles/grass_tile_3.png"),
    SAND("./src/main/resources/tiles/sand_tile.png"),
    BUSH("./src/main/resources/tiles/bush_tile.png"),
    WATER0("./src/main/resources/tiles/water/0.png"),
    WATER1("./src/main/resources/tiles/water/1.png"),
    WATER2("./src/main/resources/tiles/water/2.png"),
    WATER3("./src/main/resources/tiles/water/3.png"),
    WATER4("./src/main/resources/tiles/water/4.png"),
    WATER5("./src/main/resources/tiles/water/5.png"),
    WATER6("./src/main/resources/tiles/water/6.png"),
    WATER7("./src/main/resources/tiles/water/7.png"),
    WATER8("./src/main/resources/tiles/water/8.png"),
    WATER9("./src/main/resources/tiles/water/9.png"),
    WATER10("./src/main/resources/tiles/water/10.png"),
    WATER11("./src/main/resources/tiles/water/11.png"),
    WATER12("./src/main/resources/tiles/water/12.png"),
    WATER13("./src/main/resources/tiles/water/13.png"),
    WATER14("./src/main/resources/tiles/water/14.png"),
    WATER15("./src/main/resources/tiles/water/15.png"),
    WATER16("./src/main/resources/tiles/water/16.png"),
    WATER17("./src/main/resources/tiles/water/17.png"),
    WATER18("./src/main/resources/tiles/water/18.png"),
    WATER19("./src/main/resources/tiles/water/19.png"),
    WATER20("./src/main/resources/tiles/water/20.png"),
    WATER21("./src/main/resources/tiles/water/21.png"),
    WATER22("./src/main/resources/tiles/water/22.png"),
    WATER23("./src/main/resources/tiles/water/23.png"),
    WATER24("./src/main/resources/tiles/water/24.png"),
    WATER25("./src/main/resources/tiles/water/25.png"),
    WATER26("./src/main/resources/tiles/water/26.png"),
    WATER27("./src/main/resources/tiles/water/27.png"),
    WATER28("./src/main/resources/tiles/water/28.png"),
    WATER29("./src/main/resources/tiles/water/29.png"),
    WATER30("./src/main/resources/tiles/water/30.png"),
    WATER31("./src/main/resources/tiles/water/31.png"),
    WATER32("./src/main/resources/tiles/water/32.png"),
    WATER33("./src/main/resources/tiles/water/33.png"),
    WATER34("./src/main/resources/tiles/water/34.png"),
    WATER35("./src/main/resources/tiles/water/35.png"),
    WATER36("./src/main/resources/tiles/water/36.png"),
    WATER37("./src/main/resources/tiles/water/37.png"),
    WATER38("./src/main/resources/tiles/water/38.png"),
    WATER39("./src/main/resources/tiles/water/39.png"),
    WATER40("./src/main/resources/tiles/water/40.png"),
    WATER41("./src/main/resources/tiles/water/41.png"),
    WATER42("./src/main/resources/tiles/water/42.png"),
    WATER43("./src/main/resources/tiles/water/43.png"),
    WATER44("./src/main/resources/tiles/water/44.png"),
    WATER45("./src/main/resources/tiles/water/45.png"),
    WATER46("./src/main/resources/tiles/water/46.png"),
    WATER47("./src/main/resources/tiles/water/47.png"),
    WATER48("./src/main/resources/tiles/water/48.png");

    private static final int TILE_SIZE = 50;
    public final Image image;

    private Images(String path){
        this.image = new ImageIcon(path).getImage().getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
    }

    public Image getImage(){
        return this.image;
    }

}
