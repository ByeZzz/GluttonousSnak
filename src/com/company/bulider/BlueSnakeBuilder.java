package com.company.bulider;

import com.company.snake.BlueSnake;
import com.company.snake.Snake;

/**
 * 身体为蓝色的蛇的生成器..
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 17:55
 */
public class BlueSnakeBuilder extends SnakeBuilder{


    /**
     * 构造器.
     */
    public BlueSnakeBuilder(){
        snake = new BlueSnake();
    }

    @Override
    public SnakeBuilder setLength(int len) {
        snake.setLength(len);
        return this;
    }

    @Override
    public SnakeBuilder setDir(int dir) {
        snake.setDir(dir);
        return this;
    }

    @Override
    public Snake getSnake() {
        return snake;
    }
}
