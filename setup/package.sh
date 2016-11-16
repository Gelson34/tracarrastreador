#!/bin/bash

#
# Script to create installers
#

cd $(dirname $0)

if [[ $# -lt 1 ]]
then
  echo "USAGE: $0 <version>"
  exit 1
fi

VERSION=$1

check_requirement () {
  if ! eval $1 &>/dev/null
  then
    echo $2
    exit 1
  fi 
}

check_requirement "ls ../../ext-6.0.1" "Missing ../../ext-6.0.1 (https://www.sencha.com/legal/GPL/)"
check_requirement "ls yajsw-*.zip" "Missing yajsw-*.zip (https://sourceforge.net/projects/yajsw/files/)"
check_requirement "ls innosetup-*.exe" "Missing isetup-*.exe (http://www.jrsoftware.org/isdl.php)"
check_requirement "ls sqljdbc_*_enu.tar.gz" "Microsoft JDBC Drivers (https://www.microsoft.com/en-us/download/details.aspx?id=11774 or http://www.cvs.in.th/cvs/java_lib/sqljdbc_6.0.7728.100_enu.tar.gz)"
check_requirement "which sencha" "Missing sencha cmd package (https://www.sencha.com/products/extjs/cmd-download/)"
check_requirement "which wine" "Missing wine package"
check_requirement "which innoextract" "Missing innoextract package"
check_requirement "which makeself" "Missing makeself package"
check_requirement "which dos2unix" "Missing dos2unix package"

prepare () {
  unzip yajsw-*.zip
  mv yajsw-*/ yajsw/
  
  tar -zxvf sqljdbc_*_enu.tar.gz
  mv sqljdbc_*/ sqljdbc/
  
  ../traccar-web/tools/minify.sh

  innoextract innosetup-*.exe
  echo "If you got any errors here try isetup version 5.5.5 (or check supported versions using 'innoextract -v')"
}

cleanup () {
  rm -r yajsw/

  rm ../traccar-web/web/app.min.js

  rm -r app/
  
  rm -r sqljdbc/
}

copy_wrapper () {
  cp yajsw/$1/setenv* out/$1
  cp yajsw/$1/wrapper* out/$1
  cp yajsw/$1/install* out/$1
  cp yajsw/$1/start* out/$1
  cp yajsw/$1/stop* out/$1
  cp yajsw/$1/uninstall* out/$1

  chmod +x out/$1/*

  cp yajsw/conf/wrapper.conf.default out/conf

  touch out/conf/wrapper.conf
  echo "wrapper.java.command=java" >> out/conf/wrapper.conf
  echo "wrapper.java.app.jar=tracker-server.jar" >> out/conf/wrapper.conf
  echo "wrapper.app.parameter.1=./conf/traccar.xml" >> out/conf/wrapper.conf
  echo "wrapper.java.additional.1=-Dfile.encoding=UTF-8" >> out/conf/wrapper.conf
  echo "wrapper.logfile=logs/wrapper.log.YYYYMMDD" >> out/conf/wrapper.conf
  echo "wrapper.logfile.rollmode=DATE" >> out/conf/wrapper.conf
  echo "wrapper.ntservice.name=traccar" >> out/conf/wrapper.conf
  echo "wrapper.ntservice.displayname=Traccar" >> out/conf/wrapper.conf
  echo "wrapper.ntservice.description=Traccar" >> out/conf/wrapper.conf

  cp -r yajsw/lib/core out/lib
  rm out/lib/core/ReadMe.txt

  cp -r yajsw/lib/extended out/lib
  rm out/lib/extended/ReadMe.txt

  cp yajsw/templates/* out/templates

  cp yajsw/wrapper*.jar out

  if which xattr &>/dev/null
  then
    xattr -dr com.apple.quarantine out
  fi
}

copy_files () {
  cp ../target/tracker-server.jar out
  cp ../target/lib/* out/lib
  cp ../sqljdbc/sqljdbc*.jar out/lib
  cp ../schema/* out/schema
  cp -r ../templates/* out/templates
  cp -r ../traccar-web/web/* out/web
  cp default.xml out/conf
  cp traccar.xml out/conf
}

package_windows () {
  mkdir -p out/{bat,conf,data,lib,logs,web,schema,templates}

  copy_wrapper "bat"
  copy_files

  wine app/ISCC.exe traccar.iss

  zip -j traccar-windows-$VERSION.zip Output/traccar-setup.exe README.txt

  rm -r Output
  rm -r tmp
  rm -r out
}

package_unix () {
  mkdir -p out/{bin,conf,data,lib,logs,web,schema,templates}

  copy_wrapper "bin"
  find out -type f \( -name \*.sh -o -name \*.vm \) -print0 | xargs -0 dos2unix
  copy_files

  makeself out traccar.run "traccar" "\
if which java &>/dev/null ; \
then \
if [ \$(java -version 2>&1 | grep -i version | sed 's/.*version \"\(.*\)\.\(.*\)\..*\"/\1\2/; 1q') -lt 17 ] ; \
then \
echo 'Java 7 or higher required' ; \
else \
mkdir -p /opt/traccar ; \
cp -r * /opt/traccar ; \
chmod -R go+rX /opt/traccar ; \
/opt/traccar/bin/installDaemon.sh ; \
fi ; \
else \
echo 'Java runtime is required' ; \
fi"

  zip -j traccar-linux-$VERSION.zip traccar.run README.txt
  cp traccar-linux-$VERSION.zip traccar-macos-$VERSION.zip

  rm traccar.run
  rm -r out
}

package_universal () {
  mkdir -p out/{conf,data,lib,logs,web,schema}

  copy_files

  cp README.txt out
  cp other/traccar.sh out
  
  cd out
  zip -r ../traccar-other-$VERSION.zip *
  cd ..

  rm -rf out/
}

prepare

package_windows
package_unix
package_universal

cleanup
