



-- -------------------------------------------------------------------------------------------

CREATE TABLE db_kai_kiosk.public.tb_test ( 
	id serial4 NOT NULL, 
	message varchar(100) NULL, 
	deleted varchar NOT NULL DEFAULT FALSE,
	create_dt timestamp NOT NULL DEFAULT now(),
	update_dt timestamp NOT NULL DEFAULT now(),
	delete_dt timestamp DEFAULT NULL
);

DROP TABLE db_kai_kiosk.public.tb_test;

INSERT INTO public.tb_test(
message, create_dt, update_dt)
VALUES(
'', now(), now()
);

-- -------------------------------------------------------------------------------------------

CREATE TABLE public.tb_order_tag_history (
	id serial4 NOT NULL,
	tag_device_type text NULL,
	uid text NULL,
	deleted varchar NOT NULL DEFAULT FALSE,
	create_dt timestamp NOT NULL DEFAULT now(),
	update_dt timestamp NOT NULL DEFAULT now(),
	delete_dt timestamp DEFAULT null,
	CONSTRAINT tb_order_tag_history_pk PRIMARY KEY (id)
);
CREATE INDEX tb_order_tag_history_uid_idx ON public.tb_order_tag_history USING btree (uid);

DROP TABLE public.tb_order_tag_history;

-- -------------------------------------------------------------------------------------------

CREATE TABLE public.tb_order_tag_data (
	tag_id text NOT NULL,
	tag_device_type text not NULL,
	ip text NULL,
	uid text NULL,
	serial text NULL,
	context text NULL,
	deleted varchar NOT NULL DEFAULT FALSE,
	create_dt timestamp NOT NULL DEFAULT now(),
	update_dt timestamp NOT NULL DEFAULT now(),
	delete_dt timestamp DEFAULT NULL
);

DROP TABLE public.tb_order_tag_data;

-- -------------------------------------------------------------------------------------------

CREATE TABLE public.tb_user_tag_history (
	id serial4 NOT NULL,
	tag_device_type text NULL,
	uid text NULL,
	deleted varchar NOT NULL DEFAULT FALSE,
	create_dt timestamp NOT NULL DEFAULT now(),
	update_dt timestamp NOT NULL DEFAULT now(),
	delete_dt timestamp DEFAULT null,
	CONSTRAINT tb_order_tag_history_pk PRIMARY KEY (id)
);
CREATE INDEX tb_order_tag_history_uid_idx ON public.tb_order_tag_history USING btree (uid);

DROP TABLE public.tb_order_tag_history;



-- -------------------------------------------------------------------------------------------


















CREATE TABLE public.	tb_kiosk_job_list
(
    idx integer NOT NULL,
    offer_status character varying(20) NOT NULL,
    priority integer NOT NULL,
    group_id text,
    order_number character varying(20) NOT NULL,
    gop_number character varying(10) NOT NULL,
    workings character varying(10) NOT NULL,
    part_number character varying(20) NOT NULL,
    proc_start timestamp with time zone NOT NULL,
    proc_end timestamp with time zone NOT NULL,
    target_result double precision NOT NULL,
    real_result double precision NOT NULL,
    worker character varying(20) NOT NULL,
    task_center character varying(100) NOT NULL,
    PRIMARY KEY (idx)
);




CREATE TABLE public.tb_install_device
(
    idx integer NOT NULL,
    install_pos character varying(256) NOT NULL,
    install_desc character varying(256) NOT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE public.tb_kiosk_setting_info
(
    idx integer NOT NULL,
    created timestamp with time zone NOT NULL,
    updated timestamp with time zone NOT NULL,
    serial_num character varying(20) NOT NULL,
    ip_address character varying(20) NOT NULL,
    install_pos character varying(256) NOT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE public.tb_log_type_def
(
    idx integer NOT NULL,
    log_type integer NOT NULL,
    log_desc character varying(256) NOT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE public.tb_sap_group
(
    "groupId" text NOT NULL,
    PRIMARY KEY ("groupId")
);

CREATE TABLE public.tb_sap_user
(
    "userId" text NOT NULL,
    name text NOT NULL,
    group_id text,
    PRIMARY KEY ("userId")
);

CREATE TABLE public.tb_scan_log
(
    idx integer NOT NULL,
    created timestamp with time zone NOT NULL,
    tag_id character varying(20) NOT NULL,
    tag_text character varying(256) NOT NULL,
    ip_address character varying(20) NOT NULL,
    serial_num character varying(20) NOT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE public.tb_scan_log_barcode
(
    idx integer NOT NULL,
    created timestamp with time zone NOT NULL,
    tag_id character varying(20) NOT NULL,
    tag_text character varying(256) NOT NULL,
    ip_address character varying(20) NOT NULL,
    serial_num character varying(20) NOT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE public.tb_scan_log_barcode_orders
(
    id bigint NOT NULL,
    scan_log_barcode_id integer NOT NULL,
    kiosk_job_list_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.tb_scan_log_nfc
(
    idx integer NOT NULL,
    created timestamp with time zone NOT NULL,
    tag_id character varying(20) NOT NULL,
    tag_text character varying(256) NOT NULL,
    ip_address character varying(20) NOT NULL,
    serial_num character varying(20) NOT NULL,
    user_id text,
    PRIMARY KEY (idx)
);

CREATE TABLE public.tb_scan_log_orders
(
    id bigint NOT NULL,
    scan_log_id integer NOT NULL,
    kiosk_job_list_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.tb_system_log
(
    idx integer NOT NULL,
    created timestamp with time zone NOT NULL,
    log_memo text NOT NULL,
    ip_address character varying(20) NOT NULL,
    log_type_id integer,
    PRIMARY KEY (idx)
);
 
ALTER TABLE public.tb_kiosk_job_list
    ADD FOREIGN KEY (group_id)
    REFERENCES public.kai_project_sap_group ("groupId")
    NOT VALID;


ALTER TABLE public.tb_sap_user
    ADD FOREIGN KEY (group_id)
    REFERENCES public.kai_project_sap_group ("groupId")
    NOT VALID;


ALTER TABLE public.tb_scan_log_barcode_orders
    ADD FOREIGN KEY (kiosk_job_list_id)
    REFERENCES public.kai_project_kiosk_job_list (idx)
    NOT VALID;


ALTER TABLE public.tb_scan_log_barcode_orders
    ADD FOREIGN KEY (scan_log_barcode_id)
    REFERENCES public.kai_project_scan_log_barcode (idx)
    NOT VALID;


ALTER TABLE public.tb_scan_log_nfc
    ADD FOREIGN KEY (user_id)
    REFERENCES public.kai_project_sap_user ("userId")
    NOT VALID;


ALTER TABLE public.tb_scan_log_orders
    ADD FOREIGN KEY (kiosk_job_list_id)
    REFERENCES public.kai_project_kiosk_job_list (idx)
    NOT VALID;


ALTER TABLE public.tb_scan_log_orders
    ADD FOREIGN KEY (scan_log_id)
    REFERENCES public.kai_project_scan_log (idx)
    NOT VALID;


ALTER TABLE public.tb_system_log
    ADD FOREIGN KEY (log_type_id)
    REFERENCES public.kai_project_log_type_def (idx)
    NOT VALID;