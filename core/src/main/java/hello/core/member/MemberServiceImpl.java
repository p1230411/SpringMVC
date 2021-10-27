package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component      // ComponentScan 이 자동으로 읽음
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        System.out.println("member = " + member);
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        System.out.println("memberId = " + memberId);
        System.out.println("findById(memberId) = " + memberRepository.findById(memberId));
        return memberRepository.findById(memberId);
    }

    @Override
    public MemberRepository getMemberRepository(){
        return this.memberRepository;
    }
}
