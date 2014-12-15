package com.moemao.tgks.mar.tool;

public class MarConstant
{
    public static final String MODULE_TAG = "MARZ";
    
    public static final String KRSMA_SPLIT = "=";
    
    public static final String LOG_SYSTEM_INFO = "[ System Info ] ";
    
    public static final String INITIAL_NAME = "Asuna";
    
    public static final String INITIAL_CHARA = "3";

    public static final String GACHA_ID_TEN = "20000300";
    
    public static final String GACHA_ID_ELEVEN = "20000210";
    
    public static final String GACHA_PAYTYPE = "3";
    /**
     * 未使用
     */
    public static final String PASSWORDCARD_STATUS_0 = "0";
    /**
     * 使用中
     */
    public static final String PASSWORDCARD_STATUS_1 = "1";
    /**
     * 已使用
     */
    public static final String PASSWORDCARD_STATUS_2 = "2";
    
    /**
     * 新建
     */
    public static final String ACCOUNT_STATUS_0 = "0";
    /**
     * 执行中
     */
    public static final String ACCOUNT_STATUS_1 = "1";
    /**
     * 已完成
     */
    public static final String ACCOUNT_STATUS_2 = "2";
    /**
     * 已售出
     */
    public static final String ACCOUNT_STATUS_3 = "3";

    /**
     * KRSMA卡片职业 佣兵
     */
    public static final String KRSMACARD_TYPE_1 = "1";
    /**
     * KRSMA卡片职业 富豪
     */
    public static final String KRSMACARD_TYPE_2 = "2";
    /**
     * KRSMA卡片职业 盗贼
     */
    public static final String KRSMACARD_TYPE_3 = "3";
    /**
     * KRSMA卡片职业 歌姬
     */
    public static final String KRSMACARD_TYPE_4 = "4";
    
    /**
     * 注册
     */
    public static final String URL_REGIST = "https://app.login.kairisei-ma.jp:443/Auth/login.php";

    /**
     * 登录
     */
    public static final String URL_LOGIN = "https://app.login.kairisei-ma.jp:443/Auth/login.php";

    /**
     * 连接
     */
    public static final String URL_CONNECT = "http://app.kairisei-ma.jp/Game/Connect";

    /**
     * 选职起名
     */
    public static final String URL_USERCREATE = "http://app.kairisei-ma.jp/Game/UserCreate";

    /**
     * 主界面
     */
    public static final String URL_HOMESHOW = "http://app.kairisei-ma.jp/Game/HomeShow";

    /**
     * 输入招待号
     */
    public static final String URL_INVITECODEENTER = "http://app.kairisei-ma.jp/Game/InviteCodeEnter";

    /**
     * 批量收取礼物
     */
    public static final String URL_PRESENTBOXMULTIRECV = "http://app.kairisei-ma.jp/Game/PresentBoxMultiRecv";
    
    /**
     * 抽卡准备
     */
    public static final String URL_GACHASHOW= "http://app.kairisei-ma.jp/Game/GachaShow";
    
    /**
     * 抽卡
     */
    public static final String URL_GACHAPLAY = "http://app.kairisei-ma.jp/Game/GachaPlay";

    /**
     * 卡组信息
     */
    public static final String URL_CARDSHOW = "http://app.kairisei-ma.jp/Game/CardShow";

    /**
     * 卡片合成
     */
    public static final String URL_CARDFUSION = "http://app.kairisei-ma.jp/Game/CardFusion";
    
    /**
     * 卡片触手
     */
    public static final String URL_CARDSELL = "http://app.kairisei-ma.jp/Game/CardSell";

    /**
     * 战斗信息 单人
     */
    public static final String URL_TEAMBATTLESOLOSHOW = "http://app.kairisei-ma.jp/Game/TeamBattleSoloShow";

    /**
     * 战斗开始 单人
     */
    public static final String URL_TEAMBATTLESOLOSTART = "http://app.kairisei-ma.jp/Game/TeamBattleSoloStart";

    /**
     * 战斗结束 单人
     */
    public static final String URL_TEAMBATTLESOLOEND = "http://app.kairisei-ma.jp/Game/TeamBattleSoloEnd";
    
    /**
     * 探索
     */
    public static final String URL_EXPLORESTART = "http://app.kairisei-ma.jp/Game/ExploreStart";
    
