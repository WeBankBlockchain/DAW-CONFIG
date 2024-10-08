CREATE TABLE `t_app_update_info` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `version` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'App版本号',
  `android_url` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '安卓下载链接',
  `ios_url` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'IOS下载链接',
  `intro_url` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '介绍链接',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `version` (`version`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `t_asset_info` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `network_name` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `contract_address` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `asset_name` varchar(256) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `asset_symbol` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `asset_type` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `asset_icon` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `asset_status` smallint(6) NOT NULL DEFAULT 0,
  `asset_config` text COLLATE utf8mb4_bin NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `asset_symbol` (`asset_symbol`),
  KEY `idx_asset_status` (`asset_status`),
  KEY `idx_network_name` (`network_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `t_asset_series` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `series_name` varchar(64) NOT NULL DEFAULT '',
  `series_icon` varchar(512) NOT NULL DEFAULT '',
  `series_type` varchar(64) NOT NULL DEFAULT '',
  `contract_address` varchar(300) NOT NULL DEFAULT '',
  `status` smallint(6) NOT NULL DEFAULT 0 COMMENT '0: 正常, 1: 已销户',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`pk_id`),
  KEY `series_type` (`series_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;



CREATE TABLE `t_banner_info` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '名称',
  `url` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '链接',
  `img` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '图片链接',
  `priority` smallint(6) NOT NULL DEFAULT '1000' COMMENT '优先级',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '0-启用；1-不启用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `t_explore_info` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '名称',
  `title` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '描述',
  `url` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '链接',
  `icon` varchar(512) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'icon url',
  `priority` smallint(6) NOT NULL DEFAULT '1000' COMMENT '优先级',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '0-启用；1-不启用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `t_hk_email_code` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(190) NOT NULL DEFAULT '',
  `verification_code` varchar(16) NOT NULL DEFAULT '',
  `verified` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0: 未验证, 1: 已验证',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `t_hk_user` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(190) NOT NULL DEFAULT '',
  `first_name` varchar(128) NOT NULL DEFAULT '',
  `last_name` varchar(128) NOT NULL DEFAULT '',
  `company` varchar(128) NOT NULL DEFAULT '',
  `phone_code` varchar(8) NOT NULL DEFAULT '',
  `phone_number` varchar(32) NOT NULL DEFAULT '',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '0: 正常, 1: 已销户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;


CREATE TABLE `t_mnemonic_info` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户id',
  `key_type` smallint(6) NOT NULL DEFAULT '0',
  `encrypt_mn` varchar(1024) COLLATE utf8mb4_bin NOT NULL DEFAULT '加密后的助记词',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


