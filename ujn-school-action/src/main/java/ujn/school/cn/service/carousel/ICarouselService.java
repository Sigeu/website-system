/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.carousel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ujn.school.cn.model.carousel.Carousel;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface ICarouselService {

	/**
	 * 
	 * @Description: 更新
	 * @param carousel
	 * @return
	 */
	int updateCarousel(Carousel carousel);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param carouselId
	 * @return
	 */
	Carousel queryCarouselById(int carouselId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param carousel
	 * @return
	 */
	List<Carousel> queryCarouselList(Carousel carousel);

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param carousel
	 * @return
	 */
	int addCarousel(HttpServletRequest request, Carousel carousel);

	/**
	 * 
	 * @Description: 删除
	 * @param carouselId
	 * @return
	 */
	int deleteCarousel(int carouselId);

	void uploadCarouselImg(HttpServletRequest request, String id);

}
