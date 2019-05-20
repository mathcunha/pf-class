#!/usr/bin/env bash
cd /vagrant/pf-class/jooq
mvn exec:java -Dexec.mainClass="org.jooq.codegen.GenerationTool" -Dexec.args=/vagrant/pf-class/jooq/src/main/resources/petclinic.xml
