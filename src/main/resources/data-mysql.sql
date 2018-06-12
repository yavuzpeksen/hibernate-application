INSERT INTO `role` (`id`,`name`) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO `user` (`id`, `email`, `password`, `creation_date`, `authenticated`) VALUES (1,'fighterjericho@yahoo.com','$2a$10$gkyKWfXjwPHTU7iuLvU5x..Oo1l61PD5HsgFQYb6tbtmMYA1eBJsq','2018-04-01 22:00:08',1),(2,'yavuz','$2a$10$B.zy2XqTPTo3AeTyCwVaq.5A8pDNzioxxBb0FEZPT4RAdBPj91wyC','2018-04-03 23:11:45',1);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1,1),(2,2);

INSERT INTO `job_listing` (`id`, `user_id`) VALUES (1,1),(2,3);

INSERT INTO `job` (`id`, `job_listing_id`, `title`, `description`, `hiring_person_number`, `last_application_date`) VALUES (1,2,'Sale Executive','Description',4,'2022-04-01 21:00:00'),(4,1,'deneme','desc',33,'2020-12-31 21:00:00');