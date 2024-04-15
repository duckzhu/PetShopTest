# petShopTest
SQLserver数据库
sql:
-- mydatabase.dbo.product definition

-- Drop table

-- DROP TABLE mydatabase.dbo.product;

CREATE TABLE mydatabase.dbo.product (
	id int IDENTITY(1,1) NOT NULL,
	name varchar(64) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NOT NULL,
	pic_path varchar(256) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	introduction varchar(256) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	price varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	addDate date DEFAULT getdate() NULL,
	updateDate date DEFAULT NULL NULL,
	state int DEFAULT 1 NULL,
	CONSTRAINT PK__product PRIMARY KEY (id)
);


-- mydatabase.dbo.tb_order definition

-- Drop table

-- DROP TABLE mydatabase.dbo.tb_order;

CREATE TABLE mydatabase.dbo.tb_order (
	id int IDENTITY(1,1) NOT NULL,
	payment varchar(50) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	status int DEFAULT NULL NULL,
	addDate date DEFAULT getdate() NULL,
	updateDate date DEFAULT NULL NULL,
	payment_time datetime DEFAULT NULL NULL,
	consign_time datetime DEFAULT NULL NULL,
	shipping_name varchar(20) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	shipping_code varchar(20) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	user_id int DEFAULT NULL NULL,
	buyer_message varchar(100) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	buyer_name varchar(50) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	product_id int NOT NULL,
	product_num int DEFAULT 1 NOT NULL,
	status_str varchar(100) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	price varchar(100) COLLATE Latin1_General_100_CI_AS_SC_UTF8 NULL,
	product_name varchar(100) COLLATE Latin1_General_100_CI_AS_SC_UTF8 NULL,
	CONSTRAINT PK__order PRIMARY KEY (id)
);


-- mydatabase.dbo.tb_user definition

-- Drop table

-- DROP TABLE mydatabase.dbo.tb_user;

CREATE TABLE mydatabase.dbo.tb_user (
	id int IDENTITY(1,1) NOT NULL,
	userName varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 NOT NULL,
	password varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 NOT NULL,
	realName varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	business varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	email varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	headPicture varchar(45) COLLATE Latin1_General_100_CI_AS_SC_UTF8 DEFAULT NULL NULL,
	addDate date DEFAULT getdate() NULL,
	updateDate date DEFAULT NULL NULL,
	state int DEFAULT 1 NULL,
	[level] int DEFAULT 2 NULL,
	CONSTRAINT PK__tb_user__3213E83F9042139F PRIMARY KEY (id),
	CONSTRAINT UQ__tb_user__66DCF95C0AF2DBF2 UNIQUE (userName)
);
