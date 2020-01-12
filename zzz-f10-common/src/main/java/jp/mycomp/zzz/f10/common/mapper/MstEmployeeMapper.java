package jp.mycomp.zzz.f10.common.mapper;

import java.util.List;
import jp.mycomp.zzz.f10.common.entity.MstEmployee;
import jp.mycomp.zzz.f10.common.entity.MstEmployeeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MstEmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    long countByExample(MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int deleteByExample(MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(@Param("cid") String cid, @Param("eid") String eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int insert(MstEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int insertSelective(MstEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    List<MstEmployee> selectByExampleWithBLOBs(MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    List<MstEmployee> selectByExample(MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    MstEmployee selectByPrimaryKey(@Param("cid") String cid, @Param("eid") String eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MstEmployee record, @Param("example") MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") MstEmployee record, @Param("example") MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MstEmployee record, @Param("example") MstEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MstEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(MstEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_employee
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MstEmployee record);
}