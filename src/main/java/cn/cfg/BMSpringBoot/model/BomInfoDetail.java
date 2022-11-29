
package cn.cfg.BMSpringBoot.model;

import lombok.Data;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月26日 上午1:28:21
*/
@Data
public class BomInfoDetail {
	private int id;
	private String comment;
	private String description;
	private String designator;
	private String footprint;
	private int quantity;
	private int bomid;
	private int skuid;
}
