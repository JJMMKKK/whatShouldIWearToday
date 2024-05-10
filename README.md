<h1>What Should I Wear Today?</h1>
What Should I Wear Today?(오늘 뭐 입지?)는 Chat Gpt를 사용하는 날씨에 따른 옷 추천 프로그램입니다.<br>
<p>
<h3>프로그램 기능</h3>
1. 유저는 마이페이지에서 옷 추가
2. 기상청으로부터 오늘의 날씨 및 미세먼지 농도 데이터를 받아 출력
3. Chat Gpt에서 개인이 갖고 있는 옷과 날씨 데이터를 제공
4. 어떤 옷을 입을지, 마스크 착용 추천 여부에 대한 대답을 출력
* 질문은 유저가 입력하는 것이 아니라, 프로그램에서 문구를 지정하여 Chat GPT에게 질문하여 규칙성 있는 답변을 불러옵니다.
</p>
<p>
<h3>프로그램 구현</h3>
- 회원가입 및 로그인 기능
- 마이페이지에서 유저가 가진 옷을 입력하는 기능
- 공공데이터를 통해 날씨 정보를 불러와서 출력하는 기능
- 오늘의 날씨와 유저가 입력한 옷 데이터를 토대로 Chat GPT에게 질문하는 기능
- 받은 답변 결과가 저장되어 유저 개인 페이지에서 볼 수 있는 기능
</p>
<p>
<h3>추가적으로 구상 중인 기능</h3>
- 유저가 가진 옷을 입력할 때, 옷의 사진까지 저장하는 기능(AWS의 S3와 IAM을 사용)
- 해외에서도 사용할 수 있도록 국내 / 해외를 나누어서 기능 구현(해외까지 구현할 경우, OpenWeatherMap을 사용할 예정)
- Chat GPT가 답변한 결과물을 토대로 데이터를 구성하여 화면에 출력(사진 등)
- 화면에 출력된 데이터를 "공유하기" 버튼을 누르면 Url이 생성되고, 해당 Url을 사용하여 오늘의 데일리룩을 공유하는 기능(NoSQL로 브라우저에 데이터 출력 / SNS 공유 기능 등)
</p>
<p>
<h3>프로그래밍 언어 및 개발 환경, 기술스택</h3>
- JDK 17 / Spring Boot 3.2.5
- JSP / Servlet
- JavaScript / CSS / HTML
- PostgreSQL / IntelliJ
- JPA
- Gradle / MSA
- Apache Tomcat
</p>
<p>
<h3>추가적으로 구상 중인 프로그래밍 언어 및 개발 환경, 기술스택</h3>
- React / TypeScript를 통한 프론트엔드 재구성
</p>
