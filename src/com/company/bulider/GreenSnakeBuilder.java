package com.company.bulider;

import com.company.snake.BlueSnake;
import com.company.snake.GreenSnake;
import com.company.snake.Snake;

/**
 * 身体为绿色的蛇的生成器..
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 17:55
 */
public class GreenSnakeBuilder extends SnakeBuilder {

    /**
     * 实例化.
     */
    public GreenSnakeBuilder(){
        snake = new GreenSnake();
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
