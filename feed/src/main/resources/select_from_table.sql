select t.tweetid, e.login, e.firstname, e.lastname
from feed_cfg.tweets t left join feed_cfg.usersinfo e on t.userid = e.userid
where t.userId = 1;