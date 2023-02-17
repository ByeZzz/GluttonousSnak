package com.company.GUI;

import com.company.ImageData;
import com.company.command.*;
import com.company.snake.Position;
import com.company.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * 游戏面板.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 18:07
 */
class GamePanel extends JPanel {//由Panel继承JPanel，创建一个画布类

    /**
     * 游戏对象（蛇）.
     */
    private Snake snake;
    /**
     * 命令.
     */
    private Command command;
    /**
     * 得分.
     */
    private int score;
    /**
     * 蛇的运行速度.
     */
    private int speed;
    /**
     * 结束标准.
     */
    private boolean isOver = false;
    /**
     * 开始标志.
     */
    private boolean isStart = false;
    /**
     * 地图初始位置.
     */
    private Position initPos;
    /**
     * 地图大小.
     */
    private Position mapSize;
    /**
     * 图标大小.
     */
    private int iconSize;
    /**
     * 食物位置.
     */
    private Position food;
    /**
     * 随机数.
     */
    private Random random = new Random();

    /**
     * 蛇自动运动定时器.
     */
    private Timer timer = new Timer(speed,(ActionEvent e)->{

        if (isStart && !isOver){
            command = new UpdateCommand(snake);
            command.execute();

            checkCollision();
            eatFood();
       }
    });

    /**
     * 界面刷新定时器.
     */
    Timer timer_updateScene = new Timer(20,(ActionEvent e)->{
        // 重新绘制界面
        if(isStart && !isOver){
            repaint();
        }

    });

    /**
     * 初始化部分参数.
     */
    public void Init() {
        snake.setLength(1);
        // 初始化蛇头位置
        snake.getSnakePosition().clear();
        snake.getSnakePosition().add(new Position(10, 10));
        snake.getSnakePosition().add(new Position(9, 10));
        snake.getSnakePosition().add(new Position(8, 10));
        // 初始化蛇头方向向右
        snake.initDir(4);
        // 随机生成食物坐标
        food = new Position(random.nextInt(34),random.nextInt(29));

        // 游戏积分初始化为0
        score = 0;

        //初始速度
        speed = 500;

        //初始化地图大小
        mapSize = new Position(850 , 725);

        //初始化偏移位置
        initPos = new Position(18 , 31);

        //初始化图标像素大小
        iconSize = 25;

        isOver = false;
        isStart = false;

        timer.setDelay(speed);

        repaint();
    }

    /**
     * 实例化.
     *
     * @param snake 蛇
     */
    public GamePanel(Snake snake){
        super();
        this.snake = snake;
        this.setFocusable(true);

        Init();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE) {
                    if (isOver) {
                        Init();
                    } else {
                        isStart = !isStart;
                    }
                }
                // 按键上下左右控制贪吃蛇的头部方向
                if (isStart && !isOver){
                    if (keyCode == KeyEvent.VK_RIGHT) {
                        command = new MoveRightCommand(snake);
                        command.execute();
                        checkCollision();
                        eatFood();
                    } else if (keyCode == KeyEvent.VK_DOWN) {
                        command = new MoveDownCommand(snake);
                        command.execute();
                        checkCollision();
                        eatFood();
                    } else if (keyCode == KeyEvent.VK_LEFT) {
                        command = new MoveLeftCommand(snake);
                        command.execute();
                        checkCollision();
                        eatFood();
                    } else if (keyCode == KeyEvent.VK_UP) {
                        command = new MoveUpCommand(snake);
                        command.execute();
                        checkCollision();
                        eatFood();
                    }
                }
                repaint();// 重新绘制界面
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        timer_updateScene.start();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //清屏
        super.paintComponent(g);
        this.setBackground(Color.gray);
        //添加组件，绘制游戏区
        g.fillRect(initPos.getX(), initPos.getY(), mapSize.getX(), mapSize.getY());

        // 绘制游戏积分板块
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体", Font.BOLD, 18));
        g.drawString("时延：" +speed/100 , 20, 25);
        g.drawString("分数：" + score, 200, 25);
        drawSnake(g);

        // 根据随机坐标绘制食物
        paintByPos(food, g, ImageData.food);

        // 游戏开始前的提示
        if (!isStart) {
            g.setColor(Color.white);
            g.setFont(new Font("宋体", Font.BOLD, 40));
            g.drawString("按下空格键开始游戏", 245, 400);
            g.drawString("吃一个食物得10分", 265, 450);
        }

        if (isOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("宋体", Font.BOLD, 40));
            g.drawString("游戏失败，按下空格键则重新开始游戏", 100, 400);
            g.drawString("吃一个食物得10分", 260, 450);
        }
    }

    /**
     * 绘制蛇.
     *
     * @param g 画笔对象
     */
    void drawSnake(Graphics g) {
        //蛇头
        paintByPos(snake.getSnakePosition().get(0), g, snake.getHeadImage());

        //蛇身
        for(int i = 1; i < snake.getSnakePosition().size(); i++){
            paintByPos(snake.getSnakePosition().get(i), g, snake.getBodyImage());
        }
    }

    /**
     * 通过逻辑坐标绘制图标.
     *
     * @param pos       逻辑坐标
     * @param g         画笔
     * @param imageIcon 图标
     */
    void paintByPos(Position pos, Graphics g ,ImageIcon imageIcon){
        imageIcon.paintIcon(this, g, pos.getX() * iconSize + initPos.getX(), pos.getY() * iconSize + initPos.getY());
    }

    /**
     * 检测碰撞.
     */
    void  checkCollision(){
        Position pos = snake.getSnakePosition().get(0);

        if(pos.getX() < 0 || pos.getX() > 33 || pos.getY() < 0 || pos.getY() > 28){
            isOver = true;
        }
        for (int i = 1; i < snake.getSnakePosition().size(); i++) {
            if (snake.getSnakePosition().get(0).getX() == snake.getSnakePosition().get(i).getX()
                    && snake.getSnakePosition().get(0).getY() == snake.getSnakePosition().get(i).getY()) {
                isOver = true;
                break;
            }
        }
    }

    /**
     * 检测是否吃到食物.
     */
    void eatFood(){
        Position pos = snake.getSnakePosition().get(0);

        if (pos.getX() == food.getX() && pos.getY() == food.getY()) {
            int frontScore = score;
            // 分数加10
            score += 1;

            if(score / 5 != frontScore / 5){
                speed = speed - 50;
                timer.setDelay(speed);
            }

            snake.eatFood();

            // 更新食物坐标
            food.setX(random.nextInt(34));
            food.setY(random.nextInt(29));

        }
    }
}