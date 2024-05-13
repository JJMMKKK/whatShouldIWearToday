create table paticulateMattervo(
       id SERIAL primary key,
       sidoName varchar(50) not null,
       dataTime varchar(50) not null,
       stationName varchar(50) not null,
       pm25Grade varchar(50) not null,
       pm25Flag varchar(50),
       pm25Value varchar(50),
       pm10Grade varchar(50) not null,
       pm10Flag varchar(50),
       pm10Value varchar(50)
);

