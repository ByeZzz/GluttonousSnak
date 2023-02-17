package com.company;
import com.company.GUI.GUI;
import com.company.bulider.RedSnakeBuilder;
import com.company.bulider.SnakeBuilder;
import com.company.snake.Snake;

/**
 * @author bye
 */
public class Main {

    public static void main(String[] args) {
        SnakeBuilder builder = new RedSnakeBuilder();
        Snake s = builder.getSnake();
        System.out.println(s);
        GUI.show(s);
    }
}
