package sales.transactional.validators.party;

import com.silvermoongroup.party.domain.Party;
import sales.transactional.validators.Validator;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091144
 * @since 0.1201504091144
 */
public interface PartyValidator extends Validator<Party> {

    void validate(Party lead);
}
