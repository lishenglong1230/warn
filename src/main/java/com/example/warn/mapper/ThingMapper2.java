package com.example.warn.mapper;

import com.example.warn.model.Thing;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ThingMapper2 {


    /*
        通过地址找到信息
     */
    @Select("SELECT * FROM things WHERE address =#{address}")
    Thing findByAddress(@Param("address") String address);

    @Select("SELECT * FROM things WHERE id =#{id}")
    Thing findById(@Param("id") Integer id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "address", column = "address"),
            @Result(property = "type", column = "type"),
            @Result(property = "time", column = "time")
    })



    /*
        查询全部信息
     */
    @Select("SELECT id, address, type, time FROM things")
    List<Thing> findAll();

    /*
        插入一条数据
        传对象
     */
    @Insert("INSERT INTO things(address, type, time) VALUES(#{address}, #{type}, #{time})")
    int insertByThing(Thing thing);


    @Insert("INSERT INTO things(address, type, time) VALUES(#{address}, #{type}, #{time})")
    int insert(@Param("address") String address, @Param("type") String type, @Param("time") String time);


    /*
        通过id删除
     */
    @Delete("DELETE FROM things WHERE id =#{id}")
    void delete(Long id);


    @Insert("INSERT INTO things(address, type, time) VALUES(#{address,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

     /*
        暂时不用
     */
    /*@Update("UPDATE things SET address=#{address} WHERE address=#{address}")
    void update(Thing thing);*/

}