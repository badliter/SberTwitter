INSERT INTO feed_cfg.usersinfo values
(1, 'rtz' ,'ivan', 'ivanov'),
(2, 'qwerty', 'alex', 'alexeev'),
(3, 'badliter', 'maxim', 'badanin');
INSERT INTO feed_cfg.tweets values
(1,1,'why are you runnin?','2016-06-22 19:10:25'),
(2,1,'why are you runnin, man?','2016-06-25 19:10:25'),
(1,2,'directed by','2016-06-26 19:10:25'),
(1,3,'robert w.weide','2016-06-27 19:10:25');
INSERT INTO feed_cfg.ownersubscriptions values
(1,2),
(1,3),
(2,3),
(3,1);

select t.tweetid, e.login, e.name, e.surname
from feed_cfg.tweets t left join feed_cfg.usersinfo e on t.userid = e.userid
where t.userId = 1;