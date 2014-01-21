import net.kaleidos.mapping.i18n.UrlMappingsI18nTranslator as UMI

class UrlMappings {

    static mappings = {

        // UrlMappings i18n - public urls

        UMI.languages.each() {
            UMI.locale = "$it"

            name ([("nameA_" + UMI.locale): "/${UMI.m('nameA')}/$variable?" {
                controller = 'test1'; action = [GET:'action1'] }])
        }


        // not public urls, no i18n

        name nameB: "/nameB" { controller = 'test2'; action = [GET:'action2'] }
    }
}
