package com.xoado.FilingCabinet.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoado.FilingCabinet.bean.TblArchives;
import com.xoado.FilingCabinet.bean.TblBoxes;
import com.xoado.FilingCabinet.bean.TblCurrentArchives;
import com.xoado.FilingCabinet.bean.TblCurrentArchivesExample;
import com.xoado.FilingCabinet.bean.TblCurrentArchivesExample.Criteria;
import com.xoado.FilingCabinet.common.XDboex;
import com.xoado.FilingCabinet.mapper.TblArchivesMapper;
import com.xoado.FilingCabinet.mapper.TblBoxesMapper;
import com.xoado.FilingCabinet.mapper.TblCurrentArchivesMapper;
import com.xoado.FilingCabinet.service.IBoxes;
import com.xoado.common.MD5;
import com.xoado.common.XoadoResult;
import com.xoado.protocol.AccessIdentity;
import com.xoado.protocol.BaseRetCode;
import com.xoado.protocol.XoadoConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
* @author 作者
* @version 创建时间：2018年8月4日 下午3:41:10
* 类说明
*/
@Service
public class Boxes implements IBoxes{

	@Autowired
	private TblBoxesMapper boxesMapper;
	@Autowired
	private TblCurrentArchivesMapper tblCurrentArchivesMapper;
	@Autowired
	private TblArchivesMapper tblArchivesMapper;
	/**
	 * 
	 * @param boxname  档案柜名称
	 * @param owner_orgid 所属组织Id
	 * @param owner_orgname 所属组织名称
	 * @param scopeofuse  使用类型   enum private public
	 * @param location_address  地址的具体信息
	 * @param location_longitude  经度
	 * @param location_latitude  纬度
	 * @param remarks 备注
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult Add_Boex(String boxname, String owner_orgid, String owner_orgname, String scopeofuse,
			String location_address, double location_longitude, double location_latitude, String remarks,
			HttpServletRequest request) {
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String box_id = MD5.MD5Encode(UUID.randomUUID().toString());
		String moveable ="unmovable";//是否可携带 unmovable portability  enum
		JSONObject locationjson = new JSONObject();
		locationjson.put("location_address", location_address);
		locationjson.put("location_longitude", location_longitude);
		locationjson.put("location_latitude", location_latitude);
		JSONObject orgjson = new JSONObject();
		orgjson.put("owner_orgid", owner_orgid);
		orgjson.put("owner_orgname", owner_orgname);
		JSONObject createrjson = new JSONObject();
		createrjson.put("creater_id", token.getUserId());
		createrjson.put("creater_name", "");
		TblBoxes boxes = new TblBoxes();
		boxes.setBoxId(box_id);
		boxes.setBoxName(boxname);
		boxes.setScopeofuse(scopeofuse);
		boxes.setMoveable(moveable);
		boxes.setLocation(locationjson.toString());
		boxes.setOwnerOrg(orgjson.toString());
		boxes.setShareto(new JSONArray().toString());
		boxes.setCreater(createrjson.toString());
		boxes.setCreaterTime(new Date());
		boxes.setRemarks(remarks);
		boxes.setUseState(0);
		boxes.setCloseState("open");
		boxesMapper.insert(boxes);
		
		JSONObject object = new JSONObject();
		object.put("boxid", box_id);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),object.toString());
	}

	/**
	 * 
	 * @param request
	 * @return  返回当前用户有权限的档案柜列表，包括创建的和别人共享的
	 */
	@Override
	public XoadoResult Obtain_current_users(HttpServletRequest request) {
//		查找当前用户自己创建的档案柜
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String sql = "SELECT box.box_id,box.box_name,box.owner_org,box.scopeofuse,box.location,box.use_state,box.close_state,box.remarks FROM tbl_boxes AS box WHERE JSON_CONTAINS(creater,'{\"creater_id\":\""+token.getUserId()+"\"}') || JSON_CONTAINS(shareto,'{\"userid\":\""+token.getUserId()+"\"}')";
		List<LinkedHashMap<String,Object>> list = boxesMapper.selectGis(sql);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),list);
	}
	/**
	 * 删除一个自己创建的空档案柜
	 * @param boxid  删除指定的档案柜
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult remove_boex(String boxid, HttpServletRequest request) {
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		TblBoxes key = boxesMapper.selectByPrimaryKey(boxid);
		if(key==null){
			return XoadoResult.build(202, "没有此档案柜");
		}
//		判断当前档案柜是否存在资料
		TblCurrentArchivesExample example = new TblCurrentArchivesExample();
		Criteria criteria = example.createCriteria();
		criteria.andOwneridEqualTo(boxid);
		List<TblCurrentArchives> list = tblCurrentArchivesMapper.selectByExample(example);
		if(list!=null &&list.size()!=0){
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), "不能进行删除，存在");
		}
//		判断档案柜是否是当前用户创建
		Object creater = key.getCreater();
		JSONObject createjson = JSONObject.fromObject(creater);
		String creater_id =(String) createjson.get("creater_id");
		if(token.getUserId().equals(creater_id)){
			key.setUseState(0);
			boxesMapper.updateByPrimaryKey(key);
			return XoadoResult.ok();
		}
		return XoadoResult.build(202, "不是柜子所有者 不能进行删除");
	}
	/**
	 * 指定一个档案柜共享给一个或者多个人
	 * @param userid  共享给的人
	 * @param boxid  指定的档案柜
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult share_boexAddUser(String userid, String username, String boxid, HttpServletRequest request) {
		
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
//		档案柜是否是当前用户所创建
		TblBoxes key = boxesMapper.selectByPrimaryKey(boxid);
		JSONObject createjson = JSONObject.fromObject(key.getCreater());
		String creater_id =(String) createjson.get("creater_id");
		if(token.getUserId().equals(creater_id)){
			Object shareto = key.getShareto();
			JSONArray fromObject = JSONArray.fromObject(shareto);
			for (int i = 0; i < fromObject.size(); i++) {
				Object object = fromObject.get(i);
				 JSONObject fromObject2 = JSONObject.fromObject(object);
				 Object Y_userid = fromObject2.get("userid");
				 if(Y_userid.equals(userid)){
					 return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), "当前共享存在此用户");
				 }
			}
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userid", userid);
			jsonObject.put("username", username);
			fromObject.add(jsonObject);
			key.setShareto(fromObject.toString());
			boxesMapper.updateByPrimaryKey(key);
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg());
		}
		return null;
	}
	/**
	 * 将指定的一个或者多个人从当前档案柜共享中删除
	 * @param userid  指定删除的人
	 * @param boxid  指定的档案柜
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult share_boexRemoveUser(String userid, String boxid, HttpServletRequest request) {
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
//		获取数据
		TblBoxes key = boxesMapper.selectByPrimaryKey(boxid);
//		获取当前用户的创建人
		JSONObject createjson = JSONObject.fromObject(key.getCreater());
//		判断是当前档案柜是否属于此用户
		String creater_id =(String) createjson.get("creater_id");
		if(token.getUserId().equals(creater_id)){
//		获取共享字段json数组
			Object shareto = key.getShareto();
			JSONArray fromObject = JSONArray.fromObject(shareto);
//			将json字段遍历
			for (int i = 0; i < fromObject.size(); i++) {
//				取出json数组字段所对应object
				Object object = fromObject.get(i);
				 JSONObject fromObject2 = JSONObject.fromObject(object);
//				 判断jsonObject是否有该共享用户
				 Object Y_userid = fromObject2.get("userid");
//				 与传入的userid比对
				 if(Y_userid.equals(userid)){
//					 如果存在共享的用户则删除掉
					 fromObject.remove(i);
					 key.setShareto(fromObject.toString());
					 boxesMapper.updateByPrimaryKey(key);
					 return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg());
				 }
				 return XoadoResult.build(202, "没有该共享用户");
			}
		}
		return XoadoResult.build(202, "不是管理员");
	}
	/**
	 * 	返回指定档案柜详情（创建人和被授权人）。
	 * @param boexId
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult get_boex_particulars(String Boexid, HttpServletRequest request) {
		/**
		 * 要查档案柜的详细信息  必须是所属人或者共享用户
		 */
