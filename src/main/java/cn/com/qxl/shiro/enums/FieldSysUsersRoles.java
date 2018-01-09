package cn.com.qxl.shiro.enums;

public enum FieldSysUsersRoles {

    FIELD_USER_ID("USER_ID","userId"),//
    FIELD_ROLE_ID("ROLE_ID","roleId"),//
    ;
    private String dbCode;
    private String attrCode;
    private FieldSysUsersRoles (String dbCode,String attrCode){
        this.dbCode = dbCode;
        this.attrCode = attrCode;
    }
    @Override
    public String toString(){
        return this.dbCode;
    }
    public String getAttrCode(){
        return this.attrCode;
    }
}