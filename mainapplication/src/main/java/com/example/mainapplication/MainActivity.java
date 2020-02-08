package com.example.mainapplication;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;


public class MainActivity extends AppCompatActivity {

    //TODO: Show wrong list in the last.
    //TODO: Put 2,000 Kanji
    //TODO: Difficulty selection
    //TODO: Review example sentence. If sentence is related to picture it helps to remember.
    //TODO: Add German/English word from G2
    //TODO: Think about monetise.
    //FUTURE: Change language function -> Make different application because it will break the layout

    ConstraintLayout constraintLayout;
    int        Questions        = 0;
    int        CorrectAnswers   = 0;
    int        RandomNumber     = 0;
    boolean    LockNumberCount  = false;

    // Multi dimensional array
    // G1 = FirstGrade
    // Each array contains 40-50 kanjis
    String[][] KanjisG3_3 = {
            {"charge", "係", "example"},
            {"emotion", "感", "example"},
            {"throw", "投", "example"},
            {"hit", "打", "example"},
            {"island", "島", "example"},
            {"both", "両", "example"},
            {"clothing", "服", "example"},
            {"rite", "式", "example"},
            {"discuss", "談", "example"},
            {"flow", "流", "example"},
            {"bureau", "局", "example"},
            {"release", "放", "example"},
            {"ball", "球", "example"},
            {"duty", "役", "example"},
            {"somebody", "身", "example"},
            {"wherefore", "由", "example"},
            {"drink", "飲", "example"},
            {"extinguish", "消", "example"},
            {"god", "神", "example"},
            {"distribute", "配", "example"},
            {"grow_up", "育", "example"},
            {"ride", "乗", "example"},
            {"concept", "想", "example"},
            {"", "想", "example"},
    };
    String[][] KanjisG3_2 = {
            {"doctor", "医", "example"},
            {"serve", "仕", "example"},
            {"leave", "去", "example"},
            {"taste", "味", "example"},
            {"copy", "写", "example"},
            {"pour", "注", "example"},
            {"bad", "悪", "example"},
            {"mansion", "館", "example"},
            {"roof", "屋", "example"},
            {"opposite", "対", "example"},
            {"section", "部", "example"},
            {"mutual", "相", "example"},
            {"determine", "定", "example"},
            {"reality", "実", "example"},
            {"decide", "決", "example"},
            {"whole", "全", "example"},
            {"surface", "表", "example"},
            {"learn", "習", "example"},
            {"tune", "調", "example"},
            {"change", "化", "example"},
            {"station", "駅", "example"},
            {"period", "期", "example"},
            {"take", "取", "example"},
            {"metropolis", "都", "example"},
            {"harmony", "和", "example"},
            {"even", "平", "example"},
            {"passive", "受", "example"},
            {"district", "区", "example"},
            {"ocean", "洋", "example"},
            {"prefecture", "県", "example"},
            {"advance", "進", "example"},
            {"finger", "指", "example"},
            {"trip", "旅", "example"},
            {"beforehand", "予", "example"},
            {"toward", "向", "example"},
            {"win", "勝", "example"},
            {"mask", "面", "example"},
            {"committee", "委", "example"},
            {"anti", "反", "example"},
            {"place", "所", "example"},
            {"sequence", "次", "example"}
    };
    String[][] KanjisG3_1 = {
            {"thing", "事", "example"},
            {"develop", "発", "example"},
            {"someone", "者", "example"},
            {"business", "業", "example"},
            {"member", "員", "example"},
            {"open", "開", "example"},
            {"question", "問", "example"},
            {"substitute", "代", "example"},
            {"move", "動", "example"},
            {"main", "主", "example"},
            {"title", "題", "example"},
            {"idea", "意", "example"},
            {"degree", "度", "example"},
            {"hold", "持", "example"},
            {"generation", "世", "example"},
            {"relax", "安", "example"},
            {"institution", "院", "example"},
            {"world", "界", "example"},
            {"heavy", "重", "example"},
            {"correct", "集", "example"},
            {"object", "物", "example"},
            {"use", "使", "example"},
            {"goods", "品", "example"},
            {"death", "死", "example"},
            {"begin", "始", "example"},
            {"carry", "運", "example"},
            {"end", "終", "example"},
            {"live", "住", "example"},
            {"true", "真", "example"},
            {"possess", "有", "example"},
            {"express", "急", "example"},
            {"send", "送", "example"},
            {"rotate", "転", "example"},
            {"study", "研", "example"},
            {"research", "究", "example"},
            {"rouse", "起", "example"},
            {"arrive", "着", "example"},
            {"ill", "病", "example"},
            {"wait", "待", "example"},
            {"tribe", "族", "example"},
            {"silver", "銀", "example"}
    };
    String[][] KanjisG2_3 = {
            {"consider", "考", "example"},
            {"paint", "画", "example"},
            {"sell", "売", "example"},
            {"know", "知", "example"},
            {"road", "道", "example"},
            {"plan", "計", "example"},
            {"morning", "朝", "example"},
            {"pedestal", "台", "example"},
            {"wide", "広", "example"},
            {"little", "小", "example"},
            {"craft", "工", "example"},
            {"stop", "止", "example"},
            {"cut", "切", "example"},
            {"fun", "楽", "example"},
            {"shop", "店", "example"},
            {"parent", "親", "example"},
            {"answer", "答", "example"},
            {"night", "夜", "example"},
            {"homecoming", "帰", "example"},
            {"old", "古", "example"},
            {"sing", "歌", "example"},
            {"buy", "買", "example"},
            {"map", "図", "example"},
            {"week", "週", "example"},
            {"room", "室", "example"},
            {"walk", "歩", "example"},
            {"wind", "風", "example"},
            {"paper", "紙", "example"},
            {"black", "黒", "example"},
            {"spring", "春", "example"},
            {"color", "色", "example"},
            {"run", "走", "example"},
            {"autumn", "秋", "example"},
            {"summer", "夏", "example"},
            {"fit", "合", "example"},
            {"city", "市", "example"},
            {"inside", "内", "example"},
            {"round", "回", "example"},
            {"rice", "米", "example"},
            {"hit", "当", "example"},
            {"neck", "首", "example"},
            {"number", "数", "example"},
            {"scribe", "記", "example"},
            {"point", "点", "example"},
            {"lively", "活", "example"},
            {"primitive", "原", "example"},
            {"mingle", "交", "example"},
            {"association", "組", "example"},
            {"pull", "引", "example"},
            {"straightaway", "直", "example"},
            {"weekday", "曜", "example"}
    };
    String[][] KanjisG2_2 = {
            {"time", "時", "example" },
            {"before", "前", "example"},
            {"between", "間", "example"},
            {"east", "東", "example"},
            {"now", "今", "example"},
            {"high", "高", "example"},
            {"out", "外", "example"},
            {"come", "来", "example"},
            {"story", "話", "example"},
            {"north", "北", "example"},
            {"noon", "午", "example"},
            {"write", "書", "example"},
            {"half", "半", "example"},
            {"west", "西", "example"},
            {"electronic", "電", "example"},
            {"word", "語", "example"},
            {"listen", "聞", "example"},
            {"food", "食", "example"},
            {"what", "何", "example"},
            {"South", "南", "example"},
            {"ten_thousand", "万", "example"},
            {"every", "毎", "example"},
            {"mother", "母", "example"},
            {"read", "読", "example"},
            {"friend", "友", "example"},
            {"meet", "会", "example"},
            {"same", "同", "example"},
            {"me", "自", "example"},
            {"company", "社", "example"},
            {"father", "父", "example"},
            {"direction", "方", "example"},
            {"new", "新", "example"},
            {"place", "場", "example"},
            {"bright", "明", "example"},
            {"capital", "京", "example"},
            {"traffic", "通", "example"},
            {"say", "言", "example"},
            {"reason", "理", "example"},
            {"body", "体", "example"},
            {"make", "作", "example"},
            {"use", "用", "example"},
            {"strong", "強", "example"},
            {"public", "公", "example"},
            {"field", "野", "example"},
            {"think", "思", "example"},
            {"house", "家", "example"},
            {"many", "多", "example"},
            {"heart", "心", "example"},
            {"teach", "教", "example"},
            {"origin", "元", "example"},
            {"near", "近", "example"}
    };
    String[][] KanjisG2_1 = {
            {"turn", "番", "example"},
            {"calculate", "算", "example"},
            {"meat", "肉", "example"},
            {"line", "線", "example"},
            {"voice", "声", "example"},
            {"form", "形", "example"},
            {"bird", "鳥", "example"},
            {"head", "頭", "example"},
            {"gate", "門", "example"},
            {"winter", "冬", "example"},
            {"afternoon", "昼", "example"},
            {"tea", "茶", "example"},
            {"valley", "谷", "example"},
            {"ray", "光", "example"},
            {"department", "科", "example"},
            {"younger_brother", "弟", "example"},
            {"dainty", "細", "example"},
            {"round", "丸", "example"},
            {"thick", "太", "example"},
            {"door", "戸", "example"},
            {"cow", "牛", "example"},
            {"fish", "魚", "example"},
            {"elder_brother", "兄", "example"},
            {"park", "園", "example"},
            {"horse", "馬", "example"},
            {"face", "顔", "example"},
            {"ship", "船", "example"},
            {"feather", "羽", "example"},
            {"rock", "岩", "example"},
            {"angle", "角", "example"},
            {"little_sister", "妹", "example"},
            {"pond", "池", "example"},
            {"star", "星", "example"},
            {"elder_sister", "姉", "example"},
            {"temple", "寺", "example"},
            {"distant", "遠", "example"},
            {"picture", "絵", "example"},
            {"weak", "弱", "example"},
            {"clear_up", "晴", "example"},
            {"snow", "雪", "example"},
            {"fur", "毛", "example"},
            {"yellow", "黄", "example"},
            {"cloud", "雲", "example"},
            {"chirp", "鳴", "example"},
            {"talent", "才", "example"},
            {"barley", "麦", "example"},
            {"parent's_home", "里", "example"},
            {"dart", "矢", "example"},
            {"blade", "刀", "example"},
            {"bow", "弓", "example"},
            {"vapor", "汽", "example"},
            {"back", "後", "example"},
            {"minute", "分", "example"},
            {"go", "行", "example"},
            {"time", "時", "example"},
            {"long", "長", "example"},
            {"country", "国", "example"}
    };
    String[][] KanjisG1_2 = {
            {"person", "人", "人々が団結する/Menschen vereinen sich/People unite"},
            {"water", "水", "水滴が波紋を生む/Tröpfchen erzeugen Wellen/Droplets create ripples"},
            {"justice", "正", "正義の名の下に/Im Namen der Gerechtigkeit/In the name of justice"},
            {"life", "生", "子供が生まれる/Ein Kind wird geboren/A child is born"},
            {"six", "六", "さいころの六/Sechsseitigen Würfeln möglich/Six of dice"},
            {"glove", "林", "木々が群生して林になる/Bäume wachsen zu Handschuhen/Trees grow into grove"},
            {"power", "力", "供給電力/Mit Strom versorgen/Supply power"},
            {"stand", "立", "ヨガのポーズで立つ/Stehen Sie in Yoga-Pose/Stand in yoga pose"},
            {"eye", "目", "青い目/Blaue Augen/Blue eyes"},
            {"name", "名", "名義が書かれたカード/Karte mit Namen/Card with name"},
            {"book", "本", "本を散らかす/Bücher streuen/Scatter books"},
            {"sentence", "文", "啓発文の書かれたコップ/Tasse mit Aufklärungssatz/Cup with enlightenment sentence"},
            {"hundred", "百", "百パーセント保証/Hudred Prozent Garantie/Hudred percent guarantee"},
            {"eight", "八", "八番球/Acht Ball/Eighth ball"},
            {"white", "白", "白鳥が泳ぐ/Schwäne schwimmen/Swans swim"},
            {"year", "年", "今年は東京オリンピック/Dieses Jahr sind die Olympischen Spiele in Tokio/This year is the Tokyo Olympics"},
            {"enter", "入", "入口/der Eingang/Entrance"},
            {"two", "二", "二人の女性/Zwei Frauen/Two women"},
            {"earth", "地", "干ばつした地面/Dürre Boden/Drought ground"},
            {"ricefield", "田", "一面に広がる田畑/Felder breiteten sich aus/Fields spread all over"},
            {"heaven", "天", "天より遣われし犬天使/Hundeengel vom Himmel geschickt/Dog angel sent from heaven"},
            {"town", "町", "町に夜が訪れる/Die Nacht kommt in die Stadt/Night comes to town"},
            {"insect", "虫", "テントウムシ/Die Marienkäfer/Ladybird"},
            {"middle", "中", "ハートの真ん中/Mitten im Herzen/Middle of heart"},
            {"bamboo", "竹", "聳え立つ竹/Hoch aufragender Bambus/Towering bamboo"},
            {"man", "男", "暗闇に佇む男/Mann steht in der Dunkelheit/Man standing in the dark"},
            {"large", "大", "巨大クラゲ/die Riesenquallen/Giant jellyfish"},
            {"village", "村", "村に夕日が落ちる/Sonnenuntergang fällt in das Dorf/Sunset falls in the village"},
            {"leg", "足", "車から足だけ出す/Steig aus dem Auto/Get your feet out of the car"},
            {"grass", "草", "草原で読書/Lesen auf der Wiese/Reading on the meadow"},
            {"early", "早", "早朝/früher Morgen/Early morning"},
            {"ahead", "先", "この先には何が待っているのか/Was wartet noch?/What's waiting ahead"},
            {"river", "川", "川で魚を釣る/Fischen Sie im Fluss/Fish in the river"},
            {"thousand", "千", "千ルーブル/Tausend Rubel/Thousand rubles"},
            {"red", "赤", "赤い薔薇/rote Rose/Red rose"},
            {"evening", "夕", "夕日を背に受ける/Der Sonnenuntergang dahinter/The sunset behind"},
            {"blue", "青", "青い目/Blaue Augen/Blue eyes"},
            {"sea", "海", "海で泳ぐ/Schwimmen Sie im Meer/Swim in the sea"}
    };

