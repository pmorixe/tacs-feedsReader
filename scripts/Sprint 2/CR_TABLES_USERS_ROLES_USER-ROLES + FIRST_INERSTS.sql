CREATE TABLE `users` (  
  `id` int(6) NOT NULL AUTO_INCREMENT,  
  `username` varchar(20) NOT NULL,  
  `password` varchar(20) NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8; 

CREATE TABLE `roles` (  
  `id` int(6) NOT NULL AUTO_INCREMENT,  
  `role` varchar(20) NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;  
  
 
CREATE TABLE `user_roles` (  
  `user_id` int(6) NOT NULL,  
  `role_id` int(6) NOT NULL,  
  KEY `user` (`user_id`),  
  KEY `role` (`role_id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  

INSERT INTO roles (role) VALUES ('admin'), ('moderator');  
  
INSERT INTO users (USERNAME, PASSWORD) VALUES ('moder', 'moder'), ('admin', 'admin');  
  
/*INSERT INTO user_roles (user_id, role_id) VALUES (5, 6), (6, 5);  */

ALTER TABLE entry ADD COLUMN important BIT;


ALTER TABLE users ADD FIRSTNAME VARCHAR(60);
ALTER TABLE users ADD LASTNAME VARCHAR(60);
ALTER TABLE users ADD EMAIL VARCHAR(60);


create table UserConnection (userId varchar(255) not null,
        providerId varchar(255) not null,
        providerUserId varchar(255),
        rank int not null,
        displayName varchar(255),
        profileUrl varchar(512),
        imageUrl varchar(512),
        accessToken varchar(255) not null,                                        
        secret varchar(255),
        refreshToken varchar(255),
        expireTime bigint,
        primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);