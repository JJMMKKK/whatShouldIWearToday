create table place(
    id serial primary key,
    country varchar(50) not null,
    area varchar(50) unique,
    stationName varchar(50) not null
);

INSERT INTO place (country, area, stationName) VALUES
    ('경기', '수원시장안구', '경수대로(동수원)'),
    ('경기', '수원시권선구', '신장동'),
    ('경기', '수원시팔달구', '영통동'),
    ('경기', '수원시영통구', '영통동'),
    ('경기', '성남시수정구', '성남대로(모란역)'),
    ('경기', '성남시중원구', '성남대로(모란역)'),
    ('경기', '성남시분당구', '새솔동'),
    ('경기', '의정부시', '의정부동'),
    ('경기', '안양시만안구', '안양8동'),
    ('경기', '안양시동안구', '안양2동'),
    ('경기', '부천시원미구', '오산동'),
    ('경기', '부천시소사구', '부곡동1'),
    ('경기', '부천시오정구', '대야동'),
    ('경기', '광명시', '경안동'),
    ('경기', '평택시', '고덕면'),
    ('경기', '동두천시', '별내면'),
    ('경기', '안산시상록구', '고잔동'),
    ('경기', '안산시단원구', '고잔동'),
    ('경기', '고양시덕양구', '산본동'),
    ('경기', '고양시일산동구', '산본동'),
    ('경기', '고양시일산서구', '백석읍'),
    ('경기', '과천시', '과천동'),
    ('경기', '구리시', '별내면'),
    ('경기', '남양주시', '다산동'),
    ('경기', '오산시', '오산동'),
    ('경기', '시흥시', '금오동'),
    ('경기', '군포시', '산본동'),
    ('경기', '의왕시', '오전동'),
    ('경기', '하남시', '고잔동'),
    ('경기', '용인시처인구', '동탄'),
    ('경기', '용인시기흥구', '기흥'),
    ('경기', '용인시수지구', '수지'),
    ('경기', '파주시', '부곡동1'),
    ('경기', '이천시', '대월면'),
    ('경기', '안성시', '고잔동'),
    ('경기', '김포시', '고촌읍'),
    ('경기', '화성시', '동탄'),
    ('경기', '광주시', '경안동'),
    ('경기', '양주시', '은현면'),
    ('경기', '포천시', '중앙동(경기)'),
    ('경기', '여주시', '가남읍'),
    ('경기', '연천군', '연천'),
    ('경기', '가평군', '가평'),
    ('경기', '양평군', '원덕읍');
