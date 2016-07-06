/**
 * This class is generated by jOOQ
 */
package com.ethercis.jooq.pg.tables.records;


import com.ethercis.jooq.pg.tables.TerminologyProvider;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * openEHR identified terminology provider
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TerminologyProviderRecord extends UpdatableRecordImpl<TerminologyProviderRecord> implements Record3<String, String, String> {

	private static final long serialVersionUID = 793179472;

	/**
	 * Setter for <code>ehr.terminology_provider.code</code>.
	 */
	public void setCode(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.terminology_provider.code</code>.
	 */
	public String getCode() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>ehr.terminology_provider.source</code>.
	 */
	public void setSource(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.terminology_provider.source</code>.
	 */
	public String getSource() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>ehr.terminology_provider.authority</code>.
	 */
	public void setAuthority(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ehr.terminology_provider.authority</code>.
	 */
	public String getAuthority() {
		return (String) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<String> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<String, String, String> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<String, String, String> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return TerminologyProvider.TERMINOLOGY_PROVIDER.CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return TerminologyProvider.TERMINOLOGY_PROVIDER.SOURCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return TerminologyProvider.TERMINOLOGY_PROVIDER.AUTHORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getSource();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getAuthority();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord value1(String value) {
		setCode(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord value2(String value) {
		setSource(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord value3(String value) {
		setAuthority(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord values(String value1, String value2, String value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TerminologyProviderRecord
	 */
	public TerminologyProviderRecord() {
		super(TerminologyProvider.TERMINOLOGY_PROVIDER);
	}

	/**
	 * Create a detached, initialised TerminologyProviderRecord
	 */
	public TerminologyProviderRecord(String code, String source, String authority) {
		super(TerminologyProvider.TERMINOLOGY_PROVIDER);

		setValue(0, code);
		setValue(1, source);
		setValue(2, authority);
	}
}
