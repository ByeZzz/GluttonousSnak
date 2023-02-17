package com.company.command;

import com.company.snake.Snake;

/**
 * 蛇自动移动命令.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 18:38
 */
public class UpdateCommand extends Command{
    /**
     * 实例化.
     *
     * @param snake 蛇
     */
    public UpdateCommand(Snake snake) {
        super(snake);
    }

    @Override
    public void execute() {
        snake.updatePosition();
    }
}