    String[][] KanjisG1_1 = {
            {"sun", "日", "日が昇る/Die Sonne geht auf/The sun rises"},
            {"stone", "石", "石が地面に落ちている/Stein liegt auf dem Boden/Stone is on the ground"},
            {"tree", "木", " 木が見える/Ich kann die Bäume sehen/I can see the tree"},
            {"right", "右", "上下左右/Hoch, runter, links, rechts/Up, down, left, right"},
            {"one", "一", "彼女が一番だ。/Sie ist die Beste/She is the best"},
            {"rain", "雨", "雨が降っている。/Es regnet/It's raining"},
            {"circle", "円", "百円玉/Hundert-Yen-Münze/Hundred yen coin"},
            {"king", "王", "俺は海賊王になる/Ich werde der Piratenkönig sein/I will be the pirate king"},
            {"sound", "音", "音が聞こえる/Ich kann ein Geräusch hören/I can hear a sound"},
            {"below", "下", "下着/Unterwäsche/Underwear"},
            {"fire", "火", "火炎放射/Unterwäsche/Underwear"},
            {"flower", "花", "花が咲く/Blumen blühen/flowers bloom"},
            {"seashell", "貝", "貝を拾う/Nehmen Sie Schalentiere mit/flowers bloom"},
            {"study", "子", "栄養について学ぶ/Erfahren Sie über Ernährung/Learn about nutrition"},
            {"mind", "気", "気の迷い/das Zögern/Hesitation"},
            {"nine", "九", "九十九歳/neunundneunzig Jahre alt/ninety nine years old"},
            {"rest", "休", "休みを取る/machen sie eine pause/Take a break"},
            {"jewelry", "球", "宝石を買う/Schmuck kaufen/Buy jewelry"},
            {"gold", "金", "金塊を発掘した/Ausgegrabene Goldnuggets/Excavated gold nuggets"},
            {"sky", "空", "空に風船が浮かぶ/Luftballons schweben in den Himmel/Balloons floating in the sky"},
            {"moon", "月", "夜空に浮かぶ月/Mond, der in den nächtlichen Himmel schwimmt/Moon floating in the night sky"},
            {"dog", "犬", "犬とハンター/Hund und Jäger/dog and hunter"},
            {"see", "見", "望遠鏡で遠くを見る/Schauen Sie mit einem Teleskop weit weg/Look far away with a telescope"},
            {"five", "六", "五番目のボール/Fünfter Ball/Fifth ball"},
            {"mouth", "口", "大きく口を開ける/Mund weit öffnen/Open mouth widely"},
            {"school", "校", "学校に通う/zur Schule gehen/go to school"},
            {"left", "左", "左方向へ向かう/Gehe nach links/Head left"},
            {"three", "三", "三人の女性/Drei Frauen/Three women"},
            {"mountain", "山", "山を見下ろす/Blick auf die Berge/Mountain view"},
            {"kid", "子", "子供が遊んでいる/Kind spielt/Child is playing"},
            {"four", "四", "サイコロの四/Vier von Würfel/Four of dice"},
            {"thread", "糸", "巻かれた糸/Gewickelter Faden/Wound thread"},
            {"character", "字", "活字版/der Buchdruck/Letterpress"},
            {"ear", "耳", "耳を検査する/Untersuche das Ohr/Examining the ear"},
            {"seven", "七", "七転び八起き/Nach einem Sturz immer aufstehen/Always rising after a fall"},
            {"car", "車", "車を運転する/ein Auto fahren/Drive a car"},
            {"hand", "手", "手をつなぐ/Händchen halten/Hold hands"},
            {"ten", "十", "十ユーロ札/Zehn Euro/Ten EURO"},
            {"exit", "出", "出口はここです/Ausgang ist hier/Exit is here"},
            {"woman", "女", "スカーフを被った女性/Frau trägt einen Schal/Woman wearing a scarf"},
            {"little", "小", "小鳥/der kleiner Vogel/Little Bird"},
            {"above", "上", "上空に航空機が飛んでいる/Ein Flugzeug fliegt über den Himmel/An airplane is flying over the sky"},
            {"forest", "森", "森の空気を吸う/Atme die Luft des Waldes/Breathe the air of the forest"}
    };

