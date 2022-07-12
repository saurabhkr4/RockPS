package com.example.rockps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rockButton, paperButton, scissorButton, startOverButton;
    private TextView humanText, computerText, yourScoreText, computerScoreText;
    private ImageView humanImage, computerImage;
    private int humanScore, computerScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorButton = findViewById(R.id.scissorButton);
        startOverButton = findViewById(R.id.startOverButton);

        humanText = findViewById(R.id.humanText);
        computerText = findViewById(R.id.computerText);
        yourScoreText = findViewById(R.id.yourScoreText);
        computerScoreText = findViewById(R.id.computerScoreText);

        humanImage = findViewById(R.id.humanImage);
        computerImage = findViewById(R.id.computerImage);

        humanScore = 0;
        computerScore = 0;

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanImage.setImageResource(R.drawable.rockp);
                decide("rock");
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanImage.setImageResource(R.drawable.paperp);
                decide("paper");
            }
        });

        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanImage.setImageResource(R.drawable.scissorp);
                decide("scissor");
            }
        });

        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanScore = 0;
                computerScore = 0;
                updateScore();

                humanImage.setImageResource(R.drawable.rockp);
                computerImage.setImageResource(R.drawable.paperp);

                Toast.makeText(MainActivity.this, "Starting Over", Toast.LENGTH_SHORT).show();

            }
        });

    }

     public void decide(String humanChoice){

        String computerChoice="";
        SecureRandom r = new SecureRandom();
        int computerChoiceInteger = r.nextInt(3)+1;

        if(computerChoiceInteger==1){
            computerChoice = "rock";
        }
        else if(computerChoiceInteger==2){
            computerChoice = "paper";
        }
        else if(computerChoiceInteger==3){
            computerChoice = "scissor";
        }


        //Changing the images of the computer choice
        if(computerChoice.equals("rock")){
            computerImage.setImageResource(R.drawable.rockp);
        }
        else if(computerChoice.equals("paper")){
            computerImage.setImageResource(R.drawable.paperp);
        }
        else if(computerChoice.equals("scissor")){
            computerImage.setImageResource(R.drawable.scissorp);
        }




        if(humanChoice.equals(computerChoice)){
            final Toast toast = Toast.makeText(MainActivity.this, "It's a draw", Toast.LENGTH_SHORT);
            toast.show();
            new CountDownTimer(500, 5)
            {
                public void onTick(long millisUntilFinished) {toast.show();}
                public void onFinish() {toast.cancel();}
            }.start();
        }
        else{
            if(humanChoice.equals("rock")){
                if(computerChoice.equals("paper")){
                    computerScore++;
                    updateScore();
                }
                else if(computerChoice.equals("scissor")){
                    humanScore++;
                    updateScore();
                }
            }
            else if(humanChoice.equals("paper")){
                if(computerChoice.equals("scissor")){
                    computerScore++;
                    updateScore();
                }
                else if(computerChoice.equals("rock")){
                    humanScore++;
                    updateScore();
                }
            }
            else if(humanChoice.equals("scissor")){
                if(computerChoice.equals("rock")){
                    computerScore++;
                    updateScore();
                }
                else if(computerChoice.equals("paper")){
                    humanScore++;
                    updateScore();
                }
            }

        }


     }

     public void updateScore(){
        yourScoreText.setText("Your Score: "+ humanScore);
        computerScoreText.setText("Computer Score: "+computerScore);
     }


}