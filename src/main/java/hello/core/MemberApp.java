package hello.core;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerivce;

public class MemberApp {
    //순수 자바코드로만 테스트
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberSerivce memberSerivce = appConfig.memberSerivce();

        //MemberSerivce memberSerivce = new MemberSerivceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberSerivce.join(member);

        Member findeMember = memberSerivce.findeMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.printf("find Member = " +findeMember.getName());

    }
}
