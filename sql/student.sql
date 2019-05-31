DROP TABLE student;

CREATE TABLE `student` (
	`id` BIGINT (10) AUTO_INCREMENT COMMENT 'id',
	`student_no` BIGINT (20) NOT NULL COMMENT '学号',
	`name` VARCHAR (600) COMMENT '姓名',
	`age` INT (3) COMMENT '年龄',
	`major` VARCHAR (600) COMMENT '主修课程',
	PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140402','李四','20','历史');
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140403','王五','19','历史');
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140404','赵六','19','历史');
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140405','蔡徐坤','19','体育');
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140406','蔡虚困','20','体育');
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140411','库里','19','体育');
INSERT INTO `student` (`student_no`, `name`, `age`, `major`) VALUES('20140412','哈登','19','体育');
