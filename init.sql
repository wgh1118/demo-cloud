-- -------------------------------------------------------------
-- TablePlus 2.9(263)
--
-- https://tableplus.com/
--
-- Database: test
-- Generation Time: 2019-10-15 18:02:50.6380
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
                                      `token_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密的access_token的值',
                                      `token` blob COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
                                      `authentication_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密过的username,client_id,scope',
                                      `user_name` varchar(256) DEFAULT NULL COMMENT '登录的用户名',
                                      `client_id` varchar(256) DEFAULT NULL COMMENT '客户端ID',
                                      `authentication` blob COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据',
                                      `refresh_token` varchar(256) DEFAULT NULL COMMENT 'MD5加密果的refresh_token的值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问令牌表';

DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
                                   `userid` varchar(256) DEFAULT NULL COMMENT '登录的用户名',
                                   `clientid` varchar(256) DEFAULT NULL COMMENT '客户端ID',
                                   `scope` varchar(256) DEFAULT NULL COMMENT '申请的权限',
                                   `status` varchar(10) DEFAULT NULL COMMENT '状态（Approve或Deny）',
                                   `expiresat` datetime DEFAULT NULL COMMENT '过期时间',
                                   `lastmodifiedat` datetime DEFAULT NULL COMMENT '最终修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权记录表';

DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
                                        `client_id` varchar(256) NOT NULL COMMENT '客户端ID',
                                        `resource_ids` varchar(256) DEFAULT NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
                                        `client_secret` varchar(256) DEFAULT NULL COMMENT '客户端密匙',
                                        `scope` varchar(256) DEFAULT NULL COMMENT '客户端申请的权限范围',
                                        `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '客户端支持的grant_type',
                                        `web_server_redirect_uri` varchar(256) DEFAULT NULL COMMENT '重定向URI',
                                        `authorities` varchar(256) DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
                                        `access_token_validity` int(11) DEFAULT NULL COMMENT '访问令牌有效时间值(单位:秒)',
                                        `refresh_token_validity` int(11) DEFAULT NULL COMMENT '更新令牌有效时间值(单位:秒)',
                                        `additional_information` varchar(4096) DEFAULT NULL COMMENT '预留字段',
                                        `autoapprove` varchar(256) DEFAULT NULL COMMENT '用户是否自动Approval操作',
                                        PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户端信息';

DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
                                      `token_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密的access_token值',
                                      `token` blob COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
                                      `authentication_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密过的username,client_id,scope',
                                      `user_name` varchar(256) DEFAULT NULL COMMENT '登录的用户名',
                                      `client_id` varchar(256) DEFAULT NULL COMMENT '客户端ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户端授权令牌表';

DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
                              `code` varchar(256) DEFAULT NULL COMMENT '授权码(未加密)',
                              `authentication` blob COMMENT 'AuthorizationRequestHolder.java对象序列化后的二进制数据'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权码表';

DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
                                       `token_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密过的refresh_token的值',
                                       `token` blob COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据',
                                       `authentication` blob COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='更新令牌表';

DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `user_id` bigint(20) DEFAULT NULL,
                                `create_at` datetime DEFAULT NULL,
                                `price` int(11) DEFAULT NULL,
                                `quantity` int(11) DEFAULT NULL,
                                `create_by` bigint(20) DEFAULT NULL,
                                `update_at` datetime DEFAULT NULL,
                                `update_by` bigint(20) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `permit`;
CREATE TABLE `permit` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `permit` bigint(20) DEFAULT NULL,
                          `code` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `create_at` datetime DEFAULT NULL,
                        `create_by` bigint(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role_2_permit`;
CREATE TABLE `role_2_permit` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `role_id` bigint(20) DEFAULT NULL,
                                 `permit_id` bigint(20) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `create_at` datetime DEFAULT NULL,
                        `phone` varchar(255) DEFAULT NULL,
                        `balance` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_2_role`;
CREATE TABLE `user_2_role` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `user_id` bigint(20) DEFAULT NULL,
                               `role_id` bigint(20) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('test_client', NULL, '$2a$10$2szDKjvKHJCWE6YQNznogOeQF3USZHmCYj1fG7YbfK.vnTgNKLzri', 'read', 'client_credentials,authorization_code,password,refresh_token', 'http://baidu.com', NULL, '7200', '108000', NULL, NULL);

INSERT INTO `role` (`id`, `name`, `create_at`, `create_by`) VALUES ('1', 'Admin', NULL, NULL),
                                                                   ('2', 'Emp', NULL, NULL);

INSERT INTO `user` (`id`, `username`, `password`, `create_at`, `phone`, `balance`) VALUES ('1', 'admin', '$2a$10$y7E.gjuhqpSFir2vvxdl8.6s1Phw/xkryW/20/BRZSBmbKOmfFZx.', '2019-10-15 03:02:13', NULL, '0');

INSERT INTO `user_2_role` (`id`, `user_id`, `role_id`) VALUES ('1', '1', '1');




/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
