package framework.system.dao;

import framework.system.model.RoleType;

public interface RoleTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_role_type
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_role_type
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int insert(RoleType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_role_type
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int insertSelective(RoleType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_role_type
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    RoleType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_role_type
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int updateByPrimaryKeySelective(RoleType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_role_type
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    int updateByPrimaryKey(RoleType record);
}