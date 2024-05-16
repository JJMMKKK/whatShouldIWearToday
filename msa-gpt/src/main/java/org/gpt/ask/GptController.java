package org.gpt.ask;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gpt.GptanswervoDto;
import org.gpt.saveAnswer.SaveAnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Slf4j
@Controller
public class GptController {

    private final GptService gptService;
    private final SaveAnswerService saveAnswerService;

    @ResponseBody
    @PostMapping("/askToGpt")
    public String askToGpt(String question) throws JsonProcessingException {

        String username = "qwe";
        question = "1.\t오늘의 날씨를 보고 입을 옷을 옷 데이터 중에서 골라줘. 반드시 항목 중에서 골라야 해. \n" +
                "모자, 겉옷, 상의, 하의, 양말, 신발이 서로 조화가 잘 되도록 골라줘.\n" +
                "모자, 겉옷은 필요하면 안 입을 수 있어,\n" +
                "하지만 상의, 하의, 양말, 신발은 반드시 골라야 해\n" +
                "2.\t미세먼지 상태를 보고 마스크 착용 여부도 알려줘\n" +
                "3.\t답변은 목록 형태로 액셀에 입력하기 좋은 목록 형태로 출력해줘\n" +
                "ex) 모자 OO/없음 // 겉옷 OO//없음 // 상의 OO // 하의 OO // 양말 OO // 신발 OO // 마스크 착용 권장/필수/없음\n" +
                "\n" +
                "오늘의 날씨\n" +
                "[WQ(category=1시간 기온, fcstValue=18℃), WQ(category=풍속(동서성분), fcstValue=4.7m/s), WQ(category=풍속(남북성분), fcstValue=-1.8m/s), WQ(category=풍향, fcstValue=WNW), WQ(category=풍속, fcstValue=5.1m/s), WQ(category=하늘상태, fcstValue=맑음), WQ(category=강수형태, fcstValue=강수없음), WQ(category=강수확률, fcstValue=0%), WQ(category=파고, fcstValue=0M), WQ(category=1시간 강수량, fcstValue=강수없음)]\n" +
                "\n" +
                "오늘의 미세먼지\n" +
                "PQ(pm25grade=좋음, pm25value=9, pm10grade=점검 중, pm10value=25)\n" +
                "옷 데이터\n" +
                "[ClothDTO(id=14, userid=null, category=모자, clothdata=다채로운 블랙 볼캡), ClothDTO(id=15, userid=null, category=모자, clothdata=그레이 시크한 털 모피 장식 비니), ClothDTO(id=16, userid=null, category=모자, clothdata=베레모 레드 클래식한), ClothDTO(id=17, userid=null, category=모자, clothdata=네이비 우아한 플랫 브림 페도라), ClothDTO(id=18, userid=null, category=모자, clothdata=카모플라지 캐주얼한 가죽 스트랩 헌팅캡), ClothDTO(id=19, userid=null, category=상의, clothdata=화이트 심플한 캐주얼한 티셔츠), ClothDTO(id=20, userid=null, category=상의, clothdata=라이트 블루 포멀한 셔츠), ClothDTO(id=21, userid=null, category=상의, clothdata=그린 편안한 스웨터), ClothDTO(id=22, userid=null, category=상의, clothdata=후드티 고급스러운 핑크), ClothDTO(id=23, userid=null, category=상의, clothdata=블라우스 핑크 정장용), ClothDTO(id=30, userid=null, category=하의, clothdata=진청 데일리한 청바지), ClothDTO(id=31, userid=null, category=하의, clothdata=카키 클래식한 슬랙스), ClothDTO(id=32, userid=null, category=하의, clothdata=그레이 스포티한 조거 팬츠), ClothDTO(id=33, userid=null, category=하의, clothdata=블랙 유니크한 레깅스), ClothDTO(id=34, userid=null, category=하의, clothdata=네이비 캐주얼한 반바지), ClothDTO(id=35, userid=null, category=겉옷, clothdata=블랙 편안한 자켓), ClothDTO(id=36, userid=null, category=겉옷, clothdata=카멜 우아한 코트), ClothDTO(id=37, userid=null, category=겉옷, clothdata=네이비 클래식한 야상), ClothDTO(id=38, userid=null, category=겉옷, clothdata=다크 그린 따뜻한 패딩), ClothDTO(id=39, userid=null, category=겉옷, clothdata=베이지 스타일리시한 트렌치코트), ClothDTO(id=40, userid=null, category=양말, clothdata=화이트 베이직한 스니커즈 양말), ClothDTO(id=41, userid=null, category=양말, clothdata=블랙 심플한 드레스 양말), ClothDTO(id=42, userid=null, category=양말, clothdata=그레이 스포티한 스포츠 양말), ClothDTO(id=43, userid=null, category=양말, clothdata=파스텔 핑크 세련된 앵클 양말), ClothDTO(id=44, userid=null, category=양말, clothdata=스트라이프 유용한 무릎 양말), ClothDTO(id=46, userid=null, category=신발, clothdata=화이트 심플한 캔버스 스니커즈), ClothDTO(id=47, userid=null, category=신발, clothdata=브라운 클래식한 레더 구두), ClothDTO(id=48, userid=null, category=신발, clothdata=블랙 편안한 스웨이드 부츠), ClothDTO(id=49, userid=null, category=신발, clothdata=네이비 시크한 캔버스 플랫슈즈), ClothDTO(id=50, userid=null, category=신발, clothdata=골드 여성스러운 스트랩 샌들)]\n";
        String answer = gptService.getGptResponse(question);

        GptanswervoDto gptanswervoDto = new GptanswervoDto(username, question, answer);
        saveAnswerService.saveAnswer(gptanswervoDto);

        return answer;
    }

    @GetMapping("/gptMain")
    public String gptMain() {
        return "GptMain";
    }

}
