package com.springboot.simpleiuds.service;

import com.springboot.simpleiuds.beans.Memberships;
import com.springboot.simpleiuds.domain.MemberDao;
import com.springboot.simpleiuds.domain.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipsService implements MemberDao {
    private static final Logger LOGGER= LoggerFactory.getLogger(MembershipsService.class);


    private final MemberRepository memberRepository;
    @Autowired
    public MembershipsService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Override
    public List<Memberships> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Memberships insertOrUpdate(Memberships members) {
        LOGGER.info("新增或修改會員 :"+members.toString());
        return memberRepository.save(members);
    }

    @Override
    public Memberships deleteMembers(Integer id) {
        Memberships members=memberRepository.findById(id).get();
        memberRepository.delete(members);
        LOGGER.info("刪除會員 :"+members.toString());
        return members;
    }

    @Override
    public Memberships findById(Integer id) {
        LOGGER.info("獲取會員編號 :"+id);
        return memberRepository.findById(id).get();
    }
}
