




--
create table db_kai_kiosk.public.tb_test ( 
	id serial4 not null, 
	message varchar(100) null, 
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

-- 
DROP TABLE tb_login_history;

CREATE TABLE tb_login_history (
	id serial4 NOT NULL,
	kiosk_id text NOT NULL,
	employee_id text NOT NULL,
	ip_addr text NOT NULL,
	device_id text NOT NULL,
	login_dt timestamp NOT NULL DEFAULT now(),
	deleted bool NOT NULL DEFAULT false,
	create_dt timestamp NOT NULL DEFAULT now(),
	update_dt timestamp NOT NULL DEFAULT now(),
	delete_dt timestamp NULL
);

--
DROP TABLE tb_tag_history

CREATE TABLE tb_tag_history (
	id serial4 NOT NULL,
	kiosk_id text NOT NULL,
	ip_addr text NOT NULL,
	device_id text NOT NULL,
	device_type text NOT null,
	contents text not null,
	tag_dt timestamp NOT NULL DEFAULT now(),
	deleted bool NOT NULL DEFAULT false,
	create_dt timestamp NOT NULL DEFAULT now(),
	update_dt timestamp NOT NULL DEFAULT now(),
	delete_dt timestamp NULL
);




-- -------------------------------------------------------------------------------------------
-- task order
-- -------------------------------------------------------------------------------------------

create table public.tb_task_order_list (
	task_order_id text not null,
	gop text not null,
	workspace text not null,
	part_number text not null,
	start_process timestamp null,
	end_process timestamp null,
	target_result text null,
	real_result text null,
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table public.tb_task_order_list;
-- -------------------------------------------------------------------------------------------
-- kiosk
-- -------------------------------------------------------------------------------------------

create table public.tb_kiosk_info (
	kiosk_id text not null,	
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table public.tb_kiosk_info;
-- -------------------------------------------------------------------------------------------
-- job order tagging (RFID, Barcode, Manual)
-- -------------------------------------------------------------------------------------------

create table public.tb_task_order_tag_history (
	kiosk_id text not null,
	task_order_id text not null,
	tag_uuid text not null,
	device_type text not null,
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table public.tb_task_order_tag_history;
-- -------------------------------------------------------------------------------------------
-- worker order tagging (NFC)
-- -------------------------------------------------------------------------------------------

create table public.tb_worker_tag_history (
   kiosk_id text not null,
	tag_uuid text not null,
	employee_id text not null,
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table public.tb_order_tag_history;
-- -------------------------------------------------------------------------------------------
-- workers
-- -------------------------------------------------------------------------------------------

create table public.tb_worker_group (
	worker_group_id serial4 not null,
	kiosk_id text not null,
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table public.tb_worker_group;

create table public.tb_worker (
	employee_id text not null,
	worker_group_id text not null,
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table public.tb_worker_group;
-- -------------------------------------------------------------------------------------------
-- test
-- -------------------------------------------------------------------------------------------

create table db_kai_kiosk.public.tb_test ( 
	id serial4 not null, 
	message varchar(100) null, 
	deleted varchar not null default false,
	create_dt timestamp not null default now(),
	update_dt timestamp not null default now(),
	delete_dt timestamp default null
);

drop table db_kai_kiosk.public.tb_test;

insert
	into
	public.tb_test(
message,
	create_dt,
	update_dt)
values(
'',
now(),
now()
);
-- -------------------------------------------------------------------------------------------