    // Finish array
    String[][] Finish = {
        {
                    "finish",
                    "終", "了", "。"
        }
    };

    // Initial setting
    String[][] Kanjis = KanjisG1_2;
    int AnswerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Declarations.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView KanjiAnswerButtonLeft   = (ImageView) findViewById(R.id.KanjiAnswerButtonLeft);
        final ImageView KanjiAnswerButtonMiddle = (ImageView) findViewById(R.id.KanjiAnswerButtonMiddle);
        final ImageView KanjiAnswerButtonRight  = (ImageView) findViewById(R.id.KanjiAnswerButtonRight);
        final ImageView LeftKanjiBack           = (ImageView) findViewById(R.id.LeftKanjiBack);
        final ImageView MiddleKanjiBack         = (ImageView) findViewById(R.id.MiddleKanjiBack);
        final ImageView RightKanjiBack          = (ImageView) findViewById(R.id.RightKanjiBack);
        final ImageView NextButton              = (ImageView) findViewById(R.id.NextButton);
        final ImageView image                   = (ImageView) findViewById(R.id.kanjiWindow);
        final TextView  ReftKanji               = (TextView)  findViewById(R.id.LeftKanjiText);
        final TextView  MiddleKanji             = (TextView)  findViewById(R.id.MiddleKanjiText);
        final TextView  RightKanji              = (TextView)  findViewById(R.id.RightKanjiText);
        final TextView  ExampleKanji            = (TextView)  findViewById(R.id.Answer);
        // final EditText  QuestionsText           = (EditText)  findViewById(R.id.Questions);
        final EditText  CorrectAnswersText      = (EditText)  findViewById(R.id.CorrectAnswers);

