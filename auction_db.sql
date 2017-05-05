CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
INSERT INTO `roles` (`id`, `name`, `description`) VALUES
(1, 'admin', 'Administrator'),
(2, 'landlord', 'Landlord'),
(3, 'tenant', 'Tenant');

CREATE TABLE IF NOT EXISTS `account_statuses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6;   
INSERT INTO `account_statuses` (`id`, `description`) VALUES
(1, 'Active'),
(2, 'Inactive'),
(3, 'Suspended'),
(4, 'Deactivated'),
(5, 'Blocked');

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `cell_no` varchar(50) DEFAULT NULL,  
  `account_status_id` int(11) unsigned NOT NULL,
  `last_login` int(11) unsigned DEFAULT 0,
  `created_on` int(11) unsigned DEFAULT 0,
  `modified_on` int(11) unsigned DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_account_statuses1` FOREIGN KEY (`account_status_id`) REFERENCES `account_statuses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
INSERT INTO `users` (`id`, `user_name`, `password`, `email`, `first_name`, `last_name`, `cell_no`, `account_status_id`) VALUES
(1, 'nazmul', 'password', 'nazmul@gmail.com',  'Nazmul', 'Hasan', '8801678112509', 1),
(2, 'alamgir', 'password', 'alamgir@gmail.com',  'Alamgir', 'Kabir', '8801712341213', 1),
(3, 'redoy', 'password', 'redoy@gmail.com',  'Nazmul', 'Islam', '8801911123456', 1),
(4, 'shem', 'password', 'shem@gmail.com',  'Shem', 'Haye', '8801811123456', 1);


CREATE TABLE IF NOT EXISTS `users_roles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `role_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_users_roles` (`user_id`,`role_id`),
  KEY `fk_users_roles_users1_idx` (`user_id`),
  KEY `fk_users_roles_roles1_idx` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
ALTER TABLE `users_roles`
  ADD CONSTRAINT `fk_users_roles_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_users_roles_roles1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
INSERT INTO `users_roles` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 1),
(5, 2, 2),
(6, 2, 3),
(7, 3, 2),
(8, 4, 3);