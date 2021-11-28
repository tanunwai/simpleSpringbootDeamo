package com.springboot.simpleiuds.domain;

import com.springboot.simpleiuds.beans.Memberships;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Memberships,Integer> {
}
