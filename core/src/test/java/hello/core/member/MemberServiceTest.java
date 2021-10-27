package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
//    AnnotationConfigApplicationContext df = new AnnotationConfigApplicationContext(AppConfig.class);
//    MemberService memberService;
//    MemberService memberService2;
//    MemberService memberService3;


    @BeforeEach
    public void befoeEach(){

//        AppConfig appConfig = new AppConfig();
//        AppConfig appConfig2 = new AppConfig();
//        AppConfig appConfig3 = new AppConfig();
//        memberService = appConfig.memberService();
//        memberService2 = appConfig2.memberService();
//        memberService3 = appConfig3.memberService();


    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        //AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext df = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberRepository memberRepository1 = df.getBean(MemberRepository.class);

        MemberRepository memberRepository2 = df.getBean(MemberRepository.class);
        System.out.println("memberRepository1 : " + memberRepository1);
        System.out.println("memberRepository2 : " + memberRepository2);

        OrderService orderService = df.getBean(OrderService.class);
        MemberService memberService = df.getBean(MemberService.class);

        MemberRepository memberRepository = orderService.getMemberRepository();
        MemberRepository memberRepository3 = memberService.getMemberRepository();
        System.out.println("orderService.getMemberRepository() : " + memberRepository);
        System.out.println("memberService.getMemberRepository() : " + memberRepository3);



        String[] beanDefinitionNames = df.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = df.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + bean.getClass().getName() + " bean = " + bean);
        }
    }
}
