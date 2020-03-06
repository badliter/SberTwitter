DROP TABLE IF EXISTS FEED_CFG.FEED;
CREATE TABLE FEED(
  ownerid BIGINT NOT NULL,
  userid BIGINT NOT NULL,
  twittid BIGINT NOT NULL,
  content TEXT,
  date TIMESTAMP,
  PRIMARY KEY(ownerid,userid,twittid)
) TABLESPACE feed_cfg_data;