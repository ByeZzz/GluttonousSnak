package com.company.command;

import com.company.snake.Snake;

/**
 * 基本命令类.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 18:35
 */
public abstract class Command {
    /**
     * 蛇.
     */
    Snake snake;

    /**
     * 实例化.
     *
     * @param snake 蛇
     */
    public Command(Snake snake){
        this.snake = snake;
    }

    /**
     * 执行命令.
     */
    public abstract void execute();
}
