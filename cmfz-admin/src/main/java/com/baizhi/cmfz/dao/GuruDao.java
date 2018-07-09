package com.baizhi.cmfz.dao;


import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Description Guru 数据访问层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-06 15:12:30
 */
public interface GuruDao {

    /*public Guru selectGuru(@Param("guruId") String guruId);*/

    public int updateGuru(Guru guru);

    public List<Guru> selectAllGuru(@Param("value1") String value1,@Param("page") Integer nowPage, @Param("rows") Integer rows);

    public int insertGuru(Guru guru);

    public int count(@Param("value1") String value1);

    public List<Guru> selectAll();

}
