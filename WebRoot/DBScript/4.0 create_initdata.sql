--
-- 转存表中的数据 `t_tgks_common_user`
--

INSERT INTO `t_tgks_common_user` (`id`, `username`, `password`, `status`, `type`, `email`, `name`, `sex`, `groupid`, `createtime`) VALUES
('UMSX20141206012303000001', 'KRSMA', '123456', '1', '0', 'KRSMA', 'KRSMA', '0', NULL, '2014-12-05 17:23:03');


--
-- 转存表中的数据 `t_tgks_common_menu`
--

INSERT INTO `t_tgks_common_menu` (`id`, `preid`, `name`, `status`, `url`, `level`, `sort`) VALUES
('COMM20141205024116000001', '0', 'MARZ管理系统', '1', '#', '1', '3300'),
('COMM20141206020826000010', 'COMM20141205024116000001', '卡密管理', '1', '../mar/passwordCardManager.action', '2', '3300'),
('COMM20141206020826000011', 'COMM20141205024116000001', '卡牌管理', '1', '../mar/krsmaCardManager.action', '2', '3301'),
('COMM20141206020826000012', 'COMM20141205024116000001', '初始管理', '1', '../mar/accountManager.action', '2', '3302');

--
-- 转存表中的数据 `t_tgks_mar_krsmacard`
--

