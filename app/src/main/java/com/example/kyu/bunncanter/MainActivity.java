package com.example.kyu.bunncanter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int sta, stb, undob, undoa; //sta - Score of Team A- Home, stb - Score Team B - Guests
    String undoString, actual;
    TextView scoreViewA, scoreViewB, notifications;
    Button a1, a2, a3, b1, b2, b3; //a1 for 1 point for Team A, a2 for 2 points for Team A etc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        notifications = (TextView) findViewById(R.id.scrool);
        a1 = (Button) findViewById(R.id.Button1a);
        a2 =(Button) findViewById(R.id.Button2a);
        a3 =(Button) findViewById(R.id.Button3a);
        b1= (Button) findViewById(R.id.Button2b);
        b2= (Button) findViewById(R.id.Button3b);
        b3= (Button) findViewById(R.id.Button1b);
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        actual = " ";
        undoString = " ";
    }



    //BUTTON METHODS
    //When we click button with 3 points for Home Team
    public void apathree(View v) {
        undoa = 3;
        undob = 0;
        sta = sta + 3;
        displayForTeamA(sta);
        displayNotifications(3, "Team A");
    }
    //When we click button with 2 points for Home Team
    public void apatwo(View v) {
        undoa = 2;
        undob = 0;
        sta = sta + 2;
        displayForTeamA(sta);
        displayNotifications(2, "Team A");
    }

    //When we click button with 1 point for Home Team
    public void apaone(View v) {
        undoa = 1;
        undob = 0;
        sta = sta + 1;
        displayForTeamA(sta);
        displayNotifications(1, "Team A");
    }

    //When we click button with 3 points for Guest Team
    public void apbthree(View v) {
        undob = 3;
        undoa = 0;
        stb = stb + 3;
        displayForTeamB(stb);
        displayNotifications(3, "Team B");
    }
    //When we click button with 2 points for Guest Team
    public void apbtwo(View v) {
        undoa = 0;
        undob = 2;
        stb = stb + 2;
        displayForTeamB(stb);
        displayNotifications(2, "Team B");
    }

    //When we click button with 1 points for Guest Team
    public void apbone(View v) {
        undoa = 0;
        undob = 1;
        stb = stb + 1;
        displayForTeamB(stb);
        displayNotifications(1, "Team B");
    }

    //When we want to display score for Home Team
    public void displayForTeamA(int scorea) {
        scoreViewA.setText(String.valueOf(scorea));
    }

    //When we want to display score for Guests Team
    public void displayForTeamB(int scoreb) {

        scoreViewB.setText(String.valueOf(scoreb));
    }

    //Metod which allows us to see points scored in notification table
    public void displayNotifications(int result, String team) {
        undoString = actual;
        actual += "\n" + team + " scored " + result + "!";
        notifications.setText(String.valueOf(actual));
    }

    //BAR METHODS

    //Restart method. It nulls all scored points and all gained data
    public void start(View view){
        sta = 0;
        stb = 0;
        actual = "";
        undoa = 0;
        undob = 0;
        undoString = " ";
        displayForTeamA(sta);
        displayForTeamB(stb);
        notifications.setText(String.valueOf(actual));
        a1.setEnabled(false);
        a2.setEnabled(true);
        a3.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
    }

    //undo method. allows us to undo last move we've done
    public void undo(View view) {
        sta = sta - undoa;
        stb = stb - undob;
        displayForTeamA(sta);
        displayForTeamB(stb);
        notifications.setText(String.valueOf(undoString));
        actual = undoString;
        undoa = 0;
        undob = 0;
    }


    //stop method. It disables all buttons so we can "end" our match
    public void stop(View view) {
        undoa = 0;
        undob = 0;
        undoString = actual;
        notifications.setText(String.valueOf(actual));
        a1.setEnabled(false);
        a2.setEnabled(false);
        a3.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);

    }
}

