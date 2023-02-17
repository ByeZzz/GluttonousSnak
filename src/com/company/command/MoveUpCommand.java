package com.company.command;

import com.company.snake.Snake;

/**
 * 蛇向上移动命令.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 19:14
 */
public class MoveUpCommand extends Command{
    /**
     * 实例化.
     *
     * @param snake 蛇
     */
    public MoveUpCommand(Snake snake) {
        super(snake);
    }

    @Override
    public void execute() {
        snake.moveUp();
    }
}
