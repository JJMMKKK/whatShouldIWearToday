package org.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreRepository extends JpaRepository<MemberVO, Integer> {
}