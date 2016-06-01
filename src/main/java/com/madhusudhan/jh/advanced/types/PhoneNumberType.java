package com.madhusudhan.jh.advanced.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

public class PhoneNumberType implements UserType {
	
	/**
	 * 
	 */
	public static final PhoneNumberType INSTANCE = new PhoneNumberType();
	public static final String[] KEYS = new String[]{PhoneNumberType.class.getName()};

	@Override
	public int[] sqlTypes() {
		return new int[]{
	            IntegerType.INSTANCE.sqlType(),
	            IntegerType.INSTANCE.sqlType(),
	            StringType.INSTANCE.sqlType()
	        };
	}

	@Override
	public Class<PhoneNumber> returnedClass() {
		return PhoneNumber.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		
		assert names.length == 1;
        Integer countryCode = IntegerType.INSTANCE.fromString( names[0] ); // already handles null check
        Integer localCode = IntegerType.INSTANCE.fromString( names[1] ); // already handles null check
        String country = names[3];
        
        return countryCode == null && localCode == null && country == null
                ? null
                : new PhoneNumber( countryCode, localCode, country ); //localCode, country 
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		
		if ( value == null ) {
        	IntegerType.INSTANCE.set( st, null, index , session );
        	IntegerType.INSTANCE.set( st, null, index + 1 , session );
        	StringType.INSTANCE.set( st, null, index + 2, session );
        }
        else {
            final PhoneNumber phoneNumber = (PhoneNumber) value;
            IntegerType.INSTANCE.set( st, phoneNumber.getCountryCode(), index , session );
            IntegerType.INSTANCE.set( st, phoneNumber.getLocalCode(), index+1 , session );
            StringType.INSTANCE.set( st, phoneNumber.getCountry(), index+2 , session );
        }
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
