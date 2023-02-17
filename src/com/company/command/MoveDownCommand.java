package com.company.command;

import com.company.snake.Snake;

/**
 * 蛇向下移动命令.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 19:15
 */
public class MoveDownCommand extends Command{
    /**
     * 实例化.
     *
     * @param snake 蛇
     */
    public MoveDownCommand(Snake snake) {
        super(snake);
    }

    @Override
    public void execute() {
        snake.moveDown();
    }
}
