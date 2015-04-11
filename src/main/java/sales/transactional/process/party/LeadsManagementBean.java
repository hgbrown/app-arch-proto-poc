package sales.transactional.process.party;

import com.silvermoongroup.common.constants.Components;
import com.silvermoongroup.common.domain.ApplicationContext;
import com.silvermoongroup.common.domain.ObjectReference;
import com.silvermoongroup.common.enumeration.CoreTypeReference;
import com.silvermoongroup.party.domain.Party;
import com.silvermoongroup.party.structural.PartyManager;
import sales.frontend.cunsumable.domain.party.LeadDTO;
import sales.transactional.translators.party.PartyDomainTranslator;
import sales.transactional.translators.party.PartyType;
import sales.transactional.validators.party.PartyValidationException;
import sales.transactional.validators.party.PartyValidator;
import sales.transactional.validators.party.PartyValidatorFactory;

import static sales.transactional.translators.party.PartyType.LEAD;

/**
 *  Both Translators and Validators need access to structural managers ...
 *
 *  Example:
 *
 *  1) Party Duplicate check needs to find parties by criteria
 *  2) Agreement Translator needs to create request in order to translate AgreementDTO to Agreement
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091048
 * @since 0.1201504091048
 */
public class LeadsManagementBean {

    PartyDomainTranslator partyDomainTranslator;

    PartyManager partyManager;

    public ObjectReference createLead(ApplicationContext applicationContext, LeadDTO leadDTO) {

        //1. translate to domain object(s)
        final Party lead = partyDomainTranslator.translateToDomain(leadDTO);

        //2. apply business rules
        //get the correct validator
        final PartyValidator partyValidator = PartyValidatorFactory.getInstance().getValidator(LEAD);

        try {
            //2. (a) validate domain object
            partyValidator.validate(lead);

            //3. save party using structural manager
            final Party savedParty = partyManager.establishParty(applicationContext, lead);

            return savedParty.getObjectReference();
        } catch(PartyValidationException pve) {
            throw pve;
        }

    }

    public LeadDTO get(ApplicationContext applicationContext, Long id) {
        final ObjectReference objectReference = new ObjectReference(Components.PARTY, CoreTypeReference.PARTY.getLongValue(), id);
        final Party party = partyManager.getParty(applicationContext, objectReference);
        final LeadDTO lead = (LeadDTO) partyDomainTranslator.translateToDTO(party, PartyType.LEAD);
        return lead;
    }

}
