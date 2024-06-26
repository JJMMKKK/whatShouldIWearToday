CREATE TABLE weatherAreavo (
    id SERIAL PRIMARY KEY,
    country VARCHAR(50) NOT NULL,
    area VARCHAR(50) NOT NULL,
    nx INTEGER NOT NULL,
    ny INTEGER NOT NULL
);

INSERT INTO weatherAreavo (country, area, nx, ny)
VALUES
    ('서울', '종로구', 60, 127),
    ('서울', '중구', 60, 127),
    ('서울', '용산구', 60, 126),
    ('서울', '성동구', 61, 127),
    ('서울', '광진구', 62, 126),
    ('서울', '동대문구', 61, 127),
    ('서울', '중랑구', 62, 128),
    ('서울', '성북구', 61, 127),
    ('서울', '강북구', 61, 128),
    ('서울', '도봉구', 61, 129),
    ('서울', '노원구', 61, 129),
    ('서울', '은평구', 59, 127),
    ('서울', '서대문구', 59, 127),
    ('서울', '마포구', 59, 127),
    ('서울', '양천구', 58, 126),
    ('서울', '강서구', 58, 126),
    ('서울', '구로구', 58, 125),
    ('서울', '금천구', 59, 124),
    ('서울', '영등포구', 58, 126),
    ('서울', '동작구', 59, 125),
    ('서울', '관악구', 59, 125),
    ('서울', '서초구', 61, 125),
    ('서울', '강남구', 61, 126),
    ('서울', '송파구', 62, 126),
    ('서울', '강동구', 62, 126),
    ('부산', '중구', 97, 74),
    ('부산', '서구', 97, 74),
    ('부산', '동구', 98, 75),
    ('부산', '영도구', 98, 74),
    ('부산', '부산진구', 97, 75),
    ('부산', '동래구', 98, 76),
    ('부산', '남구', 98, 75),
    ('부산', '북구', 96, 76),
    ('부산', '해운대구', 99, 75),
    ('부산', '사하구', 96, 74),
    ('부산', '금정구', 98, 77),
    ('부산', '강서구', 96, 76),
    ('부산', '연제구', 98, 76),
    ('부산', '수영구', 99, 75),
    ('부산', '사상구', 96, 75),
    ('부산', '기장군', 100, 77),
    ('대구', '중구', 89, 90),
    ('대구', '동구', 90, 91),
    ('대구', '서구', 88, 90),
    ('대구', '남구', 89, 90),
    ('대구', '북구', 89, 91),
    ('대구', '수성구', 89, 90),
    ('대구', '달서구', 88, 90),
    ('대구', '달성군', 86, 88),
    ('인천', '중구', 54, 125),
    ('인천', '동구', 54, 125),
    ('인천', '미추홀구', 54, 124),
    ('인천', '연수구', 55, 123),
    ('인천', '남동구', 56, 124),
    ('인천', '부평구', 55, 125),
    ('인천', '계양구', 56, 126),
    ('인천', '서구', 55, 126),
    ('인천', '강화군', 51, 130),
    ('인천', '옹진군', 54, 124),
    ('광주', '동구', 60, 74),
    ('광주', '서구', 59, 74),
    ('광주', '남구', 59, 73),
    ('광주', '북구', 59, 75),
    ('광주', '광산구', 57, 74),
    ('대전', '동구', 68, 100),
    ('대전', '중구', 68, 100),
    ('대전', '서구', 67, 100),
    ('대전', '유성구', 67, 101),
    ('대전', '대덕구', 68, 100),
    ('울산', '중구', 102, 84),
    ('울산', '남구', 102, 84),
    ('울산', '동구', 104, 83),
    ('울산', '북구', 103, 85),
    ('울산', '울주군', 101, 84),
    ('세종', '세종', 66, 103),
    ('경기', '수원시장안구', 60, 121),
    ('경기', '수원시권선구', 60, 120),
    ('경기', '수원시팔달구', 61, 121),
    ('경기', '수원시영통구', 61, 120),
    ('경기', '성남시수정구', 63, 124),
    ('경기', '성남시중원구', 63, 124),
    ('경기', '성남시분당구', 62, 123),
    ('경기', '의정부시', 61, 130),
    ('경기', '안양시만안구', 59, 123),
    ('경기', '안양시동안구', 59, 123),
    ('경기', '부천시원미구', 57, 125),
    ('경기', '부천시소사구', 57, 125),
    ('경기', '부천시오정구', 57, 126),
    ('경기', '광명시', 58, 125),
    ('경기', '평택시', 62, 114),
    ('경기', '동두천시', 61, 134),
    ('경기', '안산시상록구', 58, 121),
    ('경기', '안산시단원구', 57, 121),
    ('경기', '고양시덕양구', 57, 128),
    ('경기', '고양시일산동구', 56, 129),
    ('경기', '고양시일산서구', 56, 129),
    ('경기', '과천시', 60, 124),
    ('경기', '구리시', 62, 127),
    ('경기', '남양주시', 64, 128),
    ('경기', '오산시', 62, 118),
    ('경기', '시흥시', 57, 123),
    ('경기', '군포시', 59, 122),
    ('경기', '의왕시', 60, 122),
    ('경기', '하남시', 64, 126),
    ('경기', '용인시처인구', 64, 119),
    ('경기', '용인시기흥구', 62, 120),
    ('경기', '용인시수지구', 62, 121),
    ('경기', '파주시', 56, 131),
    ('경기', '이천시', 68, 121),
    ('경기', '안성시', 65, 115),
    ('경기', '김포시', 55, 128),
    ('경기', '화성시', 57, 119),
    ('경기', '광주시', 65, 123),
    ('경기', '양주시', 61, 131),
    ('경기', '포천시', 64, 134),
    ('경기', '여주시', 71, 121),
    ('경기', '연천군', 61, 138),
    ('경기', '가평군', 69, 133),
    ('경기', '양평군', 69, 125),
    ('충북', '청주시상당구', 69, 106),
    ('충북', '청주시서원구', 69, 107),
    ('충북', '청주시흥덕구', 67, 106),
    ('충북', '청주시청원구', 69, 107),
    ('충북', '충주시', 76, 114),
    ('충북', '제천시', 81, 118),
    ('충북', '보은군', 73, 103),
    ('충북', '옥천군', 71, 99),
    ('충북', '영동군', 74, 97),
    ('충북', '증평군', 71, 110),
    ('충북', '진천군', 68, 111),
    ('충북', '괴산군', 74, 111),
    ('충북', '음성군', 72, 113),
    ('충북', '단양군', 84, 115),
    ('충남', '천안시동남구', 63, 110),
    ('충남', '천안시서북구', 63, 112),
    ('충남', '공주시', 63, 102),
    ('충남', '보령시', 54, 100),
    ('충남', '아산시', 60, 110),
    ('충남', '서산시', 51, 110),
    ('충남', '논산시', 62, 97),
    ('충남', '계룡시', 65, 99),
    ('충남', '당진시', 54, 112),
    ('충남', '금산군', 69, 95),
    ('충남', '부여군', 59, 99),
    ('충남', '서천군', 55, 94),
    ('충남', '청양군', 57, 103),
    ('충남', '홍성군', 55, 106),
    ('충남', '예산군', 58, 107),
    ('충남', '태안군', 48, 109),
    ('전북', '전주시완산구', 63, 89),
    ('전북', '전주시덕진구', 63, 89),
    ('전북', '군산시', 56, 92),
    ('전북', '익산시', 60, 91),
    ('전북', '정읍시', 58, 83),
    ('전북', '남원시', 68, 80),
    ('전북', '김제시', 59, 88),
    ('전북', '완주군', 63, 89),
    ('전북', '진안군', 68, 88),
    ('전북', '무주군', 72, 93),
    ('전북', '장수군', 70, 85),
    ('전북', '임실군', 66, 84),
    ('전북', '순창군', 63, 79),
    ('전북', '고창군', 56, 80),
    ('전북', '부안군', 56, 87),
    ('전남', '목포시', 50, 67),
    ('전남', '여수시', 73, 66),
    ('전남', '순천시', 70, 70),
    ('전남', '나주시', 56, 71),
    ('전남', '광양시', 73, 70),
    ('전남', '담양군', 61, 78),
    ('전남', '곡성군', 66, 77),
    ('전남', '구례군', 63, 77),
    ('전남', '고흥군', 65, 66),
    ('전남', '보성군', 65, 63),
    ('전남', '화순군', 68, 74),
    ('전남', '장흥군', 70, 63),
    ('전남', '강진군', 73, 63),
    ('전남', '해남군', 66, 60),
    ('전남', '영암군', 69, 62),
    ('전남', '무안군', 68, 70),
    ('전남', '함평군', 62, 69),
    ('전남', '영광군', 57, 67),
    ('전남', '장성군', 62, 74),
    ('전남', '완도군', 76, 67),
    ('전남', '진도군', 70, 66),
    ('전남', '신안군', 54, 61),
    ('경북', '포항시남구', 98, 75),
    ('경북', '포항시북구', 98, 76),
    ('경북', '경주시', 102, 81),
    ('경북', '김천시', 93, 86),
    ('경북', '안동시', 88, 92),
    ('경북', '구미시', 93, 90),
    ('경북', '영주시', 84, 89),
    ('경북', '영천시', 98, 79),
    ('경북', '상주시', 93, 96),
    ('경북', '문경시', 89, 94),
    ('경북', '경산시', 95, 83),
    ('경북', '군위군', 82, 85),
    ('경북', '의성군', 88, 84),
    ('경북', '청송군', 99, 73),
    ('경북', '영양군', 91, 70),
    ('경북', '영덕군', 97, 73),
    ('경북', '청도군', 92, 87),
    ('경북', '고령군', 94, 85),
    ('경북', '성주군', 90, 92),
    ('경북', '칠곡군', 97, 87),
    ('경북', '예천군', 88, 91),
    ('경북', '봉화군', 97, 79),
    ('경북', '울진군', 102, 72),
    ('경북', '울릉군', 107, 85),
    ('경남', '창원시의창구', 91, 77),
    ('경남', '창원시성산구', 91, 77),
    ('경남', '창원시마산합포구', 94, 74),
    ('경남', '창원시마산회원구', 94, 75),
    ('경남', '창원시진해구', 94, 79),
    ('경남', '진주시', 85, 76),
    ('경남', '통영시', 82, 73),
    ('경남', '고성군', 92, 65),
    ('경남', '사천시', 81, 69),
    ('경남', '김해시', 94, 76),
    ('경남', '밀양시', 88, 74),
    ('경남', '거제시', 88, 68),
    ('경남', '의령군', 89, 70),
    ('경남', '함안군', 87, 80),
    ('경남', '창녕군', 86, 83),
    ('경남', '양산시', 96, 82),
    ('경남', '하동군', 85, 71),
    ('경남', '남해군', 81, 78),
    ('경남', '함양군', 82, 85),
    ('경남', '산청군', 85, 87),
    ('경남', '거창군', 84, 93),
    ('경남', '합천군', 86, 96),
    ('제주', '제주시', 52, 38),
    ('제주', '서귀포시', 48, 38),
    ('강원', '춘천시', 73, 134),
    ('강원', '원주시', 76, 122),
    ('강원', '강릉시', 92, 131),
    ('강원', '동해시', 97, 127),
    ('강원', '태백시', 95, 119),
    ('강원', '속초시', 87, 141),
    ('강원', '삼척시', 98, 125),
    ('강원', '홍천군', 75, 130),
    ('강원', '횡성군', 77, 125),
    ('강원', '영월군', 86, 119),
    ('강원', '평창군', 84, 123),
    ('강원', '정선군', 89, 123),
    ('강원', '철원군', 65, 139),
    ('강원', '화천군', 72, 139),
    ('강원', '양구군', 77, 139),
    ('강원', '인제군', 80, 138),
    ('강원', '고성군', 85, 145),
    ('강원', '양양군', 88, 138);