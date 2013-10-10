delimiter $$ 
 
CREATE TABLE subscription ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  url varchar(300) DEFAULT NULL, 
  since timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  PRIMARY KEY (id) 
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8
$$

delimiter $$ 
 
CREATE TABLE feed ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  title varchar(200) DEFAULT NULL,
  url varchar(200) DEFAULT NULL,
  copyright varchar(200) DEFAULT NULL,
  language varchar(200) DEFAULT NULL,
  pubDate varchar(80) DEFAULT NULL,
  summary varchar(200) DEFAULT NULL,
  createdDate datetime DEFAULT NULL,
  idSubscription int(11) DEFAULT NULL, 
  PRIMARY KEY (id), 
  KEY fk_feed_subscription (idSubscription), 
  CONSTRAINT fk_feed_subscription FOREIGN KEY (idSubscription) REFERENCES subscription (id) ON DELETE NO ACTION ON UPDATE NO ACTION 
) ENGINE=InnoDB DEFAULT CHARSET=utf8
$$

delimiter $$ 
 
CREATE TABLE entry ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  title varchar(1000) DEFAULT NULL,
  description longtext DEFAULT NULL,
  link varchar(200) DEFAULT NULL,
  author longtext DEFAULT NULL,
  guid longtext DEFAULT NULL,
    idFeed int,
  PRIMARY KEY (id), 
  KEY fk_entry_feed (idFeed), 
  CONSTRAINT fk_entry_feed FOREIGN KEY (idFeed) REFERENCES feed (id) ON DELETE NO ACTION ON UPDATE NO ACTION 
) ENGINE=InnoDB DEFAULT CHARSET=utf8
$$