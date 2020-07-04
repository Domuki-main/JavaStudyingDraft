package FB;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * @Author MA ZHIYUAN 201464
 * @Date 2020/06/30
 */

public class AssignmentFXBird extends Application {

    /** Containers */
    private Label scoreLabel;               //used to display the score all the time in game
    private Label beginningLabel;           //the label of the beginning and it will be changed when game begins
    private Label gameOverLabel;
    private Label gameWinLabel;
    private Ellipse bird;                   //the bird object
    private Rectangle ground;               //the ground
    private ArrayList<Rectangle> columns;   //the columns group
    private Group root;
    private Scene scene;
    private Timeline timeline;
    /** Variables */
    private int score;
    private int maxScore;                  //the score of user
    private int HEIGHT = 700;
    private int WIDTH = 800;                //the width and height of stage (the whole window of the game)
    private int number_of_columns = 2;
    private int bird_speed;
    private int timer_action;
    private boolean gameWin;
    private boolean gameOver;

    /**
     * the function of setting beginning label
     */
    public void beginningLabelSetting(){
        beginningLabel.setText("< Press UP key to start >");
        beginningLabel.setFont(new Font("Arial",40));
        beginningLabel.setLayoutX(WIDTH/2-220);
        beginningLabel.setLayoutY(HEIGHT/2-100);
        beginningLabel.setTextFill(Color.INDIANRED);
    }

    /**
     * the function of setting game over label
     */
    public void gameOverLabelSetting(){
        gameOverLabel.setText("UPM DIED\n   Score:" + score);
        gameOverLabel.setFont(new Font("Arial",80));
        gameOverLabel.setLayoutX(WIDTH / 2 - 210);
        gameOverLabel.setLayoutY(HEIGHT / 2 - 140);
        gameOverLabel.setTextFill(Color.DARKRED);
    }

    /**
     * the judgement of game over
     */
    public void gameOverJudgement(){
        for(Rectangle column:columns) {
            if (score < columns.size())
                if((column.getBoundsInParent().intersects(bird.getBoundsInParent()))) {
                    //when border conflict, the game over
                    gameOver = true;
                    if(bird.getCenterX() <= column.getX())
                    /*
                        when the centre X small than column X means that
                        centre of bird didn't pass the x position of column
                     */
                        bird.setCenterX(column.getX() - 2 * bird.getRadiusX() + 5);
                    /*
                        let the bird die on the left side of the last column
                     */
                }
        }
        if (score < columns.size())
            if(bird.getCenterY() > HEIGHT - 120 || bird.getCenterY() < 0) {
                gameOver = true; //die over the bound
            }
        if(gameOver) {
            gameOverLabelSetting();
        }
    }

    /**
     * the function of setting game win label
     */
    public void gameWinLabelSetting(){
        gameWinLabel.setText("UPM WIN!\n   Score:" + score);
        gameWinLabel.setFont(new Font("Arial", 80));
        gameWinLabel.setLayoutX(WIDTH / 2 - 210);
        gameWinLabel.setLayoutY(HEIGHT / 2 - 140);
        gameWinLabel.setTextFill(Color.GOLD);
    }

    /**
     * the judgement of game win
     */
    public void gameWinJudgement(){
        System.out.println(score+"\t"+columns.size());
        if (score == number_of_columns)
            gameWin = true;
        if(gameWin) {
            gameWinLabelSetting();
        }
    }

    /**
     * the function of setting score label
     */
    public void scoreLabelSetting(){
        scoreLabel.setText("Score: " + score + "\nMAX: " + maxScore);
        scoreLabel.setAlignment(Pos.TOP_CENTER);
        scoreLabel.setTextFill(Color.DARKRED);
        scoreLabel.setFont(new Font("Arial",30));
        scoreLabel.setTranslateX(350);
        scoreLabel.setTranslateY(20);
        /*
            initialize the score
            display the score on the top of the screen
         */
    }

    /**
     * the function of bird setting
     */
    public void birdSetting(){
        ImagePattern pattern_bird = new ImagePattern(new Image("FB/bird.png"));
        bird.setFill(pattern_bird);
        bird.setRadiusX((20));
        bird.setRadiusY((20));
        bird.setCenterX(WIDTH / 2 - 10);
        bird.setCenterY(HEIGHT / 2 - 10);
        bird_speed = 0;
    }

    /**
     * action jump
     */
    public void jump(){
        if(!gameOver){
            /* When the game isn't over, the operation can continue */
            if(bird_speed > 0){
                /* if YMovement larger than 0, it becomes 0 */
                bird_speed = 0;
            }
            bird_speed = bird_speed - 6;
        }
    }

    /**
     * producing columns
     */
    public void addColumn() {
        int space = 300; //the entrance between the upper column and lower column
        int width = 100; //the width of column
        int height = 50 + (int) (Math.random() * 300); //the height of column

        columns.add(new Rectangle(WIDTH +width+(columns.size()*200), HEIGHT - height-120, width, height)); //lower column
        columns.add(new Rectangle(WIDTH +width+(columns.size()-1)*200,0, width, HEIGHT - height - space)); //upper column
    }

