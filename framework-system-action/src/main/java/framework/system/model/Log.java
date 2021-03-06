package framework.system.model;

public class Log {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_log.Id
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_log.type
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    private String type;
    private String type_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_log.operation
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    private String operation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_log.user
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    private String user;
    private String user_name;
    
    
    private String date_start;
    private String date_end;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_log.ip
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_log.create_date
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    private String create_date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_log.Id
     *
     * @return the value of ujn_log.Id
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_log.Id
     *
     * @param id the value for ujn_log.Id
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_log.type
     *
     * @return the value of ujn_log.type
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_log.type
     *
     * @param type the value for ujn_log.type
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_log.operation
     *
     * @return the value of ujn_log.operation
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_log.operation
     *
     * @param operation the value for ujn_log.operation
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_log.user
     *
     * @return the value of ujn_log.user
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_log.user
     *
     * @param user the value for ujn_log.user
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_log.ip
     *
     * @return the value of ujn_log.ip
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_log.ip
     *
     * @param ip the value for ujn_log.ip
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_log.create_date
     *
     * @return the value of ujn_log.create_date
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_log.create_date
     *
     * @param create_date the value for ujn_log.create_date
     *
     * @mbg.generated Thu Feb 09 18:39:43 CST 2017
     */
    public void setCreate_date(String create_date) {
        this.create_date = create_date == null ? null : create_date.trim();
    }

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
}