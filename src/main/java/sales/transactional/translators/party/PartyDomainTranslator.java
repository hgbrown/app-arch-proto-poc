package sales.transactional.translators.party;

import com.silvermoongroup.party.domain.Party;
import sales.frontend.cunsumable.domain.party.AbstractPartyDTO;
import sales.frontend.cunsumable.domain.party.LeadDTO;
import sales.transactional.translators.TranslationTypeEnum;
import sales.transactional.translators.Translator;

/**
 * Contains no state and is responsible for converting between any frontend consumer based domain to the internaal IAA
 * domain for a Party.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091107
 * @since 0.1201504091107
 */
public class PartyDomainTranslator implements Translator<AbstractPartyDTO, Party> {

    public Party translateToDomain(AbstractPartyDTO partyDTO) {
        if(partyDTO instanceof LeadDTO) {
            return translateToLead((LeadDTO) partyDTO);
        }
        return null;
    }

    public AbstractPartyDTO translateToDTO(Party party, TranslationTypeEnum<AbstractPartyDTO, Party> type) {
        return null;
    }


    private Party translateToLead(LeadDTO leadDTO) {
        return null;
    }
}
