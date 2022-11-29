
package cn.cfg.BMSpringBoot.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.cfg.BMSpringBoot.model.BomInfoDetail;
import cn.cfg.BMSpringBoot.model.MaterielGoodsInfo;
import cn.cfg.BMSpringBoot.model.PcbBomInfo;

import java.util.List;

import org.apache.ibatis.annotations.*;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月23日 下午9:00:42
*/
@Mapper
public interface MaterielGoodsSelectMapper {
	//查询所有库存信息
	@Select("select * from MaterielGoodsInfo")
	List<MaterielGoodsInfo> findall();
	//新增库存信息
	@Insert("insert into MaterielGoodsInfo (comment,description,designator,footprint,quantity) values(#{comment},#{description},#{designator},#{footprint},#{quantity})")
	void addMaterielGoodsInfo(String comment, String description,String designator,String footprint,int quantity);
	//修改指定库存数量
	@Update("update MaterielGoodsInfo set quantity = #{updatenum} where id = #{id}")
	void UpdateMaterielGoodsNum(int id,int updatenum);
	//删除当前库存信息
	@Delete("delete from MaterielGoodsInfo where id =#{id}" )
	void DeleteMaterielGoodsInfo(int id );
	//查询单个库存信息
	@Select("select * from MaterielGoodsInfo where id = #{skuid}")
	List<MaterielGoodsInfo> singlegoodsinfo(int skuid);
	
	
	//查询所有板子信息
	@Select("select * from pcbbominfo")
	List<PcbBomInfo> findbominfo();
	//查询单个板子信息
	@Select("select * from pcbbominfo where bomid = #{bomid}")
	List<PcbBomInfo> selectsinglebominfo(int bomid);
	//删除单个板子信息
	@Delete("delete from pcbbominfo where bomid = #{bomid}")
	void deletesinglebominfo(int bomid);
	//新增单个板子信息
	@Insert("insert into pcbbominfo(bomid,bomname,quantity) values (#{bomid},#{bomname},#{bomquantity})")
	void addpcbbominfo(int bomid ,String bomname,int bomquantity);
	
	
	
	//查看单个板子的清单
	@Select("select * from pcbbominfodetail a left join pcbbominfo b on a.bomid = b.bomid left join materielgoodsinfo c on c.id = a.skuid where b.bomid = #{bomid}")
	List<BomInfoDetail> selectbominfobybomid(int bomid);
	
	//删除单个板子的清单明细
	@Delete("Delete from pcbbominfodetail where bomid = #{bomid} and skuid = #{skuid}")
	void deletebominfodetailbybomidandskuid(int bomid ,int skuid);
	//修改单个板子的清单物资数量
	@Update("update pcbbominfodetail set quantity = #{quantity} where bomid = #{bomid} and skuid = #{skuid}")
	void updatebominfodetailbybomidandskuid(int bomid ,int skuid,int quantity);
	
	//插入单个板子的清单明细
	@Insert ("insert into pcbbominfodetail (bomid,skuid,quantity) values (#{bomid},#{skuid},#{quantity})")
	void addbominfodetail(int bomid,int skuid,int quantity);
}
