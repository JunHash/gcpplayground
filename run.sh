#!/bin/bash -ex

export JAVA_HOME=/opt/jdk
export M2_HOME=/opt/mvn

mvn=${M2_HOME}/bin/mvn

#${mvn} clean package install assembly:single dependency:copy-dependencies exec:java
rm -rf log/* && ${mvn} clean package exec:java
#${mvn} exec:java
#${mvn} clean javadoc:fix javadoc:javadoc

