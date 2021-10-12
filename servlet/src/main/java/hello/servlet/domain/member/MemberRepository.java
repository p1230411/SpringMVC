package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
    
    public static void main(String[] args){
        Member member1 = new Member("test1",1);
        Member saveMember = MemberRepository.getInstance().save(member1);

        Member member2 = new Member("test2",2);
        Member saveMembe = MemberRepository.getInstance().save(member2);

        List<Member> findList = MemberRepository.getInstance().findAll();
        for (Member find:findList) {
            System.out.println(find.getUsername());
        }


    }
}
