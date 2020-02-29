package com.KanjiFlash.mainapplication;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.content.res.Resources;
import android.widget.Spinner;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    //FUTURE: Show wrong list in the last.
    //FUTURE: Review example sentence. If sentence is related to picture it helps to remember.
    //FUTURE: Think about monetise.
    //FUTURE: Add German/English word from G2

    ConstraintLayout constraintLayout;
    int Questions = 0;
    int CorrectAnswers = 0;
    int RandomNumber = 0;
    int RandomNumber2 = 0;
    int RandomNumber3 = 0;
    int KanjisLength = 0;
    boolean LockNumberCount = false;
    private Spinner spinner1;


    // Multi dimensional array
    // G1 = FirstGrade
    // Each array contains 40-50 kanjis
    String[][] KanjisH15 = {
            {"worry", "愁", "example"},
            {"tower", "楼", "example"},
            {"firewood", "薪", "example"},
            {"brown", "褐", "example"},
            {"bestow", "賜", "example"},
            {"maintenance", "繕", "example"},
            {"plug", "栓", "example"},
            {"sunken", "凹", "example"},
            {"refining", "錬", "example"},
            {"eclectic", "衷", "example"},
            {"gradually", "逐", "example"},
            {"rejection", "斥", "example"},
            {"decree", "詔", "example"},
            {"night", "宵", "example"},
            {"delusion", "妄", "example"},
            {"discretionary", "酌", "example"},
            {"distribution", "頒", "example"},
            {"limb", "肢", "example"},
            {"transcript", "謄", "example"},
            {"heir", "嗣", "example"},
            {"furrow", "畝", "example"},
            {"copy", "抄", "example"},
            {"lazy", "惰", "example"},
            {"savagery", "蛮", "example"},
            {"one", "壱", "example"},
            {"weather", "侯", "example"},
            {"arc", "弧", "example"},
            {"attach", "附", "example"},
            {"but", "但", "example"},
            {"potato", "芋", "example"},
            {"hag", "婆", "example"},
            {"imitation", "倣", "example"},
            {"frugality", "倹", "example"},
            {"cocoon", "繭", "example"},
            {"audience", "謁", "example"},
            {"section", "箇", "example"},
            {"and", "且", "example"},
            {"loaf", "斤", "example"},
            {"trapped", "虞", "example"},
            {"cultivate", "墾", "example"},
            {"seal", "璽", "example"},
            {"spoon", "勺", "example"},
            {"lord", "爵", "example"},
            {"follow", "遵", "example"},
            {"weight", "錘", "example"},
            {"shiny_metal", "銑", "example"},
            {"mould", "塑", "example"},
            {"swell", "脹", "example"},
            {"i", "朕", "example"},
            {"smallpox", "痘", "example"},
            {"two", "弐", "example"},
            {"endow", "賦", "example"},
            {"third", "丙", "example"},
            {"consume", "耗", "example"},
            {"momme", "匁", "example"},
            {"excessive", "濫", "example"},
            {"official", "吏", "example"}
    };
    String[][] KanjisH14 = {
            {"lip", "唇", "example"},
            {"quiet", "閑", "example"},
            {"ghost", "幽", "example"},
            {"sergeant", "曹", "example"},
            {"chant", "詠", "example"},
            {"humble", "卑", "example"},
            {"insult", "侮", "example"},
            {"casting", "鋳", "example"},
            {"wipe", "抹", "example"},
            {"captain", "尉", "example"},
            {"scribe", "隷", "example"},
            {"slavery", "禍", "example"},
            {"dairy", "酪", "example"},
            {"stem", "茎", "example"},
            {"marshal", "帥", "example"},
            {"pass_away", "逝", "example"},
            {"hide", "匿", "example"},
            {"collar", "襟", "example"},
            {"firefly", "蛍", "example"},
            {"widow", "寡", "example"},
            {"dysentery", "痢", "example"},
            {"mediocre", "庸", "example"},
            {"pit", "坑", "example"},
            {"thief", "賊", "example"},
            {"squeezing", "搾", "example"},
            {"shore", "畔", "example"},
            {"hole", "孔", "example"},
            {"torture", "拷", "example"},
            {"young_lady", "嬢", "example"},
            {"valley", "渓", "example"},
            {"old_man", "翁", "example"},
            {"inexpensive", "廉", "example"},
            {"sincerely", "謹", "example"},
            {"kiln", "窯", "example"},
            {"praise", "褒", "example"},
            {"ugly", "醜", "example"},
            {"shou", "升", "example"},
            {"martyrdom", "殉", "example"},
            {"bother", "煩", "example"},
            {"impeach", "劾", "example"},
            {"fall", "堕", "example"},
            {"tax", "租", "example"},
            {"pier", "桟", "example"},
            {"son-in-law", "婿", "example"},
            {"adore", "慕", "example"},
            {"dismissal", "罷", "example"},
            {"straightening", "矯", "example"},
            {"certain", "某", "example"},
            {"prisoners", "囚", "example"},
            {"secrete", "泌", "example"},
            {"gradually", "漸", "example"},
            {"mosquito", "蚊", "example"},
            {"disaster", "厄", "example"},
            {"algae", "藻", "example"},
            {"legitimacy", "嫡", "example"},
            {"scare", "嚇", "example"},
            {"convex", "凸", "example"},
            {"rhyme", "韻", "example"},
            {"frost", "霜", "example"},
            {"nitrate", "硝", "example"},
            {"edict", "勅", "example"},
            {"coffin", "棺", "example"},
            {"confucianism", "儒", "example"}
    };

    String[][] KanjisH13 = {
            {"sulfur", "硫", "example"},
            {"amnesty", "赦", "example"},
            {"steal", "窃", "example"},
            {"bubble", "泡", "example"},
            {"also", "又", "example"},
            {"generous", "慨", "example"},
            {"spinning", "紡", "example"},
            {"hate", "恨", "example"},
            {"fat", "肪", "example"},
            {"help", "扶", "example"},
            {"play", "戯", "example"},
            {"avoid", "忌", "example"},
            {"turbidity", "濁", "example"},
            {"rush", "奔", "example"},
            {"ladle", "斗", "example"},
            {"fast", "迅", "example"},
            {"portrait", "肖", "example"},
            {"bowl", "鉢", "example"},
            {"rotten", "朽", "example"},
            {"shell", "殻", "example"},
            {"enjoy", "享", "example"},
            {"clan", "藩", "example"},
            {"matchmaker", "媒", "example"},
            {"chicken", "鶏", "example"},
            {"zen", "禅", "example"},
            {"entrust", "嘱", "example"},
            {"torso", "胴", "example"},
            {"send", "迭", "example"},
            {"insertion", "挿", "example"},
            {"accompany", "陪", "example"},
            {"dissect", "剖", "example"},
            {"genealogy", "譜", "example"},
            {"leisurely", "悠", "example"},
            {"virtue", "淑", "example"},
            {"sail", "帆", "example"},
            {"dawn", "暁", "example"},
            {"master", "傑", "example"},
            {"guy", "奴", "example"},
            {"tablets", "錠", "example"},
            {"transition", "遷", "example"},
            {"clumsy", "拙", "example"},
            {"warrior", "侍", "example"},
            {"pass", "峠", "example"},
            {"serious", "篤", "example"},
            {"thirst", "渇", "example"},
            {"uncle", "叔", "example"},
            {"female", "雌", "example"},
            {"worthy", "堪", "example"},
            {"order", "叙", "example"},
            {"vinegar", "酢", "example"},
            {"moan", "吟", "example"},
            {"gradually", "逓", "example"},
            {"very", "甚", "example"},
            {"worship", "崇", "example"},
            {"lacquer", "漆", "example"},
            {"cape", "岬", "example"},
            {"habit", "癖", "example"},
            {"enjoy", "愉", "example"},
            {"reef", "礁", "example"},
            {"cantonment", "屯", "example"},
            {"marriage", "姻", "example"},
            {"fake", "擬", "example"},
            {"fence", "塀", "example"}
    };

    String[][] KanjisH12 = {
            {"blind", "盲", "example"},
            {"chic", "粋", "example"},
            {"disgrace", "辱", "example"},
            {"jurisdiction", "轄", "example"},
            {"ape", "猿", "example"},
            {"string", "弦", "example"},
            {"smother", "窒", "example"},
            {"cooking", "炊", "example"},
            {"flood", "洪", "example"},
            {"intake", "摂", "example"},
            {"bored", "飽", "example"},
            {"redundant", "冗", "example"},
            {"peach", "桃", "example"},
            {"hunting", "狩", "example"},
            {"red", "朱", "example"},
            {"eddy", "渦", "example"},
            {"gentry", "紳", "example"},
            {"pivot", "枢", "example"},
            {"monument", "碑", "example"},
            {"forge", "鍛", "example"},
            {"drum", "鼓", "example"},
            {"bare", "裸", "example"},
            {"still", "猶", "example"},
            {"piece", "塊", "example"},
            {"spin", "旋", "example"},
            {"currency", "幣", "example"},
            {"membrane", "膜", "example"},
            {"fan", "扇", "example"},
            {"tank", "槽", "example"},
            {"kind", "慈", "example"},
            {"cut", "伐", "example"},
            {"clean", "漬", "example"},
            {"inquire", "糾", "example"},
            {"grave", "墳", "example"},
            {"tsubo", "坪", "example"},
            {"navy_blue", "紺", "example"},
            {"panic", "慌", "example"},
            {"entertainment", "娯", "example"},
            {"luo", "羅", "example"},
            {"gorge", "峡", "example"},
            {"salary", "俸", "example"},
            {"centimeter", "厘", "example"},
            {"peak", "峰", "example"},
            {"brewing", "醸", "example"},
            {"funeral", "弔", "example"},
            {"witty", "乙", "example"},
            {"juice", "汁", "example"},
            {"nun", "尼", "example"},
            {"pilgrimage", "遍", "example"},
            {"equilibrium", "衡", "example"},
            {"fragrant", "薫", "example"},
            {"hunting", "猟", "example"},
            {"subsection", "款", "example"},
            {"review", "閲", "example"},
            {"detect", "偵", "example"},
            {"exclamation", "喝", "example"},
            {"dare", "敢", "example"},
            {"womb", "胎", "example"},
            {"yeast", "酵", "example"},
            {"anger", "憤", "example"},
            {"pig", "豚", "example"},
            {"cover", "遮", "example"},
            {"door", "扉", "example"}
    };

    String[][] KanjisH11 = {
            {"idiot", "痴", "example"},
            {"carrying", "搬", "example"},
            {"healing", "癒", "example"},
            {"outer_fence", "郭", "example"},
            {"pee", "尿", "example"},
            {"fierce", "凶", "example"},
            {"threw_up", "吐", "example"},
            {"feast", "宴", "example"},
            {"guest", "賓", "example"},
            {"captive", "虜", "example"},
            {"pottery", "陶", "example"},
            {"bell", "鐘", "example"},
            {"regret", "憾", "example"},
            {"descendant", "昆", "example"},
            {"crude", "粗", "example"},
            {"revision", "訂", "example"},
            {"umbrella", "傘", "example"},
            {"ride", "騎", "example"},
            {"rather", "寧", "example"},
            {"follow", "循", "example"},
            {"endure", "忍", "example"},
            {"lazy", "怠", "example"},
            {"such_as", "如", "example"},
            {"dorm", "寮", "example"},
            {"lead", "鉛", "example"},
            {"beads", "珠", "example"},
            {"condense", "凝", "example"},
            {"seedling", "苗", "example"},
            {"beast", "獣", "example"},
            {"sorrow", "哀", "example"},
            {"jump", "跳", "example"},
            {"artisan", "匠", "example"},
            {"snake", "蛇", "example"},
            {"clear", "澄", "example"},
            {"seam", "縫", "example"},
            {"monk", "僧", "example"},
            {"overlook", "眺", "example"},
            {"sudden", "唐", "example"},
            {"kure", "呉", "example"},
            {"mediocrity", "凡", "example"},
            {"rest", "憩", "example"},
            {"ditch", "溝", "example"},
            {"respect", "恭", "example"},
            {"mow", "刈", "example"},
            {"sleep", "睡", "example"},
            {"confusion", "錯", "example"},
            {"earl", "伯", "example"},
            {"mausoleum", "陵", "example"},
            {"fog", "霧", "example"},
            {"soul", "魂", "example"},
            {"disadvantage", "弊", "example"},
            {"princess", "妃", "example"},
            {"ship", "舶", "example"},
            {"hungry", "餓", "example"},
            {"poor", "窮", "example"},
            {"palm", "掌", "example"},
            {"korea", "麗", "example"},
            {"smelly", "臭", "example"},
            {"pleased", "悦", "example"},
            {"blade", "刃", "example"},
            {"bind", "縛", "example"},
            {"calendar", "暦", "example"},
            {"suitability", "宜", "example"}
    };

    String[][] KanjisH10 = {
            {"fantasy", "幻", "example"},
            {"boil", "煮", "example"},
            {"princess", "姫", "example"},
            {"oath", "誓", "example"},
            {"grasp", "把", "example"},
            {"practice", "践", "example"},
            {"present", "呈", "example"},
            {"sparse", "疎", "example"},
            {"supine", "仰", "example"},
            {"strong", "剛", "example"},
            {"disease", "疾", "example"},
            {"conquest", "征", "example"},
            {"smashing", "砕", "example"},
            {"song", "謡", "example"},
            {"bride", "嫁", "example"},
            {"modest", "謙", "example"},
            {"call", "伺", "example"},
            {"grief", "嘆", "example"},
            {"bacteria", "菌", "example"},
            {"frequency", "頻", "example"},
            {"japanese_harp", "琴", "example"},
            {"shelf", "棚", "example"},
            {"terrible", "酷", "example"},
            {"governor", "宰", "example"},
            {"corridor", "廊", "example"},
            {"lonely", "寂", "example"},
            {"bow", "伏", "example"},
            {"go", "碁", "example"},
            {"vulgar", "俗", "example"},
            {"desert", "漠", "example"},
            {"evil", "邪", "example"},
            {"crystal", "晶", "example"},
            {"ink", "墨", "example"},
            {"suppression", "鎮", "example"},
            {"hole", "洞", "example"},
            {"shoe", "履", "example"},
            {"inferior", "劣", "example"},
            {"beat", "殴", "example"},
            {"pregnant", "娠", "example"},
            {"enshrine", "奉", "example"},
            {"worry", "憂", "example"},
            {"docile", "朴", "example"},
            {"pavilion", "亭", "example"},
            {"strange", "怪", "example"},
            {"drunk", "酔", "example"},
            {"pity", "惜", "example"},
            {"gain", "穫", "example"},
            {"good", "佳", "example"},
            {"moisturize", "潤", "example"},
            {"mourn", "悼", "example"},
            {"lack", "乏", "example"},
            {"corresponding", "該", "example"},
            {"go", "赴", "example"},
            {"mulberry", "桑", "example"},
            {"pith", "髄", "example"},
            {"pots", "盆", "example"},
            {"ear", "穂", "example"},
            {"strong", "壮", "example"},
            {"embankment", "堤", "example"},
            {"hungry", "飢", "example"},
            {"pong", "傍", "example"},
            {"plague", "疫", "example"},
            {"cumulative", "累", "example"}
    };
    String[][] KanjisH9 = {
            {"void_", "虚", "example"},
            {"soul", "霊", "example"},
            {"regret", "悔", "example"},
            {"decree", "諭", "example"},
            {"awful", "惨", "example"},
            {"ppressive", "虐", "example"},
            {"turn", "翻", "example"},
            {"fall", "墜", "example"},
            {"swamp", "沼", "example"},
            {"set", "据", "example"},
            {"gradually", "徐", "example"},
            {"tower", "搭", "example"},
            {"shield", "盾", "example"},
            {"waterfall", "滝", "example"},
            {"rail", "軌", "example"},
            {"hinder", "妨", "example"},
            {"rub", "擦", "example"},
            {"whale", "鯨", "example"},
            {"mansion", "荘", "example"},
            {"promise", "諾", "example"},
            {"thunder", "雷", "example"},
            {"drift", "漂", "example"},
            {"bosom", "懐", "example"},
            {"intuition", "勘", "example"},
            {"plant", "栽", "example"},
            {"abduction", "拐", "example"},
            {"uselessly", "駄", "example"},
            {"add", "添", "example"},
            {"crown", "冠", "example"},
            {"oblique", "斜", "example"},
            {"wave", "浪", "example"},
            {"second_place", "亜", "example"},
            {"fraud", "詐", "example"},
            {"altar", "壇", "example"},
            {"medal", "勲", "example"},
            {"magic", "魔", "example"},
            {"reward", "酬", "example"},
            {"purple", "紫", "example"},
            {"crest", "紋", "example"},
            {"wholesale", "卸", "example"},
            {"column", "欄", "example"},
            {"deviate", "逸", "example"},
            {"lifetime", "涯", "example"},
            {"develop", "拓", "example"},
            {"prison", "獄", "example"},
            {"yet", "尚", "example"},
            {"carved", "彫", "example"},
            {"calm", "穏", "example"},
            {"remarkable", "顕", "example"},
            {"skillful", "巧", "example"},
            {"spear", "矛", "example"},
            {"wall", "垣", "example"},
            {"deceive", "欺", "example"},
            {"fish", "釣", "example"},
            {"makeup", "粧", "example"},
            {"suppression", "粛", "example"},
            {"stupid", "愚", "example"},
            {"encounter", "遭", "example"},
            {"frame", "架", "example"},
            {"ghost", "鬼", "example"},
            {"common", "庶", "example"},
            {"baby", "稚", "example"},
            {"nourish", "滋", "example"}
    };

    String[][] KanjisH8 = {
            {"mood", "雰", "example"},
            {"encounter", "遇", "example"},
            {"advisory", "諮", "example"},
            {"narrow", "狭", "example"},
            {"table", "卓", "example"},
            {"grain", "糧", "example"},
            {"book", "簿", "example"},
            {"furnace", "炉", "example"},
            {"special", "殊", "example"},
            {"colonization", "殖", "example"},
            {"warship", "艦", "example"},
            {"fellow", "輩", "example"},
            {"odd", "奇", "example"},
            {"pride", "慢", "example"},
            {"plot", "謀", "example"},
            {"beat", "拍", "example"},
            {"length", "丈", "example"},
            {"relax", "寛", "example"},
            {"cover", "覆", "example"},
            {"cell", "胞", "example"},
            {"partition", "隔", "example"},
            {"purification", "浄", "example"},
            {"discard", "没", "example"},
            {"free_time", "暇", "example"},
            {"chastity", "貞", "example"},
            {"view", "鑑", "example"},
            {"shadow", "陰", "example"},
            {"drop", "滴", "example"},
            {"inscription", "銘", "example"},
            {"follow", "随", "example"},
            {"intense", "烈", "example"},
            {"searching", "尋", "example"},
            {"draft", "稿", "example"},
            {"red", "丹", "example"},
            {"revelation", "啓", "example"},
            {"hill", "丘", "example"},
            {"building", "棟", "example"},
            {"soil", "壌", "example"},
            {"comic", "漫", "example"},
            {"expert", "玄", "example"},
            {"stick", "粘", "example"},
            {"realize", "悟", "example"},
            {"shop", "舗", "example"},
            {"pregnant", "妊", "example"},
            {"rise", "騰", "example"},
            {"finally_", "遂", "example"},
            {"mad", "狂", "example"},
            {"crossroads", "岐", "example"},
            {"latitude", "緯", "example"},
            {"culture", "培", "example"},
            {"decline", "衰", "example"},
            {"boat", "艇", "example"},
            {"bend", "屈", "example"},
            {"pale", "淡", "example"},
            {"abstract_", "抽", "example"},
            {"show", "披", "example"},
            {"court", "廷", "example"},
            {"associate", "准", "example"},
            {"recommendation", "奨", "example"},
            {"soak", "浸", "example"},
            {"surplus", "剰", "example"},
            {"gall", "胆", "example"},
            {"fiber", "繊", "example"}
    };

    String[][] KanjisH7 = {
            {"rotten", "腐", "example"},
            {"foot", "脚", "example"},
            {"exhausted", "尽", "example"},
            {"i", "僕", "example"},
            {"slip", "滑", "example"},
            {"solitary", "孤", "example"},
            {"inflammation", "炎", "example"},
            {"reparation", "賠", "example"},
            {"sandwich", "挟", "example"},
            {"life", "寿", "example"},
            {"stubborn", "頑", "example"},
            {"chain", "鎖", "example"},
            {"color", "彩", "example"},
            {"rub", "摩", "example"},
            {"encourage", "励", "example"},
            {"bright", "輝", "example"},
            {"accumulation", "蓄", "example"},
            {"axis", "軸", "example"},
            {"patrol", "巡", "example"},
            {"earn", "稼", "example"},
            {"instant", "瞬", "example"},
            {"cannon", "砲", "example"},
            {"spray", "噴", "example"},
            {"boast", "誇", "example"},
            {"auspicious", "祥", "example"},
            {"animal_sacrifice", "牲", "example"},
            {"clouds", "曇", "example"},
            {"rank", "秩", "example"},
            {"emperor", "帝", "example"},
            {"instigate", "唆", "example"},
            {"block", "阻", "example"},
            {"peace", "泰", "example"},
            {"bribe", "賄", "example"},
            {"bruise", "撲", "example"},
            {"cave", "堀", "example"},
            {"chrysanthemum", "菊", "example"},
            {"twist", "絞", "example"},
            {"edge", "縁", "example"},
            {"only", "唯", "example"},
            {"inflated", "膨", "example"},
            {"resistance", "耐", "example"},
            {"school", "塾", "example"},
            {"leak", "漏", "example"},
            {"celebrate", "慶", "example"},
            {"fierce", "猛", "example"},
            {"aromatic", "芳", "example"},
            {"punish", "懲", "example"},
            {"sword", "剣", "example"},
            {"award", "彰", "example"},
            {"chess", "棋", "example"},
            {"permanent", "恒", "example"},
            {"raise", "揚", "example"},
            {"risk", "冒", "example"},
            {"ethnicity", "倫", "example"},
            {"display", "陳", "example"},
            {"recall", "憶", "example"},
            {"latent", "潜", "example"},
            {"win", "克", "example"},
            {"mountain", "岳", "example"},
            {"general", "概", "example"},
            {"arrest", "拘", "example"},
            {"silence", "黙", "example"},
            {"partial", "偏", "example"}
    };
    String[][] KanjisH6 = {
            {"luxury", "豪", "example"},
            {"stagnant", "滞", "example"},
            {"micro", "微", "example"},
            {"grand", "隆", "example"},
            {"disease", "症", "example"},
            {"temporarily", "暫", "example"},
            {"cap", "帽", "example"},
            {"liver", "肝", "example"},
            {"shout", "喚", "example"},
            {"peculiar", "妙", "example"},
            {"withered", "枯", "example"},
            {"search", "索", "example"},
            {"raid", "襲", "example"},
            {"intimacy", "懇", "example"},
            {"handle", "柄", "example"},
            {"shock", "驚", "example"},
            {"hemp", "麻", "example"},
            {"drug", "剤", "example"},
            {"ford", "瀬", "example"},
            {"interest", "趣", "example"},
            {"stratagem", "陥", "example"},
            {"religious", "斎", "example"},
            {"penetrate", "貫", "example"},
            {"immortal", "仙", "example"},
            {"comfort", "慰", "example"},
            {"cool", "涼", "example"},
            {"boat", "舟", "example"},
            {"season", "旬", "example"},
            {"and", "兼", "example"},
            {"purport", "旨", "example"},
            {"immediately", "即", "example"},
            {"willow", "柳", "example"},
            {"false_", "偽", "example"},
            {"relatively", "較", "example"},
            {"supremacy", "覇", "example"},
            {"symbol", "符", "example"},
            {"detailed", "詳", "example"},
            {"resist", "抵", "example"},
            {"threaten", "脅", "example"},
            {"hate", "憎", "example"},
            {"willing", "肯", "example"},
            {"luxuriant", "茂", "example"},
            {"sacrifice", "犠", "example"},
            {"distance", "距", "example"},
            {"elegant", "雅", "example"},
            {"decorations", "飾", "example"},
            {"dry", "燥", "example"},
            {"network", "網", "example"},
            {"dragon", "竜", "example"},
            {"prosperity", "繁", "example"},
            {"livestock", "畜", "example"},
            {"wing", "翼", "example"},
            {"lagoon", "潟", "example"},
            {"enchantment", "魅", "example"},
            {"unpleasant", "嫌", "example"},
            {"boy", "坊", "example"},
            {"simultaneous", "斉", "example"},
            {"floor", "敷", "example"},
            {"advocacy", "擁", "example"},
            {"area", "圏", "example"},
            {"punish", "罰", "example"},
            {"destroy", "滅", "example"},
            {"foundation", "礎", "example"}
    };
    String[][] KanjisH5 = {
            {"promote", "促", "example"},
            {"abstain", "慎", "example"},
            {"refrain", "控", "example"},
            {"grip", "握", "example"},
            {"surname", "姓", "example"},
            {"cylinder", "筒", "example"},
            {"goodness", "俊", "example"},
            {"grain", "粒", "example"},
            {"bitter", "渋", "example"},
            {"gun", "銃", "example"},
            {"great", "偉", "example"},
            {"carry", "携", "example"},
            {"consultation", "診", "example"},
            {"entrusted", "託", "example"},
            {"taking", "撮", "example"},
            {"invade", "侵", "example"},
            {"include", "括", "example"},
            {"driving", "駆", "example"},
            {"through", "透", "example"},
            {"wharf", "津", "example"},
            {"wall", "壁", "example"},
            {"rice_plant", "稲", "example"},
            {"tatami", "畳", "example"},
            {"crack", "裂", "example"},
            {"agile", "敏", "example"},
            {"yes", "是", "example"},
            {"exhaustion", "排", "example"},
            {"abundant", "裕", "example"},
            {"firm", "堅", "example"},
            {"lawn", "芝", "example"},
            {"rope", "綱", "example"},
            {"skin", "膚", "example"},
            {"handling", "扱", "example"},
            {"patron", "顧", "example"},
            {"litigation", "訟", "example"},
            {"commandment", "戒", "example"},
            {"well_being", "祉", "example"},
            {"reputation", "誉", "example"},
            {"delight", "歓", "example"},
            {"recommendation", "勧", "example"},
            {"uproar", "騒", "example"},
            {"faction", "閥", "example"},
            {"armor", "甲", "example"},
            {"wash", "濯", "example"},
            {"rope", "縄", "example"},
            {"cat", "猫", "example"},
            {"shake", "揺", "example"},
            {"avoid", "免", "example"},
            {"already", "既", "example"},
            {"recommend", "薦", "example"},
            {"tower", "塔", "example"},
            {"next_to", "隣", "example"},
            {"boil", "沸", "example"},
            {"glamorous", "華", "example"},
            {"model", "範", "example"},
            {"hidden", "隠", "example"},
            {"wise", "哲", "example"},
            {"confectionery", "菓", "example"},
            {"chinese_fir", "杉", "example"},
            {"pardon", "釈", "example"},
            {"a_few", "幾", "example"},
            {"proper", "妥", "example"},
            {"prestige", "威", "example"}
    };

    String[][] KanjisH3 = {
            {"dimension", "維", "example"},
            {"soft", "軟", "example"},
            {"beach", "浜", "example"},
            {"sinking", "沈", "example"},
            {"base", "塁", "example"},
            {"state", "邦", "example"},
            {"freeze", "凍", "example"},
            {"dispatch", "遣", "example"},
            {"smoke", "煙", "example"},
            {"anti", "抗", "example"},
            {"male", "雄", "example"},
            {"love", "恋", "example"},
            {"tight", "緊", "example"},
            {"suburb", "郊", "example"},
            {"waist", "腰", "example"},
            {"dance", "踊", "example"},
            {"sleep", "眠", "example"},
            {"waste", "廃", "example"},
            {"fear", "怖", "example"},
            {"river", "江", "example"},
            {"treasure", "珍", "example"},
            {"official", "僚", "example"},
            {"lucky", "吉", "example"},
            {"enjoy", "喫", "example"},
            {"tread", "踏", "example"},
            {"corrupted", "壊", "example"},
            {"debt", "債", "example"},
            {"instrument", "儀", "example"},
            {"dissolve", "溶", "example"},
            {"continue", "継", "example"},
            {"fight", "闘", "example"},
            {"burial", "葬", "example"},
            {"avoid", "避", "example"},
            {"tear", "涙", "example"},
            {"animals", "匹", "example"},
            {"catch", "逮", "example"},
            {"sharpness", "鋭", "example"},
            {"force", "迫", "example"},
            {"be_puzzled", "惑", "example"},
            {"collapse", "崩", "example"},
            {"hearing", "聴", "example"},
            {"take_off", "脱", "example"},
            {"paint", "塗", "example"},
            {"eaves", "軒", "example"},
            {"tighten", "締", "example"},
            {"tenacity", "執", "example"},
            {"yell", "叫", "example"},
            {"room", "房", "example"},
            {"withdraw", "撤", "example"},
            {"cut", "削", "example"},
            {"measures", "措", "example"},
            {"load", "載", "example"},
            {"dried", "乾", "example"},
            {"front", "陣", "example"},
            {"for_", "為", "example"},
            {"suppress", "抑", "example"},
            {"pray", "祈", "example"},
            {"option", "択", "example"},
            {"excellent", "秀", "example"},
            {"hair", "髪", "example"},
            {"features", "徴", "example"},
            {"busy", "忙", "example"},
            {"bullet", "弾", "example"}
    };

    String[][] KanjisH4 = {
            {"compensate", "償", "example"},
            {"conforming", "拠", "example"},
            {"refuse", "拒", "example"},
            {"punishment", "刑", "example"},
            {"mound", "塚", "example"},
            {"do_", "致", "example"},
            {"repetitive", "繰", "example"},
            {"tail", "尾", "example"},
            {"draw", "描", "example"},
            {"sweat", "汗", "example"},
            {"bell", "鈴", "example"},
            {"plate", "盤", "example"},
            {"item", "項", "example"},
            {"funeral", "喪", "example"},
            {"companion", "伴", "example"},
            {"hang", "懸", "example"},
            {"wet", "湿", "example"},
            {"contract", "契", "example"},
            {"bulletin", "掲", "example"},
            {"jump", "躍", "example"},
            {"abandoned", "棄", "example"},
            {"bottle", "瓶", "example"},
            {"mansion", "邸", "example"},
            {"bloom", "咲", "example"},
            {"return_", "還", "example"},
            {"summon", "召", "example"},
            {"consider", "慮", "example"},
            {"can", "缶", "example"},
            {"weir", "隻", "example"},
            {"frame", "枠", "example"},
            {"fat", "脂", "example"},
            {"grace", "恵", "example"},
            {"dew", "露", "example"},
            {"off_the_coast", "沖", "example"},
            {"slow", "緩", "example"},
            {"skin", "肌", "example"},
            {"need", "需", "example"},
            {"shoes", "靴", "example"},
            {"purchase", "購", "example"},
            {"charge", "充", "example"},
            {"blunt", "鈍", "example"},
            {"shame", "恥", "example"},
            {"tribute", "貢", "example"},
            {"but", "却", "example"},
            {"end", "端", "example"},
            {"obtain", "獲", "example"},
            {"mud", "泥", "example"},
            {"both", "併", "example"},
            {"go_through", "徹", "example"},
            {"rush", "衝", "example"},
            {"focal", "焦", "example"},
            {"steal", "奪", "example"},
            {"corner", "隅", "example"},
            {"riverside", "浦", "example"},
            {"even", "偶", "example"},
            {"analyze", "析", "example"},
            {"spicy", "辛", "example"},
            {"polish", "磨", "example"},
            {"yield", "譲", "example"},
            {"call", "称", "example"},
            {"challenge", "挑", "example"},
            {"lure", "誘", "example"},
            {"distract", "紛", "example"}
    };

    String[][] KanjisH2 = {
            {"resident", "駐", "example"},
            {"introduce", "紹", "example"},
            {"well", "井", "example"},
            {"hire", "雇", "example"},
            {"replacement", "替", "example"},
            {"fresh", "鮮", "example"},
            {"gifts", "贈", "example"},
            {"thin", "薄", "example"},
            {"inner_part", "奥", "example"},
            {"packed", "詰", "example"},
            {"hang", "掛", "example"},
            {"double_", "双", "example"},
            {"thorn", "刺", "example"},
            {"arrival", "到", "example"},
            {"prison", "監", "example"},
            {"ring", "環", "example"},
            {"sleeping", "寝", "example"},
            {"examine", "審", "example"},
            {"thief", "盗", "example"},
            {"complaint", "訴", "example"},
            {"trouble", "悩", "example"},
            {"honorable", "御", "example"},
            {"shadow", "影", "example"},
            {"shot", "撃", "example"},
            {"rage", "荒", "example"},
            {"assistant", "佐", "example"},
            {"nuclear", "核", "example"},
            {"hard", "硬", "example"},
            {"melt", "融", "example"},
            {"bury", "埋", "example"},
            {"negotiation", "渉", "example"},
            {"bag", "袋", "example"},
            {"sound", "響", "example"},
            {"blow", "吹", "example"},
            {"seal", "封", "example"},
            {"daughter", "娘", "example"},
            {"please", "請", "example"},
            {"attack", "攻", "example"},
            {"small_peninsula", "崎", "example"},
            {"virtuous", "賢", "example"},
            {"supervise", "督", "example"},
            {"urge", "催", "example"},
            {"arm", "腕", "example"},
            {"and", "及", "example"},
            {"bed", "床", "example"},
            {"leave", "離", "example"},
            {"soft", "柔", "example"},
            {"pick", "摘", "example"},
            {"man", "郎", "example"},
            {"temple", "殿", "example"},
            {"concentrated", "濃", "example"},
            {"shoulder", "肩", "example"},
            {"zero", "零", "example"},
            {"angry", "怒", "example"},
            {"stay", "泊", "example"},
            {"cup", "杯", "example"},
            {"vibration", "振", "example"},
            {"sweet", "甘", "example"},
            {"sweep", "掃", "example"},
            {"dig", "掘", "example"},
            {"offer", "献", "example"},
            {"tired", "疲", "example"},
            {"all", "皆", "example"}
    };

    String[][] KanjisH1 = {
            {"age", "歳", "example"},
            {"giving", "与", "example"},
            {"wrong", "違", "example"},
            {"europe", "欧", "example"},
            {"suffered", "被", "example"},
            {"cross_over", "渡", "example"},
            {"contain", "含", "example"},
            {"situation", "況", "example"},
            {"sudden", "突", "example"},
            {"bay", "湾", "example"},
            {"search", "捜", "example"},
            {"ultra", "超", "example"},
            {"cure", "療", "example"},
            {"catch_", "捕", "example"},
            {"introduction", "介", "example"},
            {"welcome", "迎", "example"},
            {"sales", "販", "example"},
            {"width", "幅", "example"},
            {"he", "彼", "example"},
            {"general", "般", "example"},
            {"dance", "舞", "example"},
            {"included", "込", "example"},
            {"change", "換", "example"},
            {"take_up", "占", "example"},
            {"ask", "頼", "example"},
            {"way", "途", "example"},
            {"unplug", "抜", "example"},
            {"stretch", "伸", "example"},
            {"burst", "爆", "example"},
            {"general", "普", "example"},
            {"marriage", "婚", "example"},
            {"age", "齢", "example"},
            {"float_", "浮", "example"},
            {"push", "押", "example"},
            {"defeat", "倒", "example"},
            {"end", "了", "example"},
            {"suffer", "患", "example"},
            {"entangle", "絡", "example"},
            {"raise", "募", "example"},
            {"payment", "払", "example"},
            {"rise", "昇", "example"},
            {"late", "遅", "example"},
            {"fragrant", "香", "example"},
            {"more", "更", "example"},
            {"hold", "抱", "example"},
            {"fear", "恐", "example"},
            {"return", "戻", "example"},
            {"huge", "巨", "example"},
            {"shock", "震", "example"},
            {"more", "越", "example"},
            {"enterprises", "企", "example"},
            {"touch", "触", "example"},
            {"according_to", "依", "example"},
            {"membership", "籍", "example"},
            {"dirty", "汚", "example"},
            {"mutual", "互", "example"},
            {"swamp", "沢", "example"},
            {"escape", "逃", "example"},
            {"aid", "援", "example"},
            {"pour", "傾", "example"},
            {"apply", "施", "example"},
            {"thread", "緒", "example"},
            {"mark", "跡", "example"}
    };

    String[][] KanjisG6_4 = {
            {"shrink", "縮", "example"},
            {"steam", "蒸", "example"},
            {"shoot", "射", "example"},
            {"command", "揮", "example"},
            {"rent", "賃", "example"},
            {"expensive", "貴", "example"},
            {"accept", "納", "example"},
            {"tree", "樹", "example"},
            {"to", "至", "example"},
            {"sect", "宗", "example"},
            {"air", "宙", "example"},
            {"word", "詞", "example"},
            {"operation", "操", "example"},
            {"birth", "誕", "example"},
            {"think", "孝", "example"},
            {"desk", "机", "example"},
            {"reason", "訳", "example"},
            {"nurse", "看", "example"},
            {"play_instrument", "奏", "example"},
            {"township", "郷", "example"},
            {"gray", "灰", "example"},
            {"myself", "己", "example"},
            {"loyal", "忠", "example"},
            {"along", "沿", "example"},
            {"honest", "誠", "example"},
            {"japanese_poetry", "俳", "example"},
            {"saint", "聖", "example"},
            {"tide", "潮", "example"},
            {"steel", "鋼", "example"},
            {"vertical", "縦", "example"},
            {"benevolence", "仁", "example"},
            {"hole", "穴", "example"},
            {"warm", "暖", "example"},
            {"bright", "朗", "example"},
            {"lung", "肺", "example"},
            {"mature", "熟", "example"},
            {"majesty", "陛", "example"},
            {"sugar", "糖", "example"},
            {"see", "覧", "example"},
            {"enthusiasm", "奮", "example"},
            {"queen", "后", "example"},
            {"group", "班", "example"},
            {"inch", "寸", "example"},
            {"magnetic", "磁", "example"},
            {"hang", "垂", "example"},
            {"grain", "穀", "example"},
            {"silk", "絹", "example"},
            {"ruler", "尺", "example"},
            {"silkworm", "蚕", "example"}
    };

    String[][] KanjisG6_3 = {
            {"sand", "砂", "example"},
            {"error", "誤", "example"},
            {"discuss", "討", "example"},
            {"wash", "洗", "example"},
            {"constitution", "憲", "example"},
            {"honor", "尊", "example"},
            {"cheap", "激", "example"},
            {"window", "窓", "example"},
            {"system", "系", "example"},
            {"batch", "批", "example"},
            {"alliance", "盟", "example"},
            {"follow", "従", "example"},
            {"young", "幼", "example"},
            {"expansion", "拡", "example"},
            {"completion", "就", "example"},
            {"different", "異", "example"},
            {"severe", "厳", "example"},
            {"discard", "捨", "example"},
            {"heritage", "遺", "example"},
            {"belly", "腹", "example"},
            {"milk", "乳", "example"},
            {"mold", "模", "example"},
            {"red", "紅", "example"},
            {"book", "冊", "example"},
            {"declare", "宣", "example"},
            {"assortment", "盛", "example"},
            {"egg", "卵", "example"},
            {"emperor", "皇", "example"},
            {"coming", "臨", "example"},
            {"dry", "干", "example"},
            {"top", "頂", "example"},
            {"source", "源", "example"},
            {"create", "創", "example"},
            {"barrier", "障", "example"},
            {"muscle", "筋", "example"},
            {"good", "善", "example"},
            {"night", "晩", "example"},
            {"dense", "密", "example"},
            {"worship", "拝", "example"},
            {"i", "我", "example"},
            {"baton", "棒", "example"},
            {"screen", "幕", "example"},
            {"dye", "染", "example"},
            {"hurt", "傷", "example"},
            {"secret", "秘", "example"}
    };

    String[][] KanjisG6_2 = {
            {"author", "著", "example"},
            {"magazine", "誌", "example"},
            {"engraved", "刻", "example"},
            {"universe", "宇", "example"},
            {"want", "欲", "example"},
            {"pain", "痛", "example"},
            {"sheet", "枚", "example"},
            {"mail", "郵", "example"},
            {"court", "裁", "example"},
            {"explore", "探", "example"},
            {"bone", "骨", "example"},
            {"notification", "届", "example"},
            {"roll", "巻", "example"},
            {"close", "閉", "example"},
            {"exhibition", "展", "example"},
            {"twilight", "暮", "example"},
            {"simple", "簡", "example"},
            {"regard", "視", "example"},
            {"viscera", "臓", "example"},
            {"law", "律", "example"},
            {"pure", "純", "example"},
            {"suck", "吸", "example"},
            {"stock", "株", "example"},
            {"appearance", "姿", "example"},
            {"pavilion", "閣", "example"},
            {"next", "翌", "example"},
            {"masses", "衆", "example"},
            {"sheet", "片", "example"},
            {"respectfully", "敬", "example"},
            {"spring", "泉", "example"},
            {"forget", "忘", "example"},
            {"push", "推", "example"},
            {"treasure", "宝", "example"},
            {"breast", "胸", "example"}
    };
    String[][] KanjisG6_1 = {
            {"i", "私", "example"},
            {"reflect", "映", "example"},
            {"party", "党", "example"},
            {"authority", "権", "example"},
            {"already", "済", "example"},
            {"recognize", "認", "example"},
            {"admonish", "論", "example"},
            {"leather", "革", "example"},
            {"suspect", "疑", "example"},
            {"supply", "供", "example"},
            {"percentage", "割", "example"},
            {"difficult", "難", "example"},
            {"fill", "補", "example"},
            {"excellent", "優", "example"},
            {"income", "収", "example"},
            {"house", "宅", "example"},
            {"police", "警", "example"},
            {"visit", "訪", "example"},
            {"area", "域", "example"},
            {"responsible", "担", "example"},
            {"young", "若", "example"},
            {"brain", "脳", "example"},
            {"warehouse", "蔵", "example"},
            {"segment", "段", "example"},
            {"call", "呼", "example"},
            {"needle", "針", "example"},
            {"dedicated", "専", "example"},
            {"value", "値", "example"},
            {"place", "処", "example"},
            {"no", "否", "example"},
            {"existance", "存", "example"},
            {"seat", "座", "example"},
            {"except", "除", "example"},
            {"drop", "降", "example"},
            {"and", "並", "example"},
            {"danger", "危", "example"},
            {"will", "将", "example"},
            {"dress", "装", "example"},
            {"various", "諸", "example"},
            {"perish", "亡", "example"},
            {"drama", "劇", "example"},
            {"rear", "背", "example"},
            {"department", "署", "example"},
            {"delay", "延", "example"},
            {"disorderly", "乱", "example"},
            {"send", "派", "example"},
            {"agency", "庁", "example"},
            {"castle", "城", "example"},
            {"layer", "層", "example"},
            {"back", "裏", "example"},
            {"service", "勤", "example"},
            {"policy", "策", "example"},
            {"be_worried", "困", "example"}
    };

    String[][] KanjisG5_4 = {
            {"burn", "燃", "example"},
            {"protect", "護", "example"},
            {"state", "態", "example"},
            {"advance", "預", "example"},
            {"article", "条", "example"},
            {"dry", "幹", "example"},
            {"alone", "独", "example"},
            {"rate", "率", "example"},
            {"group", "群", "example"},
            {"guard", "衛", "example"},
            {"stretch", "張", "example"},
            {"righteousness", "義", "example"},
            {"pleasant", "快", "example"},
            {"review", "評", "example"},
            {"made_by", "製", "example"},
            {"award", "授", "example"},
            {"used", "慣", "example"},
            {"liquid", "液", "example"},
            {"poor", "貧", "example"},
            {"ancestor", "祖", "example"},
            {"repair", "修", "example"},
            {"weave", "織", "example"},
            {"therefore", "故", "example"},
            {"valve", "弁", "example"},
            {"elementary", "素", "example"},
            {"beneficial", "益", "example"},
            {"interest", "興", "example"},
            {"ore", "鉱", "example"},
            {"branch", "枝", "example"},
            {"will", "志", "example"},
            {"cotton", "綿", "example"},
            {"copper", "銅", "example"},
            {"belong", "属", "example"},
            {"plow", "耕", "example"},
            {"disaster", "災", "example"},
            {"money", "銭", "example"},
            {"thank", "謝", "example"},
            {"provisional", "仮", "example"},
            {"congratulate", "賀", "example"},
            {"virtue", "徳", "example"},
            {"sequence", "序", "example"},
            {"hut", "舎", "example"},
            {"enemy", "敵", "example"},
            {"acid", "酸", "example"},
            {"cherry_blossoms", "桜", "example"},
            {"sentence", "句", "example"},
            {"tomb", "墓", "example"},
            {"feed", "飼", "example"},
            {"favor", "恩", "example"},
            {"often", "往", "example"},
            {"fat", "肥", "example"},
            {"bale", "俵", "example"},
            {"eye", "眼", "example"},
            {"clean", "潔", "example"},
            {"tongue", "舌", "example"}
    };
    String[][] KanjisG5_3 = {
            {"reverse", "逆", "example"},
            {"long", "久", "example"},
            {"wife", "妻", "example"},
            {"violent", "暴", "example"},
            {"steep", "険", "example"},
            {"all", "均", "example"},
            {"pressure", "圧", "example"},
            {"forgiveness", "許", "example"},
            {"stay", "留", "example"},
            {"crime", "罪", "example"},
            {"sum", "統", "example"},
            {"fine", "精", "example"},
            {"law", "則", "example"},
            {"measurement", "測", "example"},
            {"rich", "豊", "example"},
            {"thick", "厚", "example"},
            {"insurance", "保", "example"},
            {"slightly", "略", "example"},
            {"support", "承", "example"},
            {"absolutely", "絶", "example"},
            {"version", "版", "example"},
            {"damage", "損", "example"},
            {"buddha", "仏", "example"},
            {"achievement", "績", "example"},
            {"build", "築", "example"},
            {"mix", "混", "example"},
            {"house", "居", "example"},
            {"crude", "雑", "example"},
            {"invitation", "招", "example"},
            {"forever", "永", "example"},
            {"publication", "刊", "example"},
            {"image", "像", "example"},
            {"base", "基", "example"},
            {"praise", "賛", "example"},
            {"crime", "犯", "example"},
            {"price", "価", "example"},
            {"cloth", "布", "example"},
            {"offer", "提", "example"},
            {"response", "応", "example"},
            {"inspection", "検", "example"},
            {"duplicate", "複", "example"},
            {"similar", "似", "example"},
            {"proof", "証", "example"},
            {"fan", "迷", "example"},
            {"dream", "夢", "example"}
    };
    String[][] KanjisG5_2 = {
            {"technique", "術", "example"},
            {"guide", "導", "example"},
            {"equipment", "備", "example"},
            {"loan", "貸", "example"},
            {"transport", "輸", "example"},
            {"state", "述", "example"},
            {"military", "武", "example"},
            {"limit", "限", "example"},
            {"amount", "額", "example"},
            {"retreat", "退", "example"},
            {"quasi", "準", "example"},
            {"make", "造", "example"},
            {"skill", "技", "example"},
            {"recovery", "復", "example"},
            {"shift", "移", "example"},
            {"pieces", "個", "example"},
            {"non", "非", "example"},
            {"fiscal", "財", "example"},
            {"knowledge", "識", "example"},
            {"journey", "程", "example"},
            {"contact", "接", "example"},
            {"effect", "効", "example"},
            {"old", "旧", "example"},
            {"division", "師", "example"},
            {"easy", "易", "example"},
            {"ticket", "券", "example"},
            {"broken", "破", "example"},
            {"editing", "編", "example"},
            {"responsibility", "責", "example"},
            {"collection", "採", "example"},
            {"factor", "因", "example"},
            {"rich", "富", "example"},
            {"trade", "貿", "example"},
            {"lecture", "講", "example"},
            {"river", "河", "example"},
            {"suitable", "適", "example"},
            {"woman", "婦", "example"},
            {"approach", "寄", "example"},
            {"extra", "余", "example"},
            {"ban", "禁", "example"}
    };
    String[][] KanjisG5_1 = {
            {"quality", "質", "example"},
            {"politics", "政", "example"},
            {"through", "経", "example"},
            {"present", "現", "example"},
            {"sex", "性", "example"},
            {"system", "制", "example"},
            {"business", "務", "example"},
            {"gross", "総", "example"},
            {"territory", "領", "example"},
            {"setting", "設", "example"},
            {"support", "支", "example"},
            {"report", "報", "example"},
            {"solution", "解", "example"},
            {"capital", "資", "example"},
            {"edge", "際", "example"},
            {"inspection", "査", "example"},
            {"size", "判", "example"},
            {"presence", "在", "example"},
            {"matter", "件", "example"},
            {"gathering", "団", "example"},
            {"assignment", "任", "example"},
            {"increase", "増", "example"},
            {"information", "情", "example"},
            {"show", "示", "example"},
            {"indeed", "確", "example"},
            {"power", "勢", "example"},
            {"less", "減", "example"},
            {"contain", "容", "example"},
            {"play", "演", "example"},
            {"ability", "能", "example"},
            {"again", "再", "example"},
            {"ranking", "格", "example"},
            {"failure", "過", "example"},
            {"tax", "税", "example"},
            {"always", "常", "example"},
            {"status", "状", "example"},
            {"encampment", "営", "example"},
            {"office", "職", "example"},
            {"possible", "可", "example"},
            {"construct", "構", "example"},
            {"ratio", "比", "example"},
            {"anti", "防", "example"},
            {"break_", "断", "example"},
            {"territory", "境", "example"},
            {"regulation", "規", "example"}
    };
    String[][] KanjisG4_5 = {
            {"train", "訓", "example"},
            {"bath", "浴", "example"},
            {"salt", "塩", "example"},
            {"device", "器", "example"},
            {"scholar", "士", "example"},
            {"trillion", "兆", "example"},
            {"wish", "祝", "example"},
            {"healthy", "健", "example"},
            {"clothes", "衣", "example"},
            {"team", "隊", "example"},
            {"minister", "臣", "example"},
            {"shallow", "浅", "example"},
            {"mark", "標", "example"},
            {"brave", "勇", "example"},
            {"weapon", "械", "example"},
            {"side_dish", "菜", "example"},
            {"print", "刷", "example"},
            {"department", "司", "example"},
            {"health", "康", "example"},
            {"grandson", "孫", "example"},
            {"narrative", "紀", "example"},
            {"poison", "毒", "example"},
            {"doctor", "博", "example"},
            {"save", "救", "example"},
            {"merits", "功", "example"},
            {"powder", "粉", "example"},
            {"support", "養", "example"},
            {"town", "街", "example"},
            {"node", "節", "example"},
            {"county", "郡", "example"},
            {"light", "灯", "example"},
            {"stomach", "胃", "example"},
            {"code", "典", "example"},
            {"warehouse", "倉", "example"},
            {"sing", "唱", "example"},
            {"flag", "旗", "example"},
            {"plum", "梅", "example"},
            {"shepherd", "牧", "example"},
            {"sob", "泣", "example"},
            {"path", "径", "example"},
            {"pulse", "脈", "example"},
            {"mirror", "鏡", "example"},
            {"nest", "巣", "example"},
            {"bud", "芽", "example"},
            {"intestinal", "腸", "example"}
    };
    String[][] KanjisG4_4 = {
            {"strive", "努", "example"},
            {"solid", "固", "example"},
            {"scatter", "散", "example"},
            {"quiet", "静", "example"},
            {"like", "喜", "example"},
            {"enclosed", "囲", "example"},
            {"graduation", "卒", "example"},
            {"order", "順", "example"},
            {"knot", "結", "example"},
            {"old", "老", "example"},
            {"orders", "令", "example"},
            {"vanity", "徒", "example"},
            {"goods", "貨", "example"},
            {"idea", "案", "example"},
            {"season", "季", "example"},
            {"lack", "欠", "example"},
            {"bottom", "底", "example"},
            {"behavior", "挙", "example"},
            {"willing", "願", "example"},
            {"hope", "希", "example"},
            {"lol", "笑", "example"},
            {"bundle", "束", "example"},
            {"relationship", "仲", "example"},
            {"glory", "栄", "example"},
            {"bill", "札", "example"},
            {"package_", "包", "example"},
            {"fold", "折", "example"},
            {"baked", "焼", "example"},
            {"illumination", "照", "example"},
            {"fish", "漁", "example"},
            {"pine", "松", "example"},
            {"storage", "貯", "example"},
            {"ballot", "票", "example"}
    };
    String[][] KanjisG4_3 = {
            {"mould", "型", "example"},
            {"accomplished", "達", "example"},
            {"good", "良", "example"},
            {"climate", "候", "example"},
            {"chronicle", "史", "example"},
            {"fullness", "満", "example"},
            {"failure", "敗", "example"},
            {"pipe", "管", "example"},
            {"soldier", "兵", "example"},
            {"volume", "積", "example"},
            {"record", "録", "example"},
            {"focus", "省", "example"},
            {"circumference", "周", "example"},
            {"lumber", "材", "example"},
            {"fly", "飛", "example"},
            {"kill", "殺", "example"},
            {"simple", "単", "example"},
            {"complete", "完", "example"},
            {"compete_with", "競", "example"},
            {"salary", "給", "example"},
            {"continuation", "歴", "example"},
            {"resign", "辞", "example"},
            {"love", "愛", "example"},
            {"still", "末", "example"},
            {"sail", "航", "example"},
            {"cool", "冷", "example"},
            {"sort", "類", "example"},
            {"child", "児", "example"},
            {"print", "印", "example"},
            {"wheel", "輪", "example"},
            {"heat", "熱", "example"},
            {"clear", "清", "example"},
            {"mr", "氏", "example"},
            {"realize", "覚", "example"},
            {"One_hundred_million", "億", "example"},
            {"tricks", "芸", "example"},
            {"convenience", "便", "example"},
            {"stop", "停", "example"},
            {"land", "陸", "example"},
            {"band", "帯", "example"}
    };
    String[][] KanjisG4_2 = {
            {"unusual", "変", "example"},
            {"each", "各", "example"},
            {"reward", "果", "example"},
            {"inevitable", "必", "example"},
            {"contend", "争", "example"},
            {"nothingness", "無", "example"},
            {"rank", "位", "example"},
            {"placement", "置", "example"},
            {"borrow", "借", "example"},
            {"expense", "費", "example"},
            {"adhere", "付", "example"},
            {"theory", "説", "example"},
            {"husband", "夫", "example"},
            {"harm", "害", "example"},
            {"duplicate", "副", "example"},
            {"seat", "席", "example"},
            {"remainder", "残", "example"},
            {"public_chamber", "堂", "example"},
            {"wish", "念", "example"},
            {"elephant", "象", "example"},
            {"labor", "労", "example"},
            {"example", "例", "example"},
            {"sort_of_thing", "然", "example"},
            {"transmit", "伝", "example"},
            {"work", "働", "example"},
            {"scenery", "景", "example"},
            {"meal", "飯", "example"},
            {"fond", "好", "example"},
            {"prize", "賞", "example"},
            {"environs", "辺", "example"},
            {"lower", "低", "example"},
            {"lose", "失", "example"},
            {"distinction", "差", "example"},
            {"chapter", "課", "example"},
            {"end", "末", "example"},
            {"poles", "極", "example"},
            {"species", "種", "example"},
            {"quantity", "量", "example"},
            {"ambition", "望", "example"},
            {"outlook", "観", "example"},
            {"guess", "察", "example"}
    };
    String[][] KanjisG4_1 = {
            {"negative", "不", "example"},
            {"because", "以", "example"},
            {"separate", "別", "example"},
            {"special", "特", "example"},
            {"materials", "料", "example"},
            {"build", "建", "example"},
            {"test", "試", "example"},
            {"verification", "験", "example"},
            {"english", "英", "example"},
            {"deliberation", "議", "example"},
            {"people", "民", "example"},
            {"take_along", "連", "example"},
            {"choice", "選", "example"},
            {"connection", "関", "example"},
            {"war", "戦", "example"},
            {"most", "最", "example"},
            {"approximately", "約", "example"},
            {"law", "法", "example"},
            {"target", "的", "example"},
            {"need", "要", "example"},
            {"reign", "治", "example"},
            {"turn_into", "成", "example"},
            {"corporate", "協", "example"},
            {"mechanism", "機", "example"},
            {"add", "加", "example"},
            {"continue_", "続", "example"},
            {"improve", "改", "example"},
            {"first_time", "初", "example"},
            {"products", "産", "example"},
            {"urban_prefecture", "府", "example"},
            {"together", "共", "example"},
            {"gain", "得", "example"},
            {"revelation", "告", "example"},
            {"army", "軍", "example"},
            {"be_defeated", "参", "example"},
            {"profit", "利", "example"},
            {"believe", "信", "example"},
            {"side", "側", "example"},
            {"request", "求", "example"},
            {"yesterday", "昨", "example"},
            {"bureaucrat", "官", "example"}
    };
    String[][] KanjisG3_5 = {
            {"harbor", "港", "example"},
            {"stair", "階", "example"},
            {"sad", "悲", "example"},
            {"second", "秒", "example"},
            {"darkness", "暗", "example"},
            {"sunshine", "陽", "example"},
            {"skin", "皮", "example"},
            {"organize", "整", "example"},
            {"tooth", "歯", "example"},
            {"pillar", "柱", "example"},
            {"deify", "祭", "example"},
            {"brush", "筆", "example"},
            {"juvenile", "童", "example"},
            {"garden", "畑", "example"},
            {"green", "緑", "example"},
            {"salute", "礼", "example"},
            {"antiquity", "昔", "example"},
            {"swim", "泳", "example"},
            {"baggage", "荷", "example"},
            {"charcoal", "炭", "example"},
            {"bright", "昭", "example"},
            {"lake", "湖", "example"},
            {"bath", "湯", "example"},
            {"box", "箱", "example"},
            {"class_", "級", "example"},
            {"ice", "氷", "example"},
            {"cold", "寒", "example"},
            {"pick_up", "拾", "example"},
            {"nose", "鼻", "example"},
            {"plate", "皿", "example"},
            {"poem", "詩", "example"},
            {"street", "丁", "example"},
            {"bean", "豆", "example"},
            {"sultry", "暑", "example"},
            {"notebook", "帳", "example"},
            {"sheep", "羊", "example"},
            {"flute", "笛", "example"}
    };
    String[][] KanjisG3_4 = {
            {"harbor", "港", "example"},
            {"stair", "階", "example"},
            {"path", "路", "example"},
            {"other", "他", "example"},
            {"bridge", "橋", "example"},
            {"beach", "岸", "example"},
            {"customer", "客", "example"},
            {"ascend", "登", "example"},
            {"quick", "速", "example"},
            {"center", "央", "example"},
            {"number", "号", "example"},
            {"root", "根", "example"},
            {"suffering", "苦", "example"},
            {"tool", "具", "example"},
            {"steel", "鉄", "example"},
            {"return", "返", "example"},
            {"short_", "短", "example"},
            {"oil", "油", "example"},
            {"plant", "植", "example"},
            {"inn", "宿", "example"},
            {"medicine", "薬", "example"},
            {"double_", "倍", "example"},
            {"wave", "波", "example"},
            {"order", "第", "example"},
            {"happy", "幸", "example"},
            {"practice", "練", "example"},
            {"lightly", "軽", "example"},
            {"equal", "等", "example"},
            {"bend", "曲", "example"},
            {"courtyard", "庭", "example"},
            {"blood", "血", "example"},
            {"warm", "温", "example"},
            {"warehouse", "庫", "example"},
            {"china", "漢", "example"},
            {"slope", "坂", "example"},
            {"breath", "息", "example"},
            {"plank", "板", "example"},
            {"row", "列", "example"},
            {"play", "遊", "example"},
            {"you", "君", "example"},
            {"chapter", "章", "example"},
            {"palace", "宮", "example"},
            {"sake", "酒", "example"}
    };
    String[][] KanjisG3_3 = {
            {"charge", "係", "example"},
            {"emotion", "感", "example"},
            {"throw_", "投", "example"},
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
            {"body", "身", "example"},
            {"reason", "由", "example"},
            {"drink", "飲", "example"},
            {"extinguish", "消", "example"},
            {"god", "神", "example"},
            {"distribute", "配", "example"},
            {"grow_up", "育", "example"},
            {"ride", "乗", "example"},
            {"concept", "想", "example"},
            {"agriculture", "農", "example"},
            {"state", "州", "example"},
            {"help", "助", "example"},
            {"chase", "追", "example"},
            {"make_a_deal", "商", "example"},
            {"leaf", "葉", "example"},
            {"fall", "落", "example"},
            {"exertion", "勉", "example"},
            {"defeat", "負", "example"},
            {"guard", "守", "example"},
            {"beauty", "美", "example"},
            {"life", "命", "example"},
            {"blessing", "福", "example"},
            {"sideways", "横", "example"},
            {"side", "横", "example"},
            {"state_politely", "申", "example"},
            {"kind", "様", "example"}
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
            {"gathering", "集", "example"},
            {"object", "物", "example"},
            {"use", "使", "example"},
            {"goods", "品", "example"},
            {"death", "死", "example"},
            {"begin", "始", "example"},
            {"carry", "運", "example"},
            {"end", "終", "example"},
            {"live", "住", "example"},
            {"true_", "真", "example"},
            {"possess", "有", "example"},
            {"hurry", "急", "example"},
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
            {"time", "時", "example"},
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
            {"south", "南", "example"},
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
            {"new_", "新", "example"},
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
            {"public_", "公", "example"},
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
            {"sunny", "晴", "example"},
            {"snow", "雪", "example"},
            {"fur", "毛", "example"},
            {"yellow", "黄", "example"},
            {"cloud", "雲", "example"},
            {"chirp", "鳴", "example"},
            {"talent", "才", "example"},
            {"barley", "麦", "example"},
            {"parents_home", "里", "example"},
            {"dart", "矢", "example"},
            {"blade", "刀", "example"},
            {"bow", "弓", "example"},
            {"vapor", "汽", "example"},
            {"back", "後", "example"},
            {"minute", "分", "example"},
            {"go", "行", "example"},
            {"time", "時", "example"},
            {"long_", "長", "example"},
            {"country", "国", "example"}
    };
    String[][] KanjisG1_2 = {
            {"person", "人", "人々が団結する/Menschen vereinen sich/People unite"},
            {"water", "水", "水滴が波紋を生む/Tröpfchen erzeugen Wellen/Droplets create ripples"},
            {"justice", "正", "正義の名の下に/Im Namen der Gerechtigkeit/In the name of justice"},
            {"life", "生", "子供が生まれる/Ein Kind wird geboren/A child is born"},
            {"six", "六", "さいころの六/Sechsseitigen Würfeln möglich/Six of dice"},
            {"grove", "林", "木々が群生して林になる/Bäume wachsen zu Handschuhen/Trees grow into grove"},
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
            {"study", "学", "栄養について学ぶ/Erfahren Sie über Ernährung/Learn about nutrition"},
            {"mind", "気", "気の迷い/das Zögern/Hesitation"},
            {"nine", "九", "九十九歳/neunundneunzig Jahre alt/ninety nine years old"},
            {"rest", "休", "休みを取る/machen sie eine pause/Take a break"},
            {"jewelry", "球", "宝石を買う/Schmuck kaufen/Buy jewelry"},
            {"gold", "金", "金塊を発掘した/Ausgegrabene Goldnuggets/Excavated gold nuggets"},
            {"sky", "空", "空に風船が浮かぶ/Luftballons schweben in den Himmel/Balloons floating in the sky"},
            {"moon", "月", "夜空に浮かぶ月/Mond, der in den nächtlichen Himmel schwimmt/Moon floating in the night sky"},
            {"dog", "犬", "犬とハンター/Hund und Jäger/dog and hunter"},
            {"see", "見", "望遠鏡で遠くを見る/Schauen Sie mit einem Teleskop weit weg/Look far away with a telescope"},
            {"five", "五", "五番目のボール/Fünfter Ball/Fifth ball"},
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
    String[][] Kanjis = KanjisG1_1;
    String SelectedLevel;

    int AnswerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Declarations.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView KanjiAnswerButtonLeft = (ImageView) findViewById(R.id.KanjiAnswerButtonLeft);
        final ImageView KanjiAnswerButtonMiddle = (ImageView) findViewById(R.id.KanjiAnswerButtonMiddle);
        final ImageView KanjiAnswerButtonRight = (ImageView) findViewById(R.id.KanjiAnswerButtonRight);
        final ImageView LeftKanjiBack = (ImageView) findViewById(R.id.LeftKanjiBack);
        final ImageView MiddleKanjiBack = (ImageView) findViewById(R.id.MiddleKanjiBack);
        final ImageView RightKanjiBack = (ImageView) findViewById(R.id.RightKanjiBack);
        final ImageView NextButton = (ImageView) findViewById(R.id.NextButton);
        final ImageView image = (ImageView) findViewById(R.id.kanjiWindow);
        final Button    selectLevel = findViewById(R.id.SelectLevel);
        final TextView ReftKanji = (TextView) findViewById(R.id.LeftKanjiText);
        final TextView MiddleKanji = (TextView) findViewById(R.id.MiddleKanjiText);
        final TextView RightKanji = (TextView) findViewById(R.id.RightKanjiText);
        final TextView ExampleKanji = (TextView) findViewById(R.id.Answer);
        // final EditText  QuestionsText           = (EditText)  findViewById(R.id.Questions);
        final EditText CorrectAnswersText = (EditText) findViewById(R.id.CorrectAnswers);

        // If user click the one of the Kanji, set visible to Next button/answer.
        // If user select correct Kanji, add score. And lock the number
        // until user click the next button.
        int RightPosition = 1;
        int MiddlePosition = 2;
        int LeftPosition = 3;

        selectLevel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Spinner spinner   = (Spinner)findViewById(R.id.spinner);
                String KanjiLevel = spinner.getSelectedItem().toString();

                String baseDir    = getFilesDir().getAbsolutePath();
                String fileName   = KanjiLevel + ".csv";
                String filePath   = baseDir + File.separator + fileName;

                Questions         = 0;
                CorrectAnswers    = 0;
                NextButton.setVisibility(View.VISIBLE);
                ExampleKanji.setVisibility(View.INVISIBLE);
                LeftKanjiBack.setVisibility(View.INVISIBLE);
                MiddleKanjiBack.setVisibility(View.INVISIBLE);
                RightKanjiBack.setVisibility(View.INVISIBLE);
                ReftKanji.setText("");
                MiddleKanji.setText("");
                RightKanji.setText("");

                Context context = getApplicationContext();
                int id = context.getResources().getIdentifier("start", "drawable", getPackageName());
                image.setImageResource(id);

                // future: read data from CSV files.
                // try (CSVReader csvReader = new CSVReader(new FileReader(filePath))){
                //     String[] values = null;
                //     while ((values = csvReader.readNext()) != null){
                //         Kanjis
                //     }
                // }

                switch(KanjiLevel)
            {
                case "G1_1": Kanjis = KanjisG1_1; break;
                case "G1_2": Kanjis = KanjisG1_2; break;
                case "G2_1": Kanjis = KanjisG2_1; break;
                case "G2_2": Kanjis = KanjisG2_2; break;
                case "G2_3": Kanjis = KanjisG2_3; break;
                case "G3_1": Kanjis = KanjisG3_1; break;
                case "G3_2": Kanjis = KanjisG3_2; break;
                case "G3_3": Kanjis = KanjisG3_3; break;
                case "G3_4": Kanjis = KanjisG3_4; break;
                case "G3_5": Kanjis = KanjisG3_5; break;
                case "G4_1": Kanjis = KanjisG4_1; break;
                case "G4_2": Kanjis = KanjisG4_2; break;
                case "G4_3": Kanjis = KanjisG4_3; break;
                case "G4_4": Kanjis = KanjisG4_4; break;
                case "G4_5": Kanjis = KanjisG4_5; break;
                case "G5_1": Kanjis = KanjisG5_1; break;
                case "G5_2": Kanjis = KanjisG5_2; break;
                case "G5_3": Kanjis = KanjisG5_3; break;
                case "G5_4": Kanjis = KanjisG5_4; break;
                case "G6_1": Kanjis = KanjisG6_1; break;
                case "G6_2": Kanjis = KanjisG6_2; break;
                case "G6_3": Kanjis = KanjisG6_3; break;
                case "G6_4": Kanjis = KanjisG6_4; break;
                case "H1":   Kanjis = KanjisH1;   break;
                case "H2":   Kanjis = KanjisH2;   break;
                case "H3":   Kanjis = KanjisH3;   break;
                case "H4":   Kanjis = KanjisH4;   break;
                case "H5":   Kanjis = KanjisH5;   break;
                case "H6":   Kanjis = KanjisH6;   break;
                case "H7":   Kanjis = KanjisH7;   break;
                case "H8":   Kanjis = KanjisH8;   break;
                case "H9":   Kanjis = KanjisH9;   break;
                case "H10":  Kanjis = KanjisH10;  break;
                case "H11":  Kanjis = KanjisH11;   break;
                case "H12":  Kanjis = KanjisH12;   break;
                case "H13":  Kanjis = KanjisH13;   break;
                case "H14":  Kanjis = KanjisH14;   break;
                case "H15":  Kanjis = KanjisH15;   break;
                default: break;
                }

                CorrectAnswersText.setText(String.valueOf(Questions).concat("/").concat(String.valueOf(Kanjis.length)));

                KanjisLength = Kanjis.length;

                // Export csv files
                // try {

                //     String baseDir = getFilesDir().getAbsolutePath();
                //     String fileName = KanjiLevel + ".csv";
                //     String filePath = baseDir + File.separator + fileName;

                //     // CSV export
                //     CSVWriter writer = new CSVWriter(new FileWriter(filePath), ',');
                //     // feed in your array (or convert your data to an array)
                //     for (String[] strTemp : Kanjis) {
                //         writer.writeNext(strTemp);
                //     }
                //     writer.close();
                // }
                // catch (IOException e){
                //     e.printStackTrace();
                // }
            }
        });

        KanjiAnswerButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextButton.setVisibility(View.VISIBLE);
                ExampleKanji.setVisibility(View.VISIBLE);
                LeftKanjiBack.setVisibility(View.VISIBLE);
                MiddleKanjiBack.setVisibility(View.VISIBLE);
                RightKanjiBack.setVisibility(View.VISIBLE);
                // If this selection is correct added up score.
                if (!LockNumberCount) {
                    if (AnswerPosition == LeftPosition) {
                        CorrectAnswers = CorrectAnswers + 1;
                        // Remove Array elements to prevent duplication
                        Kanjis = ArrayUtils.remove(Kanjis, RandomNumber);
                    }
                }
                LockNumberCount = true;
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
                if (!LockNumberCount) {
                    if (AnswerPosition == MiddlePosition) {
                        CorrectAnswers = CorrectAnswers + 1;
                        // Remove Array elements to prevent duplication
                        Kanjis = ArrayUtils.remove(Kanjis, RandomNumber);
                    }
                }
                LockNumberCount = true;
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
                if (!LockNumberCount) {
                    if (AnswerPosition == RightPosition) {
                        CorrectAnswers = CorrectAnswers + 1;
                        // Remove Array elements to prevent duplication
                        Kanjis = ArrayUtils.remove(Kanjis, RandomNumber);
                    }
                }
                LockNumberCount = true;
            }
        });

        // On click event. If user clicked next button, then change kanji image.
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String CorrectKanji;
                String WrongKanji;
                String WrongKanji2;

                // If reach the end
                if (Kanjis.length > 3) {
                    // Generate random number
                    Random ran = new Random();
                    RandomNumber  = ran.nextInt(Kanjis.length - 0);
                    RandomNumber2 = ran.nextInt(Kanjis.length - 0);
                    RandomNumber3 = ran.nextInt(Kanjis.length - 0);

                    while (RandomNumber == RandomNumber2 || RandomNumber == RandomNumber3){
                        RandomNumber2 = ran.nextInt(Kanjis.length - 0);
                        RandomNumber3 = ran.nextInt(Kanjis.length - 0);
                    }
                    WrongKanji   = Kanjis[RandomNumber2][1];
                    WrongKanji2  = Kanjis[RandomNumber3][1];
                } else {
                    RandomNumber = 0;
                    Kanjis = Finish;
                    WrongKanji   = "";
                    WrongKanji2  = "";
                }

                CorrectKanji = Kanjis[RandomNumber][1];

                // To change images. First get resources, then apply it to specified drawable object.
                Context context = getApplicationContext();
                int id = context.getResources().getIdentifier(Kanjis[RandomNumber][0], "drawable", getPackageName());
                image.setImageResource(id);

                Random ran = new Random();
                int ChoicePosition = ran.nextInt(3 - 0);
                Drawable LeftImage = null;
                Drawable MiddleImage = null;
                Drawable RightImage = null;
                Resources res = getResources();

                switch (ChoicePosition) {
                    case 0:
                        ReftKanji.setText(CorrectKanji);
                        MiddleKanji.setText(WrongKanji);
                        RightKanji.setText(WrongKanji2);
                        LeftImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                        MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        RightImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        AnswerPosition = 3;
                        break;
                    case 1:
                        ReftKanji.setText(WrongKanji);
                        MiddleKanji.setText(CorrectKanji);
                        RightKanji.setText(WrongKanji2);
                        LeftImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                        RightImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        AnswerPosition = 2;
                        break;
                    case 2:
                        ReftKanji.setText(WrongKanji2);
                        MiddleKanji.setText(WrongKanji);
                        RightKanji.setText(CorrectKanji);
                        LeftImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        MiddleImage = ResourcesCompat.getDrawable(res, R.drawable.wrong, null);
                        RightImage = ResourcesCompat.getDrawable(res, R.drawable.correct, null);
                        AnswerPosition = 1;
                        break;
                    default:
                        break;
                }
                ExampleKanji.setText(Kanjis[RandomNumber][0]);

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

                if (KanjisLength < Kanjis.length) {
                    KanjisLength = Kanjis.length;
                }
                CorrectAnswersText.setText(String.valueOf(Kanjis.length - 3).concat("/").concat(String.valueOf(KanjisLength - 3)));
                if (Kanjis == Finish) {
                    CorrectAnswersText.setText("");
                }
                // Count up number of questions
                Questions = Questions + 1;

                // Unlock number count
                LockNumberCount = false;

            }
        });
    }


}