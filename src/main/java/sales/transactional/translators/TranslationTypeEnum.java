package sales.transactional.translators;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091120
 * @since 0.1201504091120
 */
public interface TranslationTypeEnum<DTO, DOMAIN> {

    Class<? extends DOMAIN> getDomainType();

    Class<? extends DTO> getDTOType();

}
