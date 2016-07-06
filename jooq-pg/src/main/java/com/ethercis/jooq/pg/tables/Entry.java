/**
 * This class is generated by jOOQ
 */
package com.ethercis.jooq.pg.tables;


import com.ethercis.jooq.pg.Ehr;
import com.ethercis.jooq.pg.Keys;
import com.ethercis.jooq.pg.enums.EntryType;
import com.ethercis.jooq.pg.tables.records.EntryRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * this table hold the actual archetyped data values (from a template)
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Entry extends TableImpl<EntryRecord> {

	private static final long serialVersionUID = -256138029;

	/**
	 * The reference instance of <code>ehr.entry</code>
	 */
	public static final Entry ENTRY = new Entry();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<EntryRecord> getRecordType() {
		return EntryRecord.class;
	}

	/**
	 * The column <code>ehr.entry.id</code>.
	 */
	public final TableField<EntryRecord, UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>ehr.entry.composition_id</code>.
	 */
	public final TableField<EntryRecord, UUID> COMPOSITION_ID = createField("composition_id", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.entry.sequence</code>.
	 */
	public final TableField<EntryRecord, Integer> SEQUENCE = createField("sequence", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>ehr.entry.item_type</code>.
	 */
	public final TableField<EntryRecord, EntryType> ITEM_TYPE = createField("item_type", org.jooq.util.postgres.PostgresDataType.VARCHAR.asEnumDataType(com.ethercis.jooq.pg.enums.EntryType.class), this, "");

	/**
	 * The column <code>ehr.entry.template_id</code>.
	 */
	public final TableField<EntryRecord, String> TEMPLATE_ID = createField("template_id", org.jooq.impl.SQLDataType.VARCHAR.length(250), this, "");

	/**
	 * The column <code>ehr.entry.template_uuid</code>.
	 */
	public final TableField<EntryRecord, UUID> TEMPLATE_UUID = createField("template_uuid", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.entry.archetype_id</code>.
	 */
	public final TableField<EntryRecord, String> ARCHETYPE_ID = createField("archetype_id", org.jooq.impl.SQLDataType.VARCHAR.length(250), this, "");

	/**
	 * The column <code>ehr.entry.category</code>.
	 */
	public final TableField<EntryRecord, UUID> CATEGORY = createField("category", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.entry.entry</code>.
	 */
	public final TableField<EntryRecord, Object> ENTRY_ = createField("entry", org.jooq.impl.DefaultDataType.getDefaultDataType("jsonb"), this, "");

	/**
	 * The column <code>ehr.entry.sys_transaction</code>.
	 */
	public final TableField<EntryRecord, Timestamp> SYS_TRANSACTION = createField("sys_transaction", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>ehr.entry.sys_period</code>.
	 */
	public final TableField<EntryRecord, Object> SYS_PERIOD = createField("sys_period", org.jooq.impl.DefaultDataType.getDefaultDataType("tstzrange"), this, "");

	/**
	 * Create a <code>ehr.entry</code> table reference
	 */
	public Entry() {
		this("entry", null);
	}

	/**
	 * Create an aliased <code>ehr.entry</code> table reference
	 */
	public Entry(String alias) {
		this(alias, ENTRY);
	}

	private Entry(String alias, Table<EntryRecord> aliased) {
		this(alias, aliased, null);
	}

	private Entry(String alias, Table<EntryRecord> aliased, Field<?>[] parameters) {
		super(alias, Ehr.EHR, aliased, parameters, "this table hold the actual archetyped data values (from a template)");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<EntryRecord> getPrimaryKey() {
		return Keys.ENTRY_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<EntryRecord>> getKeys() {
		return Arrays.<UniqueKey<EntryRecord>>asList(Keys.ENTRY_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<EntryRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<EntryRecord, ?>>asList(Keys.ENTRY__ENTRY_COMPOSITION_ID_FKEY, Keys.ENTRY__ENTRY_CATEGORY_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Entry as(String alias) {
		return new Entry(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Entry rename(String name) {
		return new Entry(name, null);
	}
}
