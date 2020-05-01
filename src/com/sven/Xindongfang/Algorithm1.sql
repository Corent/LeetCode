CREATE TABLE `node` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL,
	`pid` BIGINT NULL COMMENT '父节点ID'
);

select n1.name
from node n1, (select distinct pid from node) n2
where n1.id = n2.pid
