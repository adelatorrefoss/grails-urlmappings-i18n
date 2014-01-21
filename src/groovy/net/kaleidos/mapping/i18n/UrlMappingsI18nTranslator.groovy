package net.kaleidos.mapping.i18n

import grails.util.Holders

class UrlMappingsI18nTranslator {
    static locale
    static messageSource = Holders.grailsApplication.mainContext.getBean('messageSource')
    static languages = Holders.grailsApplication.config.urlMapping.i18n.languages

    static String m (String code) {
        println "Loading locale: $locale"

        def msg = messageSource.getMessage("url.$code", [] as Object[], new Locale(locale))
        println "translating code:${code}=${msg}"
        return msg
    }
}