//		如果是所属人，需对比
//		创建一个json作为返回值
//		String sql = "SELECT BOEX.box_id,BOEX.box_name,BOEX.owner_org,BOEX.scopeofuse,BOEX.location,BOEX.remarks,BOEX.close_state,BOEX.creater,BOEX.creater_time,BOEX.shareto FROM tbl_boxes AS BOEX WHERE box_id=\""+Boexid+"\"";
		JSONObject jsonObject = new JSONObject();
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		TblBoxes key = boxesMapper.selectByPrimaryKey(Boexid);
		
		Object creater = key.getCreater();
		JSONObject fromObject = JSONObject.fromObject(creater);
		String creater_id =(String) fromObject.get("creater_id");
//		进行比对
		
		if(token.getUserId().equals(creater_id)){	
			XDboex dboex = new XDboex();
			dboex.setBoxid(key.getBoxId());
			dboex.setBoxname(key.getBoxName());
			dboex.setOwnerorg(key.getOwnerOrg());
			dboex.setScopeofuse(key.getScopeofuse());
			dboex.setLocation(key.getLocation());
			dboex.setRemarks(key.getRemarks());
			dboex.setClosestate(key.getCloseState());
			dboex.setCreater(key.getCreater());
			dboex.setCreatertime(key.getCreaterTime());
			dboex.setShareto(key.getShareto());
			TblCurrentArchivesExample example = new TblCurrentArchivesExample();
			Criteria criteria = example.createCriteria();
			criteria.andOwneridEqualTo(Boexid);
			List<TblCurrentArchives> list = tblCurrentArchivesMapper.selectByExample(example);
			String archive_id = null;
			for (TblCurrentArchives tblCurrentArchives : list) {
				archive_id = tblCurrentArchives.getArchiveId();
			}
			if(archive_id!=null){
				TblArchives tblArchives = tblArchivesMapper.selectByPrimaryKey(archive_id);
				JSONObject map = new JSONObject();
				map.put("archive_id", tblArchives.getArchiveId());
				map.put("archive_name", tblArchives.getArchiveName());
				map.put("owner_org", tblArchives.getOwnerOrg());
				map.put("comments", tblArchives.getComments());
				map.put("attachment_picture_thumbnail", tblArchives.getAttachmentPicture() );
				map.put("attachment_document_thumbnail", tblArchives.getAttachmentDocument());
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(map);
				dboex.setArchives(jsonArray);
				JSONObject object = JSONObject.fromObject(dboex);
				return XoadoResult.build(200, "",object.toString());
			}
			JSONObject object = JSONObject.fromObject(dboex);
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),object.toString());
	}
