package cdu.zch.demo21mybatisgeneratorpage.mapper;

import cdu.zch.demo21mybatisgeneratorpage.pojo.Account;
import cdu.zch.demo21mybatisgeneratorpage.pojo.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 20698
 */
@Repository("accountMapper")
public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(String actno);

    int insert(Account row);

    int insertSelective(Account row);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(String actno);

    int updateByExampleSelective(@Param("row") Account row, @Param("example") AccountExample example);

    int updateByExample(@Param("row") Account row, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account row);

    int updateByPrimaryKey(Account row);
}