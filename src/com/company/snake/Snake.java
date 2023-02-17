package com.company.snake;

import com.company.ImageData;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 贪吃蛇.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 16:45
 */
public class Snake {
    /**
     * 长度.
     */
    protected int length;
    /**
     * 运动方向.
     */
    protected int dir;

    /**
     * 获取蛇的位置信息.
     *
     * @return 蛇的位置信息
     */
    public List<Position> getSnakePosition() {
        return snakePosition;
    }

    /**
     * 蛇的位置信息.
     */
    protected List<Position> snakePosition;

    /**
     * 获取头部图像.
     *
     * @return 获取头部图像
     */
    public ImageIcon getHeadImage() {
        return headImage;
    }

    /**
     * 头部图像.
     */
    protected ImageIcon headImage;

    private Position addPosition;

    /**
     * 获取身体图像.
     *
     * @return 身体图像
     */
    public ImageIcon getBodyImage() {
        return bodyImage;
    }

    /**
     * 身体图像.
     */
    protected ImageIcon bodyImage;


    /**
     * 设置蛇的长度.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 初始化蛇的运行方向.
     *
     * @param dir 蛇的运行方向
     */
    public void initDir(int dir){
        this.dir = dir;
        switch (dir){
            case 1 : headImage = ImageData.up;break;
            case 2 : headImage = ImageData.left;break;
            case 3 : headImage = ImageData.down;break;
            case 4 : headImage = ImageData.right;break;
            default:
        }
    }

    /**
     * 设置蛇的运行方向.
     *
     * @param dir 运行方向
     * @return 是否设置成功
     */
    public boolean setDir(int dir) {

        if(Math.abs(dir - this.dir) == 2){
            return false;
        }

        this.dir = dir;
        switch (dir){
            case 1 : headImage = ImageData.up;break;
            case 2 : headImage = ImageData.left;break;
            case 3 : headImage = ImageData.down;break;
            case 4 : headImage = ImageData.right;break;
            default:
        }
        return true;
    }

    /**
     * 实例化.
     */
    public Snake(){
        snakePosition = new ArrayList<>();
        length = 0;
        dir = 4;
        headImage = ImageData.right;
        addPosition = new Position(0,0);
    }

    /**
     * 更新位置坐标.
     */
    public void updatePosition(){

        addPosition.setX(snakePosition.get(snakePosition.size()-1).getX());
        addPosition.setY(snakePosition.get(snakePosition.size()-1).getY());

        for(int i = snakePosition.size() - 1; i > 0; i--){
            snakePosition.get(i).setX(snakePosition.get(i - 1).getX());
            snakePosition.get(i).setY(snakePosition.get(i - 1).getY());
        }

        Position headPosition = snakePosition.get(0);

        switch (dir){
            case 1 :  headPosition.setY(headPosition.getY() - 1);break;
            case 2 : headPosition.setX(headPosition.getX() - 1);break;
            case 3 : headPosition.setY(headPosition.getY() + 1);break;
            case 4 : headPosition.setX(headPosition.getX() + 1);break;
            default:
        }
    }

    /**
     * 向上运动.
     */
    public void moveUp(){
        if(setDir(1)){
            updatePosition();
        }
    }

    /**
     * 向下运动.
     */
    public void moveDown(){
        if(setDir(3)){
            updatePosition();
        }
    }

    /**
     * 向左运动.
     */
    public void moveLeft(){
        if(setDir(2)){
            updatePosition();
        }
    }

    /**
     * 向右运动.
     */
    public void moveRight(){
        if(setDir(4)){
            updatePosition();
        }

    }

    /**
     * 吃食物.
     */
    public void eatFood(){
        snakePosition.add(new Position(addPosition.getX(), addPosition.getY()));
    }

}

