package com.company.command;

import com.company.snake.Snake;

/**
 * 蛇向左移动命令.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 19:15
 */
public class MoveLeftCommand extends Command{
    /**
     * 实例化.
     *
     * @param snake 蛇
     */
    public MoveLeftCommand(Snake snake) {
        super(snake);
    }

    @Override
    public void execute() {
        snake.moveLeft();
    }
}
