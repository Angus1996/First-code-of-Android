package com.angus.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView fruitImageView = (ImageView) findViewById(R.id.fruit_image_view);
        TextView fruitContentText = (TextView) findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(fruitImageView);
        String fruitContent = generateFruitContent(fruitName);
        fruitContentText.setText(fruitContent);
    }

    private String generateFruitContent(String fruitName) {
        StringBuilder fruitContent = new StringBuilder();
        /*for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }*/
        switch (fruitName) {
            case "Apple":
                fruitContent.append("苹果（学名：Malus pumila）是水果的一种，是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果的果实富含矿物质和维生素，是人们经常食用的水果之一。\n" +
                        "苹果是一种低热量食物，每100克只产生60千卡热量。苹果中营养成分可溶性大，易被人体吸收，故有“活水”之称。其有利于溶解硫元素，使皮肤润滑柔嫩 [1]  。据说“每天一苹果，医生远离我”。");
                break;
            case "Banana":
                fruitContent.append("香蕉（学名：Musa nana Lour.）芭蕉科芭蕉属植物，又指其果实，热带地区广泛种植。香蕉味香、富含营养，植株为大型草本，从根状茎发出，由叶鞘下部形成高3～6公尺(10～20尺)的假杆；叶长圆形至椭圆形，有的长达3～3.5公尺(10～11.5尺)，宽65公分(26寸)，10～20枚簇生茎顶。穗状花序下垂 [1]  ，由假杆顶端抽出，花多数，淡黄色；果序弯垂，结果10～20串，约50～150个。植株结果后枯死，由根状茎长出的吸根继续繁殖，每一根株可活多年。原产亚洲东南部，台湾、海南、广东、广西等均有栽培。 [1] ");
                break;
            case "Orange":
                fruitContent.append("橘（英语：Mandarin orange；学名：Citrus reticulata）是芸香科柑橘属的一种水果。“橘”（jú）和“桔”（jú）都是现代汉语规范字，然“桔”作橘子一义时，为“橘”的俗写[1]。在广东的一些方言中二字同音，“桔”也曾做过“橘”的二简字。闽南语称橘为柑仔。西南官话区的各方言中呼为“柑子”或“柑儿”。\n" +
                        "“柑橘”与“橘柑”不同：“柑橘”可以指柑橘属所有水果，包括柚、柑、橘、橙等；而“橘柑”在有些方言中和橘子同义。\n" +
                        "柑和橘都属于芸香科柑橘属的宽皮柑橘类，果实外皮肥厚，内藏瓤瓣，由汁泡和种子构成。李时珍在《本草纲目·果部》中记载：“橘实小，其瓣味微醋（即酸），其皮薄而红，味辛而苦；柑大于橘，其瓣味酢，其皮稍厚而黄，叶辛而甘。”一般说来，柑的果形正圆，黄赤色，皮紧纹细不易剥，多汁甘香；橘的果形扁圆，红或黄色，皮薄而光滑易剥，味微甘酸。柑和橘虽有区别，但在日常语言中常混用，如广柑也说广橘，蜜橘也说蜜柑。\n" +
                        "橘子中的维生素A还能够增强人体在黑暗环境中的视力和治疗夜盲症。橘子不宜食用过量，吃太多会患有胡萝卜素血症，皮肤呈深黄色，如同黄疸一般。若因吃太多橘子造成手掌变黄，只要停吃一段时间，就能让肤色渐渐恢复正常。明代张岱季叔张烨芳对橘子情有独钟，据载其“性好啖橘，橘熟，堆砌床案间，无非橘者，自刊不给，辄命数僮环立剥之”，吃到手脚都呈现黄色。\n");
                break;
            case "Watermelon":
                fruitContent.append("西瓜（学名：Citrullus lanatus (Thunb.) Matsum. et Nakai）一年生蔓生藤本；茎、枝粗壮，具明显的棱。卷须较粗壮，具短柔毛，叶柄粗，密被柔毛；叶片纸质，轮廓三角状卵形，带白绿色，两面具短硬毛，叶片基部心形。雌雄同株。雌、雄花均单生于叶腋。雄花花梗长3-4厘米，密被黄褐色长柔毛；花萼筒宽钟形；花冠淡黄色；雄蕊近离生，花丝短，药室折曲。雌花：花萼和花冠与雄花同；子房卵形，柱头肾形。果实大型，近于球形或椭圆形，肉质，多汁，果皮光滑，色泽及纹饰各式。种子多数，卵形，黑色、红色，两面平滑，基部钝圆，通常边缘稍拱起，花果期夏季。\n" +
                        "中国各地栽培，品种甚多，外果皮、果肉及种子形式多样，以新疆、甘肃兰州、山东德州、江苏东台等地最为有名。其原种可能来自非洲，久已广泛栽培于世界热带到温带，金、元时始传入中国。\n" +
                        "西瓜为夏季之水果，果肉味甜，能降温去暑；种子含油，可作消遣食品；果皮药用，有清热、利尿、降血压之效。");
                break;
            case "Cherry":
                fruitContent.append("樱桃（学名：Cerasus pseudocerasus），是某些李属类植物的统称，包括樱桃亚属、酸樱桃亚属、桂樱亚属等。乔木，高2-6米，树皮灰白色。小枝灰褐色，嫩枝绿色，无毛或被疏柔毛。冬芽卵形，无毛。\n" +
                        "果实可以作为水果食用，外表色泽鲜艳、晶莹美丽、红如玛瑙，黄如凝脂，果实富含糖、蛋白质、维生素及钙、铁、磷、钾等多种元素。\n" +
                        "世界上樱桃主要分布在美国、加拿大、智利、澳洲、欧洲等地，中国主要产地有黑龙江、吉林、辽宁、山东、安徽、江苏、浙江、河南、甘肃、陕西、四川等。 [1] ");
                break;
            case "Pear":
                fruitContent.append("梨为蔷薇科梨属植物，多年生落叶果树，乔木，叶子卵形，花多白色，果子多汁、可食。8-9月间果实成熟时采收，鲜用或切片晒干。主要品种有秋子梨、白梨、沙梨、洋梨四种，多分布在中国华北、东北、西北及长江流域各省。按植物学分类，梨属于蔷薇科植物。梨子偏寒，说到梨子偏寒这问题，研究得深入一点，可知不同种类的梨子性寒程度亦有异。例如我们常吃的天鸭梨偏寒，跟小巧玲珑的香梨和个子较大的贡梨性质差不多，而皮粗的沙梨和进口的啤酒梨，则更寒凉。中国是梨属植物中心发源地之一，亚洲梨属的梨大都源于亚洲东部，日本\n" +
                        "梨\n" +
                        "梨\n" +
                        "和朝鲜也是亚洲梨的原始产地。中国栽培的白梨、沙梨、秋子梨都原产中国。梨有降血压、清热镇凉的作用，梨皮和梨叶、花、根也均可入药，有润肺、消痰、清热、解毒等功效。梨是“百果之宗”，因其鲜嫩多汗、酸甜适口，所以又有“天然矿泉水”之称。");
                break;
            case "Mango":
                fruitContent.append("芒果是杧果 [1]  （中国植物志）的通俗名（拉丁学名：Mangifera indica L.），芒果是一种原产印度的漆树科常绿大乔木，叶革质，互生；花小，杂性，黄色或淡黄色，成顶生的圆锥花序。核果大，压扁，长5-10厘米，宽3-4.5厘米，成熟时黄色，味甜，果核坚硬。\n" +
                        "芒果为著名热带水果之一，芒果果实含有糖、蛋白质、粗纤维，芒果所含有的维生素A的前体胡萝卜素成分特别高，是所有水果中少见的。其次维生素C含量也不低。矿物质、蛋白质、脂肪、糖类等，也是其主要营养成分。可制果汁、果酱、罐头、腌渍、酸辣泡菜及芒果奶粉、蜜饯等。");
                break;
            case "Grape":
                fruitContent.append("葡萄（学名：Vitis vinifera L.）为葡萄科葡萄属木质藤本植物，小枝圆柱形，有纵棱纹，无毛或被稀疏柔毛，叶卵圆形，圆锥花序密集或疏散，基部分枝发达，果实球形或椭圆形，花期4-5月，果期8-9月。\n" +
                        "葡萄是世界最古老的果树树种之一，葡萄的植物化石发现于第三纪地层中，说明当时已遍布于欧、亚及格陵兰。 [1]  葡萄原产亚洲西部，世界各地均有栽培， [2]  世界各地的葡萄约95%集中分布在北半球。 [3] \n" +
                        "葡萄为著名水果，生食或制葡萄干，并酿酒，酿酒后的酒脚可提酒食酸，根和藤药用能止呕、安胎。 [2] ");
                break;
            case "Strawberry":
                fruitContent.append("草莓（学名：Fragaria × ananassa Duch.），多年生草本植物。高10-40厘米，茎低于叶或近相等，密被开展黄色柔毛。叶三出，小叶具短柄，质地较厚，倒卵形或菱形，上面深绿色，几无毛，下面淡白绿色，疏生毛，沿脉较密；叶柄密被开展黄色柔毛。聚伞花序，花序下面具一短柄的小叶；花两性；萼片卵形，比副萼片稍长；花瓣白色，近圆形或倒卵椭圆形。聚合果大，宿存萼片直立，紧贴于果实；瘦果尖卵形，光滑。花期4-5月，果期6-7月 [1]  。\n" +
                        "原产南美，中国各地及欧洲等地广为栽培。草莓营养价值高，含有多种营养物质 ，且有保健功效。");
                break;
            case "Pineapple":
                fruitContent.append("菠萝（学名：Ananas comosus），是热带水果之一。福建和台湾地区称之为旺梨或者旺来（ông-lâi），新马一带称为黄梨，大陆及香港称作菠萝。有70多个品种，岭南四大名果之一。\n" +
                        "菠萝原产于南美洲巴西、巴拉圭的亚马逊河流域一带，16世纪从巴西传入中国。 现在已经流传到整个热带地区。其可食部分主要由肉质增大之花序轴、螺旋状排列于外周的花组成，花通常不结实，宿存的花被裂片围成一空腔，腔内藏有萎缩的雄蕊和花柱。叶的纤维甚坚韧，可供织物、制绳、结网和造纸。 [1] \n" +
                        "凤梨与菠萝在生物学上是同一种水果。 [2]  市场上，凤梨与菠萝为不同品种水果：菠萝削皮后有“内刺”需要剔除；而凤梨消掉外皮后没有“内刺”，不需要刀到划出一道道沟。 [3] ");
                break;
            default:
                break;
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
