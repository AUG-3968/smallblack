package com.jskj.model.dao;

import com.jskj.entities.Brand;
import com.jskj.entities.Kind;
import com.jskj.entities.ModelViewbean;
import com.jskj.entities.Phoneinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lintao
 */
@Mapper
public interface ModelMapper {
    //模具管理模块开始
    /**
     * 查询所有型号信息
     * @return
     */
    @Select("select kid,kname from kind")
    List<Kind> showOneSelect();
    /**
     * 二级联动
     * @param kid
     * @return
     */
    @Select("select bid,pbrand,kid from brand where kid=#{value}")
    List<Brand> showLevelTwoSelects(Integer kid);
    /**
     * 三级联动
     * @param bid
     * @return
     */
    @Select("select pid,pmodel,bid from phoneinfo where bid=#{value}")
    List<Phoneinfo> showLevelThreeSelects(Integer bid);
    /**
     * 查询所有模具型号信息
     * @return
     */
    List<ModelViewbean> findAllModel(@Param(value="kind") String kind, @Param(value="bname")String bname, @Param(value="pmodel")String pmodel);
    /**
     * 通过pid删除型号信息
     * @param pids
     * @return
     */
    @Delete("<script>DELETE FROM phoneinfo where pid in <foreach collection='array' item='id' open='(' separator=',' close=')'> #{id} </foreach> </script>")
    int deleteOrdersBypids(String[] pids);
    @Update("DELETE FROM phoneinfo WHERE pid=#{arg0}")
    int deleteOrdersBypid(String pid);
    //模具管理模块结束
    /**
     * 根据材质、品牌、型号 查询是否以及存在该型号的配置
     * @param cz 材质
     * @param brand 品牌
     * @param phone 型号
     * @return
     */
    @Select("SELECT count(*) FROM brand LEFT JOIN phoneinfo ON phoneinfo.bid = brand.bid WHERE kid=#{arg0} and brand.bid=#{arg} and pmodel=#{arg}")
    int findModelByThree(String cz, String brand, String phone);
    /**
     * 插入对应的手机型号
     * @param phone 型号名称
     * @param brand 品牌id
     */
    @Insert("INSERT INTO phoneinfo(Pmodel,bid) VALUES(#{arg0},#{arg1})")
    void addPmodel(String phone, String brand);
    /**
     * 根据材质、品牌 查询是否以及存在该品牌的配置
     * @param cz 材质id
     * @param brand 品牌名称
     * @return
     */
    @Select("SELECT count(*) FROM brand WHERE kid=#{arg0} AND Pbrand=#{arg1}")
    int findBrandByBidAndKid(String cz, String brand);
    /**
     * 插入对应的手机品牌
     * @param cz 材质id
     * @param brand 品牌名称
     */
    @Insert("INSERT INTO brand(kid,Pbrand) VALUES(#{arg0},#{arg1})")
    void addPbrand(String cz, String brand);
    /**
     * 查询是否存在该材质的配置
     * @param cz 材质名称
     * @return
     */
    @Select("SELECT count(*) FROM kind where kname=#{arg0}")
    int findKindByName(String cz);
    /**
     * 插入新的手机材质类型
     * @param cz 材质名称
     */
    @Insert("INSERT INTO kind(kname) VALUES(#{arg0})")
    void addkName(String cz);
}
