package sales.transactional.translators;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091117
 * @since 0.1201504091117
 */
public interface Translator<DTO, DOMAIN> {


    DOMAIN translateToDomain(DTO dto);

    DTO translateToDTO(DOMAIN domain, TranslationTypeEnum<DTO, DOMAIN> type);

}
