/**
 * This class is generated by jOOQ
 */
package com.ethercis.jooq.pg.enums;


import com.ethercis.jooq.pg.Ehr;

import javax.annotation.Generated;

import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum ContributionState implements EnumType {

	complete("complete"),

	incomplete("incomplete"),

	deleted("deleted");

	private final String literal;

	private ContributionState(String literal) {
		this.literal = literal;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Schema getSchema() {
		return Ehr.EHR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "contribution_state";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLiteral() {
		return literal;
	}
}
