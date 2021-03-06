package com.yuanyuansinian.model.hall;

public class Hall {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.Id
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.title
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.description
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.imgs
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String imgs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.name
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.alias
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String alias;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.sex
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String sex;
    private String sex_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.nationality
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String nationality;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.nation
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String nation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.address
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.belief
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String belief;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.birthplace
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String birthplace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.native_place
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String native_place;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.open_type
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String open_type;
    private String open_type_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.status
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String status;
    private String status_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.create_date
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String create_date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.validity
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String validity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.create_user
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String create_user;
    private String create_user_name;
    
    private String hall_type;
    private String hall_type_name;

    //在世时间
    private String alive_date;
    //生效
    private String zodiac;
    //生日
    private String birthday;
    //去世时间
    private String death_date;
    //离世天数
    private int days;
    //模版id
    private String template_id;
    private String template_imgs;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.Id
     *
     * @return the value of ujn_hall.Id
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.Id
     *
     * @param id the value for ujn_hall.Id
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.title
     *
     * @return the value of ujn_hall.title
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.title
     *
     * @param title the value for ujn_hall.title
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.description
     *
     * @return the value of ujn_hall.description
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.description
     *
     * @param description the value for ujn_hall.description
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.imgs
     *
     * @return the value of ujn_hall.imgs
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.imgs
     *
     * @param imgs the value for ujn_hall.imgs
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.name
     *
     * @return the value of ujn_hall.name
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.name
     *
     * @param name the value for ujn_hall.name
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.alias
     *
     * @return the value of ujn_hall.alias
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getAlias() {
        return alias;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.alias
     *
     * @param alias the value for ujn_hall.alias
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.sex
     *
     * @return the value of ujn_hall.sex
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.sex
     *
     * @param sex the value for ujn_hall.sex
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.nationality
     *
     * @return the value of ujn_hall.nationality
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.nationality
     *
     * @param nationality the value for ujn_hall.nationality
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.nation
     *
     * @return the value of ujn_hall.nation
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getNation() {
        return nation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.nation
     *
     * @param nation the value for ujn_hall.nation
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.address
     *
     * @return the value of ujn_hall.address
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.address
     *
     * @param address the value for ujn_hall.address
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.belief
     *
     * @return the value of ujn_hall.belief
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getBelief() {
        return belief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.belief
     *
     * @param belief the value for ujn_hall.belief
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setBelief(String belief) {
        this.belief = belief == null ? null : belief.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.birthplace
     *
     * @return the value of ujn_hall.birthplace
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.birthplace
     *
     * @param birthplace the value for ujn_hall.birthplace
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.native_place
     *
     * @return the value of ujn_hall.native_place
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getNative_place() {
        return native_place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.native_place
     *
     * @param native_place the value for ujn_hall.native_place
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setNative_place(String native_place) {
        this.native_place = native_place == null ? null : native_place.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.open_type
     *
     * @return the value of ujn_hall.open_type
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getOpen_type() {
        return open_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.open_type
     *
     * @param open_type the value for ujn_hall.open_type
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setOpen_type(String open_type) {
        this.open_type = open_type == null ? null : open_type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.status
     *
     * @return the value of ujn_hall.status
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.status
     *
     * @param status the value for ujn_hall.status
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.create_date
     *
     * @return the value of ujn_hall.create_date
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.create_date
     *
     * @param create_date the value for ujn_hall.create_date
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setCreate_date(String create_date) {
        this.create_date = create_date == null ? null : create_date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.validity
     *
     * @return the value of ujn_hall.validity
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getValidity() {
        return validity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.validity
     *
     * @param validity the value for ujn_hall.validity
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setValidity(String validity) {
        this.validity = validity == null ? null : validity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.create_user
     *
     * @return the value of ujn_hall.create_user
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getCreate_user() {
        return create_user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.create_user
     *
     * @param create_user the value for ujn_hall.create_user
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setCreate_user(String create_user) {
        this.create_user = create_user == null ? null : create_user.trim();
    }

	public String getSex_name() {
		return sex_name;
	}

	public void setSex_name(String sex_name) {
		this.sex_name = sex_name;
	}

	public String getOpen_type_name() {
		return open_type_name;
	}

	public void setOpen_type_name(String open_type_name) {
		this.open_type_name = open_type_name;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public String getCreate_user_name() {
		return create_user_name;
	}

	public void setCreate_user_name(String create_user_name) {
		this.create_user_name = create_user_name;
	}

	public String getHall_type() {
		return hall_type;
	}

	public void setHall_type(String hall_type) {
		this.hall_type = hall_type;
	}

	public String getHall_type_name() {
		return hall_type_name;
	}

	public void setHall_type_name(String hall_type_name) {
		this.hall_type_name = hall_type_name;
	}

	public String getAlive_date() {
		return alive_date;
	}

	public void setAlive_date(String alive_date) {
		this.alive_date = alive_date;
	}

	public String getZodiac() {
		return zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeath_date() {
		return death_date;
	}

	public void setDeath_date(String death_date) {
		this.death_date = death_date;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getTemplate_imgs() {
		return template_imgs;
	}

	public void setTemplate_imgs(String template_imgs) {
		this.template_imgs = template_imgs;
	}

}