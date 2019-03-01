package com.example.assignment02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Game game;
    private int [][] button_total = {{R.id.button_one, R.id.button_two, R.id.button_three},
            {R.id.button_four, R.id.button_five, R.id.button_six}, {R.id.button_seven,
            R.id.button_eight, R.id.button_nine}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        if (savedInstanceState != null) {
            game = (Game) savedInstanceState.getSerializable("game");
            getbuttonLayOut();
        }

    }

    public void getbuttonLayOut(){
        TileState state;
        for(int i = 0; i < button_total.length; i++) {
            for(int j = 0; j < button_total.length; j++) {
                state = game.getTileState(i, j);
                Button button = findViewById(button_total[i][j]);
                if (state == TileState.CROSS) {
                    button.setText("X");
                }
                else if (state == TileState.CIRCLE) {
                    button.setText("O");
                }
            }
        }
    }

    // This function will store the game in a bundle
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("game", game);
    }


    public void tileClicked(View view) {
        Log.d("tictactoe", "tileClicked");
        Button button = (Button) view;

        // Translate clicked button ID into coordinates
        int id = view.getId();
        int row = 0;
        int column = 0;
        switch (id) {
            case R.id.button_one:
                row = 0;
                column = 0;
                break;
            case R.id.button_two:
                row = 0;
                column = 1;
                break;
            case R.id.button_three:
                row = 0;
                column = 2;
                break;
            case R.id.button_four:
                row = 1;
                column = 0;
                break;
            case R.id.button_five:
                row = 1;
                column = 1;
                break;
            case R.id.button_six:
                row = 1;
                column = 2;
                break;
            case R.id.button_seven:
                row = 2;
                column = 0;
                break;
            case R.id.button_eight:
                row = 2;
                column = 1;
                break;
            case R.id.button_nine:
                row = 2;
                column = 2;
                break;
        }

//        switch (id) {
//            case R.id.button_one:
//                row = findViewById(R.id.button_one).getLeft();
//                column = findViewById(R.id.button_one).getTop();
//                break;
//            case R.id.button_two:
//                row = findViewById(R.id.button_two).getLeft();
//                column = findViewById(R.id.button_two).getTop();
//                break;
//            case R.id.button_three:
//                row = findViewById(R.id.button_three).getLeft();
//                column = findViewById(R.id.button_three).getTop();
//                break;
//            case R.id.button_four:
//                row = findViewById(R.id.button_four).getLeft();
//                column = findViewById(R.id.button_four).getTop();
//                break;
//            case R.id.button_five:
//                row = findViewById(R.id.button_five).getLeft();
//                column = findViewById(R.id.button_five).getTop();
//                break;
//            case R.id.button_six:
//                row = findViewById(R.id.button_six).getLeft();
//                column = findViewById(R.id.button_six).getTop();
//                break;
//            case R.id.button_seven:
//                row = findViewById(R.id.button_seven).getLeft();
//                column = findViewById(R.id.button_seven).getTop();
//                break;
//            case R.id.button_eight:
//                row = findViewById(R.id.button_eight).getLeft();
//                column = findViewById(R.id.button_eight).getTop();
//                break;
//            case R.id.button_nine:
//                row = findViewById(R.id.button_nine).getLeft();
//                column = findViewById(R.id.button_nine).getTop();
//                break;
//        }

            // Feed coordinates to Game choose method
            TileState state = game.choose(row, column);

            switch (state){
                case CROSS:
                    button.setText("X");
                    findViewById(R.id.INVALID).setVisibility(View.INVISIBLE);
                    // Check if the game has been won
                    if (game.won() == GameState.PLAYER_ONE) {
                        findViewById(R.id.PLAYER_ONE).setVisibility(View.VISIBLE);
                    }
                    break;
                case CIRCLE:
                    button.setText("O");
                    findViewById(R.id.INVALID).setVisibility(View.INVISIBLE);
                    // Check if the game has been won
                    if (game.won() == GameState.PLAYER_TWO) {
                        findViewById(R.id.PLAYER_TWO).setVisibility(View.VISIBLE);
                    }
                    break;
                case INVALID:
                    findViewById(R.id.INVALID).setVisibility(View.VISIBLE);
                    // Check if the game has been won
                    game.won();
                    break;
            }

            if (game.won() == GameState.DRAW) {
                findViewById(R.id.PLAYER_DRAW).setVisibility(View.VISIBLE);
            }

        }


    public void resetClicked(View view) {
        // Reset user interface
        setContentView(R.layout.activity_main);

        // Set new game
        game = new Game();
    }


}
