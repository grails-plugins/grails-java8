package org.grails.plugins.web

import grails.plugins.*
import org.grails.plugins.databinding.DataBindingGrailsPlugin

class Java8GrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.2.0 > *"

    // TODO Fill in these fields
    def title = "Grails Java 8 Plugin" // Headline output name of the plugin
    def author = "James Kleeh"
    def authorEmail = "kleehj@ociweb.com"
    def description = '''\
This plugin provides support for Java 8 specific functions in a Grails application
'''
    String documentation = ''
    String license = 'APACHE'
    def organization = [name: 'Grails', url: 'http://www.grails.org/']
    def issueManagement = [url: 'https://github.com/grails-plugins/grails-java8/issues']
    def scm = [url: 'https://github.com/grails-plugins/grails-java8']

    Closure doWithSpring() {{->

        List dateFormats = config.getProperty(DataBindingGrailsPlugin.DATE_FORMATS, List, DataBindingGrailsPlugin.DEFAULT_DATE_FORMATS)

        grailsTagDateHelper(Jsr310TagDateHelper)

        jsr310DataBinding(Jsr310ConvertersConfiguration) {
            formatStrings = dateFormats
        }

    }}

}
