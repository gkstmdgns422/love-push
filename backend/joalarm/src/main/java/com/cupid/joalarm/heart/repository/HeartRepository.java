package com.cupid.joalarm.heart.repository;

import com.cupid.joalarm.heart.entity.AccountsEmbedded;
import com.cupid.joalarm.heart.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeartRepository extends JpaRepository<Heart, AccountsEmbedded> {

    @Query("select h.AccountsWhoExchangedHearts.receiveAccount.accountSeq " +
            "from Heart h where h.AccountsWhoExchangedHearts.sendAccount.accountSeq = :seq")
    List<Long> findReceiveMyHeartAccountsSeq(@Param("seq") Long seq);
}
