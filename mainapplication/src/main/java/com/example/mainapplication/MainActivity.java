package com.example.mainapplication;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;

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

    //TODO: Put 2,000 Kanji
    //TODO: Difficulty selection
    //TODO: Review example sentence. If sentence is related to picture it helps to remember.
    //FUTURE: Change language function -> Make different application because it will break the layout

    ConstraintLayout constraintLayout;
    int        Questions        = 0;
    int        CorrectAnswers   = 0;
    int        RandomNumber     = 0;
    boolean    LockNumberCount  = false;

    // Multi dimensional array
    // G1 = FirstGrade
    // TODO: Add German/English word from G2
    String[][] KanjisG1_2 = {
            {
                "person",
                "人", "日", "一",
                "Right", "Wrong", "Wrong",
                "人々が団結する/Menschen vereinen sich/People unite",
                "Person", "Sun", "One",
                "die Person", "Die Sonne", "eine"
            },
            {
                "water",
                "火", "水", "氷",
                "Wrong", "Right", "Wrong",
                "水滴が波紋を生む/Tröpfchen erzeugen Wellen/Droplets create ripples",
                "Fire", "Water", "Ice",
                "das Feuer", "das Wasser", "das Eis"
            },
            {
                "justice",
                "生", "征", "正",
                "Wrong", "Wrong", "Right",
                "正義の名の下に/Im Namen der Gerechtigkeit/In the name of justice",
                "Life", "Conquest", "Justice",
                "das Leben", "die Eroberung", "die Gerechtigkeit"
            },
            {
                    "life",
                    "生", "征", "正",
                    "Right", "Wrong", "Wrong",
                    "子供が生まれる/Ein Kind wird geboren/A child is born",
                    "Life", "Conquest", "Justice",
                    "das Leben", "die Eroberung", "die Gerechtigkeit"
            },
            {
                    "six",
                    "六", "七", "五",
                    "Right", "Wrong", "Wrong",
                    "さいころの六/Sechsseitigen Würfeln möglich/Six of dice",
                    "Six", "Seven", "Five",
                    "sechs", "Sieben", "fünf"
            },
            {
                    "grove",
                    "本", "休", "林",
                    "Wrong", "Wrong", "Right",
                    "木々が群生して林になる/Bäume wachsen zu Handschuhen/Trees grow into grove",
                    "Book", "Rest", "Grove",
                    "das Buch", "der Rest", "der Hain"
            },
            {
                    "power",
                    "仂", "力", "刀",
                    "Wrong", "Right", "Wrong",
                    "供給電力/Mit Strom versorgen/Supply power",
                    "Act", "Power", "Blade",
                    "die Handlung", "die Klinge"
            },
            {
                    "stand",
                    "立", "経", "絶",
                    "Right", "Wrong", "Wrong",
                    "ヨガのポーズで立つ/Stehen Sie in Yoga-Pose/Stand in yoga pose",
                    "Standing", "Passing", "Absolute",
                    "das Stehen", "das Bestehen", "das Absolute"
            },
            {
                    "eye",
                    "日", "貝", "目",
                    "Wrong", "Wrong", "Right",
                    "青い目/Blaue Augen/Blue eyes",
                    "Sun", "Shellfish", "Eye",
                    "die Sonne", "das Schaltier", "das Auge"
            },
            {
                    "name",
                    "代", "名", "前",
                    "Wrong", "Right", "Wrong",
                    "名義が書かれたカード/Karte mit Namen/Card with name",
                    "Generation", "Name", "Previous",
                    "die Generation", "der Name", "vorig"
            },
            {
                    "book",
                    "本", "木", "林",
                    "Right", "Wrong", "Wrong",
                    "本を散らかす/Bücher streuen/Scatter books",
                    "Book", "Tree", "Woods",
                    "das Buch", "der Baum", "der Wald"
            },
            {
                    "sentence",
                    "門", "竹", "文",
                    "Wrong", "Wrong", "Right",
                    "啓発文の書かれたコップ/Tasse mit Aufklärungssatz/Cup with enlightenment sentence",
                    "Gate", "Bamboo", "Sentence",
                    "das Tor", "der Bambus", "der Satz"
            },
            {
                    "hundred",
                    "千", "百", "万",
                    "Wrong", "Right", "Wrong",
                    "百パーセント保証/Hudred Prozent Garantie/Hudred percent guarantee",
                    "Thousand", "Hundred", "Ten thousand",
                    "Tausend", "Hundert", "Zehntausend"
            },
            {
                    "eight",
                    "八", "九", "七",
                    "Right", "Wrong", "Wrong",
                    "八番球/Acht Ball/Eighth ball",
                    "Eight", "Nine", "Seven",
                    "Acht", "Neun", "Sieben"
            },
            {
                    "white",
                    "赤", "黄", "白",
                    "Wrong", "Wrong", "Right",
                    "白鳥が泳ぐ/Schwäne schwimmen/Swans swim",
                    "Red", "Yellow", "White",
                    "rot", "Gelb", "das Weiß"
            },
            {
                    "year",
                    "齢", "年", "歳",
                    "Wrong", "Right", "Wrong",
                    "今年は東京オリンピック/Dieses Jahr sind die Olympischen Spiele in Tokio/This year is the Tokyo Olympics",
                    "Age", "Year", "Age",
                    "das Alter", "das Jahr", "das Alter"
            },
            {
                    "enter",
                    "入", "出", "居",
                    "Right", "Wrong", "Wrong",
                    "入口/der Eingang/Entrance",
                    "Entering", "Out", "Residence",
                    "eintreten", "aus", "die Residenz"
            },
            {
                    "enter",
                    "入", "出", "居",
                    "Right", "Wrong", "Wrong",
                    "入口/der Eingang/Entrance",
                    "Entering", "Out", "Residence",
                    "eintreten", "aus", "die Residenz"
            },
            {
                    "two",
                    "一", "三", "二",
                    "Wrong", "Wrong", "Right",
                    "二人の女性/Zwei Frauen/Two women",
                    "One", "Three", "Two",
                    "eine", "drei", "zwei"
            },
            {
                    "earth",
                    "知", "地", "血",
                    "Wrong", "Right", "Wrong",
                    "干ばつした地面/Dürre Boden/Drought ground",
                    "Knowledge", "Earth", "Blood",
                    "das Wissen", "die Erde", "das Blut"
            },
            {
                    "ricefield",
                    "田", "多", "十",
                    "Right", "Wrong", "Wrong",
                    "一面に広がる田畑/Felder breiteten sich aus/Fields spread all over",
                    "Rice field", "Many", "Ten",
                    "das Reisfeld", "Viele", "Zehn"
            },
            {
                    "heavens",
                    "地", "夫", "天",
                    "Wrong", "Wrong", "Right",
                    "天より遣われし犬天使/Hundeengel vom Himmel geschickt/Dog angel sent from heaven",
                    "Earth", "husband", "Heaven",
                    "die Erde", "der Ehemann", "der Himmel"
            },
            {
                    "town",
                    "坊", "町", "田",
                    "Wrong", "Right", "Wrong",
                    "町に夜が訪れる/Die Nacht kommt in die Stadt/Night comes to town",
                    "Boy", "Town", "Rice field",
                    "der Junge", "die Stadt", "das Reisfeld"
            },
            {
                    "insect",
                    "虫", "無", "蒸",
                    "Right", "Wrong", "Wrong",
                    "テントウムシ/Die Marienkäfer/Ladybird",
                    "Insect", "Naught", "Steaming",
                    "das Insekt", "das Nichts", "dampfen"
            },
            {
                    "middle",
                    "外", "大", "中",
                    "Wrong", "Wrong", "Right",
                    "ハートの真ん中/Mitten im Herzen/Middle of heart",
                    "Out", "Large", "Middle",
                    "aus", "groß", "die Mitte"
            },
            {
                    "bamboo",
                    "武", "竹", "丈",
                    "Wrong", "Right", "Wrong",
                    "聳え立つ竹/Hoch aufragender Bambus/Towering bamboo",
                    "Martial", "Bamboo", "length",
                    "kriegerisch", "der Bambus", "die Länge"
            },
            {
                    "man",
                    "男", "女", "両",
                    "Right", "Wrong", "Wrong",
                    "暗闇に佇む男/Mann steht in der Dunkelheit/Man standing in the dark",
                    "Man", "Woman", "Both",
                    "der Mann", "die Frau", "beide"
            },
            {
                    "large",
                    "中", "小", "大",
                    "Wrong", "Wrong", "Right",
                    "巨大クラゲ/die Riesenquallen/Giant jellyfish",
                    "Middle", "Small", "Large",
                    "die Mitte", "klein", "groß"
            },
            {
                    "village",
                    "街", "村", "町",
                    "Wrong", "Right", "Wrong",
                    "村に夕日が落ちる/Sonnenuntergang fällt in das Dorf/Sunset falls in the village",
                    "City", "Village", "Town",
                    "die Großstadt", "das Dorf", "die Stadt"
            },
            {
                    "leg",
                    "足", "芦", "是",
                    "Right", "Wrong", "Wrong",
                    "車から足だけ出す/Steig aus dem Auto/Get your feet out of the car",
                    "Foot", "Reed", "By all means",
                    "der Fuß", "das Schilf", "Auf jeden Fall"
            },
            {
                    "grass",
                    "早", "十", "草",
                    "Wrong", "Wrong", "Right",
                    "草原で読書/Lesen auf der Wiese/Reading on the meadow",
                    "Early", "Ten", "Grass",
                    "früh", "zehn", "das Gras"
            },
            {
                    "early",
                    "遅", "早", "速",
                    "Wrong", "Right", "Wrong",
                    "早朝/früher Morgen/Early morning",
                    "Slow", "Early", "Fast",
                    "langsam", "früh", "schnell"
            },
            {
                    "ahead",
                    "先", "後", "生",
                    "Right", "Wrong", "Wrong",
                    "この先には何が待っているのか/Was wartet noch?/What's waiting ahead",
                    "Ahead", "Back", "Life",
                    "voraus", "zurück", "das Leben"
            },
            {
                    "river",
                    "海", "空", "川",
                    "Wrong", "Wrong", "Right",
                    "川で魚を釣る/Fischen Sie im Fluss/Fish in the river",
                    "Sea", "Sky", "River",
                    "das Meer", "der Himmel", "der Fluss"
            },
            {
                    "thousand",
                    "百", "千", "億",
                    "Wrong", "Right", "Wrong",
                    "千ルーブル/Tausend Rubel/Thousand rubles",
                    "Hundred", "Thousand", "Hundred million",
                    "hundert", "Tausend", "hundert Millionen"
            },
            {
                    "red",
                    "赤", "青", "黄",
                    "Right", "Wrong", "Wrong",
                    "赤い薔薇/rote Rose/Red rose",
                    "Red", "Blue", "Yellow",
                    "rot", "Blau", "Gelb"
            },
            {
                    "evening",
                    "朝", "昼", "夕",
                    "Wrong", "Wrong", "Right",
                    "夕日を背に受ける/Der Sonnenuntergang dahinter/The sunset behind",
                    "Morning", "Afternoon", "Evening",
                    "Morgen", "Nachmittag", "Abend"
            },
            {
                    "blue",
                    "黄", "青", "赤",
                    "Wrong", "Right", "Wrong",
                    "青い目/Blaue Augen/Blue eyes",
                    "Yellow", "Blue", "Red",
                    "Gelb", "Blau", "rot"
            },
            {
                "sea",
                "海", "梅", "桜",
                "Right", "Wrong", "Wrong",
                "海で泳ぐ/Schwimmen Sie im Meer/Swim in the sea",
                "Sea", "Plum", "Cherry Blossoms",
                "Meer", "die Pflaume", "Die Kirschblüte",
            }
    };

    String[][] KanjisG1_1 = {
            {
                    "sun",
                    "目", "日", "楊",
                    "Wrong", "Right", "Wrong",
                    "日が昇る/Die Sonne geht auf/The sun rises",
                    "Eye", "Sun", "Yang",
                    "Das Augen", "Tag", "Yang"
            },
            {
                    "stone",
                    "砂", "磐", "石",
                    "Wrong", "Wrong", "Right",
                    "石が地面に落ちている/Stein liegt auf dem Boden/Stone is on the ground",
                    "Sand", "Rock", "Stone",
                    "Sand", "der Felsen", "der Stein"
            },
            {
                    "tree",
                    "木", "林", "森",
                    "Right", "Wrong", "Wrong",
                    " 木が見える/Ich kann die Bäume sehen/I can see the tree",
                    "Tree", "Woods", "Forest",
                    "der Bäume", "der Wald", "der Forst"
            },
            {
                    "right",
                    "左", "右", "上",
                    "Wrong", "Right", "Wrong",
                    "上下左右/Hoch, runter, links, rechts/Up, down, left, right",
                    "Left", "Right", "Up",
                    "Links", "Richtig", "Oben"
            },
            {
                    "one",
                    "三", "二", "一",
                    "Wrong", "Wrong", "Right",
                    "彼女が一番だ。/Sie ist die Beste/She is the best",
                    "Three", "Two", "One",
                    "Drei", "Zwei", "Eine"
            },
            {
                    "rain",
                    "雨", "雷", "雲",
                    "Right", "Wrong", "Wrong",
                    "雨が降っている。/Es regnet/It's raining",
                    "Rain", "Thunder", "Cloud",
                    "der Regen", "der Donner", "die Wolke"
            },
            {
                    "circle",
                    "園", "円", "九",
                    "Wrong", "Right", "Wrong",
                    "百円玉/Hundert-Yen-Münze/Hundred yen coin",
                    "Garden", "Circle", "Nine",
                    "Garten", "Kreis", "Neun"
            },
            {
                    "king",
                    "玉", "汪", "王",
                    "Wrong", "Wrong", "Right",
                    "俺は海賊王になる/Ich werde der Piratenkönig sein/I will be the pirate king",
                    "Ball", "Wang", "King",
                    "Ball", "Wang", "König"
            },
            {
                    "sound",
                    "音", "乙", "声",
                    "Right", "Wrong", "Wrong",
                    "音が聞こえる/Ich kann ein Geräusch hören/I can hear a sound",
                    "Sound", "Witty", "Voice",
                    "Klang", "Witzig", "Stimme"
            },
            {
                    "below",
                    "右", "下", "上",
                    "Wrong", "Right", "Wrong",
                    "下着/Unterwäsche/Underwear",
                    "Right", "Below", "Top",
                    "Recht", "Unten", "Oben"
            },
            {
                    "fire",
                    "人", "大", "火",
                    "Wrong", "Wrong", "Right",
                    "火炎放射/Unterwäsche/Underwear",
                    "People", "Big", "Fire",
                    "die Person", "Groß", "das Feuer"
            },
            {
                    "flower",
                    "花", "草", "鼻",
                    "Right", "Wrong", "Wrong",
                    "花が咲く/Blumen blühen/flowers bloom",
                    "Flower", "Grass", "Nose",
                    "die Blume", "Groß", "die Nase"
            },
            {
                    "seashell",
                    "介", "貝", "唄",
                    "Wrong", "Right", "Wrong",
                    "貝を拾う/Nehmen Sie Schalentiere mit/flowers bloom",
                    "Flower", "Grass", "Nose",
                    "die Blume", "Groß", "die Nase"
            },
            {
                    "study",
                    "木", "子", "学",
                    "Wrong", "Wrong", "Right",
                    "栄養について学ぶ/Erfahren Sie über Ernährung/Learn about nutrition",
                    "Tree", "Child", "Study",
                    "der Bäume", "das Kind", "das Lernen"
            },
            {
                    "mind",
                    "気", "来", "危",
                    "Right", "Wrong", "Wrong",
                    "気の迷い/das Zögern/Hesitation",
                    "Mind", "Come", "Danger",
                    "der Verstand", "Kommen", "die Gefahr"
            },
            {
                    "nine",
                    "八", "九", "七",
                    "Wrong", "Right", "Wrong",
                    "九十九歳/neunundneunzig Jahre alt/ninety nine years old",
                    "Eight", "Nine", "Seven",
                    "Acht", "Neun", "Sieben"
            },
            {
                    "rest",
                    "本", "安", "休",
                    "Wrong", "Wrong", "Right",
                    "休みを取る/machen sie eine pause/Take a break",
                    "Book", "Cheap", "Rest",
                    "das Buch", "billig", "der Rest"
            },
            {
                    "jewelry",
                    "玉", "球", "王",
                    "Right", "Wrong", "Wrong",
                    "宝石を買う/Schmuck kaufen/Buy jewelry",
                    "jewelry", "Ball", "King",
                    "der Schmuck", "der Ball", "König"
            },
            {
                    "gold",
                    "銀", "金", "銅",
                    "Wrong", "Right", "Wrong",
                    "金塊を発掘した/Ausgegrabene Goldnuggets/Excavated gold nuggets",
                    "Silver", "Gold", "Bronze",
                    "das Silber", "das Gold", "die Bronze"
            },
            {
                    "sky",
                    "海", "容", "空",
                    "Wrong", "Wrong", "Right",
                    "空に風船が浮かぶ/Luftballons schweben in den Himmel/Balloons floating in the sky",
                    "Sea", "Content", "Sky",
                    "das Meer", "der Inhalt", "der Himmel"
            },
            {
                    "moon",
                    "月", "日", "腹",
                    "Right", "Wrong", "Wrong",
                    "夜空に浮かぶ月/Mond, der in den nächtlichen Himmel schwimmt/Moon floating in the night sky",
                    "Moon", "Sun", "Stomach",
                    "der Mond", "die Sonne", "der Magen"
            },
            {
                    "dog",
                    "大", "犬", "太",
                    "Wrong", "Right", "Wrong",
                    "犬とハンター/Hund und Jäger/dog and hunter",
                    "Big", "Dog", "Thick",
                    "groß", "der Hund", "dick"
            },
            {
                    "see",
                    "芽", "赤", "見",
                    "Wrong", "Wrong", "Right",
                    "望遠鏡で遠くを見る/Schauen Sie mit einem Teleskop weit weg/Look far away with a telescope",
                    "Sprout", "Red", "See",
                    "sprießen", "rot", "Schauen"
            },
            {
                    "five",
                    "五", "六", "四",
                    "Right", "Wrong", "Wrong",
                    "五番目のボール/Fünfter Ball/Fifth ball",
                    "Five", "Six", "Four",
                    "fünf", "sechs", "vier"
            },
            {
                    "mouth",
                    "田", "貝", "口",
                    "Wrong", "Wrong", "Right",
                    "大きく口を開ける/Mund weit öffnen/Open mouth widely",
                    "Rice field", "Shellfish", "Mouth",
                    "Reisfeld", "Schaltier", "Mund"
            },
            {
                    "school",
                    "校", "交", "公",
                    "Right", "Wrong", "Wrong",
                    "学校に通う/zur Schule gehen/go to school",
                    "School", "Exchange", "Public",
                    "die Schule", "der Austausch", "die Öffentlichkeit"
            },
            {
                    "left",
                    "右", "左", "上",
                    "Wrong", "Right", "Wrong",
                    "左方向へ向かう/Gehe nach links/Head left",
                    "Right", "Left", "Up",
                    "rechts", "links", "oben"
            },
            {
                    "three",
                    "一", "二", "三",
                    "Wrong", "Wrong", "Right",
                    "三人の女性/Drei Frauen/Three women",
                    "One", "Two", "Three",
                    "Eine", "Zwei", "Drei"
            },
            {
                    "mountain",
                    "山", "川", "馬",
                    "Right", "Wrong", "Wrong",
                    "山を見下ろす/Blick auf die Berge/Mountain view",
                    "Mountain", "River", "Horse",
                    "der Berg", "der Fluss", "das Pferd"
            },
            {
                    "kid",
                    "成", "子", "大",
                    "Wrong", "Right", "Wrong",
                    "子供が遊んでいる/Kind spielt/Child is playing",
                    "Success", "Kid", "Big",
                    "der Erfolg", "das Kind", "groß"
            },
            {
                    "four",
                    "五", "六", "四",
                    "Wrong", "Wrong", "Right",
                    "サイコロの四/Vier von Würfel/Four of dice",
                    "Five", "Six", "Four",
                    "fünf", "sechs", "vier"
            },
            {
                    "thread",
                    "糸", "衣", "絃",
                    "Right", "Wrong", "Wrong",
                    "巻かれた糸/Gewickelter Faden/Wound thread",
                    "Thread", "Clothing", "String",
                    "das Gewinde", "die Kleidung", "die schnur"
            },
            {
                    "character",
                    "地", "字", "時",
                    "Wrong", "Right", "Wrong",
                    "活字版/der Buchdruck/Letterpress",
                    "Earth", "Character", "Time",
                    "die Erde", "der Charakter", "Die Zeit"
            },
            {
                    "ear",
                    "目", "見", "耳",
                    "Wrong", "Wrong", "Right",
                    "耳を検査する/Untersuche das Ohr/Examining the ear",
                    "Eye", "See", "Ear",
                    "das Auge", "sehen", "das Ohr"
            },
            {
                    "seven",
                    "七", "六", "八",
                    "Right", "Wrong", "Wrong",
                    "七転び八起き/Nach einem Sturz immer aufstehen/Always rising after a fall",
                    "Seven", "Six", "Eight",
                    "sieben", "sechs", "acht"
            },
            {
                    "car",
                    "来", "車", "田",
                    "Wrong", "Right", "Wrong",
                    "車を運転する/ein Auto fahren/Drive a car",
                    "Coming", "Car", "Rice field",
                    "das Kommen", "das Auto", "Reisfeld"
            },
            {
                    "hand",
                    "平", "千", "手",
                    "Wrong", "Wrong", "Right",
                    "手をつなぐ/Händchen halten/Hold hands",
                    "Flat", "Thousand", "Hand",
                    "Eben", "Tausend",  "die Hand"
            },
            {
                    "ten",
                    "十", "銃", "九",
                    "Right", "Wrong", "Wrong",
                    "十ユーロ札/Zehn Euro/Ten EURO",
                    "Flat", "Thousand", "Hand",
                    "Eben", "Tausend",  "die Hand"
            },
            {
                    "exit",
                    "口", "出", "山",
                    "Wrong", "Right", "Wrong",
                    "出口はここです/Ausgang ist hier/Exit is here",
                    "Mouth", "Out", "Mountain",
                    "der Mund", "aus",  "der Berg"
            },
            {
                    "woman",
                    "乙", "男", "女",
                    "Wrong", "Wrong", "Right",
                    "スカーフを被った女性/Frau trägt einen Schal/Woman wearing a scarf",
                    "Witty", "Man", "Woman",
                    "witzig", "der Mann", "die Frau"
            },
            {
                    "little",
                    "小", "大", "中",
                    "Right", "Wrong", "Wrong",
                    "小鳥/der kleiner Vogel/Little Bird",
                    "Little", "Big", "Middle",
                    "klein", "groß", "die Mitte"
            },
            {
                    "above",
                    "下", "上", "中",
                    "Wrong", "Right", "Wrong",
                    "上空に航空機が飛んでいる/Ein Flugzeug fliegt über den Himmel/An airplane is flying over the sky",
                    "Under", "Above", "Middle",
                    "unter", "über", "die Mitte"
            },
            {
                    "forest",
                    "守", "盛", "森",
                    "Wrong", "Wrong", "Right",
                    "森の空気を吸う/Atme die Luft des Waldes/Breathe the air of the forest",
                    "Protect", "Assortment", "Forest",
                    "Schützen", "das Sortiment", "der Wald"
            }
    };

    // Finish array
    String[][] Finish = {
        {
                    "finish",
                    "終", "了", "。",
                    "Right", "Right", "Right",
                    "これで終了です。",
                    "", "", "",
                    "", "", ""
        }
    };

    // Initial setting
    String[][] Kanjis = KanjisG1_1;

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
                        if (Kanjis[RandomNumber][4].equals("Right")) {
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
                        if (Kanjis[RandomNumber][5].equals("Right")) {
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
                        if (Kanjis[RandomNumber][6].equals("Right")) {
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
                if(Kanjis.length != 0){
                    // Generate random number
                    Random ran = new Random();
                    RandomNumber = ran.nextInt(Kanjis.length - 0);
                }else{
                    RandomNumber = 0;
                    Kanjis = Finish;
                }

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
                    case "sound":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.sound, null);
                        break;
                    case "below":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.below, null);
                        break;
                    case "flower":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.flower, null);
                        break;
                    case "fire":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.fire, null);
                        break;
                    case "seashell":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.seashell, null);
                        break;
                    case "study":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.study, null);
                        break;
                    case "mind":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.mind, null);
                        break;
                    case "nine":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.nine, null);
                        break;
                    case "jewelry":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.jewelry, null);
                        break;
                    case "gold":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.gold, null);
                        break;
                    case "sky":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.sky, null);
                        break;
                    case "moon":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.moon, null);
                        break;
                    case "dog":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.dog, null);
                        break;
                    case "see":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.see, null);
                        break;
                    case "five":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.five, null);
                        break;
                    case "mouth":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.mouth, null);
                        break;
                    case "rest":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.rest, null);
                        break;
                    case "school":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.school, null);
                        break;
                    case "left":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.left, null);
                        break;
                    case "thread":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.thread, null);
                        break;
                    case "four":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.four, null);
                        break;
                    case "kid":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.kid, null);
                        break;
                    case "finish":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.finish, null);
                        break;
                    case "mountain":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.mountain, null);
                        break;
                    case "three":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.three, null);
                        break;
                    case "character":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.character, null);
                        break;
                    case "seven":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.seven, null);
                        break;
                    case "car":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.car, null);
                        break;
                    case "hand":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.hand, null);
                        break;
                    case "ten":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.ten, null);
                        break;
                    case "exit":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.exit, null);
                        break;
                    case "woman":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.woman, null);
                        break;
                    case "little":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.little, null);
                        break;
                    case "above":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.above, null);
                        break;
                    case "forest":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.forest, null);
                        break;
                    case "ear":
                        // code block
                        myImage = ResourcesCompat.getDrawable(res, R.drawable.ear, null);
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