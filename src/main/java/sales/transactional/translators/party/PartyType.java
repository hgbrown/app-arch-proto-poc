package sales.transactional.translators.party;

import com.silvermoongroup.party.domain.Party;
import sales.frontend.cunsumable.domain.party.AbstractPartyDTO;
import sales.frontend.cunsumable.domain.party.LeadDTO;
import sales.frontend.cunsumable.domain.party.PersonDTO;
import sales.frontend.cunsumable.domain.party.WholeSaleMemberDTO;
import sales.transactional.translators.TranslationTypeEnum;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091235
 * @since 0.1201504091235
 */
public enum PartyType implements TranslationTypeEnum<AbstractPartyDTO, Party> {

    LEAD {
        public Class<? extends AbstractPartyDTO> getDTOType() {
            return LeadDTO.class;
        }
    },
    WHOLESALE_MEMBER {
        public Class<? extends AbstractPartyDTO> getDTOType() {
            return WholeSaleMemberDTO.class;
        }
    },
    PERSON {
        public Class<? extends AbstractPartyDTO> getDTOType() {
            return PersonDTO.class;
        }
    };

    public Class<Party> getDomainType() {
        return Party.class;
    }

}