    /**
     * 初始地图
     */
    public static final String BATTLESOLOSTART_10000101 = "10000101";
    public static final String BATTLESOLOEND_10000101 = "{\"progress\":3,\"is_clear\":1,\"input_cmd\":[\"40967,12,1,-1094478231\\n40967,13,1,1688423108,-307924438,-1109076503,-98282593,1363694209,702014236,1530950256,-1479841701,1882375902,339297594\\n40967,12,2,-2123006695\\n40967,13,2,1858030861,1609098183,111631633,1702686679,-1667121605,-14857794,-1145761117,-589054781,1152635910,927187480\\n40967,12,3,987772800\\n40967,13,3,-1198360069,1289591036,-2108788831,-1058316615,-1115372015,358882571,330731556,40545635,2125183240,-2111758011\\n40967,12,4,-720601786\\n40967,13,4,1215020716,189195468,1300725195,-1638505336,-580282773,-228619101,1454281141,-1287719137,-1548365682,-642815099\\n40967,14,5,-124786120,-689087767\\n40967,14,6,-124786120,-689087767\\n40967,14,7,-124786120,-689087767\\n40967,14,8,-1136481224,1602949194\\n40967,15,-117239005\\n40967,10\\n40967,0\\n40967,3,4\\n40967,3,3\\n40967,3,2\\n40967,3,1\\n40967,6\\n40967,1\\n40297,10\\n40297,0\\n40297,3,4\\n40297,3,3\\n40297,3,2\\n40297,3,1\\n40297,6\\n\",\"40297,12,1,-1094478231\\n40297,13,1,1688423108,-307924438,-1109076503,-98282593,1363694209,702014236,1530950256,-1479841701,1882375902,339297594\\n40297,12,2,-2123006695\\n40297,13,2,1858030861,1609098183,111631633,1702686679,-1667121605,-14857794,-1145761117,-589054781,1152635910,927187480\\n40297,12,3,987772800\\n40297,13,3,-1198360069,1289591036,-2108788831,-1058316615,-1115372015,358882571,330731556,40545635,2125183240,-2111758011\\n40297,12,4,-720601786\\n40297,13,4,1215020716,189195468,1300725195,-1638505336,-580282773,-228619101,1454281141,-1287719137,-1548365682,-642815099\\n40297,14,5,-124786120,-689087767\\n40297,14,6,-124786120,-689087767\\n40297,14,7,-124786120,-689087767\\n40297,14,8,-1136481224,1602949194\\n40297,15,-117239005\\n40297,10\\n40297,0\\n40297,3,4\\n40297,3,3\\n40297,3,2\\n40297,3,1\\n40297,6\\n40297,1\\n38957,10\\n38957,0\\n38957,3,4\\n38957,3,3\\n38957,3,2\\n38957,3,1\\n38957,6\\n\",\"38957,12,1,-1094478231\\n38957,13,1,1688423108,-307924438,-1109076503,-98282593,1363694209,702014236,1530950256,-1479841701,1882375902,339297594\\n38957,12,2,-2123006695\\n38957,13,2,1858030861,1609098183,111631633,1702686679,-1667121605,-14857794,-1145761117,-589054781,1152635910,927187480\\n38957,12,3,987772800\\n38957,13,3,-1198360069,1289591036,-2108788831,-1058316615,-1115372015,358882571,330731556,40545635,2125183240,-2111758011\\n38957,12,4,-720601786\\n38957,13,4,1215020716,189195468,1300725195,-1638505336,-580282773,-228619101,1454281141,-1287719137,-1548365682,-642815099\\n38957,14,5,-2094684080,-689087767\\n38957,14,6,-2094684080,-689087767\\n38957,14,7,-1136481224,1602949194\\n38957,14,8,-1136481224,1602949194\\n38957,15,-117239005\\n38957,10\\n38957,0\\n38957,3,4\\n38957,3,3\\n38957,3,2\\n38957,3,1\\n38957,6\\n38957,1\\n37437,10\\n37437,0\\n37437,3,4\\n37437,3,3\\n37437,3,2\\n37437,3,1\\n37437,6\\n\"],\"enemy_dead_bit\":[7,7,7]}";
    
    /**
     * 水龙 卑弥呼掉落
     */
    public static final String BATTLESOLOSTART_HIMIKO = "30010204";
    public static final String BATTLESOLOEND_HIMIKO = "{\"progress\":1,\"is_clear\":1,\"input_cmd\":[\"86092,12,1,-345701819\\n86092,13,1,918288534,1317022023,-1381316606,1323454491,930281386,-2099391674,-1011425084,-310330939,341901425,1778302089\\n86092,12,2,1679576390\\n86092,13,2,-1921566795,694835855,-136369704,-1536331276,885303797,938689926,736685983,-478098567,805622766,1059701364\\n86092,12,3,1711516929\\n86092,13,3,-1354214784,-1536331276,-1052474299,-423306017,96906387,206897531,-788319515,-654049063,-1197097309,837295655\\n86092,12,4,-678391685\\n86092,13,4,1059701364,1646477942,-863242427,885303797,1501455446,-1536331276,-1100482971,-569432478,1809517484,417860889\\n86092,14,5,-1811517166,-53851249\\n86092,14,6,1652470028,-1101633416\\n86092,14,7,683261599,-1719796844\\n86092,14,8,-1136481224,1602949194\\n86092,15,-117239005\\n86092,10\\n86092,0\\n86092,3,4\\n86092,3,3\\n86092,3,2\\n86092,2,1,0,0,0,0,8,0,0,0,0,6\\n86092,6\\n86092,1\\n75792,10\\n75792,0\\n75792,3,4\\n75792,3,3\\n75792,3,2\\n75792,2,1,0,0,0,0,7,0,0,0,0,6\\n75792,6\\n75792,1\\n64792,10\\n64792,0\\n64792,3,4\\n64792,3,3\\n64792,3,2\\n64792,2,1,0,0,6,0,0,0,0,5,0,0\\n64792,6\\n64792,1\\n44532,10\\n44532,0\\n47847,3,4\\n47847,3,3\\n47847,3,2\\n47847,2,1,3,0,0,0,0,6,0,0,0,0\\n47847,6\\n80817,1\\n78607,10\\n78607,0\\n78607,3,4\\n78607,3,3\\n78607,3,2\\n78607,2,1,0,0,0,4,9,0,0,0,7,7\\n78607,6\\n80817,1\\n78607,10\\n78607,0\\n78607,3,4\\n78607,3,3\\n78607,3,2\\n78607,2,1,0,0,5,0,6,0,0,1,0,5\\n78607,6\\n\"],\"enemy_dead_bit\":[7]}";
    
}
