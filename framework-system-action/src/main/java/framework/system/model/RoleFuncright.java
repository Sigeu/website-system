package framework.system.model;

public class RoleFuncright {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_role_funcright.Id
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_role_funcright.role_code
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    private String role_code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_role_funcright.funcright_code
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    private String funcright_code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_role_funcright.status
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_role_funcright.Id
     *
     * @return the value of ujn_role_funcright.Id
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_role_funcright.Id
     *
     * @param id the value for ujn_role_funcright.Id
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_role_funcright.role_code
     *
     * @return the value of ujn_role_funcright.role_code
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public String getRole_code() {
        return role_code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_role_funcright.role_code
     *
     * @param role_code the value for ujn_role_funcright.role_code
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public void setRole_code(String role_code) {
        this.role_code = role_code == null ? null : role_code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_role_funcright.funcright_code
     *
     * @return the value of ujn_role_funcright.funcright_code
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public String getFuncright_code() {
        return funcright_code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_role_funcright.funcright_code
     *
     * @param funcright_code the value for ujn_role_funcright.funcright_code
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public void setFuncright_code(String funcright_code) {
        this.funcright_code = funcright_code == null ? null : funcright_code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_role_funcright.status
     *
     * @return the value of ujn_role_funcright.status
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_role_funcright.status
     *
     * @param status the value for ujn_role_funcright.status
     *
     * @mbg.generated Wed Jan 18 11:12:08 CST 2017
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}