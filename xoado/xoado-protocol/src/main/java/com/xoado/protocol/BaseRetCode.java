package com.xoado.protocol;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;


public enum BaseRetCode {
	
	CODE_ERROR_INVALID_AUTH_INFO("000100", "登录密码错误，请重新输入"),
	CODE_ERROR_AUTH_TOKEN_EXPIRED("000101", "登录超时"),
	CODE_ERROR_AUTH_REFRESHTOKEN_EXPIRED("000104", "登录超时"),
	CODE_ERROR_AUTH_ACCOUNT_LOCK("000106", "账户被锁定"),
	CODE_ERROR_AUTH_UNAUTH("000107", "未授权"),
	CODE_ERROR_PASSWORD("000112", "密码错误"), 
	CODE_ERROR_FAIL("000111", "系统错误"),
	CODE_ERROR_MISSING_CONTENT_LENGTH("100001","没有提供必须的 Content-Length 请求头。"),
	CODE_ERROR_MISSING_USER_AGENT("100002","没有提供必须的 User-Agent 请求头。"),
	CODE_ERROR_MISSING_CONTENT_TYPE("100003","没有为 Body 不为空的 HTTP 请求指定 Content-Type 头。"),
	CODE_ERROR_MISSING_CONTENT_MD5("100004","没有为 Body 不为空的 HTTP 请求指定 Content-MD5 头。"),
	CODE_ERROR_MISSING_CONTENT_HOST("100005","没有提供 HTTP 标准请求头 Host。"),
	CODE_ERROR_MISSING_CONTENT_DATE("100006","没有提供 HTTP 标准请求头 Date。"),
	CODE_ERROR_MISSING_XD_AUTH_SIGNATUREMETHOD("100007","没有提供 HTTP 请求头 xd_auth_signaturemethod。"),
	CODE_ERROR_MISSING_XD_AUTH_APIVERSION("100008","没有提供 HTTP 请求头 xd-auth-apiversion。"),
	CODE_ERROR_MISSING_AUTHORIZATION("100009","没有提供必须的 Authorization 请求头。"),
	
	CODE_ERROR_MISSING_SIGNATURENOTMATCH("100010","请求的数字签名不匹配。"),
	CODE_ERROR_MISSING_X_ACS_SECURITY_TOKEN("100011","没有提供 HTTP 请求头 x-acs-security-token。"),
	CODE_ERROR_INVALIDDATEFORMAT_CONTENT_DATE("100012","Date 请求头的值不符合 RFC822 标准。"),
	
	CODE_ERROR_REQUESTTIMETOOSKEWED("100013","请求的发送时间超过当前服务处理时间前后 15 分钟的范围。"),
	
	
	
	

	CODE_SUCCESS("000200", "成功"),
	CODE_ERROR_CHECK_CODE("000201", "手机验证码错误"),
	CODE_ERROR_CHECK_MOBILE_CODE("000202", "请输入正确的手机号"),
	CODE_ERROR_VAILD_CLIENT_ACCESS("000203", "非法访问"),
	CODE_ERROR_CHECK_BTOKEN_VAL_FAIL("000204", "请求参数错误"),
	CODE_ERROR_CHECK_BTOKEN_EXP("000205", "请求参数超时"),
	CODE_ERROR_CHECKCODE_EXPIRE("000206", "验证码已过期"),
	CODE_ERROR_CHECKCODE_LOGIN_OTHER("000207", "你的账户在异地登录"),
	CODE_ERROR_USER_NOT_EXISTS("020001", "用户不存在"), 
	CODE_ERROR_USER_MOBILE_EXISTS("020002", "用户手机号已被注册"),
	CODE_ERROR_REGISTER_ERROR("020003", "用户注册异常"),
	CODE_ERROR_CHANGEPWD_ERROR("020004", "用户注册异常"),
	CODE_ERROR_CHECKCODE_ERROR("020005", "验证校验码异常"),
	CODE_ERROR_USER_LOGIN_ERROR("020006", "用户登录系统异常"),
	CODE_EMPTY_DATA("020007", "暂无记录"),
	CODE_ORGANIZE_DEPT_EXISTS("020008", "服务组织部门已存在"),
	CODE_ORGANIZE_MEMBER_EXISTS("020009", "服务组织成员已存在"),
	CODE_ORGANIZE_DEPT_EXISTS_MEMBER("020010", "服务组织部门下存在成员，不可删除"),
	CODE_ORGANIZET_EXISTS_MEMBER("020011", "服务组织下存在成员，不可删除"),
	CODE_APP_BLACKLIST_EXISTS("020012", "该应用已添加到黑名单，不可重复添加"),
	CODE_APP_PERMISSIONS_EXISTS("020013", "该应用权限编码已添加，不可重复添加"),
	CODE_APP_USER_ROLE_PERMISSIONS_EXISTS("020014", "角色或用户已拥有该应用权限"),
	CODE_ORGANIZE_NAME_EXISTS("020015", "服务组织名称已存在"),
	CODE_NOT_BLANK("020016", "必填请求参数不能为空"),
	CODE_APP_INTERFACE_EXISTS("020017", "应用接口名称已存在"),
	CODE_APP_NAME_EXISTS("020018", "应用名称已存在"),
	CODE_APP_NOT_AUDIT("020019", "该应用审核未通过"),
	CODE_ERROR_WEIXIN_USER_NOT_EXISTS("020020", "该微信用户未注册"),
	CODE_USER_REAL_INFO_EXISTS("020021", "该用户信息已被注册过"),
	
	

	CODE_ERROR_FORM_VALIDATION("000400", "客户端上发送信息错误"), 
	CODE_ERROR_HEADER_VALIDATION("000401", "客户端上发送信息错误"),
	CODE_ERROR_CLIENT_CHECK("000402", "客户端上发送信息错误"), 
	CODE_ERROR_CHECKCODE("000403", "验证码错误"),
	CODE_ERROR_SERVICE_NOT_FOUND("000404", "请求资源不存在"),
	CODE_ERROR_CHECKCODE_EXCEPTION("000405", "校验验证码系统异常"),

	CODE_ERROR_SYS("000500", "系统错误"), 

	CODE_ERROR_USER_CENTER("020000", "系统错误");
	
	private String retCode;
	private String retMsg;
	private BaseRetCode(String retCode, String retMsg) { 
		this.retCode = retCode;
		this.retMsg = retMsg;

	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetCode() {
		return retCode;
	}

	public ErrorMsg toErrorMsg() {
		return new ErrorMsg(retCode,retMsg);
	}

	

}
