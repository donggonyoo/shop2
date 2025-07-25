package kr.gdu.dao.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.gdu.logic.SaleItem;

@Mapper
public interface SaleItemMapper {

	@Insert("insert  into saleitem "
			+ "values (#{saleid},#{seq},#{itemid},#{quantity})")
	void insert(SaleItem saleItem);

	@Select("select * from saleitem where saleid = #{saleid}")
	List<SaleItem> list(int saleid);
	
	

}
