CREATE SCHEMA `crow` DEFAULT CHARACTER SET utf8;
CREATE USER `crow`@`%` IDENTIFIED BY 'crow123';
GRANT ALL PRIVILEGES ON `crow`.* to `crow`@`%` identified by 'crow123';
flush PRIVILEGES;

CREATE TABLE `app` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `secret` varchar(45) NOT NULL COMMENT '密钥',
  `name` varchar(45) NOT NULL COMMENT '名称',
  `remark` varchar(45) DEFAULT NULL COMMENT '说明',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `editor` char(32) NOT NULL,
  `creator` char(32) NOT NULL,
  `modify_time` datetime NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接入系统APP名称';

CREATE TABLE `app_user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` varchar(32) NOT NULL COMMENT 'app_id',
  `user_id` varchar(32) NOT NULL COMMENT '业务层用户id',
  `user_name` varchar(512) DEFAULT NULL COMMENT '业务层用户名字',
  `user_logo` varchar(2048) DEFAULT NULL COMMENT '业务层用户头像url',
  `token` char(32) DEFAULT NULL COMMENT '登录token',
  `os_type` varchar(45) NOT NULL COMMENT '来自平台:IOS|ANDROID|PC|H5',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `editor` char(32) NOT NULL,
  `creator` char(32) NOT NULL,
  `modify_time` datetime NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

CREATE TABLE `app_message` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` varchar(32) NOT NULL COMMENT 'app_id',
  `message` varchar(2048) NOT NULL COMMENT '消息内容JSON格式',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `editor` char(32) NOT NULL,
  `creator` char(32) NOT NULL,
  `modify_time` datetime NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天消息';

CREATE TABLE `app_user_message` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` varchar(32) NOT NULL COMMENT 'app_id',
  `owner_app_user_id` bigint(32) NOT NULL COMMENT '消息拥有者',
  `from_id` bigint(32) NOT NULL COMMENT '发送对象',
  `from_type` bigint(32) NOT NULL COMMENT '发送对象类型:ME|OTHER|SYSTEM',
  `to_id` bigint(32) NOT NULL COMMENT '接受对象',
  `to_type` varchar(45) NOT NULL COMMENT '接受对象类型:USER|GROUP',
  `message_id` bigint(32) NOT NULL COMMENT '消息id',
  `status` varchar(45) NOT NULL COMMENT '消息处理状态:NEW|READED|LISTENED|CANCEL|DELETE',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `editor` char(32) NOT NULL,
  `creator` char(32) NOT NULL,
  `modify_time` datetime NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_app_id_owner_app_user_id (`app_id`,`owner_app_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户聊天消息对应关系';

--带整理实现
CREATE TABLE `app_group` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` bigint(32) NOT NULL COMMENT 'app_id',
  `md5` char(32) NOT NULL COMMENT '群成员id拼接md5,用来识别群人员人数变动',
  `name` varchar(512) NULL COMMENT '群组名称',
  `editor` char(32) NOT NULL,
  `creator` char(32) NOT NULL,
  `modify_time` datetime NOT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群组';

CREATE TABLE `app_group_user` (
  `id` char(32) NOT NULL,
  `app_group_id` char(32) NOT NULL,
  `app_user_id` char(32) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_app_group_id` (`app_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群组人员';

CREATE TABLE `app_user_info` (
  `id` char(32) NOT NULL,
  `app_user_id` char(32) DEFAULT NULL,
  `identifier` varchar(45) DEFAULT NULL,
  `os_type` varchar(45) DEFAULT NULL,
  `push_channel_id` varchar(45) DEFAULT NULL COMMENT '用户百度云推送token',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户扩展信息';

CREATE TABLE `store_message` (
  `id` char(32) NOT NULL,
  `app_id` char(32) DEFAULT '00000000000000000000000000000001',
  `chat_key` VARCHAR(66) DEFAULT NULL COMMENT '发送人,接受人,发送人删除标识,接受人删除标识',
  `from_app_user_id` char(32) DEFAULT NULL,
  `to_app_user_id` char(32) DEFAULT NULL,
  `to_app_group_id` char(32) NULL COMMENT '群聊消息的群组id',
  `message` varchar(2048) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'SUCCESS',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX index_chat_key ( `chat_key` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天消息';

CREATE TABLE `message_conversation` (
  `id` char(32) NOT NULL,
  `app_id` char(32) DEFAULT '00000000000000000000000000000001',
  `owner_app_user_id` char(32) NOT NULL,
  `to_id` char(32) NOT NULL COMMENT '对方用户appUserId或者群组Id',
  `to_type` varchar(30) NOT NULL COMMENT 'USER|GROUP',
  `last_message` varchar(2084) DEFAULT NULL,
  `order_level` tinyint(1) DEFAULT NULL COMMENT '会话排列顺序',
  `is_deleted` tinyint(1) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会话表';

CREATE TABLE `app_user_robot` (
  `id` char(32) NOT NULL,
  `app_id` char(32) NOT NULL,
  `app_user_id` char(32) NOT NULL,
  `auto_reply_text` varchar(500) NULL COMMENT '自动回复文本',
  `modify_time` datetime DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='机器人用户表示';

CREATE TABLE `app_group_unsend` (
  `id` char(32) NOT NULL,
  `app_id` char(32) NOT NULL,
  `store_message_id` char(32) NOT NULL,
  `to_app_user_id` char(32) NOT NULL,
  `status` varchar(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='未发送消息';

CREATE TABLE `system_param` (
  `id` char(32) NOT NULL,
  `app_id` char(32) NOT NULL COMMENT 'APPID',
  `name` varchar(200) DEFAULT NULL COMMENT '系统参数名',
  `val` varchar(2000) DEFAULT NULL COMMENT '系统参数值',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(1) DEFAULT NULL,
  `creator` char(32) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数';
