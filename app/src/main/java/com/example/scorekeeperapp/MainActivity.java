package com.example.scorekeeperapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isTeam1 = true;

    int outsCount;
    int balls;
    int strikes;

    int team1Total;
    int team2Total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rightLayout= (RelativeLayout) findViewById(R.id.RightLayout);
        RelativeLayout leftLayout = (RelativeLayout) findViewById(R.id.LeftLayout);

        rightLayout.setBackgroundColor(Color.WHITE);
        leftLayout.setBackgroundColor(Color.BLUE);
    }

    private void updateBoard() {
        TextView totalTeamOne = (TextView) findViewById(R.id.TotalTeam1);
        TextView totalTeamTwo = (TextView) findViewById(R.id.TotalTeam2);
        totalTeamOne.setText("Hit/Walks = " + team1Total);
        totalTeamTwo.setText("Hit/Walks = " + team2Total);

        if (isTeam1 == true) {
            TextView outs = (TextView) findViewById(R.id.Team1Outs);

            TextView strike1 = (TextView) findViewById(R.id.Strike1Team1);
            TextView strike2 = (TextView) findViewById(R.id.Strike2Team1);
            TextView strike3 = (TextView) findViewById(R.id.Strike3Team1);

            TextView ball1 = (TextView) findViewById(R.id.Ball1Team1);
            TextView ball2 = (TextView) findViewById(R.id.Ball2Team1);
            TextView ball3 = (TextView) findViewById(R.id.Ball3Team1);
            TextView ball4 = (TextView) findViewById(R.id.Ball4Team1);

            if (strikes == 1) {
                strike1.setText("🔴");
            } else if (strikes == 2) {
                strike1.setText("🔴");
                strike2.setText("🔴");
            } else if (strikes == 3) {
                strike1.setText("🔴");
                strike2.setText("🔴");
                strike3.setText("🔴");
            }

            if (outsCount == 0) {
                outs.setText("Outs = 0");
            } else if (outsCount == 1) {
                outs.setText("Outs = 1");
            } else if (outsCount == 2) {
                outs.setText("Outs = 2");
            } else if (outsCount == 3) {
                outs.setText("Outs = 3");
            }


            if (balls == 1) {
                ball1.setText("🔵");
            } else if (balls == 2) {
                ball1.setText("🔵");
                ball2.setText("🔵");
            } else if (balls == 3) {
                ball1.setText("🔵");
                ball2.setText("🔵");
                ball3.setText("🔵");
            } else if (balls == 4) {
                ball1.setText("🔵");
                ball2.setText("🔵");
                ball3.setText("🔵");
                ball4.setText("🔵");
            }

        } else {
            TextView outs = (TextView) findViewById(R.id.Team2Outs);

            TextView strike1 = (TextView) findViewById(R.id.Strike1Team2);
            TextView strike2 = (TextView) findViewById(R.id.Strike2Team2);
            TextView strike3 = (TextView) findViewById(R.id.Strike3Team2);

            TextView ball1 = (TextView) findViewById(R.id.Ball1Team2);
            TextView ball2 = (TextView) findViewById(R.id.Ball2Team2);
            TextView ball3 = (TextView) findViewById(R.id.Ball3Team2);
            TextView ball4 = (TextView) findViewById(R.id.Ball4Team2);

            if (strikes == 1) {
                strike1.setText("🔴");
            } else if (strikes == 2) {
                strike1.setText("🔴");
                strike2.setText("🔴");
            } else if (strikes == 3) {
                strike1.setText("🔴");
                strike2.setText("🔴");
                strike3.setText("🔴");
            }


            if (outsCount == 0) {
                outs.setText("Outs = 0");
            } else if (outsCount == 1) {
                outs.setText("Outs = 1");
            } else if (outsCount == 2) {
                outs.setText("Outs = 2");
            } else if (outsCount == 3) {
                outs.setText("Outs = 3");
            }


            if (balls == 1) {
                ball1.setText("🔵");
            } else if (balls == 2) {
                ball1.setText("🔵");
                ball2.setText("🔵");
            } else if (balls == 3) {
                ball1.setText("🔵");
                ball2.setText("🔵");
                ball3.setText("🔵");
            } else if (balls == 4) {
                ball1.setText("🔵");
                ball2.setText("🔵");
                ball3.setText("🔵");
                ball4.setText("🔵");
            }
        }
    }

    public void point(View v) {
        addPoint();
    }

    public void strike(View v) {
        strikes += 1;
        if (strikes == 3) {
            outsCount += 1;
            clearBallsAndStrikes();
            if (outsCount == 3) {
                outsCount = 0;
                updateBoard();
                switchTeams();
            }
        }
        updateBoard();
    }

    private void clearBallsAndStrikes() {
        TextView ball11 = (TextView) findViewById(R.id.Ball1Team1);
        TextView ball21 = (TextView) findViewById(R.id.Ball2Team1);
        TextView ball31 = (TextView) findViewById(R.id.Ball3Team1);
        TextView ball41 = (TextView) findViewById(R.id.Ball4Team1);

        ball11.setText("⚪");
        ball21.setText("⚪");
        ball31.setText("⚪");
        ball41.setText("⚪");

        TextView ball12 = (TextView) findViewById(R.id.Ball1Team2);
        TextView ball22 = (TextView) findViewById(R.id.Ball2Team2);
        TextView ball32 = (TextView) findViewById(R.id.Ball3Team2);
        TextView ball42 = (TextView) findViewById(R.id.Ball4Team2);

        ball12.setText("⚪");
        ball22.setText("⚪");
        ball32.setText("⚪");
        ball42.setText("⚪");

        balls = 0;

        TextView strike11 = (TextView) findViewById(R.id.Strike1Team1);
        TextView strike21 = (TextView) findViewById(R.id.Strike2Team1);
        TextView strike31 = (TextView) findViewById(R.id.Strike3Team1);

        strike11.setText("⚪");
        strike21.setText("⚪");
        strike31.setText("⚪");

        TextView strike12 = (TextView) findViewById(R.id.Strike1Team2);
        TextView strike22 = (TextView) findViewById(R.id.Strike2Team2);
        TextView strike32= (TextView) findViewById(R.id.Strike3Team2);

        strike12.setText("⚪");
        strike22.setText("⚪");
        strike32.setText("⚪");

        strikes = 0;
    }

    public void ball(View v) {
        balls += 1;
        if (balls == 4) {
            clearBallsAndStrikes();
            addPoint();
        }
        updateBoard();
    }

    private void addPoint() {
        if (isTeam1 == true) {
            team1Total += 1;
        } else {
            team2Total += 1;
        }
        updateBoard();
    }

    private void switchTeams() {
        RelativeLayout rightLayout= (RelativeLayout) findViewById(R.id.RightLayout);
        RelativeLayout leftLayout = (RelativeLayout) findViewById(R.id.LeftLayout);

        if (isTeam1 == true) {
            isTeam1 = false;
            rightLayout.setBackgroundColor(Color.BLUE);
            leftLayout.setBackgroundColor(Color.WHITE);
            TextView strike11 = (TextView) findViewById(R.id.Strike1Team1);
            TextView strike21 = (TextView) findViewById(R.id.Strike2Team1);
            TextView strike31 = (TextView) findViewById(R.id.Strike3Team1);

            TextView ball11 = (TextView) findViewById(R.id.Ball1Team1);
            TextView ball21 = (TextView) findViewById(R.id.Ball2Team1);
            TextView ball31 = (TextView) findViewById(R.id.Ball3Team1);
            TextView ball41 = (TextView) findViewById(R.id.Ball4Team1);

            strike11.setText("⚪");
            strike21.setText("⚪");
            strike31.setText("⚪");

            ball11.setText("⚪");
            ball21.setText("⚪");
            ball31.setText("⚪");
            ball41.setText("⚪");
        } else {
            isTeam1 = true;
            leftLayout.setBackgroundColor(Color.BLUE);
            rightLayout.setBackgroundColor(Color.WHITE);
            TextView strike12 = (TextView) findViewById(R.id.Strike1Team2);
            TextView strike22 = (TextView) findViewById(R.id.Strike2Team2);
            TextView strike32= (TextView) findViewById(R.id.Strike3Team2);

            TextView ball12 = (TextView) findViewById(R.id.Ball1Team2);
            TextView ball22 = (TextView) findViewById(R.id.Ball2Team2);
            TextView ball32 = (TextView) findViewById(R.id.Ball3Team2);
            TextView ball42 = (TextView) findViewById(R.id.Ball4Team2);

            strike12.setText("⚪");
            strike22.setText("⚪");
            strike32.setText("⚪");

            ball12.setText("⚪");
            ball22.setText("⚪");
            ball32.setText("⚪");
            ball42.setText("⚪");
        }
        balls = 0;
        strikes = 0;
        outsCount = 0;

        updateBoard();
    }

    public void reset(View v) {
        TextView strike11 = (TextView) findViewById(R.id.Strike1Team1);
        TextView strike21 = (TextView) findViewById(R.id.Strike2Team1);
        TextView strike31 = (TextView) findViewById(R.id.Strike3Team1);

        TextView ball11 = (TextView) findViewById(R.id.Ball1Team1);
        TextView ball21 = (TextView) findViewById(R.id.Ball2Team1);
        TextView ball31 = (TextView) findViewById(R.id.Ball3Team1);
        TextView ball41 = (TextView) findViewById(R.id.Ball4Team1);

        strike11.setText("⚪");
        strike21.setText("⚪");
        strike31.setText("⚪");

        ball11.setText("⚪");
        ball21.setText("⚪");
        ball31.setText("⚪");
        ball41.setText("⚪");


        TextView strike12 = (TextView) findViewById(R.id.Strike1Team2);
        TextView strike22 = (TextView) findViewById(R.id.Strike2Team2);
        TextView strike32= (TextView) findViewById(R.id.Strike3Team2);

        TextView ball12 = (TextView) findViewById(R.id.Ball1Team2);
        TextView ball22 = (TextView) findViewById(R.id.Ball2Team2);
        TextView ball32 = (TextView) findViewById(R.id.Ball3Team2);
        TextView ball42 = (TextView) findViewById(R.id.Ball4Team2);

        strike12.setText("⚪");
        strike22.setText("⚪");
        strike32.setText("⚪");

        ball12.setText("⚪");
        ball22.setText("⚪");
        ball32.setText("⚪");
        ball42.setText("⚪");

        balls = 0;
        strikes = 0;
        outsCount = 0;
        team1Total = 0;
        team2Total = 0;

        if (isTeam1 == false) {
            switchTeams();
        }

        updateBoard();
    }
}
