package framework.system.dao;

import java.util.List;

import framework.system.model.Code;

public interface CodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_code
     *
     * @mbg.generated Thu Mar 16 15:45:12 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_code
     *
     * @mbg.generated Thu Mar 16 15:45:12 CST 2017
     */
    int insert(Code record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_code
     *
     * @mbg.generated Thu Mar 16 15:45:12 CST 2017
     */
    int insertSelective(Code record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_code
     *
     * @mbg.generated Thu Mar 16 15:45:12 CST 2017
     */
    Code selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_code
     *
     * @mbg.generated Thu Mar 16 15:45:12 CST 2017
     */
    int updateByPrimaryKeySelective(Code record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_code
     *
     * @mbg.generated Thu Mar 16 15:45:12 CST 2017
     */
    int updateByPrimaryKey(Code record);

	List<Code> queryCodeList(Code code);

	List<Code> queryCodeListByType(String code_type);

	void deleteCodeByCodeType(String code_type);
}