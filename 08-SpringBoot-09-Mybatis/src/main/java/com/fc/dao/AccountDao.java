package com.fc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    void increase(@Param("id") Integer id, @Param("money") Integer money);
    void decrease(@Param("id") Integer id, @Param("money") Integer money);
}
