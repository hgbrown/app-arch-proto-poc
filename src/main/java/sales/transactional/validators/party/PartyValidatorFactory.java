package sales.transactional.validators.party;

import sales.transactional.translators.party.PartyType;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091235
 * @since 0.1201504091235
 */
public class PartyValidatorFactory {

    LeadsPartyValidator leadsPartyValidator;

    private PartyValidatorFactory(){};

    public PartyValidator getValidator(PartyType partyType) {
        switch (partyType) {
            case LEAD:
                return leadsPartyValidator;
        }
        throw new IllegalArgumentException("Uknown party type");
    }

    public static class Holder {
        public static PartyValidatorFactory INSTANCE = new PartyValidatorFactory();
    }


    public static PartyValidatorFactory getInstance() {
        return Holder.INSTANCE;
    }

}
