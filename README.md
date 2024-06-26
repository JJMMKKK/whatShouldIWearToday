<h1>What Should I Wear Today?</h1>
What Should I Wear Today?(오늘 뭐 입지?)는 Chat Gpt를 사용하는 날씨에 따른 옷 추천 프로그램입니다.<br>
화면설계서: <a href="https://docs.google.com/presentation/d/1WIGNxzBNQpK3Q4mFGntJpOaWnN3snSJL/edit#slide=id.p1">오늘 뭐입지? 화면설계서</a><br>
기능정의서: <a href="https://docs.google.com/spreadsheets/d/1y5I5Gak7hoy_W3KqU3e_zlCesWok3rgTISXhx0KGJ-8/edit#gid=1285253246">오늘 뭐입지? 기능정의서</a><br>
WBS: <a href="https://docs.google.com/spreadsheets/d/1WQBiTjqb6Jq25A431KKq7AjY8lGHLrmn_FjdtshzCCI/edit#gid=329882389">오늘 뭐입지? WBS</a><br>
ERD: <a href="">오늘 뭐입지? ERD</a><br>
Usecase: <a href="">오늘 뭐입지? Usecase</a><br>
개발 일지: <a href="https://minkee95.tistory.com/category/%EA%B0%9C%EC%9D%B8%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8">오늘 뭐입지? 개발 일지</a><br>
개발 캘린더: <a href="https://docs.google.com/spreadsheets/d/1ebNU_C5rRrkqbPds9ZFob8DVB4IETuH2rK6kcbQm4hw/edit#gid=0">오늘 뭐입지? 개발 캘린더</a><br>
소개(노션): <a href="https://www.notion.so/501ab6bd429f488691ec8e224e0b1643?v=7d1d2f8947db4eefae4fb6c063197cda&p=bc92c096396841128699d69a9307ccaa&pm=c">오늘 뭐입지? 소개</a><br>

<p><br>
<h3>프로그램 사용 방법</h3>
1. 유저는 마이페이지에서 옷 추가<br>
2. 기상청으로부터 오늘의 날씨 및 미세먼지 농도 데이터를 받아 출력<br>
3. Chat Gpt에서 개인이 갖고 있는 옷과 날씨 데이터를 제공<br>
4. 어떤 옷을 입을지, 마스크 착용 추천 여부에 대한 대답을 출력<br>
* 질문은 유저가 입력하는 것이 아니라, 프로그램에서 문구를 지정하여 Chat GPT에게 질문하여 규칙성 있는 답변을 불러옵니다.<br>
</p><br>
<p>
<h3>프로그램 기능</h3>
- 회원가입 및 로그인 기능<br>
- 마이페이지에서 유저가 가진 옷을 입력하는 기능<br>
- 공공데이터를 통해 날씨 정보를 불러와서 출력하는 기능<br>
- 오늘의 날씨와 유저가 입력한 옷 데이터를 토대로 Chat GPT에게 질문하는 기능<br>
- 받은 답변 결과가 저장되어 유저 개인 페이지에서 볼 수 있는 기능<br>
</p><br>
<p>
<h3>추가적으로 구상 중인 기능</h3>
- 유저가 가진 옷을 입력할 때, 옷의 사진까지 저장하는 기능(AWS의 S3와 IAM을 사용)<br>
- 해외에서도 사용할 수 있도록 국내 / 해외를 나누어서 기능 구현(해외까지 구현할 경우, OpenWeatherMap을 사용할 예정)<br>
- Chat GPT가 답변한 결과물을 토대로 데이터를 구성하여 화면에 출력(사진 등)<br>
- 화면에 출력된 데이터를 "공유하기" 버튼을 누르면 Url이 생성되고, 해당 Url을 사용하여 오늘의 데일리룩을 공유하는 기능(NoSQL로 브라우저에 데이터 출력 / SNS 공유 기능 등)<br>
</p><br>
<p>
<h3>프로그래밍 언어 및 개발 환경, 기술스택</h3>
- JDK 17 / Spring Boot 3.2.5<br>
- JSP / Servlet<br>
- JavaScript / CSS / HTML<br>
- PostgreSQL / IntelliJ<br>
- JPA<br>
- Gradle / MSA<br>
- Apache Tomcat<br>
</p><br>
<p>
<h3>추가적으로 구상 중인 프로그래밍 언어 및 개발 환경, 기술스택</h3>
- React / TypeScript를 통한 프론트엔드 재구성<br>
</p>
