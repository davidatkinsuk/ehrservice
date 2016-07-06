/**
 * This class is generated by jOOQ
 */
package com.ethercis.jooq.pg.tables.records;


import com.ethercis.jooq.pg.tables.Territory;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * ISO 3166-1 countries codeset
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TerritoryRecord extends UpdatableRecordImpl<TerritoryRecord> implements Record4<Integer, String, String, String> {

	private static final long serialVersionUID = 1473220549;

	/**
	 * Setter for <code>ehr.territory.code</code>.
	 */
	public void setCode(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.territory.code</code>.
	 */
	public Integer getCode() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>ehr.territory.twoletter</code>.
	 */
	public void setTwoletter(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.territory.twoletter</code>.
	 */
	public String getTwoletter() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>ehr.territory.threeletter</code>.
	 */
	public void setThreeletter(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ehr.territory.threeletter</code>.
	 */
	public String getThreeletter() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>ehr.territory.text</code>.
	 */
	public void setText(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>ehr.territory.text</code>.
	 */
	public String getText() {
		return (String) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, String, String> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, String, String> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Territory.TERRITORY.CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Territory.TERRITORY.TWOLETTER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Territory.TERRITORY.THREELETTER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Territory.TERRITORY.TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getTwoletter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getThreeletter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerritoryRecord value1(Integer value) {
		setCode(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerritoryRecord value2(String value) {
		setTwoletter(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerritoryRecord value3(String value) {
		setThreeletter(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerritoryRecord value4(String value) {
		setText(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerritoryRecord values(Integer value1, String value2, String value3, String value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TerritoryRecord
	 */
	public TerritoryRecord() {
		super(Territory.TERRITORY);
	}

	/**
	 * Create a detached, initialised TerritoryRecord
	 */
	public TerritoryRecord(Integer code, String twoletter, String threeletter, String text) {
		super(Territory.TERRITORY);

		setValue(0, code);
		setValue(1, twoletter);
		setValue(2, threeletter);
		setValue(3, text);
	}
}
