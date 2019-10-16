BEGIN
;
INSERT INTO BATCH_JOB_REQUEST(job_name,job_parameter,polling_status,create_date) VALUES('JBBB01001',CONCAT('firstDateStr=', '2018/12/31', ', lastDateStr=', '2019/12/31'),'INIT',current_timestamp)
;
INSERT INTO BATCH_JOB_REQUEST(job_name,job_parameter,polling_status,create_date) VALUES('JBBB01002',CONCAT('firstDateStr=', '2018/12/31', ', lastDateStr=', '2019/12/31'),'INIT',current_timestamp)
;
INSERT INTO BATCH_JOB_REQUEST(job_name,job_parameter,polling_status,create_date) VALUES('JBBB01003',CONCAT('firstDateStr=', '2018/12/31', ', lastDateStr=', '2019/12/31'),'INIT',current_timestamp)
;
COMMIT
;
