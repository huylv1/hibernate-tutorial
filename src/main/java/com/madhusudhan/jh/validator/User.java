package com.madhusudhan.jh.validator;

class User {
    private String userName;

    public User(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	/* whatever name you provide as propertyName will replace {propertyName} in resource bundle */
   // Annotation Attribute Value 
    @MyNotNull(propertyName="userName") 
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
