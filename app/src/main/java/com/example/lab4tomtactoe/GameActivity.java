package com.example.lab4tomtactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    //0 for jerry 1 for tom

    private final int ARRAY_SIZE = 3;
    private final int MAX_ROUND_COUNT = 9;

    private int currentPlayerID;
    private int[] playerIDs = {0,1};

    //need to check draw so need to count rounds. if more than 9 rounds its draw.
    private int roundCount = 0;

    //buttons
    private Card imageButton1;
    private Card imageButton2;
    private Card imageButton3;
    private Card imageButton4;
    private Card imageButton5;
    private Card imageButton6;
    private Card imageButton7;
    private Card imageButton8;
    private Card imageButton9;
    private Card[][] imageButtons = new Card[ARRAY_SIZE][ARRAY_SIZE];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        //randomly choose either jerry or tom
        Random random = new Random();
        int playerSelection = random.nextInt(2);
        currentPlayerID = playerSelection;
        Log.d("asdas",Integer.toString(currentPlayerID));

        //Toast for which player will start
        displayWhichPlayerStarts();


        //initializing buttons
        imageButton1 = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);
        imageButton9 = findViewById(R.id.imageButton9);
        //initializing 2d array in a very very ... very embarrassing way.
        imageButtons[0][0] = imageButton1;
        imageButtons[0][1] = imageButton2;
        imageButtons[0][2] = imageButton3;
        imageButtons[1][0] = imageButton4;
        imageButtons[1][1] = imageButton5;
        imageButtons[1][2] = imageButton6;
        imageButtons[2][0] = imageButton7;
        imageButtons[2][1] = imageButton8;
        imageButtons[2][2] = imageButton9;

    }

    private void switchPlayer(){
        currentPlayerID = currentPlayerID == 0 ? 1 : 0;
    }

    private void onCardSelected(Card button){
        if(currentPlayerID == 1){
            button.setImageResource(R.drawable.jerry_55x55);
            button.setPlayerID(1);
            Log.d("asdas","button.setPlayerID(1)");
        }else{
            button.setImageResource(R.drawable.tom_55x55);
            button.setPlayerID(0);
            Log.d("asdas","button.setPlayerID(0)");
        }
        roundCount++;

        if(checkWinner()){
            gameOver();
        }
        switchPlayer();

    }

    private boolean checkWinner(){

        int a = imageButtons[0][0].getPlayerID();
        int b = imageButtons[0][1].getPlayerID();
        int c = imageButtons[0][2].getPlayerID();
        //Toast.makeText(getApplication(),a+" "+b+" "+c+" "+currentPlayerID,Toast.LENGTH_LONG).show();

        //checking rows
        for(int rowIndex = 0; rowIndex < ARRAY_SIZE; rowIndex++){

            if (imageButtons[rowIndex][0].getPlayerID() == imageButtons[rowIndex][1].getPlayerID()
                    && imageButtons[rowIndex][0].getPlayerID() == imageButtons[rowIndex][2].getPlayerID()
                    && roundCount < MAX_ROUND_COUNT
                    && imageButtons[rowIndex][0].getPlayerID() != 2
                    && imageButtons[rowIndex][1].getPlayerID() != 2
                    && imageButtons[rowIndex][2].getPlayerID() != 2){



                return true;
            }
        }

        //checking columns
        for(int columnIndex = 0; columnIndex < ARRAY_SIZE; columnIndex++){

            if (imageButtons[0][columnIndex].getPlayerID() == imageButtons[1][columnIndex].getPlayerID()
                    && imageButtons[0][columnIndex].getPlayerID() == imageButtons[2][columnIndex].getPlayerID()
                    && roundCount < MAX_ROUND_COUNT
                    && imageButtons[0][columnIndex].getPlayerID() != 2
                    && imageButtons[1][columnIndex].getPlayerID() != 2
                    && imageButtons[0][columnIndex].getPlayerID() != 2){

                return true;
            }
        }


        //checking diagonals
        if(imageButtons[0][0].getPlayerID() == imageButtons[1][1].getPlayerID()
            && imageButtons[0][0] == imageButtons[2][2]
                && imageButtons[0][0].getPlayerID() != 2
                && imageButtons[1][1].getPlayerID() != 2
                && imageButtons[2][2].getPlayerID() != 2)   {

                return true;
        }

        if(imageButtons[0][2].getPlayerID() == imageButtons[1][1].getPlayerID()
                && imageButtons[0][2] == imageButtons[2][0]
                && imageButtons[0][2].getPlayerID() != 2
                && imageButtons[1][1].getPlayerID() != 2
                && imageButtons[2][0].getPlayerID() != 2)   {

            return true;
        }

        return false;
    }

    private void gameOver(){
        //Re-starting activity
        String winnerName = currentPlayerID == 0 ? "Tom" : "Jerry";
        Toast.makeText(getApplication(),winnerName+" has won",Toast.LENGTH_LONG).show();
        finish();
        startActivity(getIntent());
    }

    public void onClickChangeImage(View view) {

        switch (view.getId()){
            case R.id.imageButton:
                onCardSelected(imageButton1);
                Log.d("asdasdasd", "1 ");
                break;
            case R.id.imageButton2:
                onCardSelected(imageButton2);
                Log.d("asdasdasd", " 2");

                break;
            case R.id.imageButton3:
                onCardSelected(imageButton3);
                Log.d("asdasdasd", " 3");

                break;
            case R.id.imageButton4:
                onCardSelected(imageButton4);
                Log.d("asdasdasd", " 4");
                break;
            case R.id.imageButton5:
                onCardSelected(imageButton5);
                Log.d("asdasdasd", " 5");
                break;
            case R.id.imageButton6:
                onCardSelected(imageButton6);
                Log.d("asdasdasd", " 6");
                break;
            case R.id.imageButton7:
                onCardSelected(imageButton7);
                Log.d("asdasdasd", " 7");
                break;
            case R.id.imageButton8:
                onCardSelected(imageButton8);
                Log.d("asdasdasd", " 8");
                break;
            case R.id.imageButton9:
                onCardSelected(imageButton9);
                Log.d("asdasdasd", " 9");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    private void displayWhichPlayerStarts(){
        if (currentPlayerID == 0){
            Toast toast =Toast.makeText(getApplicationContext(),"Tom starts",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,350,200);
            toast.show();
        }else{
            Toast toast =Toast.makeText(getApplicationContext(),"Jerry starts",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 350,200);
            toast.show();
        }
    }
}