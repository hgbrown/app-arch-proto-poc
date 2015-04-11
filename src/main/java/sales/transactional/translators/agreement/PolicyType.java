package sales.transactional.translators.agreement;

import com.silvermoongroup.spflite.specframework.domain.Agreement;
import sales.frontend.cunsumable.domain.agreement.AgreementStructureDTO;
import sales.transactional.translators.TranslationTypeEnum;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091257
 * @since 0.1201504091257
 */
public enum PolicyType implements TranslationTypeEnum<AgreementStructureDTO, Agreement> {
    QUOTE,
    APPLIED,;

    public Class<? extends Agreement> getDomainType() {
        return Agreement.class;
    }

    public Class<? extends AgreementStructureDTO> getDTOType() {
        return AgreementStructureDTO.class;
    }
}
