# 菜单
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (1, '影视管理', null, 'movie', 2, 'ic:baseline-album', 0, null, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (2, '采集源管理', '/movie/source-config', 'sourceConfig', 1, 'ic:baseline-save-all', 1, 1, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (4, '新增采集源', null, 'addSourceConfig', 3, null, 2, 2, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (5, '映射管理', '/movie/mapping', 'mapping', 1, 'ic:baseline-extension', 1, 1, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (6, '采集管理', '/movie/collect-task', 'collectTask', 1, 'ic:baseline-article', 1, 1, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (7, '影片管理', '/movie/manage', 'manage', 1, 'ic:outline-duo', 1, 1, 4);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (8, '影片详情', '/movie/detail:id', 'detail', 1, 'ic:baseline-camera', 1, 1, 5);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (13, '分类管理', '/category', 'category', 1, 'ic:baseline-permission', 0, null, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (15, '账户管理', null, 'account', 2, 'ic:baseline-how-to-reg', 0, null, 4);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (16, '用户管理', '/account/user', 'user', 1, 'ic:outline-how-to-reg', 1, 15, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (17, '角色管理', '/account/role', 'role', 1, 'ic:outline-insert-emoticon', 1, 15, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (18, '菜单管理', '/account/permission', 'permission', 1, 'ic:sharp-attachment', 1, 15, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (19, '删除采集源', null, 'deleteSourceConfig', 3, null, 2, 2, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (20, '修改采集源', null, 'updateSourceConfig', 3, null, 2, 2, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (21, '查询采集源', null, 'querySourceConfig', 3, null, 2, 2, 4);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (22, '查询映射', null, 'queryMapping', 3, null, 2, 5, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (23, '新增映射', null, 'addMapping', 3, null, 2, 5, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (25, '查询采集任务', null, 'queryCollectTask', 3, null, 2, 6, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (26, '操作采集任务', null, 'operateCollectTask', 3, null, 2, 6, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (27, '新增采集任务', null, 'addCollectTask', 3, null, 2, 6, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (28, '删除映射', null, 'deleteMapping', 3, null, 2, 5, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (29, '查询影片', null, 'queryMovie', 3, null, 2, 7, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (30, '新增影片', null, 'addMovie', 3, null, 2, 7, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (31, '删除影片', null, 'deleteMovie', 3, null, 2, 7, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (32, '修改影片', null, 'updateMovie', 3, null, 2, 7, 4);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (33, '新增分类', null, 'addCategory', 3, null, 1, 13, 1);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (34, '删除分类', null, 'deleteCategory', 3, null, 1, 13, 2);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (35, '修改分类', null, 'updateCategory', 3, null, 1, 13, 3);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (36, '查询分类', null, 'queryCategory', 3, null, 1, 13, 4);
INSERT INTO dunhao.permission (id, menu_name, url, permission, type, icon, level, parent_id, sort) VALUES (37, '工作台', '/workbench', 'workbench', 1, 'mdi:home', 0, null, 1);

# 用户
INSERT INTO dunhao.user (id, username, password, phone, email, avatar, sex, create_time, update_time, state) VALUES (1, 'admin', 'qwer1234', '15111978641', '574399358@qq.com', null, 0, '2023-08-19 21:27:30', '2023-09-02 23:16:22', 1);
INSERT INTO dunhao.user (id, username, password, phone, email, avatar, sex, create_time, update_time, state) VALUES (2, 'dunhao', 'qwer1234', '15111978641', 'listyle36@163.com', null, 1, '2023-08-26 21:37:18', '2023-08-29 19:59:00', 1);
INSERT INTO dunhao.user (id, username, password, phone, email, avatar, sex, create_time, update_time, state) VALUES (5, 'liwell', 'qwer1234', '15111978641', '574399358@qq.com', null, 1, '2023-09-02 23:16:05', '2023-09-02 23:56:31', 1);

# 用户角色
INSERT INTO dunhao.user_role (id, user_id, role_id) VALUES (1, 1, 3);
INSERT INTO dunhao.user_role (id, user_id, role_id) VALUES (2, 2, 4);
INSERT INTO dunhao.user_role (id, user_id, role_id) VALUES (3, 3, 1);
INSERT INTO dunhao.user_role (id, user_id, role_id) VALUES (4, 4, 1);
INSERT INTO dunhao.user_role (id, user_id, role_id) VALUES (5, 5, 1);

# 角色
INSERT INTO dunhao.role (id, role_name, code) VALUES (1, '管理员', 'admin');
INSERT INTO dunhao.role (id, role_name, code) VALUES (2, '游客', 'visitor');
INSERT INTO dunhao.role (id, role_name, code) VALUES (3, '会员', 'vip');
INSERT INTO dunhao.role (id, role_name, code) VALUES (4, '普通用户', 'user');

# 角色菜单
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (74, 1, 1);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (75, 1, 2);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (76, 1, 21);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (77, 1, 20);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (78, 1, 19);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (79, 1, 4);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (80, 1, 5);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (81, 1, 22);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (82, 1, 23);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (83, 1, 28);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (84, 1, 6);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (85, 1, 25);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (86, 1, 26);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (87, 1, 27);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (88, 1, 7);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (89, 1, 8);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (90, 1, 13);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (91, 1, 15);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (92, 1, 16);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (93, 1, 17);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (94, 1, 18);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (95, 1, 29);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (96, 1, 30);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (97, 1, 31);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (98, 1, 32);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (99, 1, 33);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (100, 1, 34);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (101, 1, 35);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (102, 1, 36);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (103, 1, 37);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (104, 4, 1);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (105, 4, 7);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (106, 4, 29);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (107, 4, 8);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (108, 4, 37);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (109, 3, 37);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (110, 3, 1);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (111, 3, 2);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (112, 3, 4);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (113, 3, 19);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (114, 3, 20);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (115, 3, 21);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (116, 3, 5);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (117, 3, 22);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (118, 3, 23);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (119, 3, 28);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (120, 3, 6);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (121, 3, 25);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (122, 3, 26);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (123, 3, 27);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (124, 3, 7);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (125, 3, 29);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (126, 3, 30);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (127, 3, 31);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (128, 3, 32);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (129, 3, 8);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (130, 3, 13);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (131, 3, 33);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (132, 3, 34);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (133, 3, 35);
INSERT INTO dunhao.role_menu (id, role_id, menu_id) VALUES (134, 3, 36);

# 分类
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (1, '电影', 1, null, 0);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (2, '剧集', 2, null, 0);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (3, '动漫', 3, null, 0);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (4, '综艺', 4, null, 0);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (5, '专题', 5, null, 0);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (6, '动作片', 1, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (7, '科幻片', 2, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (8, '喜剧片', 3, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (9, '爱情片', 4, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (10, '剧情片', 5, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (11, '悬疑片', 6, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (12, '惊悚片', 7, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (13, '战争片', 8, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (14, '纪录片', 11, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (15, '犯罪片', 9, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (16, '灾难片', 10, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (17, '动画片', 12, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (18, '其他', 13, 1, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (19, '国产剧', 1, 2, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (20, '港台剧', 2, 2, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (21, '日韩剧', 3, 2, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (22, '欧美剧', 4, 2, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (23, '海外剧', 5, 2, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (24, '国产动漫', 1, 3, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (25, '日本动漫', 2, 3, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (26, '欧美动漫', 3, 3, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (27, '海外动漫', 4, 3, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (28, '大陆综艺', 1, 4, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (29, '港台综艺', 2, 4, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (30, '日韩综艺', 3, 4, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (31, '欧美综艺', 4, 4, 1);
INSERT INTO dunhao.category (id, name, sort, parent, level) VALUES (32, '其他', 5, 4, 1);

# 采集源
INSERT INTO dunhao.source_config (id, source_name, list_url, detail_url, state) VALUES (1, 'ikun', 'https://ikunzyapi.com/api.php/provide/vod?ac=list', 'https://ikunzyapi.com/api.php/provide/vod?ac=detail', 1);
INSERT INTO dunhao.source_config (id, source_name, list_url, detail_url, state) VALUES (2, '量子资源', 'https://cj.lziapi.com/api.php/provide/vod/?ac=list', 'https://cj.lziapi.com/api.php/provide/vod/?ac=detail', 1);
