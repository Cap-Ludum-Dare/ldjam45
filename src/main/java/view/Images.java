package view;

import javax.swing.*;
import java.awt.*;

public enum Images {
    GRASS1("./src/main/resources/images/background/grass (1).png"),
    GRASS2("./src/main/resources/images/background/grass (2).png"),
    GRASS3("./src/main/resources/images/background/grass (3).png"),
    GRASS4("./src/main/resources/images/background/grass (4).png"),
    GRASS5("./src/main/resources/images/background/grass (5).png"),
    GRASS6("./src/main/resources/images/background/grass (6).png"),
    GRASS7("./src/main/resources/images/background/grass (7).png"),
    GRASS8("./src/main/resources/images/background/grass (8).png"),
    GRASS9("./src/main/resources/images/background/grass (9).png"),
    GRASS10("./src/main/resources/images/background/grass (10).png"),
    GRASS11("./src/main/resources/images/background/grass (11).png"),
    GRASS12("./src/main/resources/images/background/grass (12).png"),
    GRASS13("./src/main/resources/images/background/grass (13).png"),
    WATER1("./src/main/resources/images/background/water (1).png"),
    WATER2("./src/main/resources/images/background/water (2).png"),
    WATER3("./src/main/resources/images/background/water (3).png"),
    WATER4("./src/main/resources/images/background/water (4).png"),
    WATER5("./src/main/resources/images/background/water (5).png"),
    WATER6("./src/main/resources/images/background/water (6).png"),
    WATER7("./src/main/resources/images/background/water (7).png"),
    WATER8("./src/main/resources/images/background/water (8).png"),
    WATER9("./src/main/resources/images/background/water (9).png"),
    WATER10("./src/main/resources/images/background/water (10).png"),
    WATER11("./src/main/resources/images/background/water (11).png"),
    WATER12("./src/main/resources/images/background/water (12).png"),
    WATER13("./src/main/resources/images/background/water (13).png"),
    TREE1("./src/main/resources/images/trees/tree (1).png"),
    TREE2("./src/main/resources/images/trees/tree (2).png"),
    TREE3("./src/main/resources/images/trees/tree (3).png"),
    TREE4("./src/main/resources/images/trees/tree (4).png"),
    TREE5("./src/main/resources/images/trees/tree (5).png"),
    TREE6("./src/main/resources/images/trees/tree (6).png"),
    TREE7("./src/main/resources/images/trees/tree (7).png"),
    TREE8("./src/main/resources/images/trees/tree (8).png"),
    TREE9("./src/main/resources/images/trees/tree (9).png"),
    TREE10("./src/main/resources/images/trees/tree (10).png"),
    TREE11("./src/main/resources/images/trees/tree (11).png"),
    TREE12("./src/main/resources/images/trees/tree (12).png"),
    HERO("./src/main/resources/images/hero/walks/walk_down/down1.png"),
    JAVA("./src/main/resources/images/items/java.png");


    private static final int TILE_SIZE = 50;
    private static final int HERO_HEIGHT = 80;
    private static final int ITEM_SIZE = 30;
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
