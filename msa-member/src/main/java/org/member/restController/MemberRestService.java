package org.member.restController;

import org.springframework.stereotype.Service;

@Service
public class MemberRestService {

    public final MemberRestRepository memberRestRepository;

    public MemberRestService(MemberRestRepository memberRestRepository) {
        this.memberRestRepository = memberRestRepository;
    }

    public boolean existsByUsername(String username) {
        return memberRestRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return memberRestRepository.existsByEmail(email);
    }

}
