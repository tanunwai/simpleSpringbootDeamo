package com.springboot.simpleiuds.domain;

import com.springboot.simpleiuds.beans.Memberships;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
public interface MemberDao {
    List<Memberships> findAll();
    Memberships insertOrUpdate(Memberships members);
    Memberships deleteMembers(Integer id);
    @Transactional
    @Modifying
    @Query(value = "update memberships set username=?1,password=?2,realname=?3,email=?4,phone=?5,sex=?6,birthday=?7,address=?8 where memberid=?9")
    Memberships findById(Integer id);
}
