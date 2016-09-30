/**
 * This class is generated by jOOQ
 */
package com.ethercis.jooq.pg;


import com.ethercis.jooq.pg.tables.Access;
import com.ethercis.jooq.pg.tables.Attestation;
import com.ethercis.jooq.pg.tables.AttestedView;
import com.ethercis.jooq.pg.tables.CompExpand;
import com.ethercis.jooq.pg.tables.CompoXref;
import com.ethercis.jooq.pg.tables.Composition;
import com.ethercis.jooq.pg.tables.CompositionHistory;
import com.ethercis.jooq.pg.tables.Concept;
import com.ethercis.jooq.pg.tables.Containment;
import com.ethercis.jooq.pg.tables.Contribution;
import com.ethercis.jooq.pg.tables.ContributionHistory;
import com.ethercis.jooq.pg.tables.Ehr;
import com.ethercis.jooq.pg.tables.Entry;
import com.ethercis.jooq.pg.tables.EntryHistory;
import com.ethercis.jooq.pg.tables.EventContext;
import com.ethercis.jooq.pg.tables.EventContextHistory;
import com.ethercis.jooq.pg.tables.Identifier;
import com.ethercis.jooq.pg.tables.Language;
import com.ethercis.jooq.pg.tables.Participation;
import com.ethercis.jooq.pg.tables.ParticipationHistory;
import com.ethercis.jooq.pg.tables.PartyIdentified;
import com.ethercis.jooq.pg.tables.Status;
import com.ethercis.jooq.pg.tables.StatusDetails;
import com.ethercis.jooq.pg.tables.StatusHistory;
import com.ethercis.jooq.pg.tables.System;
import com.ethercis.jooq.pg.tables.TerminologyProvider;
import com.ethercis.jooq.pg.tables.Territory;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in ehr
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * defines the modality for accessing an com.ethercis.ehr (security strategy implementation)
	 */
	public static final Access ACCESS = com.ethercis.jooq.pg.tables.Access.ACCESS;

	/**
	 * The table ehr.attestation
	 */
	public static final Attestation ATTESTATION = com.ethercis.jooq.pg.tables.Attestation.ATTESTATION;

	/**
	 * The table ehr.attested_view
	 */
	public static final AttestedView ATTESTED_VIEW = com.ethercis.jooq.pg.tables.AttestedView.ATTESTED_VIEW;

	/**
	 * The table ehr.comp_expand
	 */
	public static final CompExpand COMP_EXPAND = com.ethercis.jooq.pg.tables.CompExpand.COMP_EXPAND;

	/**
	 * The table ehr.compo_xref
	 */
	public static final CompoXref COMPO_XREF = com.ethercis.jooq.pg.tables.CompoXref.COMPO_XREF;

	/**
	 * Composition table
	 */
	public static final Composition COMPOSITION = com.ethercis.jooq.pg.tables.Composition.COMPOSITION;

	/**
	 * The table ehr.composition_history
	 */
	public static final CompositionHistory COMPOSITION_HISTORY = com.ethercis.jooq.pg.tables.CompositionHistory.COMPOSITION_HISTORY;

	/**
	 * openEHR common concepts (e.g. terminology) used in the system
	 */
	public static final Concept CONCEPT = com.ethercis.jooq.pg.tables.Concept.CONCEPT;

	/**
	 * The table ehr.containment
	 */
	public static final Containment CONTAINMENT = com.ethercis.jooq.pg.tables.Containment.CONTAINMENT;

	/**
	 * Contribution table, compositions reference this table
	 */
	public static final Contribution CONTRIBUTION = com.ethercis.jooq.pg.tables.Contribution.CONTRIBUTION;

	/**
	 * The table ehr.contribution_history
	 */
	public static final ContributionHistory CONTRIBUTION_HISTORY = com.ethercis.jooq.pg.tables.ContributionHistory.CONTRIBUTION_HISTORY;

	/**
	 * EHR itself
	 */
	public static final Ehr EHR = com.ethercis.jooq.pg.tables.Ehr.EHR;

	/**
	 * this table hold the actual archetyped data values (from a template)
	 */
	public static final Entry ENTRY = com.ethercis.jooq.pg.tables.Entry.ENTRY;

	/**
	 * The table ehr.entry_history
	 */
	public static final EntryHistory ENTRY_HISTORY = com.ethercis.jooq.pg.tables.EntryHistory.ENTRY_HISTORY;

	/**
	 * defines the context of an event (time, who, where... see openEHR IM 5.2
	 */
	public static final EventContext EVENT_CONTEXT = com.ethercis.jooq.pg.tables.EventContext.EVENT_CONTEXT;

	/**
	 * The table ehr.event_context_history
	 */
	public static final EventContextHistory EVENT_CONTEXT_HISTORY = com.ethercis.jooq.pg.tables.EventContextHistory.EVENT_CONTEXT_HISTORY;

	/**
	 * specifies an identifier for a party identified, more than one identifier is possible
	 */
	public static final Identifier IDENTIFIER = com.ethercis.jooq.pg.tables.Identifier.IDENTIFIER;

	/**
	 * ISO 639-1 language codeset
	 */
	public static final Language LANGUAGE = com.ethercis.jooq.pg.tables.Language.LANGUAGE;

	/**
	 * define a participating party for an event f.ex.
	 */
	public static final Participation PARTICIPATION = com.ethercis.jooq.pg.tables.Participation.PARTICIPATION;

	/**
	 * The table ehr.participation_history
	 */
	public static final ParticipationHistory PARTICIPATION_HISTORY = com.ethercis.jooq.pg.tables.ParticipationHistory.PARTICIPATION_HISTORY;

	/**
	 * The table ehr.party_identified
	 */
	public static final PartyIdentified PARTY_IDENTIFIED = com.ethercis.jooq.pg.tables.PartyIdentified.PARTY_IDENTIFIED;

	/**
	 * specifies an ehr modality and ownership (patient)
	 */
	public static final Status STATUS = com.ethercis.jooq.pg.tables.Status.STATUS;

	/**
	 * The table ehr.status_details
	 */
	public static final StatusDetails STATUS_DETAILS = com.ethercis.jooq.pg.tables.StatusDetails.STATUS_DETAILS;

	/**
	 * The table ehr.status_history
	 */
	public static final StatusHistory STATUS_HISTORY = com.ethercis.jooq.pg.tables.StatusHistory.STATUS_HISTORY;

	/**
	 * system table for reference
	 */
	public static final System SYSTEM = com.ethercis.jooq.pg.tables.System.SYSTEM;

	/**
	 * openEHR identified terminology provider
	 */
	public static final TerminologyProvider TERMINOLOGY_PROVIDER = com.ethercis.jooq.pg.tables.TerminologyProvider.TERMINOLOGY_PROVIDER;

	/**
	 * ISO 3166-1 countries codeset
	 */
	public static final Territory TERRITORY = com.ethercis.jooq.pg.tables.Territory.TERRITORY;
}