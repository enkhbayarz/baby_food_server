package mn.babyfood.babyfood.util;

import mn.babyfood.babyfood.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ApiUtil {
    private final MessageSource messageSource;

    @Autowired
    public ApiUtil(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public ApiResponse buildLocalizedResponse(@Nullable final String[] additionalParam) {

        return new ApiResponse(true,
                this.messageSource.getMessage(
                        ((additionalParam == null) ? "system.success.null" : "system.success"),
                        additionalParam,
                        LocaleContextHolder.getLocale()));
    }

    public ApiResponse buildCustomLocalizedResponse(
            final String text, @Nullable final String[] additionalParam) {

        return new ApiResponse(true, this.messageSource.getMessage(text, additionalParam, LocaleContextHolder.getLocale()));
    }

    public ApiResponse setLocalizedErrorResponse(
            final String[] additionalParam, final ApiResponse response) {

        response.setSuccess(false);
        response.setMessage(this.messageSource.getMessage("system.error", additionalParam, LocaleContextHolder.getLocale()));

        return response;
    }

    public String buildMessage(final String templateName, final String[] additionalParam) {

        return this.messageSource.getMessage(templateName, additionalParam, LocaleContextHolder.getLocale());
    }

}