        // If user click the one of the Kanji, set visible to Next button/answer.
        // If user select correct Kanji, add score. And lock the number
        // until user click the next button.
        int RightPosition  = 1;
        int MiddlePosition = 2;
        int LeftPosition   = 3;

            KanjiAnswerButtonLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NextButton.setVisibility(View.VISIBLE);
                    ExampleKanji.setVisibility(View.VISIBLE);
                    LeftKanjiBack.setVisibility(View.VISIBLE);
                    MiddleKanjiBack.setVisibility(View.VISIBLE);
                    RightKanjiBack.setVisibility(View.VISIBLE);
                    // If this selection is correct added up score.
                    if(!LockNumberCount) {
                        if (AnswerPosition == LeftPosition){
                            CorrectAnswers = CorrectAnswers + 1;
                        }
                   }
                    LockNumberCount = true;
                    // Remove Array elements to prevent duplication
                    Kanjis = ArrayUtils.remove(Kanjis, RandomNumber);
                }
            });
            KanjiAnswerButtonMiddle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NextButton.setVisibility(View.VISIBLE);
                    ExampleKanji.setVisibility(View.VISIBLE);
                    LeftKanjiBack.setVisibility(View.VISIBLE);
                    MiddleKanjiBack.setVisibility(View.VISIBLE);
                    RightKanjiBack.setVisibility(View.VISIBLE);
                    // If this selection is correct added up score.
                    if(!LockNumberCount) {
                          if (AnswerPosition == MiddlePosition){
                             CorrectAnswers = CorrectAnswers + 1;
                        }
                    }
                    LockNumberCount = true;
                    // Remove Array elements to prevent duplication
                    Kanjis = ArrayUtils.remove(Kanjis, RandomNumber);
                }
            });
            KanjiAnswerButtonRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NextButton.setVisibility(View.VISIBLE);
                    ExampleKanji.setVisibility(View.VISIBLE);
                    LeftKanjiBack.setVisibility(View.VISIBLE);
                    MiddleKanjiBack.setVisibility(View.VISIBLE);
                    RightKanjiBack.setVisibility(View.VISIBLE);
                    // If this selection is correct added up score.
                    if(!LockNumberCount) {
                        if (AnswerPosition == RightPosition){
                            CorrectAnswers = CorrectAnswers + 1;
                        }
                    }
                    LockNumberCount = true;
                    // Remove Array elements to prevent duplication
                    Kanjis = ArrayUtils.remove(Kanjis, RandomNumber);
                }
            });

        // On click event. If user clicked next button, then change kanji image.
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If reach the end
                if(Kanjis.length > 3){
                    // Generate random number
                    Random ran = new Random();
                    RandomNumber = ran.nextInt(Kanjis.length - 0);
                }else{
                    RandomNumber = 0;
                    Kanjis = Finish;
                }
                // To change images. First get resources, then apply it to specified drawable object.
                Context context = getApplicationContext();
                int id = context.getResources().getIdentifier(Kanjis[RandomNumber][0] , "drawable", getPackageName());
                image.setImageResource(id);

                // To change text dynamically, use setText method.
                String CorrectKanji = Kanjis[RandomNumber][1];
                String WrongKanji;
                String WrongKanji2;
                if(RandomNumber < Kanjis.length - 2 ){
                    WrongKanji   = Kanjis[RandomNumber + 1][1];
                    WrongKanji2  = Kanjis[RandomNumber + 2][1];
                }else if(Kanjis.length < 3){
                    WrongKanji   = null;
                    WrongKanji2  = null;
                }else{
                    WrongKanji   = Kanjis[RandomNumber - 1][1];
                    WrongKanji2  = Kanjis[RandomNumber - 2][1];
                }

                Random ran = new Random();
                int ChoicePosition = ran.nextInt(3 - 0);
                Drawable LeftImage   = null;
                Drawable MiddleImage = null;
                Drawable RightImage  = null;
                Resources res = getResources();

                switch (ChoicePosition){
                    case 0:
                        ReftKanji.setText(CorrectKanji);
                        MiddleKanji.setText(WrongKanji);
                        RightKanji.setText(WrongKanji2);
                        LeftImage      = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                        MiddleImage    = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        RightImage     = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        AnswerPosition = 3;
                        break;
                    case 1:
                        ReftKanji.setText(WrongKanji);
                        MiddleKanji.setText(CorrectKanji);
                        RightKanji.setText(WrongKanji2);
                        LeftImage   = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                        RightImage  = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        AnswerPosition = 2;
                        break;
                    case 2:
                        ReftKanji.setText(WrongKanji2);
                        MiddleKanji.setText(WrongKanji);
                        RightKanji.setText(CorrectKanji);
                        LeftImage   = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        RightImage  = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                        AnswerPosition = 1;
                        break;
                    default:
                        break;
                }
                ExampleKanji.setText(Kanjis[RandomNumber][2]);

                // Set image to show Wrong or Not
                LeftKanjiBack.setImageDrawable(LeftImage);
                MiddleKanjiBack.setImageDrawable(MiddleImage);
                RightKanjiBack.setImageDrawable(RightImage);

                // Set invisible for Answer/Next button.
                NextButton.setVisibility(View.INVISIBLE);
                ExampleKanji.setVisibility(View.INVISIBLE);
                LeftKanjiBack.setVisibility(View.INVISIBLE);
                MiddleKanjiBack.setVisibility(View.INVISIBLE);
                RightKanjiBack.setVisibility(View.INVISIBLE);

                // Set texts
                //CorrectAnswersText.setText(String.valueOf(CorrectAnswers).concat(" CorrectAnswers"));
                //QuestionsText.setText(String.valueOf(CorrectAnswers).concat(" CorrectAnswers/").concat(String.valueOf(Questions).concat(" Questions")));
                CorrectAnswersText.setText(String.valueOf(CorrectAnswers).concat("/").concat(String.valueOf(Questions)));

                // Count up number of questions
                Questions = Questions + 1;

                // Unlock number count
                LockNumberCount = false;

            }
        });
    }
}