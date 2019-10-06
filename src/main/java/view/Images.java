package view;

import javax.swing.*;
import java.awt.*;

public enum Images {
    GRASS1("./src/main/resources/tiles/grass (1).png"),
    GRASS2("./src/main/resources/tiles/grass (2).png"),
    GRASS3("./src/main/resources/tiles/grass (3).png"),
    GRASS4("./src/main/resources/tiles/grass (4).png"),
    GRASS5("./src/main/resources/tiles/grass (5).png"),
    GRASS6("./src/main/resources/tiles/grass (6).png"),
    GRASS7("./src/main/resources/tiles/grass (7).png"),
    GRASS8("./src/main/resources/tiles/grass (8).png"),
    GRASS9("./src/main/resources/tiles/grass (9).png"),
    GRASS10("./src/main/resources/tiles/grass (10).png"),
    GRASS11("./src/main/resources/tiles/grass (11).png"),
    GRASS12("./src/main/resources/tiles/grass (12).png"),
    GRASS13("./src/main/resources/tiles/grass (13).png"),
    WATER1("./src/main/resources/tiles/water (1).png"),
    WATER2("./src/main/resources/tiles/water (2).png"),
    WATER3("./src/main/resources/tiles/water (3).png"),
    WATER4("./src/main/resources/tiles/water (4).png"),
    WATER5("./src/main/resources/tiles/water (5).png"),
    WATER6("./src/main/resources/tiles/water (6).png"),
    WATER7("./src/main/resources/tiles/water (7).png"),
    WATER8("./src/main/resources/tiles/water (8).png"),
    WATER9("./src/main/resources/tiles/water (9).png"),
    WATER10("./src/main/resources/tiles/water (10).png"),
    WATER11("./src/main/resources/tiles/water (11).png"),
    WATER12("./src/main/resources/tiles/water (12).png"),
    WATER13("./src/main/resources/tiles/water (13).png"),
    TREE1("./src/main/resources/tiles/tree (1).png"),
    TREE2("./src/main/resources/tiles/tree (2).png"),
    TREE3("./src/main/resources/tiles/tree (3).png"),
    TREE4("./src/main/resources/tiles/tree (4).png"),
    TREE5("./src/main/resources/tiles/tree (5).png"),
    TREE6("./src/main/resources/tiles/tree (6).png"),
    TREE7("./src/main/resources/tiles/tree (7).png"),
    TREE8("./src/main/resources/tiles/tree (8).png"),
    TREE9("./src/main/resources/tiles/tree (9).png"),
    TREE10("./src/main/resources/tiles/tree (10).png"),
    TREE11("./src/main/resources/tiles/tree (11).png"),
    TREE12("./src/main/resources/tiles/tree (12).png");


    private static final int TILE_SIZE = 50;
    public final Image image;

    private Images(String path){
        this.image = new ImageIcon(path).getImage().getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT);
    }

    public Image getImage(){
        return this.image;
    }

}
