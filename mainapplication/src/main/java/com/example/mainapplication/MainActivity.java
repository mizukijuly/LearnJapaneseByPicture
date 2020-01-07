package com.example.mainapplication;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.ImageViewCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {

    //TODO: Implement wrong/correct number counter
    //TODO: Make separated kanji selection
    //TODO:
    ConstraintLayout constraintLayout;
    // Multi dimensional array
    String[][] Kanjis = {
            {
                    "sea", "海","梅","桜",
                    "Right","Wrong","Wrong",
                    "海で泳ぐ/Schwimmen Sie im Meer/Swim in the sea"
            },
            {
                    "sun", "目","日","楊",
                    "Wrong","Right","Wrong",
                    "日が昇る/Die Sonne geht auf/The sun rises"
            },
            {
                    "stone", "砂","磐","石",
                    "Wrong","Wrong","Right",
                    "石が地面に落ちている/Stein liegt auf dem Boden/Stone is on the ground"
            },
            {
                    "tree", "木","林","森",
                    "Right","Wrong","Wrong",
                    " この家の窓から木が見える/Der Baum kann durch die Fenster dieses Hauses gesehen werden/The tree can be seen through the windows of this house"
            },
            {
                    "right", "左","右","上",
                    "Wrong","Right","Wrong",
                    "上下左右/Hoch, runter, links, rechts/Up, down, left, right"
            },
            {
                    "one", "三","二","一",
                    "Wrong","Wrong","Right",
                    "彼女が一番だ。/Sie ist die Beste/She is the best"
            },
            {
                    "rain", "雨","雷","雲",
                    "Right","Wrong","Wrong",
                    "雨が降っている。/Es regnet/It's raining"
            },
            {
                    "circle", "園","円","九",
                    "Wrong","Right","Wrong",
                    "百円玉/Hundert-Yen-Münze/Hundred yen coin"
            },
            {
                    "king", "玉","汪","王",
                    "Wrong","Wrong","Right",
                    "俺は海賊王になる/Ich werde der Piratenkönig sein/I will be the pirate king"
            },
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Declarations.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView KanjiAnswerButton = (ImageView) findViewById(R.id.KanjiAnswerButton);
        final ImageView LeftKanjiBack     = (ImageView) findViewById(R.id.LeftKanjiBack);
        final ImageView MiddleKanjiBack   = (ImageView) findViewById(R.id.MiddleKanjiBack);
        final ImageView RightKanjiBack    = (ImageView) findViewById(R.id.RightKanjiBack);
        final ImageView NextButton        = (ImageView) findViewById(R.id.NextButton);
        final ImageView image             = (ImageView) findViewById(R.id.kanjiWindow);
        final TextView ReftKanji          = (TextView)  findViewById(R.id.LeftKanjiText);
        final TextView MiddleKanji        = (TextView)  findViewById(R.id.MiddleKanjiText);
        final TextView RightKanji         = (TextView)  findViewById(R.id.RightKanjiText);
        final TextView ExampleKanji       = (TextView)  findViewById(R.id.Answer);

        // If user click the one of the Kanji, set visible to Next button/answer.
        KanjiAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 NextButton.setVisibility(View.VISIBLE);
                 ExampleKanji.setVisibility(View.VISIBLE);
                 LeftKanjiBack.setVisibility(View.VISIBLE);
                 MiddleKanjiBack.setVisibility(View.VISIBLE);
                 RightKanjiBack.setVisibility(View.VISIBLE);
            }
        });

        // On click event. If user clicked next button, then change kanji image.

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate random number for random mode.
                // Create instance of Random class
                Random rand      = new Random();

                // Generate random integers in range of array
                int RandomNumber = rand.nextInt(Kanjis.length);

                // To change images. First get resources, then apply it to specified drawable object.
                Resources res    =  getResources();
                Drawable myImage;
                switch(Kanjis[RandomNumber][0]) {
                    case "sea":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.sea, null);
                        break;
                    case "sun":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.sun, null);
                        break;
                    case "tree":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.tree, null);
                        break;
                    case "stone":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.stone, null);
                        break;
                    case "right":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.right, null);
                        break;
                    case "one":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.one, null);
                        break;
                    case "rain":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.rain, null);
                        break;
                    case "circle":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.hyaku, null);
                        break;
                    case "king":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.king, null);
                        break;
                    default:
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.kanjiback, null);
                }
                image.setImageDrawable(myImage);

                // To change text dynamically, use setText method.
                ReftKanji.setText(Kanjis[RandomNumber][1]);
                MiddleKanji.setText(Kanjis[RandomNumber][2]);
                RightKanji.setText(Kanjis[RandomNumber][3]);
                ExampleKanji.setText(Kanjis[RandomNumber][7]);

                // Set image to show Wrong or Not
                Drawable LeftImage, MiddleImage, RightImage;
                if(Kanjis[RandomNumber][4].equals("Right")){
                    LeftImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                }else{
                    LeftImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                }
                if(Kanjis[RandomNumber][5].equals("Right")){
                    MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                }else{
                    MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                }
                if(Kanjis[RandomNumber][6].equals("Right")){
                    RightImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                }else{
                    RightImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                }
                LeftKanjiBack.setImageDrawable(LeftImage);
                MiddleKanjiBack.setImageDrawable(MiddleImage);
                RightKanjiBack.setImageDrawable(RightImage);

                // Set invisible for Answer/Next button.
                NextButton.setVisibility(View.INVISIBLE);
                ExampleKanji.setVisibility(View.INVISIBLE);
                LeftKanjiBack.setVisibility(View.INVISIBLE);
                MiddleKanjiBack.setVisibility(View.INVISIBLE);
                RightKanjiBack.setVisibility(View.INVISIBLE);
            }
        });
    }
}