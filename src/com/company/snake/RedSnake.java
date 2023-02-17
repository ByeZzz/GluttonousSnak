package com.company.snake;

import com.company.ImageData;


/**
 * 红色贪吃蛇.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 17:02
 */
public class RedSnake extends Snake{

    /**
     * 实例化.
     */
    public RedSnake(){
        super();
        this.bodyImage = ImageData.bodyRed;
    }
}
