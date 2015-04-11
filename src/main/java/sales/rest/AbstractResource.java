package sales.rest;

import com.silvermoongroup.common.domain.ApplicationContext;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504101059
 * @since 0.1201504101059
 */
public abstract class AbstractResource {

    ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
