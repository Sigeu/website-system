package com.suncity.model.cart;

public class Cart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_cart.Id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_cart.product_id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    private String product_id;
    private String product_name;

    private String product_pic;
    
    private String price_site;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_cart.member_id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    private String member_id;
    private String member_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_cart.product_num
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    private Integer product_num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_cart.create_date
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    private String create_date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_cart.Id
     *
     * @return the value of ujn_cart.Id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_cart.Id
     *
     * @param id the value for ujn_cart.Id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_cart.product_id
     *
     * @return the value of ujn_cart.product_id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_cart.product_id
     *
     * @param product_id the value for ujn_cart.product_id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id == null ? null : product_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_cart.member_id
     *
     * @return the value of ujn_cart.member_id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public String getMember_id() {
        return member_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_cart.member_id
     *
     * @param member_id the value for ujn_cart.member_id
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public void setMember_id(String member_id) {
        this.member_id = member_id == null ? null : member_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_cart.product_num
     *
     * @return the value of ujn_cart.product_num
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public Integer getProduct_num() {
        return product_num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_cart.product_num
     *
     * @param product_num the value for ujn_cart.product_num
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public void setProduct_num(Integer product_num) {
        this.product_num = product_num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_cart.create_date
     *
     * @return the value of ujn_cart.create_date
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_cart.create_date
     *
     * @param create_date the value for ujn_cart.create_date
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    public void setCreate_date(String create_date) {
        this.create_date = create_date == null ? null : create_date.trim();
    }

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getProduct_pic() {
		return product_pic;
	}

	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}

	public String getPrice_site() {
		return price_site;
	}

	public void setPrice_site(String price_site) {
		this.price_site = price_site;
	}
}