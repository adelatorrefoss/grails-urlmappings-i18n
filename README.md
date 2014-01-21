grails-urlmappings-i18n
=======================

Grails Plugin to get i18n urls, extending UrlMappings functions. With this plugin you cant get various urls, in different languages in the same mapping name.

After this config you get this kind of urls:

`name home_xx : "/${home_url_i18n}" { controller ... }`

only one name and url that converts in n urls:

```
name home_es : "/inicio" { controller ... }
name home_en : "/home"   { controller ... }
```


and the g.createLink() function works as usual,

`g.createLink(name:home)`

this sentence, look first for a `'home_' + getLocale()` mapping, and if not exists look for `'home'`



## Config

Files involved:

* ./conf/Config.groovy
* ./conf/UrlMappings.groovy
* ./i18n/messages_es.properties
* ./i18n/messages.properties


### Config.groovy

add this lines:
```
// Config UrlMappings i18n
// only for tests
urlMapping.i18n.languages = ['es','en']
urlMapping.i18n.defaultLanguage = 'es'
```


### UrlMappings

Edit your UrlMappings file and use this sintax:

```
import net.kaleidos.mapping.i18n.UrlMappingsI18nTranslator as UMI

class UrlMappings {

    static mappings = {

        // UrlMappings i18n

        UMI.languages.each() {
            UMI.locale = "$it"

            name ([("nameA_" + UMI.locale): "/${UMI.m('nameA')}/$variable?" {
                controller = 'test1'; action = [GET:'action1'] }])
        }


        // no i18n

        name nameB: "/nameB" { controller = 'test2'; action = [GET:'action2'] }
    }
}
```


### Messages

messages_es.properties
```
# urlmappings
url.nameA = nombre-traducidoA
```

messages.properties
```
# urlmappings
url.nameA = name-translatedA
```

## Other files

Files involved (and copied) from grails

* UrlMappingsHolderFactoryBean.java
* DefaultLinkGenerator.groovy
* GrailsUrlmappingsI18nGrailsPlugin
