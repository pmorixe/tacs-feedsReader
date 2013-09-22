delimiter $$ 
 
CREATE TABLE subscription ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  url varchar(45) DEFAULT NULL, 
  since timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  description varchar(100) DEFAULT NULL, 
  category varchar(100) DEFAULT NULL, 
  PRIMARY KEY (id) 
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8
$$

delimiter $$ 
 
CREATE TABLE feed ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  idSubscription int(11) DEFAULT NULL, 
  title varchar(200) DEFAULT NULL, 
  link varchar(200) DEFAULT NULL, 
  description varchar(200) DEFAULT NULL, 
  PRIMARY KEY (id), 
  KEY fk_feed_subscription (idSubscription), 
  CONSTRAINT fk_feed_subscription FOREIGN KEY (idSubscription) REFERENCES subscription (id) ON DELETE NO ACTION ON UPDATE NO ACTION 
) ENGINE=InnoDB DEFAULT CHARSET=utf8
$$