//		共享人进行比对
	
		Object shareto = key.getShareto();
		JSONArray jsonArray = JSONArray.fromObject(shareto);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject2 = jsonArray.getJSONObject(i);
			
			Object sharetouserid = jsonObject2.get("userid");
			
			if(sharetouserid.toString().equals(token.getUserId().toString())){
//				判断共享用户是否存在
				XDboex dboex = new XDboex();
				dboex.setBoxid(key.getMoveable());
				dboex.setBoxname(key.getBoxName());
				dboex.setOwnerorg(key.getOwnerOrg());
				dboex.setScopeofuse(key.getScopeofuse());
				dboex.setLocation(key.getLocation());
				dboex.setRemarks(key.getRemarks());
				dboex.setClosestate(key.getCloseState());
				dboex.setCreater(key.getCreater());
				dboex.setCreatertime(key.getCreaterTime());
				dboex.setShareto(key.getShareto());
				TblCurrentArchivesExample example = new TblCurrentArchivesExample();
				Criteria criteria = example.createCriteria();
				criteria.andOwneridEqualTo(Boexid);
				List<TblCurrentArchives> list = tblCurrentArchivesMapper.selectByExample(example);
				String archive_id = null;
				for (TblCurrentArchives tblCurrentArchives : list) {
					archive_id = tblCurrentArchives.getArchiveId();
				}
				if(archive_id==null){
					dboex.setArchives(new JSONArray());
					JSONObject object = JSONObject.fromObject(dboex);
					return XoadoResult.build(0, "",object);
				}
				TblArchives tblArchives = tblArchivesMapper.selectByPrimaryKey(archive_id);
				JSONObject map = new JSONObject();
				map.put("archive_id", tblArchives.getArchiveId());
				map.put("archive_name", tblArchives.getArchiveName());
				map.put("owner_org", tblArchives.getOwnerOrg());
				map.put("comments", tblArchives.getComments());
				map.put("attachment_picture_thumbnail", tblArchives.getAttachmentPicture() );
				map.put("attachment_document_thumbnail", tblArchives.getAttachmentDocument());
				JSONArray jsonArray2 = new JSONArray();
				jsonArray2.add(map);
				dboex.setArchives(jsonArray2);
				JSONObject object = JSONObject.fromObject(dboex);
				return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),object);
			}
			
			
		}
		return null;
		
		
	}


	

}
