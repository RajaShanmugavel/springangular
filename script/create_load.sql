-- mysql> source e:/trial_run.sql

use rajadb;

create table IQ_QUESTIONS(qid varchar(10), qtxt varchar(200), PRIMARY KEY(qid));

create table IQ_OPTIONS(oid varchar(10), qid varchar(10), otext varchar(250), PRIMARY KEY(oid), FOREIGN KEY(qid) REFERENCES IQ_QUESTIONS(qid));

create table IQ_ANSWERS(aid varchar(10), qid varchar(10), oid varchar(10), PRIMARY KEY(aid), FOREIGN KEY(qid) REFERENCES IQ_QUESTIONS(qid), FOREIGN KEY(oid) REFERENCES IQ_OPTIONS(oid));

create table IQ_SUBMITTED_QA(subid integer(10), qid varchar(10), qtxt varchar(200), selopid varchar(10), seloptxt varchar(250),corropid varchar(10), corroptxt varchar(250), userid varchar(100), saveddate date, PRIMARY KEY(subid); 

insert into IQ_QUESTIONS values ('Q1001','What is the capital of Italy?'); -- Rome
insert into IQ_QUESTIONS values ('Q1002','Who holds the record for winning most number of Grand Slam single titles in tennis?'); -- Serena Williams
insert into IQ_QUESTIONS values ('Q1003','Who is known as the father of Computers?'); -- Charles Babbage
insert into IQ_QUESTIONS values ('Q1004','Which country first introduced the VAT (Value Added Tax)?'); -- France
insert into IQ_QUESTIONS values ('Q1005','Capital of Venezuela?'); -- Karakkas
insert into IQ_QUESTIONS values ('Q1006','Solid Carbon di oxide is known as?'); -- Dry Ice
insert into IQ_QUESTIONS values ('Q1007','These two countries were allies in WWII'); -- Japan, Italy
insert into IQ_QUESTIONS values ('Q1008','This country lost the largest number of people in WWII?'); -- Japan
insert into IQ_QUESTIONS values ('Q1009','Which is the biggest museum?'); -- British Museum
insert into IQ_QUESTIONS values ('Q1010','The coldest planet in solar system?'); -- Neptune
insert into IQ_QUESTIONS values ('Q1011','Founders of Google?'); -- Larry Page, Sergery Brin
insert into IQ_QUESTIONS values ('Q1012','Which country is known as land of windmills?'); -- Netherlands
insert into IQ_QUESTIONS values ('Q1013','Device used to measure radiation?'); -- Geiger muller counter
insert into IQ_QUESTIONS values ('Q1014','Which animal never drinks water in its entire life?'); -- Kangaroo Rat
insert into IQ_QUESTIONS values ('Q1015','Which is the largest human cell?'); -- Ovum
insert into IQ_QUESTIONS values ('Q1016','Which is the smallest flightless bird?'); -- Kiwi
insert into IQ_QUESTIONS values ('Q1017','Which is the largest blood vessel in the body'); -- Aorta
insert into IQ_QUESTIONS values ('Q1018','What is the formula of Sulfuric acid?'); -- H2SO4
insert into IQ_QUESTIONS values ('Q1019','Rusting is a ____________ reaction?'); -- Oxidation
insert into IQ_QUESTIONS values ('Q1020','Capital of New Zealand?'); -- Wellington


insert into IQ_OPTIONS values ('OP00001','Q1001','Sydney');
insert into IQ_OPTIONS values ('OP00002','Q1001','Nice');
insert into IQ_OPTIONS values ('OP00003','Q1001','Milan');
insert into IQ_OPTIONS values ('OP00004','Q1001','Rome');
insert into IQ_OPTIONS values ('OP00005','Q1002','Serena Williams');
insert into IQ_OPTIONS values ('OP00006','Q1002','Steffi Graf');
insert into IQ_OPTIONS values ('OP00007','Q1002','Margaret Court');
insert into IQ_OPTIONS values ('OP00008','Q1002','Chris Evert');
insert into IQ_OPTIONS values ('OP00009','Q1003','Charles Babbage');
insert into IQ_OPTIONS values ('OP00010','Q1003','Allan Turing');
insert into IQ_OPTIONS values ('OP00011','Q1003','Bill Gates');
insert into IQ_OPTIONS values ('OP00012','Q1003','Ada Lovelace');
insert into IQ_OPTIONS values ('OP00013','Q1004','Italy');
insert into IQ_OPTIONS values ('OP00014','Q1004','France');
insert into IQ_OPTIONS values ('OP00015','Q1004','United Kingdom');
insert into IQ_OPTIONS values ('OP00016','Q1004','Japan');
insert into IQ_OPTIONS values ('OP00017','Q1005','Capetown');
insert into IQ_OPTIONS values ('OP00018','Q1005','Karakkas');
insert into IQ_OPTIONS values ('OP00019','Q1005','Monacco');
insert into IQ_OPTIONS values ('OP00020','Q1005','Zurich');
insert into IQ_OPTIONS values ('OP00021','Q1006','Dry Ice');	
insert into IQ_OPTIONS values ('OP00022','Q1006','Liquid Carbon');
insert into IQ_OPTIONS values ('OP00023','Q1006','CO3');
insert into IQ_OPTIONS values ('OP00024','Q1006','Soda');
insert into IQ_OPTIONS values ('OP00025','Q1007','Japan');
insert into IQ_OPTIONS values ('OP00026','Q1007','Russia');
insert into IQ_OPTIONS values ('OP00027','Q1007','Italy');
insert into IQ_OPTIONS values ('OP00028','Q1007','South Africa');
insert into IQ_OPTIONS values ('OP00029','Q1008','United Kingdom');
insert into IQ_OPTIONS values ('OP00030','Q1008','Germany');
insert into IQ_OPTIONS values ('OP00031','Q1008','Russia');
insert into IQ_OPTIONS values ('OP00032','Q1008','Japan');
insert into IQ_OPTIONS values ('OP00033','Q1009','Smithsonian Institution, Washington DC');
insert into IQ_OPTIONS values ('OP00034','Q1009','Le Louvre, Paris, France');
insert into IQ_OPTIONS values ('OP00035','Q1009','The Acropolis Museum, Athens, Greece');
insert into IQ_OPTIONS values ('OP00036','Q1009','The British Museum, London, UK');
insert into IQ_OPTIONS values ('OP00037','Q1010','Pluto');
insert into IQ_OPTIONS values ('OP00038','Q1010','Uranus');
insert into IQ_OPTIONS values ('OP00039','Q1010','Earth');
insert into IQ_OPTIONS values ('OP00040','Q1010','Neptune');
insert into IQ_OPTIONS values ('OP00041','Q1011','Larry Page');
insert into IQ_OPTIONS values ('OP00042','Q1011','Dennis Ritchie');
insert into IQ_OPTIONS values ('OP00043','Q1011','Ken Thompson');
insert into IQ_OPTIONS values ('OP00044','Q1011','Sergery Brin');
insert into IQ_OPTIONS values ('OP00045','Q1012','Netherlands');
insert into IQ_OPTIONS values ('OP00046','Q1012','Finland');
insert into IQ_OPTIONS values ('OP00047','Q1012','Germany');
insert into IQ_OPTIONS values ('OP00048','Q1012','Japan');
insert into IQ_OPTIONS values ('OP00049','Q1013','Radio counter');
insert into IQ_OPTIONS values ('OP00050','Q1013','Geiger muller counter');
insert into IQ_OPTIONS values ('OP00051','Q1013','Seismograph');
insert into IQ_OPTIONS values ('OP00052','Q1013','Seismometer');
insert into IQ_OPTIONS values ('OP00053','Q1014','Kangaroo');
insert into IQ_OPTIONS values ('OP00054','Q1014','Kangaroo rat');
insert into IQ_OPTIONS values ('OP00055','Q1014','Snow leopard');
insert into IQ_OPTIONS values ('OP00056','Q1014','Rattle snake');
insert into IQ_OPTIONS values ('OP00057','Q1015','Ovum');
insert into IQ_OPTIONS values ('OP00058','Q1015','Nerve cell');
insert into IQ_OPTIONS values ('OP00059','Q1015','Sperm');
insert into IQ_OPTIONS values ('OP00060','Q1015','Liver cell');
insert into IQ_OPTIONS values ('OP00061','Q1016','Emu');
insert into IQ_OPTIONS values ('OP00062','Q1016','Kiwi');
insert into IQ_OPTIONS values ('OP00063','Q1016','Ostrich');
insert into IQ_OPTIONS values ('OP00064','Q1016','Bee humingbird');
insert into IQ_OPTIONS values ('OP00065','Q1017','Capillary');
insert into IQ_OPTIONS values ('OP00066','Q1017','Vein');
insert into IQ_OPTIONS values ('OP00067','Q1017','Artery');
insert into IQ_OPTIONS values ('OP00068','Q1017','Aorta');
insert into IQ_OPTIONS values ('OP00069','Q1018','HN03');
insert into IQ_OPTIONS values ('OP00070','Q1018','H2SO4');
insert into IQ_OPTIONS values ('OP00071','Q1018','MNS04');
insert into IQ_OPTIONS values ('OP00072','Q1018','HCL');
insert into IQ_OPTIONS values ('OP00073','Q1019','Oxidisation');
insert into IQ_OPTIONS values ('OP00074','Q1019','Chemical');
insert into IQ_OPTIONS values ('OP00075','Q1019','Chain');
insert into IQ_OPTIONS values ('OP00076','Q1019','Reduction');
insert into IQ_OPTIONS values ('OP00077','Q1020','Auckland');
insert into IQ_OPTIONS values ('OP00078','Q1020','Wellington');
insert into IQ_OPTIONS values ('OP00079','Q1020','Queenstown');
insert into IQ_OPTIONS values ('OP00080','Q1020','Christchurch');


insert into IQ_ANSWERS values ('ANS0001','Q1001','OP00004');
insert into IQ_ANSWERS values ('ANS0002','Q1002','OP00005');
insert into IQ_ANSWERS values ('ANS0003','Q1003','OP00009');
insert into IQ_ANSWERS values ('ANS0004','Q1004','OP00014');
insert into IQ_ANSWERS values ('ANS0005','Q1005','OP00018');
insert into IQ_ANSWERS values ('ANS0006','Q1006','OP00021');
insert into IQ_ANSWERS values ('ANS0007','Q1007','OP00025');
insert into IQ_ANSWERS values ('ANS0008','Q1007','OP00027');
insert into IQ_ANSWERS values ('ANS0009','Q1008','OP00032');
insert into IQ_ANSWERS values ('ANS0010','Q1009','OP00036');
insert into IQ_ANSWERS values ('ANS0011','Q1010','OP00040');
insert into IQ_ANSWERS values ('ANS0012','Q1011','OP00041');
insert into IQ_ANSWERS values ('ANS0013','Q1011','OP00044');
insert into IQ_ANSWERS values ('ANS0014','Q1012','OP00045');
insert into IQ_ANSWERS values ('ANS0015','Q1013','OP00050');
insert into IQ_ANSWERS values ('ANS0016','Q1014','OP00054');
insert into IQ_ANSWERS values ('ANS0017','Q1015','OP00057');
insert into IQ_ANSWERS values ('ANS0018','Q1016','OP00062');
insert into IQ_ANSWERS values ('ANS0019','Q1017','OP00068');
insert into IQ_ANSWERS values ('ANS0020','Q1018','OP00070');
insert into IQ_ANSWERS values ('ANS0021','Q1019','OP00073');
insert into IQ_ANSWERS values ('ANS0022','Q1020','OP00078');

commit;








