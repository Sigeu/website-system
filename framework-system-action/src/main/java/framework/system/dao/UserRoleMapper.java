package framework.system.dao;

import java.util.List;

import framework.system.model.UserRole;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_user_role
     *
     * @mbg.generated Wed Feb 15 00:35:15 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_user_role
     *
     * @mbg.generated Wed Feb 15 00:35:15 CST 2017
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_user_role
     *
     * @mbg.generated Wed Feb 15 00:35:15 CST 2017
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_user_role
     *
     * @mbg.generated Wed Feb 15 00:35:15 CST 2017
     */
    UserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_user_role
     *
     * @mbg.generated Wed Feb 15 00:35:15 CST 2017
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_user_role
     *
     * @mbg.generated Wed Feb 15 00:35:15 CST 2017
     */
    int updateByPrimaryKey(UserRole record);

	List<UserRole> queryUserRoleTree(String user_code);

	void deleteByUserCode(String login_name);
}