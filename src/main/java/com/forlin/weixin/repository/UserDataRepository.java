package com.forlin.weixin.repository;

import com.forlin.weixin.entity.AccountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2016/3/23.
 */
@Repository
public interface UserDataRepository extends JpaRepository<AccountData, Integer> {
}
