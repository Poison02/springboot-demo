package cdu.zch.demo21mybatisgeneratorpage;

import cdu.zch.demo21mybatisgeneratorpage.mapper.AccountMapper;
import cdu.zch.demo21mybatisgeneratorpage.pojo.Account;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Demo21MybatisGeneratorPageApplicationTests {

    @Resource
    private AccountMapper accountMapper;

    @Test
    void contextLoads() {

        int pageNum = 1;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<Account> accounts = accountMapper.selectByExample(null);
        PageInfo<Account> pageInfo = new PageInfo<>(accounts, 1);
        System.out.println(pageInfo);
        /*
        PageInfo{pageNum=1, pageSize=3, size=2, startRow=1, endRow=2, total=2, pages=1,
        list=Page{count=true, pageNum=1, pageSize=3, startRow=0, endRow=3, total=2, pages=1, reasonable=false, pageSizeZero=false}
        [Account{actno='act001', balance=30000.0}, Account{actno='act002', balance=30000.0}], prePage=0, nextPage=0, isFirstPage=true,
        isLastPage=true, hasPreviousPage=false, hasNextPage=false, navigatePages=1, navigateFirstPage=1, navigateLastPage=1, navigatepageNums=[1]}
         */

    }

}