INSERT INTO `t_tgks_mar_krsmacard` (`id`, `cardId`, `name`, `nickName`, `type`, `rarity`, `imageUrl`, `iconUrl`) VALUES
('MARZ20141210204946000002', '10000056', '制圧型パーシヴァル', '香菜', '1', 'UR', 'http://img03.taobaocdn.com/imgextra/i3/180967979/TB2MAbUbXXXXXbzXpXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/239/thumb_upload.png'),
('MARZ20141210205029000004', '10000151', '虚無型エターナル フレイム', '虚无', '1', 'UR', 'http://img02.taobaocdn.com/imgextra/i2/180967979/TB2cRnYbXXXXXbvXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/141/thumb_upload.png'),
('MARZ20141210205130000007', '10003007', '蹴球型リドルグレイ', '小灰人 外星人', '1', 'UR', 'http://img01.taobaocdn.com/imgextra/i1/180967979/TB26BLZbXXXXXaQXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/365/thumb_upload.png'),
('MARZ20141210205247000010', '10001031', '特異型シグルーン', '女武神', '2', 'UR', 'http://img01.taobaocdn.com/imgextra/i1/180967979/TB287rWbXXXXXctXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/151/thumb_upload.png'),
('MARZ20141210212932000012', '10000164', '制圧型ゴッドフリーと', '暗富豪', '2', 'UR', 'http://img02.taobaocdn.com/imgextra/i2/180967979/TB2SBnUbXXXXXblXpXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/259/thumb_upload.png'),
('MARZ20141210213014000014', '10001033', '特異型ジャンヌグルク', '贞德 神威', '2', 'UR', 'http://img04.taobaocdn.com/imgextra/i4/180967979/TB2FL2ZbXXXXXbfXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/251/thumb_upload.png'),
('MARZ20141210213943000016', '10000141', '複製型クーホリン', '枪兵', '2', 'UR', 'http://img02.taobaocdn.com/imgextra/i2/180967979/TB2J2v0bXXXXXafXpXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/018/942/thumb_upload.jpg'),
('MARZ20141210214009000018', '10001029', '特異型卑弥呼', '卑弥呼', '3', 'UR', 'http://img01.taobaocdn.com/imgextra/i1/180967979/TB2CubYbXXXXXbOXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/261/thumb_upload.png'),
('MARZ20141210221628000020', '10001035', '第二型コルグリヴァんス', '盾娘', '3', 'UR', 'http://img03.taobaocdn.com/imgextra/i3/180967979/TB2lyjYbXXXXXbfXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/241/thumb_upload.png'),
('MARZ20141210221718000023', '10003009', '争杯型パーシヴァル', '水香菜', '3', 'UR', 'http://img03.taobaocdn.com/imgextra/i3/180967979/TB2YlvVbXXXXXXxXpXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/367/thumb_upload.png'),
('MARZ20141210222258000025', '10000300', '帰化型二ムエ', '妮妙 妮莎', '3', 'UR', 'http://img04.taobaocdn.com/imgextra/i4/180967979/TB2ltn3bXXXXXX.XXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/018/948/thumb_upload.jpg'),
('MARZ20141210222519000027', '10000052', '制圧型ローエングリン', '白鸟', '4', 'UR', 'http://img01.taobaocdn.com/imgextra/i1/180967979/TB2u76ZbXXXXXaOXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/149/thumb_upload.png'),
('MARZ20141210222541000029', '10000063', '制圧型エニード', '小黄书', '4', 'UR', 'http://img04.taobaocdn.com/imgextra/i4/180967979/TB2OkPVbXXXXXXrXpXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/249/thumb_upload.png'),
('MARZ20141210222621000031', '10002005', '支援型クレア', '克莱尔', '4', 'UR', 'http://img03.taobaocdn.com/imgextra/i3/180967979/TB2Oj_ZbXXXXXaUXXXXXXXXXXXX_!!180967979.jpg', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/139/thumb_upload.png'),
('MARZ20141212190059000003', '10000073', '第二型バーナード', '', '3', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/267/thumb_upload.png'),
('MARZ20141212190213000005', '10000115', '特異型ディートリヒ', '', '2', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/173/thumb_upload.png'),
('MARZ20141212190307000007', '10000129', '支援型オルウェン', '', '1', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/145/thumb_upload.png'),
('MARZ20141212190428000009', '10000214', 'シアナ', '', '4', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/313/thumb_upload.png'),
('MARZ20141212190517000012', '10001023', '特殊型ゴルロイス', '', '1', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/018/941/thumb_upload.jpg'),
('MARZ20141212190612000014', '10001057', '特異型甲斐姫', '', '2', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/018/940/thumb_upload.jpg'),
('MARZ20141212190738000017', '10002019', '妖精ムリアン', '', '4', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/018/949/thumb_upload.jpg'),
('MARZ20141212192951000001', '10000097', '支援型ガネイダ', '', '3', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/264/thumb_upload.png'),
('MARZ20141212193055000003', '10000111', '特異型リトルグレイ', '', '4', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/247/thumb_upload.png'),
('MARZ20141212193408000005', '10000154', '支援型エヴェイン', '', '4', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/282/thumb_upload.png'),
('MARZ20141212193508000007', '10000171', '複製型漁夫王', '', '1', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/255/thumb_upload.png'),
('MARZ20141212193556000009', '10001025', '第二型ディナダン', '', '4', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/235/thumb_upload.png'),
('MARZ20141213124342000001', '10000177', '支援型ラグネル', '', '2', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/300/thumb_upload.png'),
('MARZ20141213124443000003', '10002001', '第二型ローンファル', '', '3', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/245/thumb_upload.png'),
('MARZ20141213220408000007', '10000157', '制御型ベディヴィア', '', '4', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/285/thumb_upload.png'),
('MARZ20141216005440000047', '10000094', '支援型イテール', '', '1', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/170/thumb_upload.png'),
('MARZ20141216005554000049', '10000133', '第二型マルク', '', '2', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/135/thumb_upload.png'),
('MARZ20141216010003000051', '10001008', '第二型クラッキー', '猫娘 燃萌', '1', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/137/thumb_upload.png'),
('MARZ20141216010204000053', '10000066', '第二型メレアガンス', '', '3', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/303/thumb_upload.png'),
('MARZ20141216010737000055', '10000058', '第二型エレック', '', '3', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/237/thumb_upload.png'),
('MARZ20141216011541000057', '10000087', '支援型金髪のイゾルデ', '', '3', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/257/thumb_upload.png'),
('MARZ20141216012620000059', '10001014', '第二型トール', '光剑', '2', 'SR', '', 'http://cdn.wiki.famitsu.com/files/attachment/000/015/147/thumb_upload.png');