    /**
     * initialization
     */
    public void initialization(){

        /* The initialization of deleting of previous items */
        root.getChildren().removeAll(columns);
        columns.clear();

        /* The initialization of game parameters */
        gameOver = false;
        gameWin = false;
        if(score > maxScore) maxScore = score;
        score = 0;

        /* The initialization of bird, color red, centre location */
        bird_speed = 0;
        bird.setCenterX(WIDTH / 2 - 10);
        bird.setCenterY(HEIGHT / 2 - 10);

        /* The initialization of columns */
        for(int i = 0; i < number_of_columns; i++)
            addColumn();

        /* The initialization of score label */
        scoreLabelSetting();

        /* The initialization of beginning label */
        beginningLabelSetting();
        timeline.pause();
        root.getChildren().add(beginningLabel);

        /* transition */
        scene.setOnKeyReleased(k -> {
            String code = k.getCode().toString();
            if(code == "UP") {
                root.getChildren().addAll(columns);
                root.getChildren().remove(beginningLabel);
                timeline.play();
            }
        });
    }



    @Override
    public void start(Stage primaryStage){
        root = new Group(); //initialize root
        gameOverLabel = new Label();
        beginningLabel = new Label();
        gameWinLabel = new Label();
        bird = new Ellipse();   //initialize bird
        scoreLabel = new Label();
        birdSetting();

        /**
         * the score label
         */
        scoreLabelSetting();

        /**
         * the columns
         */
        columns = new ArrayList<Rectangle>();

        /**
         * the ground
         */
        ground = new Rectangle(0,HEIGHT-120,WIDTH,120);
        ground.setFill(Color.DARKRED);

        /**
         * the time line
         */
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        gameOver = false;
        gameWin = false;

        /**
         * 由timeline控制的两个条件中的一个
         * 用于检查跳跃和碰撞以及检查死亡状态
         * 跳跃则减，不跳则加。触碰则死，死则进入死亡界面
         */
        KeyFrame keyFrame_of_bird = new KeyFrame(Duration.millis(20), e -> {
            timer_action++;
            if(timer_action % 3 == 0 && bird_speed < 15) {
                bird_speed += 1;
            }

            int bird_new_centreY = (int)bird.getCenterY() + bird_speed;
            bird.setCenterY(bird_new_centreY);

            scene.setOnKeyReleased(k -> {
                String code = k.getCode().toString();
                if(code == "UP") jump();
            });

            scene.setOnMouseClicked(k -> {
                jump();
            });

            gameOverJudgement();

            if(gameOver) {

                root.getChildren().remove(bird);

                if(!(root.getChildren().contains(gameOverLabel)))
                    root.getChildren().addAll(gameOverLabel);

                scene.setOnKeyReleased(k -> {
                    if(k.getCode() == KeyCode.UP){
                        root.getChildren().remove(gameOverLabel);
                        initialization();
                        root.getChildren().add(bird);
                    }
                });
            }
        });

        KeyFrame keyFrame_of_column = new KeyFrame(Duration.millis(20), e -> {
            if (!gameOver){
                for(int i = 0;i < columns.size(); i++) {
                    Rectangle column = columns.get(i);
                    column.setFill(Color.INDIANRED);
                    column.setX((column.getX() - 5));

                    if(column.getY() == 0 && bird.getCenterX() + bird.getRadiusX() > column.getX() + column.getWidth() / 2-5
                            &&bird.getCenterX() + bird.getRadiusX() < column.getX() + column.getWidth()/2+5) {
                        score++;
                        scoreLabel.setText("Score: " + score + "\nMAX: " + maxScore);
                        scoreLabel.setTextFill(Color.DARKRED);
                    }
                }
            }
            /*
                delete the columns which already passed by
             */
            for(int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                if((column.getX()+column.getWidth())<0) {
                    columns.remove(i);
                }
            }
        });

        KeyFrame keyFrame_of_win = new KeyFrame(Duration.millis(10), e -> {

            gameWinJudgement();

            if(gameWin){
                root.getChildren().remove(bird);

                if(!(root.getChildren().contains(gameWinLabel)) && columns.size() == 0)
                    root.getChildren().addAll(gameWinLabel);
                scene.setOnKeyReleased(k -> {
                    if(k.getCode() == KeyCode.UP){
                        root.getChildren().remove(gameWinLabel);
                        initialization();
                        root.getChildren().add(bird);
                    }
                });
            }
        });

        timeline.getKeyFrames().addAll(keyFrame_of_bird, keyFrame_of_column, keyFrame_of_win);
        //the timeline is made by two key frame

        root.getChildren().addAll(ground, bird, scoreLabel);

        scene = new Scene(root);
        scene.setFill(Color.WHITE);
        initialization();

        primaryStage.setScene(scene);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setTitle("Flappy UPM");
        primaryStage.setResizable(false); //cannot change the size of the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
