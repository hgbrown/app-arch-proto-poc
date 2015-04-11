package sales.transactional.translators.agreement;

import com.silvermoongroup.spflite.specframework.domain.Agreement;
import sales.frontend.cunsumable.domain.agreement.AgreementStructureDTO;
import sales.transactional.translators.TranslationTypeEnum;
import sales.transactional.translators.Translator;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091142
 * @since 0.1201504091142
 */
public class AgreementTranslator implements Translator<AgreementStructureDTO, Agreement> {

    public Agreement translateToDomain(AgreementStructureDTO agreementStructureDTO) {
        return null;
    }

    public AgreementStructureDTO translateToDTO(Agreement agreement, TranslationTypeEnum<AgreementStructureDTO, Agreement> type) {
        return null;
    }

}
